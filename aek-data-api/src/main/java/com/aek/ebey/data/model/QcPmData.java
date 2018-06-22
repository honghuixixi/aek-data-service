package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 设备PM数据概览统计表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("qc_pm_data")
public class QcPmData extends BaseModel {

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
	 * 年度PM实施总数（累加值）
	 */
	@TableField(value="pm_implement_total_year")
	private Long pmImplementTotalYear;
	/**
	 * 年度PM计划总数（累加值）
	 */
	@TableField(value="pm_plan_total_year")
	private Long pmPlanTotalYear;
	/**
	 * 年度PM执行率(百分比)
	 */
	@TableField(value="pm_rate_year")
	private Double pmRateYear;
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

	public Long getPmImplementTotalYear() {
		return pmImplementTotalYear;
	}

	public void setPmImplementTotalYear(Long pmImplementTotalYear) {
		this.pmImplementTotalYear = pmImplementTotalYear;
	}

	public Long getPmPlanTotalYear() {
		return pmPlanTotalYear;
	}

	public void setPmPlanTotalYear(Long pmPlanTotalYear) {
		this.pmPlanTotalYear = pmPlanTotalYear;
	}

	public Double getPmRateYear() {
		return pmRateYear;
	}

	public void setPmRateYear(Double pmRateYear) {
		this.pmRateYear = pmRateYear;
	}

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}

}
