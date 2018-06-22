package com.aek.ebey.data.web.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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
import com.aek.ebey.data.model.RepairData;
import com.aek.ebey.data.model.RepairDataMonth;
import com.aek.ebey.data.response.RepairDataResponse;
import com.aek.ebey.data.service.RepairDataMonthService;
import com.aek.ebey.data.service.RepairDataService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 维修概览表  前端控制器
 *
 * @author Honghui
 * @since 2018-04-16
 */
@RestController
@RequestMapping("/data/repairData")
@Api(value = "RepairDataController", description = "维修统计数据API")
public class RepairDataController extends BaseController {
	
    //维修概览数据Lock
    private static final Lock repairDataLock = new ReentrantLock();
    //维修月份数据Lock
    private static final Lock repairDataMonthLock = new ReentrantLock();
    
    @Autowired
    private RepairDataService repairDataService;
    @Autowired
    private RepairDataMonthService repairDataMonthService;
    
    /**
     * 批量插入RepairData
     */
    @PostMapping(value = "/addRepairData")
    @ApiOperation(value = "批量插入RepairData", httpMethod = "POST", produces = "application/json")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<Object> addRepairData(@RequestBody List<RepairData> request) {
        repairDataLock.lock();
        try {
            for (RepairData repairData : request) {
                Wrapper<RepairData> wrapper = new EntityWrapper<>();
                wrapper.eq("tenant_id", repairData.getTenantId());
                wrapper.eq("count_date", DateUtil.format(repairData.getCountDate(), "yyyy-MM-dd"));
                RepairData repairDataPersitence = repairDataService.selectOne(wrapper);
                if (null != repairDataPersitence) {
                    repairData.setId(repairDataPersitence.getId());
                    repairDataService.updateById(repairData);
                } else {
                    repairDataService.insert(repairData);
                }
            }
        } finally {
            repairDataLock.unlock();
        }
        return response();  
    }
    
    /**
     * 批量插入/更新RepairDataMonth
     */
    @PostMapping(value = "/addRepairDataMonth")
    @ApiOperation(value = "批量插入/更新RepairDataMonth", httpMethod = "POST", produces = "application/json")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<Object> addRepairDataMonth(@RequestBody List<RepairDataMonth> request) {
        repairDataMonthLock.lock();
        try {
            for (RepairDataMonth repairDataMonth : request) {
                Wrapper<RepairDataMonth> wrapper = new EntityWrapper<>();
                wrapper.eq("tenant_id", repairDataMonth.getTenantId());
                wrapper.eq("count_month", repairDataMonth.getCountMonth());
                RepairDataMonth repairDataMonthPersitence = repairDataMonthService.selectOne(wrapper);
                if (null != repairDataMonthPersitence) {
                    repairDataMonth.setId(repairDataMonthPersitence.getId());
                    repairDataMonth.setUpdateTime(new Date());
                    repairDataMonthService.updateById(repairDataMonth);
                } else {
                    repairDataMonthService.insert(repairDataMonth);
                }
            }
        } finally {
            repairDataMonthLock.unlock();
        }
        return response();  
    }
    
    /**
     * 获取维修统计数据
     * @param tenantId
     * @return
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/getRepairData")
    @ApiOperation(value = "获取维修统计数据")
    @ApiResponse(code = 200, message = "OK", response = Result.class)
    public Result<RepairDataResponse> getRepairData(@RequestParam(name="tenantId") Long tenantId) {
        if (null == tenantId) {
            AuthUser authUser = WebSecurityUtils.getCurrentUser();
            if (null != authUser) {
                tenantId = authUser.getTenantId();  
            }
        }
        if(null !=  tenantId) {
            RepairDataResponse repairDataResponse = repairDataService.getRepairData(tenantId);
            return response(repairDataResponse);
        }
        throw ExceptionFactory.create("500", "参数错误");
    }
}
