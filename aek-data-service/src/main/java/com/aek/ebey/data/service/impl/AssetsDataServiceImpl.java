package com.aek.ebey.data.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.data.custom.AssetsDistributionData;
import com.aek.ebey.data.mapper.AssetsDataMapper;
import com.aek.ebey.data.mapper.AssetsDataMonthMapper;
import com.aek.ebey.data.mapper.QcInspectionDataMapper;
import com.aek.ebey.data.mapper.QcPmDataMapper;
import com.aek.ebey.data.mapper.RepairDataMapper;
import com.aek.ebey.data.mapper.RepairServenCompleteRateMapper;
import com.aek.ebey.data.model.AssetsData;
import com.aek.ebey.data.model.AssetsDataMonth;
import com.aek.ebey.data.model.QcInspectionData;
import com.aek.ebey.data.model.QcInspectionDataMonth;
import com.aek.ebey.data.model.QcPmData;
import com.aek.ebey.data.model.RepairData;
import com.aek.ebey.data.model.RepairServenCompleteRate;
import com.aek.ebey.data.response.AssetsDataResponse;
import com.aek.ebey.data.response.OverviewDataResponse;
import com.aek.ebey.data.service.AssetsDataService;
import com.aek.ebey.data.utils.DateUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 资产概览统计表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class AssetsDataServiceImpl extends BaseServiceImpl<AssetsDataMapper, AssetsData> implements AssetsDataService {

    private static final Logger logger = LoggerFactory.getLogger(AssetsDataServiceImpl.class);
    
    @Autowired
    private QcInspectionDataMapper qcInspectionDataMapper;
    @Autowired
    private QcPmDataMapper qcPmDataMapper;
    @Autowired
    private AssetsDataMapper assetsDataMapper;
    @Autowired
    private AssetsDataMonthMapper assetsDataMonthMapper;
    @Autowired
    private RepairDataMapper repairDataMapper;
    @Autowired
    private RepairServenCompleteRateMapper repairServenCompleteRateMapper;
    
    @Override
    public OverviewDataResponse getOverviewData(Long tenantId) {
        OverviewDataResponse overviewDataResponse = new OverviewDataResponse();
        String time = DateUtils.getPreDay();
        //巡检统计数据
        Wrapper<QcInspectionData> qcInspectionDataWrapper = new EntityWrapper<>();
        qcInspectionDataWrapper.eq("tenant_id", tenantId).eq("count_date", time);
        List<QcInspectionData> qcInspertionDataList  = qcInspectionDataMapper.selectList(qcInspectionDataWrapper);
        if(qcInspertionDataList != null && qcInspertionDataList.size() > 0){
            QcInspectionData qcInspectionData = qcInspertionDataList.get(0);
            if (null != qcInspectionData) {
                overviewDataResponse.setInspectionRateYear(qcInspectionData.getInspectionRateYear());
                overviewDataResponse.setInspectionTotalYear(qcInspectionData.getInspectionTotalYear());
            }
        }
        //资产统计数据
        Wrapper<AssetsData> assetsDataWrapper = new EntityWrapper<>();
        assetsDataWrapper.eq("tenant_id", tenantId).eq("count_date", time);
        List<AssetsData> assetsDataList  = assetsDataMapper.selectList(assetsDataWrapper);
        if(assetsDataList != null && assetsDataList.size() > 0){
            AssetsData assetsData = assetsDataList.get(0);
            if (null != assetsData) {
                if(null != assetsData.getAssetsTotalCapital()) {
                    Double assetsTotalCapital = new BigDecimal((double)assetsData.getAssetsTotalCapital()/(10000*100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
                    overviewDataResponse.setAssetsTotalCapital(assetsTotalCapital);
                }
                overviewDataResponse.setAssetsTotalNum(assetsData.getAssetsTotalNum());       
            }
        }
        
        Wrapper<AssetsDataMonth> assetsDataMonthWrapper = new EntityWrapper<>();
        assetsDataMonthWrapper.eq("tenant_id", tenantId);
        List<AssetsDataMonth> assetsDataMonthList = assetsDataMonthMapper.selectList(assetsDataMonthWrapper);
        if(assetsDataMonthList != null && assetsDataMonthList.size() > 0){
            Map<String,Long> assetsTotalNumMonth = new HashMap<String,Long>();
            Map<String,Double> assetsTotalCapitalMonth = new HashMap<String,Double>();
            for(AssetsDataMonth assetsDataMonth:assetsDataMonthList){
                assetsTotalNumMonth.put(assetsDataMonth.getCountMonth(), assetsDataMonth.getAssetsTotalNum());
                Double assetsTotalCapital = assetsDataMonth.getAssetsTotalCapital();
                if(null != assetsTotalCapital){
                    assetsTotalCapital = new BigDecimal((double)assetsTotalCapital/(10000*100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
                    assetsTotalCapitalMonth.put(assetsDataMonth.getCountMonth(),assetsTotalCapital);
                } else {
                    assetsTotalCapitalMonth.put(assetsDataMonth.getCountMonth(),0d);
                }
            }
            overviewDataResponse.setAssetsTotalNumMonth(assetsTotalNumMonth);
            overviewDataResponse.setAssetsTotalCapitalMonth(assetsTotalCapitalMonth);
        }
        //PM数据
        Wrapper<QcPmData> qcPmDataWrapper = new EntityWrapper<>();
        qcPmDataWrapper.eq("tenant_id", tenantId).eq("count_date", time);
        List<QcPmData> qcPmDataList  = qcPmDataMapper.selectList(qcPmDataWrapper);
        if(qcPmDataList != null && qcPmDataList.size() > 0){
            QcPmData qcPmData = qcPmDataList.get(0);
            if (null != qcPmData) {
                overviewDataResponse.setPmImplementTotalYear(qcPmData.getPmImplementTotalYear());
                overviewDataResponse.setPmRateYear(qcPmData.getPmRateYear());
            }
        }
        //维修数据
        Wrapper<RepairData> repairDataWrapper = new EntityWrapper<>();
        repairDataWrapper.eq("tenant_id", tenantId).eq("count_date", time);
        List<RepairData> repairDataList  = repairDataMapper.selectList(repairDataWrapper);
        if(repairDataList != null && repairDataList.size() > 0){
            RepairData repairData = repairDataList.get(0);
            if (null != repairData) {
                overviewDataResponse.setWaitRepairAssetsNum(repairData.getWaitRepairAssetsNum());
            }
        }
        //本年度7天完修率
        Wrapper<RepairServenCompleteRate> repairServenCompleteRateWrapper = new EntityWrapper<>();
        repairServenCompleteRateWrapper.eq("tenant_id", tenantId).like("count_month", DateUtils.getCurrentYear(), SqlLike.DEFAULT);
        List<RepairServenCompleteRate> repairServenCompleteRateList = repairServenCompleteRateMapper.selectList(repairServenCompleteRateWrapper);
        Long applyTotalNum = 0l;
        Long servenCompleteTotalNum = 0L;
        for (RepairServenCompleteRate repairServenCompleteRate : repairServenCompleteRateList) {
            applyTotalNum = applyTotalNum + repairServenCompleteRate.getApplyTotalNum();
            servenCompleteTotalNum = servenCompleteTotalNum + repairServenCompleteRate.getServenCompleteTotalNum();
        }
        if( 0 != applyTotalNum) {
            Double servenCompleteRate = new BigDecimal(((double)servenCompleteTotalNum*1.0/applyTotalNum)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
            overviewDataResponse.setServenCompleteRate(servenCompleteRate);
        }
        return overviewDataResponse;
    }

    @Override
    public AssetsDataResponse getAssetsData(Long tenantId) {
        AssetsDataResponse assetsDataResponse = new AssetsDataResponse();
        String time = DateUtils.getPreDay();
        Wrapper<AssetsData> assetsDataWrapper = new EntityWrapper<>();
        assetsDataWrapper.eq("tenant_id", tenantId).eq("count_date", time);
        List<AssetsData> assetsDataList  = assetsDataMapper.selectList(assetsDataWrapper);
        if(assetsDataList != null && assetsDataList.size() > 0){
            AssetsData assetsData = assetsDataList.get(0);
            if (null != assetsData) {
                BeanMapper.copy(assetsData, assetsDataResponse);
				Double totalCapital = assetsDataResponse.getAssetsTotalCapital();
				Double newCapitalYear = assetsDataResponse.getAssetsTotalNewCapitalYear();
				Double discardCapitalYear = assetsDataResponse.getAssetsTotalDiscardCapitalYear();
				if(null != totalCapital){
			    	totalCapital = new BigDecimal((double)totalCapital/(10000*100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			    	assetsDataResponse.setAssetsTotalCapital(totalCapital);
				}	
				if(null != newCapitalYear){
			    	newCapitalYear = new BigDecimal((double)newCapitalYear/(10000*100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
                    assetsDataResponse.setAssetsTotalNewCapitalYear(newCapitalYear);
				}
				if(null != discardCapitalYear){
			    	discardCapitalYear = new BigDecimal((double)discardCapitalYear/(10000*100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
                    assetsDataResponse.setAssetsTotalDiscardCapitalYear(discardCapitalYear);
				}        
                String assetsDistributionData = assetsData.getAssetsDistributionData();
                if(StringUtils.isNotBlank(assetsDistributionData)) {
                    List<AssetsDistributionData> assetsDistributionDataList = JSON.parseArray(assetsDistributionData, AssetsDistributionData.class);
                    assetsDataResponse.setAssetsDistribution(assetsDistributionDataList);
                }
            }
        }
        Wrapper<AssetsDataMonth> assetsDataMonthWrapper = new EntityWrapper<>();
        assetsDataMonthWrapper.eq("tenant_id", tenantId);
        List<AssetsDataMonth> assetsDataMonthList = assetsDataMonthMapper.selectList(assetsDataMonthWrapper);
        if(assetsDataMonthList != null && assetsDataMonthList.size() > 0){
            Map<String,Long> assetsTotalNumMonth = new HashMap<String,Long>();
            Map<String,Double> assetsTotalCapitalMonth = new HashMap<String,Double>();
            for(AssetsDataMonth assetsDataMonth:assetsDataMonthList){
                assetsTotalNumMonth.put(assetsDataMonth.getCountMonth(), assetsDataMonth.getAssetsTotalNum()==null?0:assetsDataMonth.getAssetsTotalNum());
                Double assetsTotalCapital = assetsDataMonth.getAssetsTotalCapital();
                if(null != assetsTotalCapital){
			    	assetsTotalCapital = new BigDecimal((double)assetsTotalCapital/(10000*100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	                assetsTotalCapitalMonth.put(assetsDataMonth.getCountMonth(),assetsTotalCapital);
				} else {
				    assetsTotalCapitalMonth.put(assetsDataMonth.getCountMonth(),0d);
				}
            }
            assetsDataResponse.setAssetsTotalNumMonth(assetsTotalNumMonth);
            assetsDataResponse.setAssetsTotalCapitalMonth(assetsTotalCapitalMonth);
        }
        return assetsDataResponse;
    }
}
