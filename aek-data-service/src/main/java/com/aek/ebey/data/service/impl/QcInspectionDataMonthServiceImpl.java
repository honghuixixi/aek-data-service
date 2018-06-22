package com.aek.ebey.data.service.impl;

import com.aek.ebey.data.model.QcInspectionDataMonth;
import com.aek.ebey.data.mapper.QcInspectionDataMonthMapper;
import com.aek.ebey.data.service.QcInspectionDataMonthService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 巡检数据月份统计表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class QcInspectionDataMonthServiceImpl extends BaseServiceImpl<QcInspectionDataMonthMapper, QcInspectionDataMonth> implements QcInspectionDataMonthService {
	
}
