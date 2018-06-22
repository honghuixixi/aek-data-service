package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * PM数据月份统计表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("qc_pm_data_month")
public class QcPmDataMonth extends BaseModel {

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
	 * 统计年月份（如：2018-04）
	 */
	@TableField(value="count_month")
	private String countMonth;
	/**
	 * PM执行设备总数（台/次）（累加值）
	 */
	@TableField(value="pm_assets_total")
	private Long pmAssetsTotal;
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

	public Long getPmAssetsTotal() {
		return pmAssetsTotal;
	}

	public void setPmAssetsTotal(Long pmAssetsTotal) {
		this.pmAssetsTotal = pmAssetsTotal;
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
