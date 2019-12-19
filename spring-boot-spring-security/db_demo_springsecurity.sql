/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : db_demo_springsecurity

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/12/2019 15:26:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'Controller路径',
  `menu_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单编码',
  `parent_id` int(8) DEFAULT NULL COMMENT '父菜单ID',
  `menu_type` int(1) DEFAULT '0' COMMENT '菜单类型：0-菜单1-按钮',
  `order_num` int(4) DEFAULT '99' COMMENT '显示序号',
  `creator` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` int(1) DEFAULT '0' COMMENT '删除状态：0-存在1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` VALUES (1, '公共资源', '/publicResource', NULL, 0, 0, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (2, 'VIP资源', '/vipResource', NULL, 0, 0, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (3, '主页', '/home', NULL, 0, 0, 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (4, '公共权限请求按钮', '/test/public', NULL, 0, 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (5, 'VIP权限请求按钮', '/test/vip', NULL, 0, 1, 99, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_menu` VALUES (6, 'mian', '/main', NULL, 0, 0, 99, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, 'ROLE_USER');
INSERT INTO `t_role` VALUES (2, 'ROLE_ADMIN');
COMMIT;

-- ----------------------------
-- Table structure for t_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menus`;
CREATE TABLE `t_role_menus` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色菜单id',
  `role_id` int(8) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(8) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_role_menus
-- ----------------------------
BEGIN;
INSERT INTO `t_role_menus` VALUES (1, 1, 1);
INSERT INTO `t_role_menus` VALUES (2, 2, 1);
INSERT INTO `t_role_menus` VALUES (3, 2, 2);
INSERT INTO `t_role_menus` VALUES (4, 1, 3);
INSERT INTO `t_role_menus` VALUES (5, 2, 3);
INSERT INTO `t_role_menus` VALUES (6, 1, 4);
INSERT INTO `t_role_menus` VALUES (7, 2, 4);
INSERT INTO `t_role_menus` VALUES (8, 2, 5);
INSERT INTO `t_role_menus` VALUES (9, 1, 6);
INSERT INTO `t_role_menus` VALUES (10, 2, 6);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'user', '$2a$10$D5E9lza7z8uea6fP/oNOJeuRq/a/y8RXQWslTDONsqxQTPlgW7Hr6');
INSERT INTO `t_user` VALUES (2, 'admin', '$2a$10$on7jUGJN.4CyjPZzyroZce0ugjCQFzA6dRuOTcEFTBLLhe3oYe5Gu');
COMMIT;

-- ----------------------------
-- Table structure for t_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_user_roles`;
CREATE TABLE `t_user_roles` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户角色对照ID',
  `user_id` int(8) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(8) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user_roles
-- ----------------------------
BEGIN;
INSERT INTO `t_user_roles` VALUES (1, 1, 1);
INSERT INTO `t_user_roles` VALUES (2, 2, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
