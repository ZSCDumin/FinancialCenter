package com.nieyue.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.Financial;
import com.nieyue.bean.FinancialCate;
import com.nieyue.dao.FinancialDao;
import com.nieyue.service.FinancialCateService;
import com.nieyue.service.FinancialService;
@Service
public class FinancialServiceImpl implements FinancialService{
	@Resource
	FinancialDao financialDao;
	@Resource
	FinancialCateService financialCateService;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addFinancial(Financial financial) {
		financial.setCreateDate(new Date());
		financial.setUpdateDate(new Date());
		financial.setPvs(0);
		financial.setUvs(0);
		financial.setIps(0);
		financial.setReadingNumber(0);
		if(financial.getRecommend()==null||financial.getRecommend().equals("")){
			financial.setRecommend(0);//默认不推
		}
		if(financial.getStatus()==null||financial.getStatus().equals("")){
			financial.setStatus(1);//默认上架
		}
		boolean b = financialDao.addFinancial(financial);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delFinancial(Integer financialId) {
		boolean b = financialDao.delFinancial(financialId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateFinancial(Financial financial) {
		financial.setUpdateDate(new Date());
		boolean b = financialDao.updateFinancial(financial);
		return b;
	}

	@Override
	public Financial loadFinancial(Integer financialId) {
		Financial financial = financialDao.loadFinancial(financialId);
		FinancialCate financialCate = financialCateService.loadFinancialCate(financial.getFinancialCateId(),null);
		financial.setFinancialCate(financialCate);
		return financial;
	}

	@Override
	public int countAll(
			Integer recommend,
			Integer financialCateId,
			Date createDate,
			Date updateDate,
			Integer status) {
		int c = financialDao.countAll(
				 recommend,
				 financialCateId,
				 createDate,
				 updateDate,
				 status);
		return c;
	}

	@Override
	public List<Financial> browsePagingFinancial(
			Integer recommend,
			Integer financialCateId,
			Date createDate,
			Date updateDate,
			Integer status,
			int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Financial> l = financialDao.browsePagingFinancial(
				 recommend,
				 financialCateId,
				 createDate,
				 updateDate,
				 status,
				 pageNum-1, pageSize, orderName, orderWay);
		
		for (Financial financial : l) {
			FinancialCate financialCate = financialCateService.loadFinancialCate(financial.getFinancialCateId(),null);
			financial.setFinancialCate(financialCate);
		}
		return l;
	}
	@Override
	public Financial loadSmallFinancial(Integer financialId) {
		Financial financial = financialDao.loadSmallFinancial(financialId);
		return financial;
	}

	
}
