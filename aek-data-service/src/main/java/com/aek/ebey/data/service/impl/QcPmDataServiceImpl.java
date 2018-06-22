package com.aek.ebey.data.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.data.mapper.QcPmDataMapper;
import com.aek.ebey.data.mapper.QcPmDataMonthMapper;
import com.aek.ebey.data.model.QcPmData;
import com.aek.ebey.data.model.QcPmDataMonth;
import com.aek.ebey.data.response.PmDataResponse;
import com.aek.ebey.data.service.QcPmDataService;
import com.aek.ebey.data.utils.DateUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 设备PM数据概览统计表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class QcPmDataServiceImpl extends BaseServiceImpl<QcPmDataMapper, QcPmData> implements QcPmDataService {

	@Autowired
	private QcPmDataMapper qcPmDataMapper;
	
	
	@Autowired
	private QcPmDataMonthMapper qcPmDataMonthMapper;
	
	@Override
	public PmDataResponse getPmData(Long tenantId) {
		PmDataResponse pmDataResponse=new PmDataResponse();
		QcPmData qcPmData=null;
		Map<String,Long> map=new HashMap<>();
		String time=DateUtils.getPreDay();
		Wrapper<QcPmData> wrapper=new EntityWrapper<>();
		wrapper.eq("tenant_id", tenantId).eq("count_date", time);
		List<QcPmData>  listData=qcPmDataMapper.selectList(wrapper);
		if(listData!=null&&listData.size()>0){
			qcPmData=listData.get(0);
		}
		Wrapper<QcPmDataMonth> wrapper2=new EntityWrapper<>();
		wrapper2.eq("tenant_id", tenantId);
		List<QcPmDataMonth> list=qcPmDataMonthMapper.selectList(wrapper2);
		if(list!=null&&list.size()>0){
			for(QcPmDataMonth qcPmDataMonth:list){
				map.put(qcPmDataMonth.getCountMonth(), qcPmDataMonth.getPmAssetsTotal());
			}
			pmDataResponse.setChart(map);
		}
		if(qcPmData!=null){
			pmDataResponse.setPmImplementTotalYear(qcPmData.getPmImplementTotalYear());
			pmDataResponse.setPmPlanTotalYear(qcPmData.getPmPlanTotalYear());
			pmDataResponse.setPmRateYear(qcPmData.getPmRateYear());
		}
		return pmDataResponse;
	}
	
}
