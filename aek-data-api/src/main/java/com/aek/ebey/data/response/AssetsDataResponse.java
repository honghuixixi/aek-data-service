package com.aek.ebey.data.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aek.ebey.data.custom.AssetsDistributionData;

public class AssetsDataResponse {
	
    private Long assetsTotalNum = 0l; // 资产设备总数
    private Double assetsTotalCapital = 0d;  // 资产设备总额
    private Long assetsTotalNewNumYear = 0l;  // 年度新增设备总数
    private Long assetsTotalDiscardNumYear = 0l;  // 年度报损总数
    private Double assetsTotalNewCapitalYear = 0d;  // 年度新增设备总额
    private Double assetsTotalDiscardCapitalYear = 0d;  // 年度报损设备总额
    private Double assetsRepairPercent = 0d;  // 维修中设备百分比
    private Double assetsUnrepairPercent = 100d;  // 正常设备百分比
    private List<AssetsDistributionData> assetsDistribution = new ArrayList<AssetsDistributionData>();  // 资产分布比例，格式[{remarks: '分布描述（String）', distributionProportion: '分布比例（Double）', sort:'排序（Integer）'}]
    private Map<String,Long> assetsTotalNumMonth = new HashMap<String,Long>();  // 图表数据(资产设备总数) ，格式：{'年份-月份': 统计值} 如： {'2018-01': 1, '2018-02': 5}
    private Map<String,Double> assetsTotalCapitalMonth = new HashMap<String,Double>();  // 图表数据（资产设备总额）
    
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
    public Long getAssetsTotalNewNumYear() {
        return assetsTotalNewNumYear;
    }
    public void setAssetsTotalNewNumYear(Long assetsTotalNewNumYear) {
        this.assetsTotalNewNumYear = assetsTotalNewNumYear;
    }
    public Long getAssetsTotalDiscardNumYear() {
        return assetsTotalDiscardNumYear;
    }
    public void setAssetsTotalDiscardNumYear(Long assetsTotalDiscardNumYear) {
        this.assetsTotalDiscardNumYear = assetsTotalDiscardNumYear;
    }
    public Double getAssetsTotalNewCapitalYear() {
        return assetsTotalNewCapitalYear;
    }
    public void setAssetsTotalNewCapitalYear(Double assetsTotalNewCapitalYear) {
        this.assetsTotalNewCapitalYear = assetsTotalNewCapitalYear;
    }
    public Double getAssetsTotalDiscardCapitalYear() {
        return assetsTotalDiscardCapitalYear;
    }
    public void setAssetsTotalDiscardCapitalYear(Double assetsTotalDiscardCapitalYear) {
        this.assetsTotalDiscardCapitalYear = assetsTotalDiscardCapitalYear;
    }
    public Double getAssetsRepairPercent() {
        return assetsRepairPercent;
    }
    public void setAssetsRepairPercent(Double assetsRepairPercent) {
        this.assetsRepairPercent = assetsRepairPercent;
    }
    public Double getAssetsUnrepairPercent() {
        return assetsUnrepairPercent;
    }
    public void setAssetsUnrepairPercent(Double assetsUnrepairPercent) {
        this.assetsUnrepairPercent = assetsUnrepairPercent;
    }
    public List<AssetsDistributionData> getAssetsDistribution() {
        return assetsDistribution;
    }
    public void setAssetsDistribution(List<AssetsDistributionData> assetsDistribution) {
        this.assetsDistribution = assetsDistribution;
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
