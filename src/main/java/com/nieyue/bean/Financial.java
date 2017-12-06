package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 金融
 * @author yy
 *
 */
public class Financial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 金融id
	 */
	private Integer financialId;
	/**
	 * 金融名称
	 */
	private String title;
	/**
	 * 期限
	 */
	private String term;
	/**
	 *推荐，默认0不推，1封推，2首投推，3复投推
	 */
	private Integer recommend;
	/**
	 *封面
	 */
	private String imgAddress;
	/**
	 * 攻略
	 */
	private String strategy;
	/**
	 *平台年化(%)
	 */
	private Double annualTransformation;
	/**
	 *网加息(%)
	 */
	private Double netAddInterest;
	/**
	 *综合年化(%)
	 */
	private Double comprehensiveAnnualTransformation;
	/**
	 *项目总额
	 */
	private Double projectTotalMoney;
	/**
	 *投资限额
	 */
	private Double investmentMoney;
	/**
	 *起投金额
	 */
	private Double startInvestmentMoney;
	/**
	 *计息方式
	 */
	private String interestMethod;
	/**
	 *还款方式
	 */
	private String repaymentMethod;
	/**
	 *pv
	 */
	private Integer pvs;
	/**
	 *uv
	 */
	private Integer uvs;
	/**
	 *ip
	 */
	private Integer ips;
	/**
	 *阅读数
	 */
	private Integer readingNumber;
	/**
	 *跳转url
	 */
	private String redirectUrl;
	/**
	 *下架0,上架1
	 */
	private Integer status;
	/**
	 *金融类型id,外键
	 */
	private Integer financialCateId;
	/**
	 * 金融创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 金融类型
	 */
	private FinancialCate FinancialCate;

	public Financial() {
		super();
	}

	public Financial(Integer financialId, String title, String term, Integer recommend, String imgAddress,
			String strategy, Double annualTransformation, Double netAddInterest,
			Double comprehensiveAnnualTransformation, Double projectTotalMoney, Double investmentMoney,
			Double startInvestmentMoney, String interestMethod, String repaymentMethod, Integer pvs, Integer uvs,
			Integer ips, Integer readingNumber, String redirectUrl, Integer status, Integer financialCateId,
			Date createDate, Date updateDate, com.nieyue.bean.FinancialCate financialCate) {
		super();
		this.financialId = financialId;
		this.title = title;
		this.term = term;
		this.recommend = recommend;
		this.imgAddress = imgAddress;
		this.strategy = strategy;
		this.annualTransformation = annualTransformation;
		this.netAddInterest = netAddInterest;
		this.comprehensiveAnnualTransformation = comprehensiveAnnualTransformation;
		this.projectTotalMoney = projectTotalMoney;
		this.investmentMoney = investmentMoney;
		this.startInvestmentMoney = startInvestmentMoney;
		this.interestMethod = interestMethod;
		this.repaymentMethod = repaymentMethod;
		this.pvs = pvs;
		this.uvs = uvs;
		this.ips = ips;
		this.readingNumber = readingNumber;
		this.redirectUrl = redirectUrl;
		this.status = status;
		this.financialCateId = financialCateId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		FinancialCate = financialCate;
	}

	public Integer getFinancialId() {
		return financialId;
	}

	public void setFinancialId(Integer financialId) {
		this.financialId = financialId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getImgAddress() {
		return imgAddress;
	}

	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public Double getAnnualTransformation() {
		return annualTransformation;
	}

	public void setAnnualTransformation(Double annualTransformation) {
		this.annualTransformation = annualTransformation;
	}

	public Double getNetAddInterest() {
		return netAddInterest;
	}

	public void setNetAddInterest(Double netAddInterest) {
		this.netAddInterest = netAddInterest;
	}

	public Double getComprehensiveAnnualTransformation() {
		return comprehensiveAnnualTransformation;
	}

	public void setComprehensiveAnnualTransformation(Double comprehensiveAnnualTransformation) {
		this.comprehensiveAnnualTransformation = comprehensiveAnnualTransformation;
	}

	public Double getProjectTotalMoney() {
		return projectTotalMoney;
	}

	public void setProjectTotalMoney(Double projectTotalMoney) {
		this.projectTotalMoney = projectTotalMoney;
	}

	public Double getInvestmentMoney() {
		return investmentMoney;
	}

	public void setInvestmentMoney(Double investmentMoney) {
		this.investmentMoney = investmentMoney;
	}

	public Double getStartInvestmentMoney() {
		return startInvestmentMoney;
	}

	public void setStartInvestmentMoney(Double startInvestmentMoney) {
		this.startInvestmentMoney = startInvestmentMoney;
	}

	public String getInterestMethod() {
		return interestMethod;
	}

	public void setInterestMethod(String interestMethod) {
		this.interestMethod = interestMethod;
	}

	public String getRepaymentMethod() {
		return repaymentMethod;
	}

	public void setRepaymentMethod(String repaymentMethod) {
		this.repaymentMethod = repaymentMethod;
	}

	public Integer getPvs() {
		return pvs;
	}

	public void setPvs(Integer pvs) {
		this.pvs = pvs;
	}

	public Integer getUvs() {
		return uvs;
	}

	public void setUvs(Integer uvs) {
		this.uvs = uvs;
	}

	public Integer getIps() {
		return ips;
	}

	public void setIps(Integer ips) {
		this.ips = ips;
	}

	public Integer getReadingNumber() {
		return readingNumber;
	}

	public void setReadingNumber(Integer readingNumber) {
		this.readingNumber = readingNumber;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFinancialCateId() {
		return financialCateId;
	}

	public void setFinancialCateId(Integer financialCateId) {
		this.financialCateId = financialCateId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public FinancialCate getFinancialCate() {
		return FinancialCate;
	}

	public void setFinancialCate(FinancialCate financialCate) {
		FinancialCate = financialCate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
