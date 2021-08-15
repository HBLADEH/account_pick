/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : db_accountpick

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 15/08/2021 23:21:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, 'blade', '测试用户', '$2a$10$GumeuSClDOdyxCWrNl/cKuVXojko77PdYoezqF/74psK9zV7CjGKm', '2021-08-08 14:56:39.156', '2021-08-08 14:56:39.156');

-- ----------------------------
-- Table structure for tb_channel
-- ----------------------------
DROP TABLE IF EXISTS `tb_channel`;
CREATE TABLE `tb_channel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '渠道',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_channel
-- ----------------------------
INSERT INTO `tb_channel` VALUES (4, '渠道5');
INSERT INTO `tb_channel` VALUES (5, '渠道6');
INSERT INTO `tb_channel` VALUES (6, '渠道7');
INSERT INTO `tb_channel` VALUES (7, '渠道8');
INSERT INTO `tb_channel` VALUES (8, '渠道9');
INSERT INTO `tb_channel` VALUES (9, '渠道10');

-- ----------------------------
-- Table structure for tb_game
-- ----------------------------
DROP TABLE IF EXISTS `tb_game`;
CREATE TABLE `tb_game`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '游戏名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_game
-- ----------------------------
INSERT INTO `tb_game` VALUES (4, '游戏4');
INSERT INTO `tb_game` VALUES (5, '游戏5');
INSERT INTO `tb_game` VALUES (6, '游戏6');
INSERT INTO `tb_game` VALUES (7, '游戏7');
INSERT INTO `tb_game` VALUES (8, '游戏8');
INSERT INTO `tb_game` VALUES (9, '游戏9');
INSERT INTO `tb_game` VALUES (10, '游戏10');

-- ----------------------------
-- Table structure for tb_game_channel
-- ----------------------------
DROP TABLE IF EXISTS `tb_game_channel`;
CREATE TABLE `tb_game_channel`  (
  `channelId` int(11) NOT NULL COMMENT '渠道ID',
  `gameId` int(11) NOT NULL COMMENT '游戏ID'
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of tb_game_channel
-- ----------------------------

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图片',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品介绍',
  `game_id` int(11) NOT NULL COMMENT '游戏ID',
  `channel_id` int(11) NULL DEFAULT NULL COMMENT '系统ID',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES (6, '222', '444', 222.10, '333', 4, 4, '2021-08-08 17:55:53.858', '2021-08-15 22:58:25.946');
INSERT INTO `tb_goods` VALUES (5, '111', '444', 222.00, '333', 4, 4, '2021-08-08 17:55:51.292', '2021-08-15 16:27:54.529');
INSERT INTO `tb_goods` VALUES (4, '114', '444', 222.00, '333', 5, 5, '2021-08-08 14:57:38.070', '2021-08-15 16:27:54.531');
INSERT INTO `tb_goods` VALUES (7, '333', '444', 222.00, '333', 6, 6, '2021-08-08 17:55:55.410', '2021-08-15 16:27:54.533');
INSERT INTO `tb_goods` VALUES (8, '4444', '444', 222.00, '333', 7, 7, '2021-08-08 17:55:57.932', '2021-08-15 16:27:54.535');

SET FOREIGN_KEY_CHECKS = 1;
