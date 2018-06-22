package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 资产概览统计表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("assets_data")
public class AssetsData extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 机构ID
	 */
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 统计日期（年月日）
	 */
	@TableField(value="count_date")
	private Date countDate;
	/**
	 * 资产设备总数
	 */
	@TableField(value="assets_total_num")
	private Long assetsTotalNum;
	/**
	 * 资产设备总额
	 */
	@TableField(value="assets_total_capital")
	private Double assetsTotalCapital;
	/**
	 * 年度新增设备总数
	 */
	@TableField(value="assets_total_new_num_year")
	private Long assetsTotalNewNumYear;
	/**
	 * 资产年度报损总数
	 */
	@TableField(value="assets_total_discard_num_year")
	private Long assetsTotalDiscardNumYear;
	/**
	 * 年度新增设备总额
	 */
	@TableField(value="assets_total_new_capital_year")
	private Double assetsTotalNewCapitalYear;
	/**
	 * 年度设备报损总额
	 */
	@TableField(value="assets_total_discard_capital_year")
	private Double assetsTotalDiscardCapitalYear;
	/**
	 * 维修中设备百分比
	 */
	@TableField(value="assets_repair_percent")
	private Double assetsRepairPercent;
	/**
	 * 正常设备百分比
	 */
	@TableField(value="assets_unrepair_percent")
	private Double assetsUnrepairPercent;
	/**
	 * 资产分布比例JSON数据集合（比例项ID，比例项描述，分布比例，排序）
	 */
	@TableField(value="assets_distribution_data")
	private String assetsDistributionData;
	/**
	 * 统计时间
	 */
	@TableField(value="count_time")
	private Date countTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Date getCountDate() {
		return countDate;
	}

	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}

	public Long getAssetsTotalNum() {
		return assetsTotalNum;
	}

	public void setAssetsTotalNum(Long assetsTotalNum) {
		this.assetsTotalNum = assetsTotalNum;
	}

	public Double getAssetsTotalCapital() {
		return assetsTotalCapital;
	}

	public void setAssetsTotalCapital(Double assetsTotalCapital) {
		this.assetsTotalCapital = assetsTotalCapital;
	}

	public Long getAssetsTotalNewNumYear() {
		return assetsTotalNewNumYear;
	}

	public void setAssetsTotalNewNumYear(Long assetsTotalNewNumYear) {
		this.assetsTotalNewNumYear = assetsTotalNewNumYear;
	}

	public Long getAssetsTotalDiscardNumYear() {
		return assetsTotalDiscardNumYear;
	}

	public void setAssetsTotalDiscardNumYear(Long assetsTotalDiscardNumYear) {
		this.assetsTotalDiscardNumYear = assetsTotalDiscardNumYear;
	}

	public Double getAssetsTotalNewCapitalYear() {
		return assetsTotalNewCapitalYear;
	}

	public void setAssetsTotalNewCapitalYear(Double assetsTotalNewCapitalYear) {
		this.assetsTotalNewCapitalYear = assetsTotalNewCapitalYear;
	}

	public Double getAssetsTotalDiscardCapitalYear() {
		return assetsTotalDiscardCapitalYear;
	}

	public void setAssetsTotalDiscardCapitalYear(Double assetsTotalDiscardCapitalYear) {
		this.assetsTotalDiscardCapitalYear = assetsTotalDiscardCapitalYear;
	}

	public Double getAssetsRepairPercent() {
		return assetsRepairPercent;
	}

	public void setAssetsRepairPercent(Double assetsRepairPercent) {
		this.assetsRepairPercent = assetsRepairPercent;
	}

	public Double getAssetsUnrepairPercent() {
		return assetsUnrepairPercent;
	}

	public void setAssetsUnrepairPercent(Double assetsUnrepairPercent) {
		this.assetsUnrepairPercent = assetsUnrepairPercent;
	}

	public String getAssetsDistributionData() {
		return assetsDistributionData;
	}

	public void setAssetsDistributionData(String assetsDistributionData) {
		this.assetsDistributionData = assetsDistributionData;
	}

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}

}
