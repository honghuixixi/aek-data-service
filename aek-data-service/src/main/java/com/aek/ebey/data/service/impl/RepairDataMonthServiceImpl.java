package com.aek.ebey.data.service.impl;

import com.aek.ebey.data.model.RepairDataMonth;
import com.aek.ebey.data.mapper.RepairDataMonthMapper;
import com.aek.ebey.data.service.RepairDataMonthService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 维修设备月份完修数与费用统计表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class RepairDataMonthServiceImpl extends BaseServiceImpl<RepairDataMonthMapper, RepairDataMonth> implements RepairDataMonthService {
	
}
