package com.aek.ebey.data.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.data.response.OverviewDataResponse;
import com.aek.ebey.data.response.PmDataResponse;
import com.aek.ebey.data.service.AssetsDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 *
 *	
 * @author HongHui
 * @date   2018年4月18日
 */
@RestController
@Api(value = "DataOverviewController", description = "数据总览统计API")
@RequestMapping("/data/overview")
public class DataOverviewController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(DataOverviewController.class);
    
    @Autowired
    private AssetsDataService assetsDataService;
    
    /**
     * 获取数据总览数据
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/getData")
    @ApiOperation(value = "获取数据总览数据")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<OverviewDataResponse> getOverViewData(@RequestParam(name="tenantId") Long tenantId) {
        logger.debug("<--------------------getOverViewData-------------");
        if (null == tenantId) {
            AuthUser authUser = WebSecurityUtils.getCurrentUser();
            if(authUser != null){
                tenantId = authUser.getTenantId();
            }
        }
        if(null != tenantId) {
            OverviewDataResponse overviewDataResponse = assetsDataService.getOverviewData(tenantId);
            return response(overviewDataResponse);
        }
        throw ExceptionFactory.create("500", "参数错误");
    }
}
