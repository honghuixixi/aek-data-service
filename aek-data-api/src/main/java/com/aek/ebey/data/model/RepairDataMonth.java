package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 维修设备月份完修数与费用统计表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("repair_data_month")
public class RepairDataMonth extends BaseModel {

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
	 * 月份（如：2018-04）
	 */
	@TableField(value="count_month")
	private String countMonth;
	/**
	 * 完修总数
	 */
	@TableField(value="repair_complete_total_num")
	private Long repairCompleteTotalNum;
	/**
	 * 完修费用
	 */
	@TableField(value="repair_complate_total_capital")
	private Double repairComplateTotalCapital;
	/**
	 * 统计时间
	 */
	@TableField(value="count_time")
	private Date countTime;
	/**
	 * 更新时间
	 */
	@TableField(value="update_time")
	private Date updateTime;


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

	public String getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(String countMonth) {
		this.countMonth = countMonth;
	}

	public Long getRepairCompleteTotalNum() {
		return repairCompleteTotalNum;
	}

	public void setRepairCompleteTotalNum(Long repairCompleteTotalNum) {
		this.repairCompleteTotalNum = repairCompleteTotalNum;
	}

	public Double getRepairComplateTotalCapital() {
		return repairComplateTotalCapital;
	}

	public void setRepairComplateTotalCapital(Double repairComplateTotalCapital) {
		this.repairComplateTotalCapital = repairComplateTotalCapital;
	}

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
