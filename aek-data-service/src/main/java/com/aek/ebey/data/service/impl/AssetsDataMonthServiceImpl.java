package com.aek.ebey.data.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.base.BaseServiceImpl;
import com.aek.ebey.data.mapper.AssetsDataMonthMapper;
import com.aek.ebey.data.model.AssetsDataMonth;
import com.aek.ebey.data.service.AssetsDataMonthService;

/**
 * 资产数据月份统计表 服务实现类
 *
 * @author Honghui
 * @since 2018-04-16
 */
@Service
@Transactional
public class AssetsDataMonthServiceImpl extends BaseServiceImpl<AssetsDataMonthMapper, AssetsDataMonth> implements AssetsDataMonthService {
	
}
