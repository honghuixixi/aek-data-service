package com.aek.ebey.data.service.impl;

import com.aek.ebey.data.model.QcPmDataMonth;
import com.aek.ebey.data.mapper.QcPmDataMonthMapper;
import com.aek.ebey.data.service.QcPmDataMonthService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PM数据月份统计表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class QcPmDataMonthServiceImpl extends BaseServiceImpl<QcPmDataMonthMapper, QcPmDataMonth> implements QcPmDataMonthService {
	
}
