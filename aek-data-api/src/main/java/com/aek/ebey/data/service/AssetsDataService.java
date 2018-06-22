package com.aek.ebey.data.service;

import com.aek.ebey.data.model.AssetsData;
import com.aek.ebey.data.response.AssetsDataResponse;
import com.aek.ebey.data.response.OverviewDataResponse;
import com.aek.common.core.base.BaseService;

/**
 * 服务类
 *
 * @author Honghui
 * @since 2018-04-16
 */
public interface AssetsDataService extends BaseService<AssetsData> {

    /**
     * 获取机构数据总览数据
     * @param tenantId
     * @return
     */
    OverviewDataResponse getOverviewData(Long tenantId);
    
    /**
     * 获取资产橄榄数据
     * @param tenantId
     * @return
     */
    AssetsDataResponse getAssetsData(Long tenantId);
}
