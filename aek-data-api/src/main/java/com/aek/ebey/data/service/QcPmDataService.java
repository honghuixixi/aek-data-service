package com.aek.ebey.data.service;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.data.model.QcPmData;
import com.aek.ebey.data.response.PmDataResponse;

/**
 * 服务类
 *
 * @author Honghui
 * @since 2018-04-16
 */
public interface QcPmDataService extends BaseService<QcPmData> {

	PmDataResponse getPmData(Long tenantId);
	
}
