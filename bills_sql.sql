CREATE DATABASE IF NOT EXISTS `bills`;
use `bills`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(16) COLLATE utf8_bin NOT NULL UNIQUE COMMENT '账号',
  `username` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` int DEFAULT NULL COMMENT '逻辑删除：0未删除，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='用户表';

DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_type` bigint NOT NULL COMMENT '分类id',
  `bill_time` DATETIME NOT NULL COMMENT '账单产生时间',
  `type` tinyint(1) NOT NULL COMMENT '收支类型 0支出 1收款',
  `pay_method` int DEFAULT NULL COMMENT '支付方式 0现金 1微信 2支付宝',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `payee` varchar(25) DEFAULT NULL COMMENT '收款方',
  `create_user` bigint NOT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='账单表';

DROP TABLE IF EXISTS `billtype`;
CREATE TABLE `bill_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(10) NOT NULL COMMENT '账单类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='账单类型表';