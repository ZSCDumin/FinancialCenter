package com.nieyue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.FinancialCate;
import com.nieyue.service.FinancialCateService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;


/**
 * 金融类型控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/financialCate")
public class FinancialCateController {
	@Resource
	private FinancialCateService financialCateService;
	
	/**
	 * 金融类型分页浏览
	 * @param orderName 金融排序数据库字段
	 * @param orderWay 金融排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingFinancialCate(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="financial_cate_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay)  {
			List<FinancialCate> list = new ArrayList<FinancialCate>();
			list= financialCateService.browsePagingFinancialCate(pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 金融类型修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateFinancialCate(@ModelAttribute FinancialCate financialCate,HttpSession session)  {
		boolean um = financialCateService.updateFinancialCate(financialCate);
		return ResultUtil.getSR(um);
	}
	/**
	 * 金融类型增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addFinancialCate(@ModelAttribute FinancialCate financialCate, HttpSession session) {
		boolean am = financialCateService.addFinancialCate(financialCate);
		return ResultUtil.getSR(am);
	}
	/**
	 * 金融类型删除
	 * @return
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delFinancialCate(@RequestParam("financialCateId") Integer financialCateId,HttpSession session)  {
		boolean dm = financialCateService.delFinancialCate(financialCateId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 金融类型浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(HttpSession session)  {
		int count = financialCateService.countAll();
		return count;
	}
	/**
	 * 金融类型单个加载
	 * @return
	 */
	@RequestMapping(value = "/{financialCateId}", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList loadFinancialCate(@PathVariable("financialCateId") Integer financialCateId,HttpSession session)  {
		List<FinancialCate> list = new ArrayList<FinancialCate>();
		FinancialCate financialCate = financialCateService.loadFinancialCate(financialCateId,null);
			if(financialCate!=null &&!financialCate.equals("")){
				list.add(financialCate);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	
}
