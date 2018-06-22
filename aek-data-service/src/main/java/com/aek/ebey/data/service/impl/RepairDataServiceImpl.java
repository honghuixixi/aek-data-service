package com.aek.ebey.data.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.data.custom.RepairDistributionData;
import com.aek.ebey.data.mapper.RepairDataMapper;
import com.aek.ebey.data.mapper.RepairDataMonthMapper;
import com.aek.ebey.data.mapper.RepairServenCompleteRateMapper;
import com.aek.ebey.data.model.RepairData;
import com.aek.ebey.data.model.RepairDataMonth;
import com.aek.ebey.data.model.RepairServenCompleteRate;
import com.aek.ebey.data.response.RepairDataResponse;
import com.aek.ebey.data.service.RepairDataService;
import com.aek.ebey.data.utils.DateUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 维修概览表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class RepairDataServiceImpl extends BaseServiceImpl<RepairDataMapper, RepairData> implements RepairDataService {

    @Autowired
    private RepairDataMapper repairDataMapper;
    @Autowired
    private RepairDataMonthMapper repairDataMonthMapper;
    @Autowired
    private RepairServenCompleteRateMapper repairServenCompleteRateMapper;
    
    @Override
    public RepairDataResponse getRepairData(Long tenantId) {
        RepairDataResponse repairDataResponse = new RepairDataResponse();
        RepairData repairData = null;
        String time = DateUtils.getPreDay();
        Wrapper<RepairData> repairDataWrapper = new EntityWrapper<>();
        repairDataWrapper.eq("tenant_id", tenantId).eq("count_date", time);
        List<RepairData>  repairDataList = repairDataMapper.selectList(repairDataWrapper);
        if(repairDataList != null && repairDataList.size() > 0){
            repairData = repairDataList.get(0);
        }
        Wrapper<RepairDataMonth> repairDataMonthWrapper = new EntityWrapper<>();
        repairDataMonthWrapper.eq("tenant_id", tenantId);
        List<RepairDataMonth> repairDataMonthList = repairDataMonthMapper.selectList(repairDataMonthWrapper);
        if(repairDataMonthList != null && repairDataMonthList.size() > 0){
            //完修总数(月份数据)
            Map<String,Long> repairCompleteTotalNumMonth = new HashMap<String,Long>();
            //完修费用(月份数据)
            Map<String,Double> repairCompleteTotalCapitalMonth = new HashMap<String,Double>();
            for(RepairDataMonth repairDataMonth:repairDataMonthList){
                repairCompleteTotalNumMonth.put(repairDataMonth.getCountMonth(), repairDataMonth.getRepairCompleteTotalNum());
                repairCompleteTotalCapitalMonth.put(repairDataMonth.getCountMonth(), repairDataMonth.getRepairComplateTotalCapital());
            }
            repairDataResponse.setRepairCompleteTotalNumMonth(repairCompleteTotalNumMonth);
            repairDataResponse.setRepairCompleteTotalCapitalMonth(repairCompleteTotalCapitalMonth);
        }
        
        //7天完修率
        Map<String,Double> servenCompleteRateMonth = new HashMap<String,Double>();
        Wrapper<RepairServenCompleteRate> repairServenCompleteRateWrapper = new EntityWrapper<>();
        repairServenCompleteRateWrapper.eq("tenant_id", tenantId);
        List<RepairServenCompleteRate> repairServenCompleteRateList = repairServenCompleteRateMapper.selectList(repairServenCompleteRateWrapper);
        //本年度7天完修率
        Long applyTotalNum = 0L;
        Long servenCompleteTotalNum = 0L;
        for (RepairServenCompleteRate repairServenCompleteRate : repairServenCompleteRateList) {
            servenCompleteRateMonth.put(repairServenCompleteRate.getCountMonth(), repairServenCompleteRate.getServenCompleteRate());
            if (StringUtils.isNotBlank(repairServenCompleteRate.getCountMonth()) && repairServenCompleteRate.getCountMonth().contains(DateUtils.getCurrentYear())) {
                applyTotalNum = applyTotalNum + repairServenCompleteRate.getApplyTotalNum();
                servenCompleteTotalNum = servenCompleteTotalNum + repairServenCompleteRate.getServenCompleteTotalNum();
            }
        }
        //获取7天完修率月度数据
        repairDataResponse.setServenCompleteRateMonth(servenCompleteRateMonth);
        //计算本年度7天完修率
        if (applyTotalNum != 0 ) {
            Double servenCompleteRate = new BigDecimal(((double)servenCompleteTotalNum*1.0/applyTotalNum)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
            repairDataResponse.setServenCompleteRate(servenCompleteRate);
        }
        if(null != repairData) {
            BeanMapper.copy(repairData, repairDataResponse);
            String repairDistributionDataStr = repairData.getRepairDistributionData();
            if (StringUtils.isNotEmpty(repairDistributionDataStr)) {
                RepairDistributionData repairDistributionData = JSON.parseObject(repairDistributionDataStr,RepairDistributionData.class);
                BeanMapper.copy(repairDistributionData,repairDataResponse);
            }
        }
        return repairDataResponse;
    }
    
}
