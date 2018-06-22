package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 维修概览表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("repair_data")
public class RepairData extends BaseModel {

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
	 * 本年度报修总数（台/次）（累加值）
	 */
	@TableField(value="apply_total_num_year")
	private Long applyTotalNumYear;
	/**
	 * 本年度完修总数（累加值）
	 */
	@TableField(value="complete_total_num_year")
	private Long completeTotalNumYear;
	/**
	 * 年度维修费总额
	 */
	@TableField(value="repair_total_capital_year")
	private Double repairTotalCapitalYear;
	/**
	 * 在修设备总数
	 */
	@TableField(value="repair_assets_num")
	private Long repairAssetsNum;
	
	/**
     * 待修设备总数
     */
    @TableField(value="wait_repair_assets_num")
	private Long waitRepairAssetsNum;
	/**
	 * 维修状态分布JSON数据（待接单总数，待接单比例，维修中总数，维修中比例，待验收总数，待验收比例，已完成总数，已完成比例）
	 */
	@TableField(value="repair_distribution_data")
	private String repairDistributionData;
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

	public Long getApplyTotalNumYear() {
		return applyTotalNumYear;
	}

	public void setApplyTotalNumYear(Long applyTotalNumYear) {
		this.applyTotalNumYear = applyTotalNumYear;
	}

	public Long getCompleteTotalNumYear() {
		return completeTotalNumYear;
	}

	public void setCompleteTotalNumYear(Long completeTotalNumYear) {
		this.completeTotalNumYear = completeTotalNumYear;
	}

	public Double getRepairTotalCapitalYear() {
		return repairTotalCapitalYear;
	}

	public void setRepairTotalCapitalYear(Double repairTotalCapitalYear) {
		this.repairTotalCapitalYear = repairTotalCapitalYear;
	}

	public Long getRepairAssetsNum() {
		return repairAssetsNum;
	}

	public void setRepairAssetsNum(Long repairAssetsNum) {
		this.repairAssetsNum = repairAssetsNum;
	}

	public String getRepairDistributionData() {
		return repairDistributionData;
	}

	public void setRepairDistributionData(String repairDistributionData) {
		this.repairDistributionData = repairDistributionData;
	}

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}

    public Long getWaitRepairAssetsNum() {
        return waitRepairAssetsNum;
    }

    public void setWaitRepairAssetsNum(Long waitRepairAssetsNum) {
        this.waitRepairAssetsNum = waitRepairAssetsNum;
    }

}
