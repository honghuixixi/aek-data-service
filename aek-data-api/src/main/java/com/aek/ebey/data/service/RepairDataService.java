package com.aek.ebey.data.service;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.data.model.RepairData;
import com.aek.ebey.data.response.RepairDataResponse;

/**
 * 服务类
 *
 * @author Honghui
 * @since 2018-04-16
 */
public interface RepairDataService extends BaseService<RepairData> {
	
    
    /**
     * 获取机构维修统计数据
     * @param tenantId
     * @return
     */
    RepairDataResponse getRepairData(Long tenantId);
    
}
