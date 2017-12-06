package com.nieyue.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.FinancialCate;
import com.nieyue.dao.FinancialCateDao;
import com.nieyue.service.FinancialCateService;
@Service
public class FinancialCateServiceImpl implements FinancialCateService{
	@Resource
	FinancialCateDao financialCateDao;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addFinancialCate(FinancialCate financialCate) {
		financialCate.setUpdateDate(new Date());
		boolean b = financialCateDao.addFinancialCate(financialCate);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delFinancialCate(Integer financialCateId) {
		boolean b = financialCateDao.delFinancialCate(financialCateId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateFinancialCate(FinancialCate financialCate) {
		financialCate.setUpdateDate(new Date());
		boolean b = financialCateDao.updateFinancialCate(financialCate);
		return b;
	}

	@Override
	public FinancialCate loadFinancialCate(Integer financialCateId,String name) {
		FinancialCate r = financialCateDao.loadFinancialCate(financialCateId,name);
		return r;
	}

	@Override
	public int countAll() {
		int c = financialCateDao.countAll();
		return c;
	}

	@Override
	public List<FinancialCate> browsePagingFinancialCate(int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<FinancialCate> l = financialCateDao.browsePagingFinancialCate(pageNum-1, pageSize, orderName, orderWay);
		return l;
	}

	
}
