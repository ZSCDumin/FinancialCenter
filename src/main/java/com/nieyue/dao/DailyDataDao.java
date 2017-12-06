package com.nieyue.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.DailyData;

/**
 * 每日数据数据库接口
 * @author yy
 *
 */
@Mapper
public interface DailyDataDao {
	/** 新增每日数据*/	
	public boolean addDailyData(DailyData dailyData) ;	
	/** 删除每日数据 */	
	public boolean delDailyData(Integer dailyDataId) ;
	/** 更新每日数据*/	
	public boolean updateDailyData(DailyData dailyData);
	/** 新增或更新每日数据*/	
	public boolean saveOrUpdateDailyData(@Param("DailyData")DailyData dailyData,@Param("uv")int uv,@Param("ip")int ip,@Param("readingNumber")int readingNumber);
	/** 装载每日数据 */	
	public DailyData loadDailyData(@Param("dailyDataId")Integer dailyDataId,@Param("createDate")Date createDate,@Param("financialId")Integer financialId,@Param("acountId")Integer acountId);	
	/** 每日数据总共数目 */	
	public int countAll(@Param("createDate")Date createDate,@Param("financialId")Integer financialId,@Param("acountId")Integer acountId);	
	/** 分页每日数据信息 */
	public List<DailyData> browsePagingDailyData(@Param("createDate")Date createDate,@Param("financialId")Integer financialId,@Param("acountId")Integer acountId,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;		
	/** 统计每日数据信息 */
	public List<DailyData> statisticsDailyData(@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("financialId")Integer financialId,@Param("acountId")Integer acountId,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;		
}
