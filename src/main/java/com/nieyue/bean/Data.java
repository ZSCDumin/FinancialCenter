package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据类
 * 
 * @author yy
 * 
 */
public class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 数据id
	 */
	private Integer dataId;
	
	/**
	 * pv数
	 */
	private Long pvs;
	/**
	 * uv数
	 */
	private Long uvs;
	
	/**
	 * ip数
	 */
	private Long ips;
	/**
	 * 阅读数
	 */
	private Long readingNumber;
	
	/**
	 *创建时间
	 */
	private Date createDate;
	/**
	 * 金融ID
	 */
	private Integer financialId;
	/**
	 * 账户ID
	 */
	private Integer acountId;
	public Data() {
		super();
	}
	public Data(Integer dataId, Long pvs, Long uvs, Long ips,Long readingNumber, Date createDate, Integer financialId,Integer acountId) {
		super();
		this.dataId = dataId;
		this.pvs = pvs;
		this.uvs = uvs;
		this.ips = ips;
		this.readingNumber=readingNumber;
		this.createDate = createDate;
		this.financialId = financialId;
		this.acountId=acountId;
	}
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public Long getPvs() {
		return pvs;
	}
	public void setPvs(Long pvs) {
		this.pvs = pvs;
	}
	public Long getUvs() {
		return uvs;
	}
	public void setUvs(Long uvs) {
		this.uvs = uvs;
	}
	public Long getIps() {
		return ips;
	}
	public void setIps(Long ips) {
		this.ips = ips;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getFinancialId() {
		return financialId;
	}
	public void setFinancialId(Integer financialId) {
		this.financialId = financialId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getAcountId() {
		return acountId;
	}
	public void setAcountId(Integer acountId) {
		this.acountId = acountId;
	}
	public Long getReadingNumber() {
		return readingNumber;
	}
	public void setReadingNumber(Long readingNumber) {
		this.readingNumber = readingNumber;
	}
	@Override
	public String toString() {
		return "Data [dataId=" + dataId + ", pvs=" + pvs + ", uvs=" + uvs + ", ips=" + ips + ", readingNumber="
				+ readingNumber + ", createDate=" + createDate + ", financialId=" + financialId + ", acountId=" + acountId
				+ "]";
	}
		
}
