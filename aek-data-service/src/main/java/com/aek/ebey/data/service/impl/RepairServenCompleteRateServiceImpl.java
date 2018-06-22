package com.aek.ebey.data.service.impl;

import com.aek.ebey.data.model.RepairServenCompleteRate;
import com.aek.ebey.data.mapper.RepairServenCompleteRateMapper;
import com.aek.ebey.data.service.RepairServenCompleteRateService;
import com.aek.common.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设备月度7天完修率表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class RepairServenCompleteRateServiceImpl extends BaseServiceImpl<RepairServenCompleteRateMapper, RepairServenCompleteRate> implements RepairServenCompleteRateService {
	
}
