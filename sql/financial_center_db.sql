# 数据库 
#创建数据库
DROP DATABASE IF EXISTS financial_center_db;
CREATE DATABASE financial_center_db;

#使用数据库 
use financial_center_db;

#创建金融类型表 
CREATE TABLE financial_cate_tb(
financial_cate_id int(11) NOT NULL AUTO_INCREMENT COMMENT '金融类型id',
name varchar(255) COMMENT '金融类型名称',
update_date datetime COMMENT '更新时间',
PRIMARY KEY (financial_cate_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='金融类型表';

#创建金融表 
CREATE TABLE financial_tb(
financial_id int(11) NOT NULL AUTO_INCREMENT COMMENT '金融id',
title varchar(255) COMMENT '金融名称',
term varchar(255) COMMENT '期限',
recommend tinyint(4) DEFAULT 0 COMMENT '推荐，默认0不推，1封推，2首投推，3复投推',
img_address varchar(255) COMMENT '封面',
strategy longtext COMMENT '攻略',
annual_transformation decimal(11,2) DEFAULT 0 COMMENT '平台年化(%)',
net_add_interest decimal(11,2) DEFAULT 0 COMMENT '网加息(%)',
comprehensive_annual_transformation decimal(11,2) DEFAULT 0 COMMENT '综合年化(%)',
project_total_money decimal(11,2) DEFAULT 0 COMMENT '项目总额',
investment_money decimal(11,2) DEFAULT 0 COMMENT '投资限额',
start_investment_money decimal(11,2) DEFAULT 0 COMMENT '起投金额',
interest_method varchar(255)  COMMENT '计息方式',
repayment_method varchar(255)  COMMENT '还款方式',
pvs bigint(20) DEFAULT 0 COMMENT 'pv',
uvs bigint(20) DEFAULT 0 COMMENT 'uv',
ips bigint(20) DEFAULT 0 COMMENT 'ip',
reading_number bigint(20) DEFAULT 0 COMMENT '阅读数',
redirect_url varchar(255)  COMMENT '跳转url',
status tinyint(4) DEFAULT 1 COMMENT '下架0,上架1',
financial_cate_id int(11) COMMENT '金融类型id,外键',
create_date datetime  COMMENT '金融创建时间',
update_date datetime  COMMENT '金融更新时间',
PRIMARY KEY (financial_id),
INDEX INDEX_RECOMMEND (recommend) USING BTREE,
INDEX INDEX_financialCATEID (financial_cate_id) USING BTREE,
INDEX INDEX_CREATEDATE (create_date) USING BTREE,
INDEX INDEX_UPDATEDATE (update_date) USING BTREE,
INDEX INDEX_STATUS (status) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='金融表';



#创建每日数据表 
CREATE TABLE daily_data_tb(
daily_data_id int(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
pvs bigint(20) COMMENT 'pvs',
uvs bigint(20) COMMENT 'uvs',
ips bigint(20) COMMENT 'ips',
reading_number bigint(20) COMMENT '阅读数',
create_date datetime COMMENT '创建时间',
financial_id int(11) COMMENT '金融id外键',
acount_id int(11) COMMENT '账户id外键',
PRIMARY KEY (daily_data_id),
INDEX INDEX_CREATEDATE (create_date) USING BTREE,
INDEX INDEX_financialID (financial_id) USING BTREE,
INDEX INDEX_ACOUNTID (acount_id) USING BTREE,
UNIQUE INDEX DAY_DATA (create_date,financial_id,acount_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='每日数据表';

#创建数据表 
CREATE TABLE data_tb(
data_id int(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
pvs bigint(20) COMMENT 'pvs',
uvs bigint(20) COMMENT 'uvs',
ips bigint(20) COMMENT 'ips',
reading_number bigint(20) COMMENT '阅读数',
create_date datetime COMMENT '创建时间',
financial_id int(11) COMMENT '金融id外键',
acount_id int(11) COMMENT '账户id外键',
PRIMARY KEY (data_id),
INDEX INDEX_CREATEDATE (create_date) USING BTREE,
INDEX INDEX_financialID (financial_id) USING BTREE,
INDEX INDEX_ACOUNTID (acount_id) USING BTREE,
UNIQUE INDEX TIME_DATA (create_date,financial_id,acount_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='数据表';