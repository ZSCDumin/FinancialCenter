package com.nieyue.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.Financial;
import com.nieyue.bean.DataRabbitmqDTO;
import com.nieyue.comments.IPCountUtil;
import com.nieyue.rabbitmq.confirmcallback.Sender;
import com.nieyue.service.FinancialService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;


/**
 * 金融控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/financial")
public class FinancialController {
	@Resource
	private FinancialService financialService;
	@Resource
	private Sender sender;
	
	/**
	 * web阅读文章获取 根据FinancialId、acountId、uv来统计数据
	 * @return
	 */
	@RequestMapping(value = "/webRead", method = {RequestMethod.GET,RequestMethod.POST})
	public StateResult webReadFinancial(
			@RequestParam(value="financialId") Integer financialId,
			@RequestParam(value="acountId") Integer acountId,
			@RequestParam(value="uv",defaultValue="0",required=false) Integer uv,
			HttpSession session,HttpServletRequest request)  {
		if(uv!=0 &&uv!=1){
			return ResultUtil.getFail();
		}
		DataRabbitmqDTO drd=new DataRabbitmqDTO();
		drd.setAcountId(acountId);//转发    10积分（获得3个有效阅读）
		drd.setFinancialId(financialId);
		drd.setUv(uv);
		drd.setIp(IPCountUtil.getIpAddr(request));//请求的ip地址
		sender.sendFinancialWebRead(drd);
		return ResultUtil.getSuccess();
	}
	
	/**
	 * 金融分页浏览
	 * @param orderName 金融排序数据库字段
	 * @param orderWay 金融排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingFinancial(
			@RequestParam(value="recommend",required=false)Integer recommend,
			@RequestParam(value="financialCateId",required=false)Integer financialCateId,
			@RequestParam(value="createDate",required=false)Date createDate,
			@RequestParam(value="updateDate",required=false)Date updateDate,
			@RequestParam(value="status",required=false)Integer status,
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="Financial_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay)  {
			List<Financial> list = new ArrayList<Financial>();
			list= financialService.browsePagingFinancial(recommend,financialCateId,createDate,updateDate,status,pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 金融修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateFinancial(@RequestBody Financial financial,HttpSession session)  {
		boolean um = financialService.updateFinancial(financial);
		return ResultUtil.getSR(um);
	}
	/**
	 * 金融增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addFinancial(@RequestBody Financial financial, HttpSession session) {
		boolean am = financialService.addFinancial(financial);
		return ResultUtil.getSR(am);
	}
	/**
	 * 金融删除
	 * @return
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delFinancial(@RequestParam("FinancialId") Integer financialId,HttpSession session)  {
		boolean dm = financialService.delFinancial(financialId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 金融浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(
			@RequestParam(value="recommend",required=false)Integer recommend,
			@RequestParam(value="financialCateId",required=false)Integer financialCateId,
			@RequestParam(value="createDate",required=false)Date createDate,
			@RequestParam(value="updateDate",required=false)Date updateDate,
			@RequestParam(value="status",required=false)Integer status,
			HttpSession session)  {
		int count = financialService.countAll(recommend,financialCateId,createDate,updateDate,status);
		return count;
	}
	/**
	 * 金融单个加载
	 * @return
	 */
	@RequestMapping(value = "/{financialId}", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList loadFinancial(@PathVariable("financialId") Integer financialId,HttpSession session)  {
		List<Financial> list = new ArrayList<Financial>();
		Financial financial = financialService.loadFinancial(financialId);
			if(financial!=null &&!financial.equals("")){
				list.add(financial);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 金融单个加载
	 * @return
	 */
	@RequestMapping(value = "/loadSmall/{financialId}", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList loadSmallFinancial(@PathVariable("financialId") Integer financialId,HttpSession session)  {
		List<Financial> list = new ArrayList<Financial>();
		Financial financial = financialService.loadSmallFinancial(financialId);
		if(financial!=null &&!financial.equals("")){
			list.add(financial);
			return ResultUtil.getSlefSRSuccessList(list);
		}else{
			return ResultUtil.getSlefSRFailList(list);
		}
	}
	
}
