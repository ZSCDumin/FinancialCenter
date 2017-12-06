package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 金融类型
 * @author yy
 *
 */
public class FinancialCate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 金融类型id
	 */
	private Integer financialCateId;
	
	/**
	 * 金融类型名
	 */
	private String name;
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public FinancialCate(Integer financialCateId, String name, String duty, Date updateDate) {
		super();
		this.financialCateId = financialCateId;
		this.name = name;
		this.updateDate = updateDate;
	}
	public FinancialCate() {
		super();
	}
	public Integer getfinancialCateId() {
		return financialCateId;
	}
	public void setfinancialCateId(Integer financialCateId) {
		this.financialCateId = financialCateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "financialCate [financialCateId=" + financialCateId + ", name=" + name + ", updateDate=" + updateDate + "]";
	}
	
}
