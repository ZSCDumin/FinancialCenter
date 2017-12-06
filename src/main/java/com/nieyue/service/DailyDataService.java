package com.nieyue.service;

import java.util.Date;
import java.util.List;

import com.nieyue.bean.DailyData;

/**
 * 每日数据逻辑层接口
 * @author yy
 *
 */
public interface DailyDataService {
	/** 新增每日数据 */	
	public boolean addDailyData(DailyData dailyData) ;	
	/** 删除每日数据 */	
	public boolean delDailyData(Integer dailyDataId) ;
	/** 更新每日数据*/	
	public boolean updateDailyData(DailyData dailyData);
	/** 新增或更新每日数据*/	
	public boolean saveOrUpdateDailyData(DailyData dailyData,int uv,int ip,int readingNumber);
	/** 装载每日数据 */	
	public DailyData loadDailyData(Integer dailyDataId,Date createDate,Integer financialId,Integer acountId);	
	/** 每日数据总共数目 */	
	public int countAll(Date createDate,Integer financialId,Integer acountId);
	/** 分页每日数据信息 */
	public List<DailyData> browsePagingDailyData(Date createDate,Integer financialId,Integer acountId,int pageNum,int pageSize,String orderName,String orderWay) ;
	/** 统计每日数据信息 */
	public List<DailyData> statisticsDailyData(Date createDate,Date endDate,Integer financialId,Integer acountId,int pageNum,int pageSize,String orderName,String orderWay) ;		
}
