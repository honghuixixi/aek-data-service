package com.aek.ebey.data.service;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.data.model.QcInspectionData;
import com.aek.ebey.data.response.QcDataResponse;

/**
 * 服务类
 *
 * @author Honghui
 * @since 2018-04-16
 */
public interface QcInspectionDataService extends BaseService<QcInspectionData> {

	QcDataResponse getQcData(Long tenantId);
	
}
