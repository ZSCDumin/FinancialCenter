package com.nieyue.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.DailyData;
import com.nieyue.dao.DailyDataDao;
import com.nieyue.service.DailyDataService;
@Service
public class DailyDataServiceImpl implements DailyDataService{
	@Resource
	DailyDataDao dailyDataDao;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addDailyData(DailyData dailyData) {
		dailyData.setCreateDate(new Date());
		boolean b = dailyDataDao.addDailyData(dailyData);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delDailyData(Integer dailyDataId) {
		boolean b = dailyDataDao.delDailyData(dailyDataId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateDailyData(DailyData dailyData) {
		boolean b = dailyDataDao.updateDailyData(dailyData);
		return b;
	}

	@Override
	public DailyData loadDailyData(Integer dailyDataId,Date createDate,Integer financialId,Integer acountId) {
		DailyData r = dailyDataDao.loadDailyData(dailyDataId,createDate,financialId,acountId);
		return r;
	}

	@Override
	public int countAll(Date createDate,Integer financialId,Integer acountId) {
		int c = dailyDataDao.countAll(createDate,financialId,acountId);
		return c;
	}

	@Override
	public List<DailyData> browsePagingDailyData(Date createDate,Integer financialId,Integer acountId,int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<DailyData> l = dailyDataDao.browsePagingDailyData(createDate,financialId,acountId,pageNum-1, pageSize, orderName, orderWay);
		return l;
	}
	@Override
	public boolean saveOrUpdateDailyData(DailyData dailyData, int uv, int ip,int readingNumber) {
		boolean b = dailyDataDao.saveOrUpdateDailyData(dailyData, uv, ip,readingNumber);
		return b;
	}
	@Override
	public List<DailyData> statisticsDailyData(Date startDate,Date endDate, Integer financialId,Integer acountId, int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<DailyData> l = dailyDataDao.statisticsDailyData(startDate,endDate, financialId, acountId, pageNum-1, pageSize, orderName, orderWay);
		return l;
	}

	
}
