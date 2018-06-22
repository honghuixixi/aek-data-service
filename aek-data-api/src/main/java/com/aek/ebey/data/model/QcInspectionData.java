package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 设备巡检数据概览统计表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("qc_inspection_data")
public class QcInspectionData extends BaseModel {

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
	 * 年度巡检总数(台/次)（累加值）
	 */
	@TableField(value="inspection_total_year")
	private Long inspectionTotalYear;
	/**
	 * 年度巡检计划总数（累加值）
	 */
	@TableField(value="inspection_plan_total_year")
	private Long inspectionPlanTotalYear;
	/**
	 * 年度巡检执行率（百分比）
	 */
	@TableField(value="inspection_rate_year")
	private Double inspectionRateYear;
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

	public Long getInspectionTotalYear() {
		return inspectionTotalYear;
	}

	public void setInspectionTotalYear(Long inspectionTotalYear) {
		this.inspectionTotalYear = inspectionTotalYear;
	}

	public Long getInspectionPlanTotalYear() {
		return inspectionPlanTotalYear;
	}

	public void setInspectionPlanTotalYear(Long inspectionPlanTotalYear) {
		this.inspectionPlanTotalYear = inspectionPlanTotalYear;
	}

	public Double getInspectionRateYear() {
		return inspectionRateYear;
	}

	public void setInspectionRateYear(Double inspectionRateYear) {
		this.inspectionRateYear = inspectionRateYear;
	}

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}

}
