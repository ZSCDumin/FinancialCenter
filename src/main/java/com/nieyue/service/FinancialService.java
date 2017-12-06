package com.nieyue.service;

import java.util.Date;
import java.util.List;

import com.nieyue.bean.Financial;

/**
 * 金融逻辑层接口
 * @author yy
 *
 */
public interface FinancialService {
	/** 新增金融 */	
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
			Integer recommend,
			Integer financialCateId,
			Date createDate,
			Date updateDate,
			Integer status);
	/** 分页金融信息 */
	public List<Financial> browsePagingFinancial(
			Integer recommend,
			Integer financialCateId,
			Date createDate,
			Date updateDate,
			Integer status,
			int pageNum,
			int pageSize,
			String orderName,
			String orderWay) ;
}
