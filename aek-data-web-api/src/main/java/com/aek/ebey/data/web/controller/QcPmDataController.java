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
import com.aek.ebey.data.model.QcPmData;
import com.aek.ebey.data.model.QcPmDataMonth;
import com.aek.ebey.data.response.PmDataResponse;
import com.aek.ebey.data.service.QcPmDataMonthService;
import com.aek.ebey.data.service.QcPmDataService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 设备PM数据概览统计表  前端控制器
 *
 * @author Honghui
 * @since 2018-04-16
 */
@RestController
@RequestMapping("/data/qcPmData")
@Api(value = "QcPmDataController", description = "PM统计数据API")
public class QcPmDataController extends BaseController {
	
private static final Logger logger = LoggerFactory.getLogger(QcPmDataController.class);
	
    //PM概览数据Lock
    private static final Lock qcPmDataLock = new ReentrantLock();
    //PM月份数据Lock
    private static final Lock qcPmDataMonthLock = new ReentrantLock();

	@Autowired
	private QcPmDataService qcPmDataService;
	
	@Autowired
	private QcPmDataMonthService qcPmDataMonthService;
	
	/**
	 * 查询PM数据
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/getPmData")
	@ApiOperation(value = "查询PM数据")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<PmDataResponse> getPmData() {
		logger.debug("<--------------------getQcData-------------");
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(authUser!=null){
			PmDataResponse pmDataResponse=qcPmDataService.getPmData(authUser.getTenantId());
			return response(pmDataResponse);
		}
		return null;
	}
	
	/**
	 * 批量插入QcPmData
	 */
	@PostMapping(value = "/addQcPmData")
	@ApiOperation(value = "批量插入QcPmData", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> addQcPmData(@RequestBody List<QcPmData> request) {
	    qcPmDataLock.lock();
	    try {
    		for(QcPmData qcPmData:request){
    			 Wrapper<QcPmData> qcPmDataDataWrapper = new EntityWrapper<>();
    			 qcPmDataDataWrapper.eq("tenant_id", qcPmData.getTenantId());
    			 qcPmDataDataWrapper.eq("count_date", DateUtil.format(qcPmData.getCountDate(), "yyyy-MM-dd"));
    			 QcPmData qcPmDataPersitence = qcPmDataService.selectOne(qcPmDataDataWrapper);
                 if (null != qcPmDataPersitence) {
                     qcPmData.setId(qcPmDataPersitence.getId());
                     qcPmDataService.updateById(qcPmData);
                 } else {
                     qcPmDataService.insert(qcPmData);
                 }
    		}
	    } finally {
	        qcPmDataLock.unlock();
	    }
		return response();	
	}
	
	/**
	 * 批量插入QcPmDataMonth
	 */
	@PostMapping(value = "/addQcPmDataMonth")
	@ApiOperation(value = "批量插入QcPmDataMonth", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> addQcPmDataMonth(@RequestBody List<QcPmDataMonth> request) {
	    qcPmDataMonthLock.lock();
	    try {
    		for(QcPmDataMonth qcPmDataMonth:request){
    			Wrapper<QcPmDataMonth> qcPmDataMonthWrapper = new EntityWrapper<>();
    			qcPmDataMonthWrapper.eq("tenant_id", qcPmDataMonth.getTenantId());
    			qcPmDataMonthWrapper.eq("count_month", qcPmDataMonth.getCountMonth());
                QcPmDataMonth qcPmDataMonthPersitence = qcPmDataMonthService.selectOne(qcPmDataMonthWrapper);
                if (null != qcPmDataMonthPersitence) {
                    qcPmDataMonth.setId(qcPmDataMonthPersitence.getId());
                    qcPmDataMonth.setUpdateTime(new Date());
                    qcPmDataMonthService.updateById(qcPmDataMonth);
                } else {
                    qcPmDataMonthService.insert(qcPmDataMonth);
                }
    		}
	    } finally {
	        qcPmDataMonthLock.unlock();
	    }
		return response();	
	}
	
}
