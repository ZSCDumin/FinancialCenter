package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.FinancialCate;

/**
 * 金融类型逻辑层接口
 * @author yy
 *
 */
public interface FinancialCateService {
	/** 新增金融类型 */	
	public boolean addFinancialCate(FinancialCate financialCate) ;	
	/** 删除金融类型 */	
	public boolean delFinancialCate(Integer financialCateId) ;
	/** 更新金融类型*/	
	public boolean updateFinancialCate(FinancialCate financialCate);
	/** 装载金融类型 */	
	public FinancialCate loadFinancialCate(Integer financialCateId,String name);	
	/** 金融类型总共数目 */	
	public int countAll();
	/** 分页金融类型信息 */
	public List<FinancialCate> browsePagingFinancialCate(int pageNum,int pageSize,String orderName,String orderWay) ;
}
