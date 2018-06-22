package com.aek.ebey.data.response;

import java.util.Map;

public class PmDataResponse {
	
	/**
	 * 年度PM实施总数（累加值）
	 */
	private Long pmImplementTotalYear;
	/**
	 * 年度PM计划总数（累加值）
	 */
	private Long pmPlanTotalYear;
	/**
	 * 年度PM执行率(百分比)
	 */
	private Double pmRateYear;
	
	private Map<String,Long> chart;

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

	public Map<String, Long> getChart() {
		return chart;
	}

	public void setChart(Map<String, Long> chart) {
		this.chart = chart;
	}
	
}
