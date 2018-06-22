package com.aek.ebey.data.response;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据总览数据结构
 *	
 * @author HongHui
 * @date   2018年4月18日
 */
public class OverviewDataResponse {
	
    private Long assetsTotalNum = 0l; // 资产设备总数
    private Double assetsTotalCapital = 0d; // 资产设备总额
    private Long inspectionTotalYear = 0l; // 年度区域巡检总数
    private Double inspectionRateYear = 100d; // 年度区域巡检执行率
    private Long pmImplementTotalYear = 0l; // 年度PM执行总数
    private Double pmRateYear = 100d; // 年度PM执行率
    private Long waitRepairAssetsNum = 0l; // 待修设备总数
    private Double servenCompleteRate = 100d; // 设备七天完修率
    private Map<String,Long> assetsTotalNumMonth = new HashMap<String,Long>(); // 图表数据(资产设备总数) ，格式：{'年份-月份': 统计值} 如： {'2018-01': 1, '2018-02': 5}
    private Map<String,Double> assetsTotalCapitalMonth = new HashMap<String,Double>(); // 图表数据（资产设备总额）
    
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
    public Long getInspectionTotalYear() {
        return inspectionTotalYear;
    }
    public void setInspectionTotalYear(Long inspectionTotalYear) {
        this.inspectionTotalYear = inspectionTotalYear;
    }
    public Double getInspectionRateYear() {
        return inspectionRateYear;
    }
    public void setInspectionRateYear(Double inspectionRateYear) {
        this.inspectionRateYear = inspectionRateYear;
    }
    public Long getPmImplementTotalYear() {
        return pmImplementTotalYear;
    }
    public void setPmImplementTotalYear(Long pmImplementTotalYear) {
        this.pmImplementTotalYear = pmImplementTotalYear;
    }
    public Double getPmRateYear() {
        return pmRateYear;
    }
    public void setPmRateYear(Double pmRateYear) {
        this.pmRateYear = pmRateYear;
    }
    public Long getWaitRepairAssetsNum() {
        return waitRepairAssetsNum;
    }
    public void setWaitRepairAssetsNum(Long waitRepairAssetsNum) {
        this.waitRepairAssetsNum = waitRepairAssetsNum;
    }
    public Double getServenCompleteRate() {
        return servenCompleteRate;
    }
    public void setServenCompleteRate(Double servenCompleteRate) {
        this.servenCompleteRate = servenCompleteRate;
    }
    public Map<String, Long> getAssetsTotalNumMonth() {
        return assetsTotalNumMonth;
    }
    public void setAssetsTotalNumMonth(Map<String, Long> assetsTotalNumMonth) {
        this.assetsTotalNumMonth = assetsTotalNumMonth;
    }
    public Map<String, Double> getAssetsTotalCapitalMonth() {
        return assetsTotalCapitalMonth;
    }
    public void setAssetsTotalCapitalMonth(Map<String, Double> assetsTotalCapitalMonth) {
        this.assetsTotalCapitalMonth = assetsTotalCapitalMonth;
    }
    
}
