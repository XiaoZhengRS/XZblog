/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.104
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 192.168.0.104:3306
 Source Schema         : xiaozhengkeji

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 28/10/2019 03:16:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tabname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文档标题',
  `docclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文档类别',
  `doctext` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文档内容',
  `dj` int(255) NULL DEFAULT NULL COMMENT '点赞',
  `ll` int(255) NULL DEFAULT NULL COMMENT '浏览',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
