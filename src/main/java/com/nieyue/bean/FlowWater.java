package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 流水
 * @author yy
 *
 */
public class FlowWater implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 流水id
	 */
	private Integer flowWaterId;
	
	/**
	 * 类型,1.新手任务 ,2.日常任务,3.达人奖励,4.文章阅读,5.徒弟进贡,6.推广分成,-1.兑换商品
	 */
	private Integer type;
	/**
	 * 子类型,1(0,1,2,3,4,5),2(1,2,3,4,5),3(1,2,3,4,5,6,7),4(1),5(1),6(1),-1(1)
	 */
	private Integer subtype;
	/**
	 * 流水积分，负数为消耗
	 */
	private Double money;
	/**
	 * 流水真钱，负数为消耗
	 */
	private Double realMoney;
	/**
	 * 流水创建时间
	 */
	private Date createDate;
	/**
	 * 流水人id外键
	 */
	private Integer acountId;
	
	
	public FlowWater() {
		super();
	}
	
	public FlowWater(Integer flowWaterId, Integer type, Integer subtype, Double money, Double realMoney,
			Date createDate, Integer acountId) {
		super();
		this.flowWaterId = flowWaterId;
		this.type = type;
		this.subtype = subtype;
		this.money = money;
		this.realMoney = realMoney;
		this.createDate = createDate;
		this.acountId = acountId;
	}

	public Integer getFlowWaterId() {
		return flowWaterId;
	}
	public void setFlowWaterId(Integer flowWaterId) {
		this.flowWaterId = flowWaterId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSubtype() {
		return subtype;
	}
	public void setSubtype(Integer subtype) {
		this.subtype = subtype;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public Double getRealMoney() {
		return realMoney;
	}
	public void setRealMoney(Double realMoney) {
		this.realMoney = realMoney;
	}
	
}
