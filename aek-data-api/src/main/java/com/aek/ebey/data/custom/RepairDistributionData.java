package com.aek.ebey.data.custom;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修状态分布JSON数据
 *	
 * @author HongHui
 * @date   2018年4月16日
 */
@ApiModel
public class RepairDistributionData implements Serializable{

    private static final long serialVersionUID = -4629034193202372448L;

    
    @ApiModelProperty(value="待接单总数")
    private Long waitTakeNum;
    
    @ApiModelProperty(value="待接单比例(百分比)")
    private Double waitTakeProportion;
    
    @ApiModelProperty(value="维修中总数")
    private Long repairingNum;
    
    @ApiModelProperty(value="维修中比例(百分比)")
    private Double repairingProportion;
    
    @ApiModelProperty(value="待验收总数")
    private Long waitCheckNum;
    
    @ApiModelProperty(value="待验收比例(百分比)")
    private Double waitCheckProportion;
    
    @ApiModelProperty(value="已完成总数")
    private Long  completedNum;
    
    @ApiModelProperty(value="已完成比例")
    private Double completedProportion;

    public Long getWaitTakeNum() {
        return waitTakeNum;
    }

    public void setWaitTakeNum(Long waitTakeNum) {
        this.waitTakeNum = waitTakeNum;
    }

    public Double getWaitTakeProportion() {
        return waitTakeProportion;
    }

    public void setWaitTakeProportion(Double waitTakeProportion) {
        this.waitTakeProportion = waitTakeProportion;
    }

    public Long getRepairingNum() {
        return repairingNum;
    }

    public void setRepairingNum(Long repairingNum) {
        this.repairingNum = repairingNum;
    }

    public Double getRepairingProportion() {
        return repairingProportion;
    }

    public void setRepairingProportion(Double repairingProportion) {
        this.repairingProportion = repairingProportion;
    }

    public Long getWaitCheckNum() {
        return waitCheckNum;
    }

    public void setWaitCheckNum(Long waitCheckNum) {
        this.waitCheckNum = waitCheckNum;
    }

    public Double getWaitCheckProportion() {
        return waitCheckProportion;
    }

    public void setWaitCheckProportion(Double waitCheckProportion) {
        this.waitCheckProportion = waitCheckProportion;
    }

    public Long getCompletedNum() {
        return completedNum;
    }

    public void setCompletedNum(Long completedNum) {
        this.completedNum = completedNum;
    }

    public Double getCompletedProportion() {
        return completedProportion;
    }

    public void setCompletedProportion(Double completedProportion) {
        this.completedProportion = completedProportion;
    }
    
}
