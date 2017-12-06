package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.FinancialCate;

/**
 * 金融类型数据库接口
 * @author yy
 *
 */
@Mapper
public interface FinancialCateDao {
	/** 新增金融类型*/	
	public boolean addFinancialCate(FinancialCate financialCate) ;	
	/** 删除金融类型 */	
	public boolean delFinancialCate(Integer financialCateId) ;
	/** 更新金融类型*/	
	public boolean updateFinancialCate(FinancialCate financialCate);
	/** 装载金融类型 */	
	public FinancialCate loadFinancialCate(@Param("financialCateId")Integer financialCateId,@Param("name")String name);	
	/** 金融类型总共数目 */	
	public int countAll();	
	/** 分页金融类型信息 */
	public List<FinancialCate> browsePagingFinancialCate(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;		
}
