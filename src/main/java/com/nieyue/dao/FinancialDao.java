package com.nieyue.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Financial;

/**
 * 金融数据库接口
 * @author yy
 *
 */
@Mapper
public interface FinancialDao {
	/** 新增金融*/	
	public boolean addFinancial(Financial financial) ;	
	/** 删除金融 */	
	public boolean delFinancial(Integer financialId) ;
	/** 更新金融*/	
	public boolean updateFinancial(Financial financial);
	/** 装载金融 */	
	public Financial loadFinancial(Integer financialId);	
	/** 装载small金融 */	
	public Financial loadSmallFinancial(Integer financialId);	
	/** 金融总共数目 */	
	public int countAll(
			@Param("recommend")Integer recommend,
			@Param("financialCateId")Integer financialCateId,
			@Param("createDate")Date createDate,
			@Param("updateDate")Date updateDate,
			@Param("status")Integer status
			);	
	/** 分页金融信息 */
	public List<Financial> browsePagingFinancial(
			@Param("recommend")Integer recommend,
			@Param("financialCateId")Integer financialCateId,
			@Param("createDate")Date createDate,
			@Param("updateDate")Date updateDate,
			@Param("status")Integer status,
			@Param("pageNum")int pageNum,
			@Param("pageSize")int pageSize,
			@Param("orderName")String orderName,
			@Param("orderWay")String orderWay) ;		
}
