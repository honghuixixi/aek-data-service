package com.aek.ebey.data.web.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.common.core.util.DateUtil;
import com.aek.ebey.data.model.AssetsData;
import com.aek.ebey.data.model.AssetsDataMonth;
import com.aek.ebey.data.model.QcInspectionData;
import com.aek.ebey.data.response.AssetsDataResponse;
import com.aek.ebey.data.service.AssetsDataMonthService;
import com.aek.ebey.data.service.AssetsDataService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 资产概览统计表  前端控制器
 *
 * @author Honghui
 * @since 2018-04-16
 */
@RestController
@RequestMapping("/data/assetsData")
@Api(value = "AssetsDataController", description = "资产统计数据API")
public class AssetsDataController extends BaseController {
	
    private static final Logger logger = LoggerFactory.getLogger(AssetsDataController.class);
    
    //资产概览数据Lock
    private static final Lock assetsDataLock = new ReentrantLock();
    //资产月份数据Lock
    private static final Lock assetsDataMonthLock = new ReentrantLock();
    
    @Autowired
    private AssetsDataService assetsDataService;
    @Autowired
    private AssetsDataMonthService assetsDataMonthService;
    
    /**
     * 查询资产概览数据
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/getAssetsData")
    @ApiOperation(value = "查询资产概览数据")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<AssetsDataResponse> getAssetsData(@RequestParam(name="tenantId") Long tenantId) {
        logger.debug("<--------------------getAssetsData-------------");
        if (null == tenantId) {
            AuthUser authUser = WebSecurityUtils.getCurrentUser();
            if (null != authUser) {
                tenantId = authUser.getTenantId();  
            }
        }
        if(null !=  tenantId) {
            AssetsDataResponse assetsDataResponse = assetsDataService.getAssetsData(tenantId);
            return response(assetsDataResponse);
        }
        throw ExceptionFactory.create("500", "参数错误");
    }
    
    /**
     * 批量插入资产概览数据
     */
    @PostMapping(value = "/addAssetsData")
    @ApiOperation(value = "批量插入资产概览数据", httpMethod = "POST", produces = "application/json")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<Object> addAssetsData(@RequestBody List<AssetsData> request) {
        assetsDataLock.lock();
        try {
            for(AssetsData assetsData : request){
                Wrapper<AssetsData> assetsDataWrapper = new EntityWrapper<>();
                assetsDataWrapper.eq("tenant_id", assetsData.getTenantId());
                assetsDataWrapper.eq("count_date", DateUtil.format(assetsData.getCountDate(), "yyyy-MM-dd"));
                AssetsData assetsDataPersitence = assetsDataService.selectOne(assetsDataWrapper);
                if (null != assetsDataPersitence) {
                    assetsData.setId(assetsDataPersitence.getId());
                    assetsDataService.updateById(assetsData);
                } else {
                    assetsDataService.insert(assetsData);
                }
            }
        } finally {
            assetsDataLock.unlock();
        }
        return response();  
    }
    
    /**
     * 批量插入资产月底数据
     */
    @PostMapping(value = "/addAssetsDataMonth")
    @ApiOperation(value = "批量插入资产月底数据", httpMethod = "POST", produces = "application/json")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<Object> addAssetsDataMonth(@RequestBody List<AssetsDataMonth> request) {
        assetsDataMonthLock.lock();
        try {
            for(AssetsDataMonth assetsDataMonth : request){
                Wrapper<AssetsDataMonth> assetsDataMonthWrapper = new EntityWrapper<>();
                assetsDataMonthWrapper.eq("tenant_id", assetsDataMonth.getTenantId());
                assetsDataMonthWrapper.eq("count_month", assetsDataMonth.getCountMonth());
                AssetsDataMonth assetsDataMonthPersitence = assetsDataMonthService.selectOne(assetsDataMonthWrapper);
                if (null != assetsDataMonthPersitence) {
                    assetsDataMonth.setId(assetsDataMonthPersitence.getId());
                    assetsDataMonth.setUpdateTime(new Date());
                    assetsDataMonthService.updateById(assetsDataMonth);
                } else {
                    assetsDataMonthService.insert(assetsDataMonth);
                }
            }
        } finally {
            assetsDataMonthLock.unlock();
        }
        return response();  
    }
}
