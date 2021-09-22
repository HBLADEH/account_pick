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

 Date: 23/09/2021 00:12:51
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
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_channel
-- ----------------------------
INSERT INTO `tb_channel` VALUES (12, '11');
INSERT INTO `tb_channel` VALUES (10, '游戏11');
INSERT INTO `tb_channel` VALUES (4, '渠道55');
INSERT INTO `tb_channel` VALUES (5, '渠道6');
INSERT INTO `tb_channel` VALUES (6, '渠道7');
INSERT INTO `tb_channel` VALUES (7, '渠道8');
INSERT INTO `tb_channel` VALUES (8, '渠道9');
INSERT INTO `tb_channel` VALUES (9, '渠道10');
INSERT INTO `tb_channel` VALUES (13, '111111');
INSERT INTO `tb_channel` VALUES (14, '22222');
INSERT INTO `tb_channel` VALUES (15, '3333333');
INSERT INTO `tb_channel` VALUES (16, '44444');
INSERT INTO `tb_channel` VALUES (17, '666');

-- ----------------------------
-- Table structure for tb_game
-- ----------------------------
DROP TABLE IF EXISTS `tb_game`;
CREATE TABLE `tb_game`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '游戏名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_game
-- ----------------------------
INSERT INTO `tb_game` VALUES (14, '111');
INSERT INTO `tb_game` VALUES (13, '33');
INSERT INTO `tb_game` VALUES (11, '三国杀');
INSERT INTO `tb_game` VALUES (12, '66');
INSERT INTO `tb_game` VALUES (5, '21');
INSERT INTO `tb_game` VALUES (6, '游戏6');
INSERT INTO `tb_game` VALUES (7, '游戏7');
INSERT INTO `tb_game` VALUES (8, '游戏8');
INSERT INTO `tb_game` VALUES (9, '游戏9');
INSERT INTO `tb_game` VALUES (10, '游戏10');
INSERT INTO `tb_game` VALUES (15, '123');
INSERT INTO `tb_game` VALUES (16, '111111111111');
INSERT INTO `tb_game` VALUES (17, '44441');
INSERT INTO `tb_game` VALUES (25, '游戏120');

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
INSERT INTO `tb_game_channel` VALUES (4, 4);
INSERT INTO `tb_game_channel` VALUES (5, 4);
INSERT INTO `tb_game_channel` VALUES (6, 4);
INSERT INTO `tb_game_channel` VALUES (2, 5);
INSERT INTO `tb_game_channel` VALUES (1, 5);

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
) ENGINE = MyISAM AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES (6, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (2, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-14 23:22:41.197');
INSERT INTO `tb_goods` VALUES (1, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (9, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-14 23:22:41.197');
INSERT INTO `tb_goods` VALUES (10, '99999', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 88.76, '<p><strong>1231231231233424324234234</strong></p><p><span style=\"color:hsl(180,75%,60%);\"><strong>123</strong></span></p><figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static/goods/content/images/16313720371771624621546129.jpg\"></figure>', 5, 0, '2021-09-11 22:54:06.855', '2021-09-15 09:41:31.356');
INSERT INTO `tb_goods` VALUES (3, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (15, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-15 23:39:58.040');
INSERT INTO `tb_goods` VALUES (13, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-15 23:39:58.044');
INSERT INTO `tb_goods` VALUES (7, '99999', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 88.76, '<p><strong>1231231231233424324234234</strong></p><p><span style=\"color:hsl(180,75%,60%);\"><strong>123</strong></span></p><figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static/goods/content/images/16313720371771624621546129.jpg\"></figure>', 5, 0, '2021-09-11 22:54:06.855', '2021-09-15 09:41:31.356');
INSERT INTO `tb_goods` VALUES (8, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (11, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-14 23:22:41.197');
INSERT INTO `tb_goods` VALUES (14, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (16, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (17, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-14 23:22:41.197');
INSERT INTO `tb_goods` VALUES (18, '99999', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 88.76, '<p><strong>1231231231233424324234234</strong></p><p><span style=\"color:hsl(180,75%,60%);\"><strong>123</strong></span></p><figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static/goods/content/images/16313720371771624621546129.jpg\"></figure>', 5, 0, '2021-09-11 22:54:06.855', '2021-09-15 09:41:31.356');
INSERT INTO `tb_goods` VALUES (19, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (20, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-14 23:22:41.197');
INSERT INTO `tb_goods` VALUES (21, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (22, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-15 23:39:58.040');
INSERT INTO `tb_goods` VALUES (23, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-15 23:39:58.044');
INSERT INTO `tb_goods` VALUES (24, '99999', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 88.76, '<p><strong>1231231231233424324234234</strong></p><p><span style=\"color:hsl(180,75%,60%);\"><strong>123</strong></span></p><figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static/goods/content/images/16313720371771624621546129.jpg\"></figure>', 5, 0, '2021-09-11 22:54:06.855', '2021-09-15 09:41:31.356');
INSERT INTO `tb_goods` VALUES (25, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');
INSERT INTO `tb_goods` VALUES (26, '123123123', 'http://image.accountpick.com:8888/static/goods/coverImage/16313720447461624621546129.jpg', 99.60, '<figure class=\"image\"><img src=\"http://image.accountpick.com:8888/static//goods/content/images/16313718093481624621546129.jpg\"></figure><p>1234567809</p>', 4, 5, '2021-09-11 22:50:11.148', '2021-09-14 23:22:41.197');
INSERT INTO `tb_goods` VALUES (27, '222', 'http://image.accountpick.com:8888/static/goods/coverImage/1631633132195pj80x80.jpg', 222.10, '<p>333</p>', 4, 4, '2021-08-08 17:55:53.858', '2021-09-14 23:25:33.877');

SET FOREIGN_KEY_CHECKS = 1;
