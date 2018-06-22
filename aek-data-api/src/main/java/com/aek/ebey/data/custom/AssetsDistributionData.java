package com.aek.ebey.data.custom;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资产分布比例
 *	
 * @author HongHui
 * @date   2018年4月16日
 */
@ApiModel
public class AssetsDistributionData implements Serializable{

    private static final long serialVersionUID = 6895232164998810079L;

    @ApiModelProperty(value="分布比例范围ID")
    private Long distributionRangeId;
    
    @ApiModelProperty(value="分布描述")
    private String remarks;
    
    @ApiModelProperty(value="分布比例")
    private Double distributionProportion;
    
    @ApiModelProperty(value="排序")
    private Integer sort;

    public Long getDistributionRangeId() {
        return distributionRangeId;
    }

    public void setDistributionRangeId(Long distributionRangeId) {
        this.distributionRangeId = distributionRangeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getDistributionProportion() {
        return distributionProportion;
    }

    public void setDistributionProportion(Double distributionProportion) {
        this.distributionProportion = distributionProportion;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
}
