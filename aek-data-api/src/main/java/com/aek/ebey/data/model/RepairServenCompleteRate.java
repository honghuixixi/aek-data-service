package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 设备月度7天完修率表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("repair_serven_complete_rate")
public class RepairServenCompleteRate extends BaseModel {

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
	 * 统计月份（如：2018-004）
	 */
	@TableField(value="count_month")
	private String countMonth;
	/**
	 * 7天完修率（百分比）
	 */
	@TableField(value="serven_complete_rate")
	private Double servenCompleteRate;
	/**
	 * 申请单总数
	 */
	@TableField(value="apply_total_num")
	private Long applyTotalNum;
	/**
	 * 7天完修总数
	 */
	@TableField(value="serven_complete_total_num")
	private Long servenCompleteTotalNum;
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

	public Double getServenCompleteRate() {
		return servenCompleteRate;
	}

	public void setServenCompleteRate(Double servenCompleteRate) {
		this.servenCompleteRate = servenCompleteRate;
	}

	public Long getApplyTotalNum() {
		return applyTotalNum;
	}

	public void setApplyTotalNum(Long applyTotalNum) {
		this.applyTotalNum = applyTotalNum;
	}

	public Long getServenCompleteTotalNum() {
		return servenCompleteTotalNum;
	}

	public void setServenCompleteTotalNum(Long servenCompleteTotalNum) {
		this.servenCompleteTotalNum = servenCompleteTotalNum;
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
