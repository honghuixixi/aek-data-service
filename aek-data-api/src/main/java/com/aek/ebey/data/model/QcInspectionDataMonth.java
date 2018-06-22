package com.aek.ebey.data.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 巡检数据月份统计表
 *
 * @author Honghui
 * @since 2018-04-16
 */
@TableName("qc_inspection_data_month")
public class QcInspectionDataMonth extends BaseModel {

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
	 * 统计年月份(如:2018-04)
	 */
	@TableField(value="count_month")
	private String countMonth;
	/**
	 * 巡检设备总数（台/次）（累加值）
	 */
	@TableField(value="inspection_assets_total")
	private Long inspectionAssetsTotal;
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

	public Long getInspectionAssetsTotal() {
		return inspectionAssetsTotal;
	}

	public void setInspectionAssetsTotal(Long inspectionAssetsTotal) {
		this.inspectionAssetsTotal = inspectionAssetsTotal;
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
