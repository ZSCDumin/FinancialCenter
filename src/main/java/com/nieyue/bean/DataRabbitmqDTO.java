package com.nieyue.bean;

import java.io.Serializable;
/**
 * 数据rabbitmq对象
 * @author 聂跃
 * @date 2017年6月6日
 */
public class DataRabbitmqDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *金融id外键
	 */
	private  Integer financialId ;
	/**
	 *账户id外键
	 */
	private  Integer acountId ;
	/**
	 *uv
	 */
	private  Integer uv ;
	/**
	 *ip
	 */
	private  String ip ;
	/**
	 *阅读
	 */
	private  Integer readingNumber ;
	
	public Integer getFinancialId() {
		return financialId;
	}
	public void setFinancialId(Integer financialId) {
		this.financialId = financialId;
	}
	public Integer getAcountId() {
		return acountId;
	}
	public void setAcountId(Integer acountId) {
		this.acountId = acountId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getUv() {
		return uv;
	}
	public void setUv(Integer uv) {
		this.uv = uv;
	}
	public DataRabbitmqDTO() {
		super();
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public DataRabbitmqDTO(Integer financialId, Integer acountId, Integer uv, String ip,Integer readingNumber) {
		super();
		this.financialId = financialId;
		this.acountId = acountId;
		this.uv = uv;
		this.ip = ip;
		this.readingNumber=readingNumber;
	}
	public Integer getReadingNumber() {
		return readingNumber;
	}
	public void setReadingNumber(Integer readingNumber) {
		this.readingNumber = readingNumber;
	}
	@Override
	public String toString() {
		return "DataRabbitmqDTO [financialId=" + financialId + ", acountId=" + acountId + ", uv=" + uv + ", ip=" + ip
				+ ", readingNumber=" + readingNumber + "]";
	}
	
}

