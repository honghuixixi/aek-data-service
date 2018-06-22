
#统计库数据脚本
-- ----------------------------
-- Table structure for assets_data
-- ----------------------------
DROP TABLE IF EXISTS `assets_data`;
CREATE TABLE `assets_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_date` date DEFAULT NULL COMMENT '统计日期（年月日）',
  `assets_total_num` bigint(20) DEFAULT NULL COMMENT '资产设备总数',
  `assets_total_capital` double DEFAULT NULL COMMENT '资产设备总额（分）',
  `assets_total_new_num_year` bigint(20) DEFAULT NULL COMMENT '年度新增设备总数',
  `assets_total_discard_num_year` bigint(20) DEFAULT NULL COMMENT '资产年度报损总数',
  `assets_total_new_capital_year` double DEFAULT NULL COMMENT '年度新增设备总额（分）',
  `assets_total_discard_capital_year` double DEFAULT NULL COMMENT '年度设备报损总额（分）',
  `assets_repair_percent` double DEFAULT NULL COMMENT '维修中设备百分比',
  `assets_unrepair_percent` double DEFAULT NULL COMMENT '正常设备百分比',
  `assets_distribution_data` json DEFAULT NULL COMMENT '资产分布比例JSON数据集合（比例项ID，比例项描述，分布比例，排序）',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_date` (`tenant_id`,`count_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产概览统计表';

-- ----------------------------
-- Table structure for assets_data_month
-- ----------------------------
DROP TABLE IF EXISTS `assets_data_month`;
CREATE TABLE `assets_data_month` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_month` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '统计年月(如：2018-04）',
  `assets_total_num` bigint(20) DEFAULT NULL COMMENT '资产总数',
  `assets_total_capital` double DEFAULT NULL COMMENT '资产总额(单位：分）',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_month` (`tenant_id`,`count_month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产数据月份统计表';

-- ----------------------------
-- Table structure for qc_inspection_data
-- ----------------------------
DROP TABLE IF EXISTS `qc_inspection_data`;
CREATE TABLE `qc_inspection_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_date` date DEFAULT NULL COMMENT '统计日期（年月日）',
  `inspection_total_year` bigint(20) DEFAULT NULL COMMENT '年度巡检总数(台/次)（累加值）',
  `inspection_plan_total_year` bigint(20) DEFAULT NULL COMMENT '年度巡检计划总数（累加值）',
  `inspection_rate_year` double(6,2) DEFAULT NULL COMMENT '年度巡检执行率（百分比）',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_date` (`tenant_id`,`count_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='设备巡检数据概览统计表';

-- ----------------------------
-- Table structure for qc_inspection_data_month
-- ----------------------------
DROP TABLE IF EXISTS `qc_inspection_data_month`;
CREATE TABLE `qc_inspection_data_month` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_month` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '统计年月份(如:2018-04)',
  `inspection_assets_total` bigint(20) DEFAULT NULL COMMENT '巡检设备总数（台/次）（累加值）',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_month` (`tenant_id`,`count_month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='巡检数据月份统计表';

-- ----------------------------
-- Table structure for qc_pm_data
-- ----------------------------
DROP TABLE IF EXISTS `qc_pm_data`;
CREATE TABLE `qc_pm_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_date` date DEFAULT NULL COMMENT '统计日期（年月日）',
  `pm_implement_total_year` bigint(20) DEFAULT NULL COMMENT '年度PM实施总数（累加值）',
  `pm_plan_total_year` bigint(20) DEFAULT NULL COMMENT '年度PM计划总数（累加值）',
  `pm_rate_year` double(6,2) DEFAULT NULL COMMENT '年度PM执行率(百分比)',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_date` (`tenant_id`,`count_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='设备PM数据概览统计表';

-- ----------------------------
-- Table structure for qc_pm_data_month
-- ----------------------------
DROP TABLE IF EXISTS `qc_pm_data_month`;
CREATE TABLE `qc_pm_data_month` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_month` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '统计年月份（如：2018-04）',
  `pm_assets_total` bigint(20) DEFAULT NULL COMMENT 'PM执行设备总数（台/次）（累加值）',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_month` (`tenant_id`,`count_month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PM数据月份统计表';

-- ----------------------------
-- Table structure for repair_data
-- ----------------------------
DROP TABLE IF EXISTS `repair_data`;
CREATE TABLE `repair_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_date` date DEFAULT NULL COMMENT '统计日期（年月日）',
  `apply_total_num_year` bigint(20) DEFAULT NULL COMMENT '本年度报修总数（台/次）（累加值）',
  `complete_total_num_year` bigint(20) DEFAULT NULL COMMENT '本年度完修总数（累加值）',
  `repair_total_capital_year` double DEFAULT NULL COMMENT '年度维修费总额',
  `repair_assets_num` bigint(20) DEFAULT NULL COMMENT '在修设备总数',
  `wait_repair_assets_num` bigint(20) DEFAULT NULL COMMENT '待修设备总数',
  `repair_distribution_data` json DEFAULT NULL COMMENT '维修状态分布JSON数据（待接单总数，待接单比例，维修中总数，维修中比例，待验收总数，待验收比例，已完成总数，已完成比例）',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_date` (`tenant_id`,`count_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修概览表';

-- ----------------------------
-- Table structure for repair_data_month
-- ----------------------------
DROP TABLE IF EXISTS `repair_data_month`;
CREATE TABLE `repair_data_month` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_month` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '月份（如：2018-04）',
  `repair_complete_total_num` bigint(20) DEFAULT NULL COMMENT '完修总数',
  `repair_complate_total_capital` double DEFAULT NULL COMMENT '完修费用',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_month` (`tenant_id`,`count_month`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修设备月份完修数与费用统计表';

-- ----------------------------
-- Table structure for repair_serven_complete_rate
-- ----------------------------
DROP TABLE IF EXISTS `repair_serven_complete_rate`;
CREATE TABLE `repair_serven_complete_rate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `count_month` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '统计月份（如：2018-004）',
  `serven_complete_rate` double DEFAULT NULL COMMENT '7天完修率（百分比）',
  `apply_total_num` bigint(20) DEFAULT NULL COMMENT '申请单总数',
  `serven_complete_total_num` bigint(20) DEFAULT NULL COMMENT '7天完修总数',
  `count_time` datetime DEFAULT NULL COMMENT '统计时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_count_month` (`tenant_id`,`count_month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='设备月度7天完修率表';


#初始化维修本年1-3月份统计数据

insert into `aek-data`.repair_data_month(tenant_id,count_month,repair_complete_total_num,repair_complate_total_capital,count_time,update_time)
(	
SELECT 
				a.tenant_id as tenant_id,
				'2018-01' as count_month,
				sum(case when (a.status in(3,4) and r.repair_date < '2018-02-01 00:00:00' and r.repair_date > '2018-01-01 00:00:00' ) then 1 else 0 end) as repair_complete_total_num,
				sum(case when (a.status in(3,4)  and r.repair_date < '2018-02-01 00:00:00' and r.repair_date > '2018-01-01 00:00:00' ) then r.total_cost else 0 end) as repair_complate_total_capital,
				'2018-02-01 00:00:00' as count_time,			
				'2018-02-01 00:00:00' as update_time
	FROM `aek-repair2`.rep_repair_apply a
			LEFT JOIN `aek-repair2`.rep_repair_report r on a.id = r.apply_id 
			group by a.tenant_id
);

insert into `aek-data`.repair_data_month(tenant_id,count_month,repair_complete_total_num,repair_complate_total_capital,count_time,update_time)
(
SELECT 
				a.tenant_id as tenant_id,
				'2018-02' as count_month,
				sum(case when (a.status in(3,4) and r.repair_date < '2018-03-01 00:00:00'  and r.repair_date > '2018-02-01 00:00:00' ) then 1 else 0 end) as repair_complete_total_num,
				sum(case when (a.status in(3,4)  and r.repair_date < '2018-03-01 00:00:00' and r.repair_date > '2018-02-01 00:00:00' ) then r.total_cost else 0 end) as repair_complate_total_capital,
				'2018-03-01 00:00:00' as count_time,
				'2018-03-01 00:00:00' as update_time
			FROM `aek-repair2`.rep_repair_apply a
			LEFT JOIN `aek-repair2`.rep_repair_report r on a.id = r.apply_id 
			group by a.tenant_id
);

insert into `aek-data`.repair_data_month(tenant_id,count_month,repair_complete_total_num,repair_complate_total_capital,count_time,update_time)
(SELECT 
				a.tenant_id as tenant_id,
				'2018-03' as count_month,
				sum(case when (a.status in(3,4) and r.repair_date < '2018-04-01 00:00:00' and r.repair_date > '2018-03-01 00:00:00' ) then 1 else 0 end) as repair_complete_total_num,
				sum(case when (a.status in(3,4)  and r.repair_date < '2018-04-01 00:00:00' and r.repair_date > '2018-03-01 00:00:00' ) then r.total_cost else 0 end) as repair_complate_total_capital,
				'2018-04-01 00:00:00' as count_time,
				'2018-04-01 00:00:00' as update_time
			FROM `aek-repair2`.rep_repair_apply a
			LEFT JOIN `aek-repair2`.rep_repair_report r on a.id = r.apply_id 
			group by a.tenant_id
);



