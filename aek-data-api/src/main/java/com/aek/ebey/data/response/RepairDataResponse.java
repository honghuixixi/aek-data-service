package com.aek.ebey.data.response;

import java.util.HashMap;
import java.util.Map;

public class RepairDataResponse {
	
	
    private Long applyTotalNumYear = 0l; // 本年度报修总数
    private Long completeTotalNumYear = 0l; // 本年度完修总数
    private Double servenCompleteRate = 100d; // 设备7天完修率
    private Double repairTotalCapitalYear = 0d;  // 年度维修总额
    private Long repairAssetsNum = 0l;  //在修设备总数
    private Long waitTakeNum = 0l;   // 待接单
    private Long repairingNum = 0l;  // 维修中
    private Long waitCheckNum = 0l;  // 待验收
    private Long completedNum = 0l;  // 已完成
	
    private Map<String,Long> repairCompleteTotalNumMonth = new HashMap<String,Long>(); //完修数月度统计数据
    private Map<String,Double> repairCompleteTotalCapitalMonth = new HashMap<String,Double>(); //完修费用月度统计数据
    private Map<String,Double> servenCompleteRateMonth = new HashMap<String,Double>();   //7天完修率
    
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
    public Double getServenCompleteRate() {
        return servenCompleteRate;
    }
    public void setServenCompleteRate(Double servenCompleteRate) {
        this.servenCompleteRate = servenCompleteRate;
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
    public Long getWaitTakeNum() {
        return waitTakeNum;
    }
    public void setWaitTakeNum(Long waitTakeNum) {
        this.waitTakeNum = waitTakeNum;
    }
    public Long getRepairingNum() {
        return repairingNum;
    }
    public void setRepairingNum(Long repairingNum) {
        this.repairingNum = repairingNum;
    }
    public Long getWaitCheckNum() {
        return waitCheckNum;
    }
    public void setWaitCheckNum(Long waitCheckNum) {
        this.waitCheckNum = waitCheckNum;
    }
    public Long getCompletedNum() {
        return completedNum;
    }
    public void setCompletedNum(Long completedNum) {
        this.completedNum = completedNum;
    }
    public Map<String, Long> getRepairCompleteTotalNumMonth() {
        return repairCompleteTotalNumMonth;
    }
    public void setRepairCompleteTotalNumMonth(Map<String, Long> repairCompleteTotalNumMonth) {
        this.repairCompleteTotalNumMonth = repairCompleteTotalNumMonth;
    }
    public Map<String, Double> getRepairCompleteTotalCapitalMonth() {
        return repairCompleteTotalCapitalMonth;
    }
    public void setRepairCompleteTotalCapitalMonth(
                    Map<String, Double> repairCompleteTotalCapitalMonth) {
        this.repairCompleteTotalCapitalMonth = repairCompleteTotalCapitalMonth;
    }
    public Map<String, Double> getServenCompleteRateMonth() {
        return servenCompleteRateMonth;
    }
    public void setServenCompleteRateMonth(Map<String, Double> servenCompleteRateMonth) {
        this.servenCompleteRateMonth = servenCompleteRateMonth;
    }
    
}
