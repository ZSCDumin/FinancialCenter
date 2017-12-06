package com.nieyue.rabbitmq.confirmcallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.nieyue.bean.Acount;
import com.nieyue.bean.Financial;
import com.nieyue.bean.DailyData;
import com.nieyue.bean.Data;
import com.nieyue.bean.DataRabbitmqDTO;
import com.nieyue.business.AcountBusiness;
import com.nieyue.service.FinancialService;
import com.nieyue.service.DailyDataService;
import com.nieyue.service.DataService;
import com.nieyue.util.DateUtil;
import com.rabbitmq.client.Channel;


/**
 * 消息监听者
 * @author 聂跃
 * @date 2017年5月31日
 */
@Configuration  
public class Listener {
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private AcountBusiness acountBusiness;
	@Resource
	private FinancialService financialService;
	@Resource
	private DailyDataService dailyDataService;
	@Resource
	private DataService dataService;
	@Resource
	private Sender sender;
	@Value("${myPugin.projectName}")
	String projectName;
	    
	    /**
	     * web金融阅读 ip==阅读
	     * @param channel
	     * @param dataRabbitmqDTO
	     * @param message
	     * @throws IOException
	     */
		    @RabbitListener(queues="${myPugin.rabbitmq.FINANCIALWEBREAD_DIRECT_QUEUE}") 
		    public void financialWebRead(Channel channel, DataRabbitmqDTO dataRabbitmqDTO,Message message) throws IOException   {
		           try {
		        	  /**
		        	   * 判断是否存在
		        	   */
		        	 //如果金融不予统计  
		       		Financial inFinancial = financialService.loadSmallFinancial(dataRabbitmqDTO.getFinancialId());
		       		if(inFinancial==null||inFinancial.equals("")){
		       		 channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		       		 return;
		       		}
		       		//如果账户不存在则用，1000
		       		Acount readinacount = acountBusiness.getAcountByAcountId(dataRabbitmqDTO.getAcountId());//阅读账户
		       		Acount inacount = acountBusiness.getAcountByAcountId(1000);//平台账户
		       		if(readinacount==null||readinacount.equals("")){
		       			readinacount = inacount;
		       		}
		     	   		/**
		        	    * 统计data
		        	    */
		       			//统计当日当前金融每日ip(总统计，做区别ip,保证不同acountId同一IP)
		        	   BoundSetOperations<String, String> bsodatips = stringRedisTemplate.boundSetOps(projectName+"FinancialId"+dataRabbitmqDTO.getFinancialId()+"Data"+DateUtil.getImgDir()+"Ips");
		        	   bsodatips.expire(DateUtil.currentToEndTime(), TimeUnit.SECONDS);//按天计算有用
		        	   int isAddIp=0;//默认没增加
		        	   int oldIPSize = bsodatips.members().size();
		        	   bsodatips.add(dataRabbitmqDTO.getIp());//总ip
		        	   int nowIPSize = bsodatips.members().size();
		        	   if(nowIPSize>oldIPSize){
		        		   isAddIp=1;//增加了
		        	   }
		        	   //统计当日当前人的当前金融每日ip
		        	   BoundSetOperations<String, String> bsodataips = stringRedisTemplate.boundSetOps(projectName+"AcountId"+readinacount.getAcountId()+"FinancialId"+dataRabbitmqDTO.getFinancialId()+"Data"+DateUtil.getImgDir()+"Ips");
		        	   bsodataips.expire(DateUtil.currentToEndTime(), TimeUnit.SECONDS);//按天计算有用
				        	   if(isAddIp==1){
				        	   bsodataips.add(dataRabbitmqDTO.getIp());//ip存入redis数据库
				        	   }
		     	  	//三段时间数据
		   			Data realdata=new Data();
		   			//时间是3段:0-8,8-16,16-24
		   			realdata.setCreateDate(DateUtil.getDayPeriod(3));
		   			realdata.setFinancialId(dataRabbitmqDTO.getFinancialId());
		   			realdata.setAcountId(readinacount.getAcountId());
		   			dataService.saveOrUpdateData(realdata,dataRabbitmqDTO.getUv(), isAddIp,isAddIp);
		   			//日数据
		   			DailyData realdailydata=new DailyData();
		   			//时间是日
		   			realdailydata.setCreateDate(DateUtil.getStartTime());
		   			realdailydata.setFinancialId(dataRabbitmqDTO.getFinancialId());
		   			realdailydata.setAcountId(readinacount.getAcountId());
		   			dailyDataService.saveOrUpdateDailyData(realdailydata, dataRabbitmqDTO.getUv(), isAddIp, isAddIp);
		        	  /**
		        	   * 更新金融
		        	   */
		        	   //当前金融
		        	   Financial financial = financialService.loadSmallFinancial(dataRabbitmqDTO.getFinancialId());
		        	   financial.setReadingNumber(financial.getReadingNumber()+isAddIp);
		        	   financial.setPvs(financial.getPvs()+1);
		        	   financial.setUvs(financial.getUvs()+dataRabbitmqDTO.getUv());
		        	   financial.setIps(financial.getIps()+isAddIp);
		        	   financialService.updateFinancial(financial);//更新金融数据
		        	  channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 try {
						channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
					} catch (IOException e1) {
						channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
						
						e1.printStackTrace();
					}
					//e.printStackTrace();
				} //确认消息成功消费 
		    }  
}
