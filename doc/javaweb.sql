/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50509
Source Host           : localhost:3306
Source Database       : javaweb

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2018-06-10 09:43:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `real_name` varchar(100) DEFAULT NULL COMMENT '真实名称',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `sex` int(2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL COMMENT '图像',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `status` int(5) DEFAULT NULL COMMENT '状态',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `cre_time` datetime DEFAULT NULL COMMENT '创建时间',
  `mod_time` datetime DEFAULT NULL COMMENT '修改时间',
  `cre_user` int(11) DEFAULT NULL COMMENT '创建人',
  `mod_user` int(11) DEFAULT NULL,
  `cre_user_name` varchar(100) DEFAULT NULL COMMENT '修改人',
  `mod_user_name` varchar(100) DEFAULT NULL COMMENT '修改人名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('34', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('35', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('36', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('37', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('38', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('39', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('40', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('41', null, 'sdaf222', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('44', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('45', null, 'sdaf222', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('46', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('47', null, 'sdaf222', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('48', null, '测试1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('49', null, '测试2', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('53', null, 'sdaf', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('54', null, 'sdaf222', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('55', null, '测试1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('56', null, '测试2', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('57', 'null', '撒地方', '1', '23', '撒的发生的', 'null', 'null', 'null', null, 'sad规范sad', '2018-05-31 10:19:22', null, null, null, null, null);
