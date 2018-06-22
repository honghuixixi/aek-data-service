package com.aek.ebey.data.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.data.mapper.QcInspectionDataMapper;
import com.aek.ebey.data.mapper.QcInspectionDataMonthMapper;
import com.aek.ebey.data.model.QcInspectionData;
import com.aek.ebey.data.model.QcInspectionDataMonth;
import com.aek.ebey.data.response.QcDataResponse;
import com.aek.ebey.data.service.QcInspectionDataService;
import com.aek.ebey.data.utils.DateUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 设备巡检数据概览统计表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class QcInspectionDataServiceImpl extends BaseServiceImpl<QcInspectionDataMapper, QcInspectionData> implements QcInspectionDataService {

	@Autowired
	private QcInspectionDataMapper qcInspectionDataMapper;
	
	
	@Autowired
	private QcInspectionDataMonthMapper qcInspectionDataMonthMapper;
	
	@Override
	public QcDataResponse getQcData(Long tenantId) {
		QcDataResponse qcDataResponse=new QcDataResponse();
		QcInspectionData qcInspectionData=null;
		Map<String,Long> map=new HashMap<>();
		String time=DateUtils.getPreDay();
		Wrapper<QcInspectionData> wrapper=new EntityWrapper<>();
		wrapper.eq("tenant_id", tenantId).eq("count_date", time);
		List<QcInspectionData>  listData=qcInspectionDataMapper.selectList(wrapper);
		if(listData!=null&&listData.size()>0){
			qcInspectionData=listData.get(0);
		}
		Wrapper<QcInspectionDataMonth> wrapper2=new EntityWrapper<>();
		wrapper2.eq("tenant_id", tenantId);
		List<QcInspectionDataMonth> list=qcInspectionDataMonthMapper.selectList(wrapper2);
		if(list!=null&&list.size()>0){
			for(QcInspectionDataMonth qcInspectionDataMonth:list){
				map.put(qcInspectionDataMonth.getCountMonth(), qcInspectionDataMonth.getInspectionAssetsTotal());
			}
			qcDataResponse.setChart(map);
		}
		if(qcInspectionData!=null){
			qcDataResponse.setInspectionPlanTotalYear(qcInspectionData.getInspectionPlanTotalYear());
			qcDataResponse.setInspectionRateYear(qcInspectionData.getInspectionRateYear());
			qcDataResponse.setInspectionTotalYear(qcInspectionData.getInspectionTotalYear());
		}
		return qcDataResponse;
	}
	
}
