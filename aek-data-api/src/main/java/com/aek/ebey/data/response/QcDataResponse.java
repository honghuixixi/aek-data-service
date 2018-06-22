package com.aek.ebey.data.response;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

public class QcDataResponse {
	
	/**
	 * 年度巡检总数(台/次)（累加值）
	 */
	private Long inspectionTotalYear;
	/**
	 * 年度巡检计划总数（累加值）
	 */
	private Long inspectionPlanTotalYear;
	/**
	 * 年度巡检执行率（百分比）
	 */
	private Double inspectionRateYear;
	
	private Map<String,Long> chart;
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
	public Map<String, Long> getChart() {
		return chart;
	}
	public void setChart(Map<String, Long> chart) {
		this.chart = chart;
	}
	public static void main(String[] args) {
		QcDataResponse QcDataResponse=new QcDataResponse();
		QcDataResponse.setInspectionPlanTotalYear(10l);
		QcDataResponse.setInspectionRateYear(12.34d);
		QcDataResponse.setInspectionTotalYear(14L);
		Map<String, Long> map=new HashMap<String, Long>();
		map.put("2018-04", 777l);
		map.put("2018-05", 778l);
		QcDataResponse.setChart(map);
		String  json = JSONArray.toJSONString(QcDataResponse) ;
		System.out.println(json);// 
	}
	

}
