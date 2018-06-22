package com.aek.ebey.data.web.controller;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.data.model.QcPmDataMonth;
import com.aek.ebey.data.model.RepairServenCompleteRate;
import com.aek.ebey.data.service.RepairServenCompleteRateService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 设备月度7天完修率表  前端控制器
 *
 * @author Honghui
 * @since 2018-04-16
 */
@RestController
@RequestMapping("/data/repairServenCompleteRate")
@Api(value = "RepairServenCompleteRateController", description = "7天维修率统计API")
public class RepairServenCompleteRateController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RepairServenCompleteRateController.class);
	
	//7天维修率数据Lock
    private static final Lock repairServenCompleteRateDataLock = new ReentrantLock();
    
	@Autowired
	private RepairServenCompleteRateService repairServenCompleteRateService;
	/**
	 * 批量插入RepairServenCompleteRate
	 */
	@PostMapping(value = "/addRepairServenCompleteRate")
	@ApiOperation(value = "批量插入RepairServenCompleteRate", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> addRepairServenCompleteRate(@RequestBody List<RepairServenCompleteRate> request) {
	    repairServenCompleteRateDataLock.lock();
	    try {
    		for(RepairServenCompleteRate repairServenCompleteRate:request){
    			Wrapper<RepairServenCompleteRate> repairServenCompleteRateWrapper = new EntityWrapper<>();
    			repairServenCompleteRateWrapper.eq("tenant_id", repairServenCompleteRate.getTenantId());
    			repairServenCompleteRateWrapper.eq("count_month", repairServenCompleteRate.getCountMonth());
    			RepairServenCompleteRate repairServenCompleteRatePersitence = repairServenCompleteRateService.selectOne(repairServenCompleteRateWrapper);
                if (null != repairServenCompleteRatePersitence) {
                    repairServenCompleteRate.setId(repairServenCompleteRatePersitence.getId());
                    repairServenCompleteRateService.updateById(repairServenCompleteRate);
                } else {
                    repairServenCompleteRateService.insert(repairServenCompleteRate);
                }
    		}
	    } finally {
	        repairServenCompleteRateDataLock.unlock();
	    }
		return response();	
	}
	
}
