/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : db_test

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 17/01/2020 10:13:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `user_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '刘备', '男');
INSERT INTO `t_user` VALUES (2, '孙尚香', '女');
INSERT INTO `t_user` VALUES (3, '周瑜', '男');
INSERT INTO `t_user` VALUES (4, '小乔', '女');
INSERT INTO `t_user` VALUES (5, '诸葛亮', '男');
INSERT INTO `t_user` VALUES (6, '黄月英', '女');
INSERT INTO `t_user` VALUES (7, '关羽', '男');
INSERT INTO `t_user` VALUES (8, '张飞', '男');
INSERT INTO `t_user` VALUES (9, '赵云', '男');
INSERT INTO `t_user` VALUES (10, '黄总', '男');
INSERT INTO `t_user` VALUES (11, '曹操', '男');
INSERT INTO `t_user` VALUES (12, '司马懿', '男');
INSERT INTO `t_user` VALUES (13, '貂蝉', '女');
INSERT INTO `t_user` VALUES (14, '吕布', '男');
INSERT INTO `t_user` VALUES (15, '马超', '男');
INSERT INTO `t_user` VALUES (16, '魏延', '男');
INSERT INTO `t_user` VALUES (17, '孟获', '男');
INSERT INTO `t_user` VALUES (18, '大乔', '女');
INSERT INTO `t_user` VALUES (19, '刘婵', '男');
INSERT INTO `t_user` VALUES (20, '姜维', '男');
INSERT INTO `t_user` VALUES (21, '廖化', '男');
INSERT INTO `t_user` VALUES (22, '关平', '男');
INSERT INTO `t_user` VALUES (25, '朝雾轻', '男');
INSERT INTO `t_user` VALUES (26, '朝雾轻寒', '女');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
