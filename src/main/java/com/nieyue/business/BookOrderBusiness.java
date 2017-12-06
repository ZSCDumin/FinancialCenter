package com.nieyue.business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.nieyue.exception.BookPayException;
import com.nieyue.util.DateUtil;

/**
 * 书订单业务
 * @author 聂跃
 * @date 2017年8月8日
 */
@Configuration
public class BookOrderBusiness {
	private Map<String ,Object> map=new HashMap<String,Object>();
  /**
   * 书订单 订单类型
   * @param iStartDate 开始时间
   * @param billingMode 计费方式，0免费，1包月，6半年，12包年，默认为1
   * @param payType 支付类型 0全部，1真钱，2积分，默认为1
   * @param iMoney 支付类型 0全部有效，输入积分
   * @param iRealMoney 支付类型 0全部有效，输入真钱
   * @return map:  money（积分） realMoney（真钱） 
 * @throws BookPayException 
   */
	public Map<String ,Object> getBooOrderMoney(Date iStartDate,int billingMode ,int payType,Double iMoney,Double iRealMoney) throws BookPayException{
		Double discount=1.0;//折扣默认为1
		Double baseRealMoney=12.0;//一个月的基础价格
		Double baseMoney=1200.0;//一个月的基础积分
		if(billingMode>=6){//
			discount=0.95;
		}
		if(billingMode>=12){
			discount=0.89;
		}
		Double money=0.0;//积分
		Double realMoney=0.0;//真钱
		Date startDate=new Date();//开始日期
		Date endDate=new Date();//结束日期
		if(iStartDate!=null ){//续费，上次的结束时间为本次的开始时间
			startDate=iStartDate;
			endDate=iStartDate;
		}
		if(iMoney==null||iRealMoney==null){
			iMoney=0.0;
			iRealMoney=0.0;
		}
		//0.免费VIP   7日
		if(billingMode==0){
			money=0.0;
			realMoney=0.0;
			endDate=new Date(startDate.getTime()+7*24*3600*1000l);//结束时间
		}else{
			if(payType==1){//真钱支付
				money=0.0;
				realMoney=(double) Math.round((billingMode*baseRealMoney*discount));
				//realMoney=0.01;
			}else if(payType==2){//积分支付
				money=(double) Math.round((billingMode*baseMoney*discount));
				realMoney=0.0;
			}else if(payType==0 &&(iMoney+iRealMoney*100)==(double)Math.round(billingMode*baseMoney*discount)){//全部支付
				money=iMoney;
				realMoney=iRealMoney;
			}else{
				throw new BookPayException();
			}
			endDate=DateUtil.nextMonth(startDate, billingMode);
		}
		map.put("money", money);
		map.put("realMoney", realMoney);
		map.put("startDate", startDate);
		map.put("endDate",endDate);
		return map;
	}
public Map<String ,Object> getMap() {
	return map;
}
public void setMap(Map<String ,Object> map) {
	this.map = map;
}

public static void main(String[] args) throws BookPayException {
	for (int i = 0; i < 13; i++) {
		//System.err.println(i*0.95*12);
		System.err.println((double)Math.round(i*0.89*12));
		System.out.println((double)Math.round(i*0.95*12));
	}
	 Map<String, Object> bm0pt0 = new BookOrderBusiness().getBooOrderMoney(null,0, 0, 500.0, 5.0);
	 System.out.println(bm0pt0);
	 Map<String, Object> bm0pt1 = new BookOrderBusiness().getBooOrderMoney(null,0, 1, 500.0, 5.0);
	 System.out.println(bm0pt1);
	 Map<String, Object> bm0pt2 = new BookOrderBusiness().getBooOrderMoney(null,0, 2, 500.0, 5.0);
	 System.out.println(bm0pt2);
	 Map<String, Object> bm0pt3 = new BookOrderBusiness().getBooOrderMoney(null,0, 3, 500.0, 5.0);
	 System.out.println(bm0pt3);
	 Map<String, Object> bm1pt0 = new BookOrderBusiness().getBooOrderMoney(null,1, 0, 500.0, 5.0);
	 System.out.println(bm1pt0);
	 Map<String, Object> bm1pt1 = new BookOrderBusiness().getBooOrderMoney(null,1, 1, 500.0, 5.0);
	 System.out.println(bm1pt1);
	 Map<String, Object> bm1pt2 = new BookOrderBusiness().getBooOrderMoney(null,1, 2, 500.0, 5.0);
	 System.out.println(bm1pt2);
	 Map<String, Object> bm1pt3 = new BookOrderBusiness().getBooOrderMoney(null,1, 3, 500.0, 5.0);
	 System.out.println(bm1pt3);
	 Map<String, Object> bm2pt0 = new BookOrderBusiness().getBooOrderMoney(null,2, 0, 2800.0, 80.0);
	 System.out.println(bm2pt0);
	 Map<String, Object> bm2pt1 = new BookOrderBusiness().getBooOrderMoney(null,2, 1, 2800.0, 80.0);
	 System.out.println(bm2pt1);
	 Map<String, Object> bm2pt2 = new BookOrderBusiness().getBooOrderMoney(null,2, 2, 2800.0, 80.0);
	 System.out.println(bm2pt2);
	 Map<String, Object> bm2pt3 = new BookOrderBusiness().getBooOrderMoney(null,2, 3, 2800.0, 80.0);
	 System.out.println(bm2pt3);
	 Map<String, Object> bm2pt4 = new BookOrderBusiness().getBooOrderMoney(null,2, 0, null, null);
	 System.out.println(bm2pt4);
	 
}
}
