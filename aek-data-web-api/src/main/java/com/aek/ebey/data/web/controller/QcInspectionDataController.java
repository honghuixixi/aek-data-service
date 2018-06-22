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
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.common.core.util.DateUtil;
import com.aek.ebey.data.model.QcInspectionData;
import com.aek.ebey.data.model.QcInspectionDataMonth;
import com.aek.ebey.data.model.RepairData;
import com.aek.ebey.data.response.QcDataResponse;
import com.aek.ebey.data.service.QcInspectionDataMonthService;
import com.aek.ebey.data.service.QcInspectionDataService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 设备巡检数据概览统计表  前端控制器
 *
 * @author Honghui
 * @since 2018-04-16
 */
@RestController
@RequestMapping("/data/qcInspectionData")
@Api(value = "QcInspectionDataController", description = "巡检统计数据API")
public class QcInspectionDataController extends BaseController {
	

	private static final Logger logger = LoggerFactory.getLogger(QcInspectionDataController.class);
	
	//巡检概览数据Lock
    private static final Lock qcInspectionDataLock = new ReentrantLock();
    //巡检月份数据Lock
    private static final Lock qcInspectionDataMonthLock = new ReentrantLock();
	
	@Autowired
	private QcInspectionDataService qcInspectionDataService;
	
	@Autowired
	private QcInspectionDataMonthService qcInspectionDataMonthService;
	
	/**
	 * 查询巡检数据
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/getQcData")
	@ApiOperation(value = "查询巡检数据")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<QcDataResponse> getQcData() {
		logger.debug("<--------------------getQcData-------------");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(authUser!=null){
			QcDataResponse qcDataResponse=qcInspectionDataService.getQcData(authUser.getTenantId());
			return response(qcDataResponse);
		}
		return null;
	}
	
	/**
	 * 批量插入QcInspectionData
	 */
	@PostMapping(value = "/addQcInspectionData")
	@ApiOperation(value = "批量插入QcInspectionData", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> addQcInspectionData(@RequestBody List<QcInspectionData> request) {
	    qcInspectionDataLock.lock();
	    try {
    		for(QcInspectionData qcInspectionData:request){
    			 Wrapper<QcInspectionData> qcInspectionDataWrapper = new EntityWrapper<>();
    			 qcInspectionDataWrapper.eq("tenant_id", qcInspectionData.getTenantId());
    			 qcInspectionDataWrapper.eq("count_date", DateUtil.format(qcInspectionData.getCountDate(), "yyyy-MM-dd"));
    	         QcInspectionData qcInspectionDataPersitence = qcInspectionDataService.selectOne(qcInspectionDataWrapper);
    	         if (null != qcInspectionDataPersitence) {
    	             qcInspectionData.setId(qcInspectionDataPersitence.getId());
    	             qcInspectionDataService.updateById(qcInspectionData);
    	         } else {
    	             qcInspectionDataService.insert(qcInspectionData);
    	         }
    		}
	    } finally {
	        qcInspectionDataLock.unlock();
	    }
		return response();	
	}
	
	/**
	 * 批量插入QcInspectionDataMonth
	 */
	@PostMapping(value = "/addQcInspectionDataMonth")
	@ApiOperation(value = "批量插入QcInspectionDataMonth", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> addQcInspectionDataMonth(@RequestBody List<QcInspectionDataMonth> request) {
	    qcInspectionDataMonthLock.lock();
	    try {
    		for(QcInspectionDataMonth qcInspectionDataMonth:request){
    			Wrapper<QcInspectionDataMonth> qcInspectionMonthDataWrapper = new EntityWrapper<>();
    			qcInspectionMonthDataWrapper.eq("tenant_id", qcInspectionDataMonth.getTenantId());
    			qcInspectionMonthDataWrapper.eq("count_month", qcInspectionDataMonth.getCountMonth());
                QcInspectionDataMonth qcInspectionDataMonthPersitence = qcInspectionDataMonthService.selectOne(qcInspectionMonthDataWrapper);
                if (null != qcInspectionDataMonthPersitence) {
                    qcInspectionDataMonth.setId(qcInspectionDataMonthPersitence.getId());
                    qcInspectionDataMonth.setUpdateTime(new Date());
                    qcInspectionDataMonthService.updateById(qcInspectionDataMonth);
                } else {
                    qcInspectionDataMonthService.insert(qcInspectionDataMonth);
                }
    		}
	    } finally {
	        qcInspectionDataMonthLock.unlock();
	    }
		return response();	
	}
}
