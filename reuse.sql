/*
 Navicat Premium Data Transfer

 Source Server         : reuse
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 43.129.251.6:3306
 Source Schema         : reuse

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 11/12/2021 17:42:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classification
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 垃圾分类词条表的id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '垃圾名称\r\n',
  `belongto` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该垃圾的所属分类\r\n',
  `status` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '词条状态',
  `bywho` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '词条添加者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '词条记录创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '词条记录更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classification
-- ----------------------------
INSERT INTO `classification` VALUES (1, '湿的衣服', '可回收垃圾', '可用', 'admin', '2021-11-28 14:02:03', '2021-11-28 14:02:05');
INSERT INTO `classification` VALUES (2, '尿', '厨余垃圾（湿垃圾）', '可用', 'qqq', '2021-11-28 16:24:36', '2021-11-28 16:24:36');

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '登录信息记录表 登录id 主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录者的用户名',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录者的ip',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此次登录的状态',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '此次登录的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (1, 'admin', '138.138.0.1', '登录成功', '2021-11-27 20:38:10');
INSERT INTO `login_log` VALUES (2, 'admin', '127.0.0.1', '登录成功', '2021-11-27 20:45:05');
INSERT INTO `login_log` VALUES (3, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:11:15');
INSERT INTO `login_log` VALUES (4, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:13:06');
INSERT INTO `login_log` VALUES (5, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:14:48');
INSERT INTO `login_log` VALUES (6, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:16:09');
INSERT INTO `login_log` VALUES (7, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:16:17');
INSERT INTO `login_log` VALUES (8, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:17:02');
INSERT INTO `login_log` VALUES (9, 'qqq', '127.0.0.1', '登录成功', '2021-11-27 21:17:15');
INSERT INTO `login_log` VALUES (10, 'qqq', '127.0.0.1', '登录成功', '2021-11-27 21:21:05');
INSERT INTO `login_log` VALUES (11, 'qqq', '127.0.0.1', '登录成功', '2021-11-27 21:22:03');
INSERT INTO `login_log` VALUES (12, 'susus', '127.0.0.1', '登录成功', '2021-11-27 21:24:27');
INSERT INTO `login_log` VALUES (13, 'susus', '127.0.0.1', '登录成功', '2021-11-27 21:24:33');
INSERT INTO `login_log` VALUES (14, 'susus', '127.0.0.1', '登录成功', '2021-11-27 21:24:36');
INSERT INTO `login_log` VALUES (15, 'susus', '127.0.0.1', '登录成功', '2021-11-27 21:24:39');
INSERT INTO `login_log` VALUES (16, 'susus', '127.0.0.1', '登录成功', '2021-11-27 21:24:41');
INSERT INTO `login_log` VALUES (17, 'susus', '127.0.0.1', '登录成功', '2021-11-27 21:24:43');
INSERT INTO `login_log` VALUES (18, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:31:56');
INSERT INTO `login_log` VALUES (19, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:34:12');
INSERT INTO `login_log` VALUES (20, 'admin', '127.0.0.1', '登录成功', '2021-11-27 21:34:43');
INSERT INTO `login_log` VALUES (21, 'admin', '127.0.0.1', '登录成功', '2021-11-27 22:39:27');
INSERT INTO `login_log` VALUES (22, 'admin', '127.0.0.1', '登录成功', '2021-11-27 22:50:52');
INSERT INTO `login_log` VALUES (23, 'admin', '127.0.0.1', '登录成功', '2021-11-27 22:52:54');
INSERT INTO `login_log` VALUES (24, 'admin', '127.0.0.1', '登录成功', '2021-11-27 22:53:17');
INSERT INTO `login_log` VALUES (25, 'admin', '127.0.0.1', '登录成功', '2021-11-27 23:03:00');
INSERT INTO `login_log` VALUES (26, 'admin', '127.0.0.1', '登录成功', '2021-11-27 23:06:49');
INSERT INTO `login_log` VALUES (27, 'admin', '127.0.0.1', '登录成功', '2021-11-27 23:07:55');
INSERT INTO `login_log` VALUES (28, 'admin', '127.0.0.1', '登录成功', '2021-11-27 23:10:16');
INSERT INTO `login_log` VALUES (29, 'admin', '127.0.0.1', '登录成功', '2021-11-27 23:12:13');
INSERT INTO `login_log` VALUES (30, 'admin', '127.0.0.1', '登录成功', '2021-11-27 23:14:50');
INSERT INTO `login_log` VALUES (31, 'admin', '127.0.0.1', '登录成功', '2021-11-27 23:15:51');
INSERT INTO `login_log` VALUES (32, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:22:25');
INSERT INTO `login_log` VALUES (33, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:23:47');
INSERT INTO `login_log` VALUES (34, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:24:22');
INSERT INTO `login_log` VALUES (35, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:24:30');
INSERT INTO `login_log` VALUES (36, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:24:56');
INSERT INTO `login_log` VALUES (37, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:25:27');
INSERT INTO `login_log` VALUES (38, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:25:56');
INSERT INTO `login_log` VALUES (39, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:26:39');
INSERT INTO `login_log` VALUES (40, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:27:13');
INSERT INTO `login_log` VALUES (41, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:28:47');
INSERT INTO `login_log` VALUES (42, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:29:56');
INSERT INTO `login_log` VALUES (43, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:30:47');
INSERT INTO `login_log` VALUES (44, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:31:27');
INSERT INTO `login_log` VALUES (45, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:31:50');
INSERT INTO `login_log` VALUES (46, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:53:42');
INSERT INTO `login_log` VALUES (47, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:54:05');
INSERT INTO `login_log` VALUES (48, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:54:43');
INSERT INTO `login_log` VALUES (49, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:55:43');
INSERT INTO `login_log` VALUES (50, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:55:52');
INSERT INTO `login_log` VALUES (51, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:56:38');
INSERT INTO `login_log` VALUES (52, 'admin', '127.0.0.1', '登录成功', '2021-11-28 13:57:25');
INSERT INTO `login_log` VALUES (53, 'admin', '127.0.0.1', '登录成功', '2021-11-28 14:01:38');
INSERT INTO `login_log` VALUES (54, 'admin', '127.0.0.1', '登录成功', '2021-11-28 14:02:11');
INSERT INTO `login_log` VALUES (55, 'admin', '127.0.0.1', '登录成功', '2021-11-28 14:08:16');
INSERT INTO `login_log` VALUES (56, 'admin', '127.0.0.1', '登录成功', '2021-11-28 14:08:29');
INSERT INTO `login_log` VALUES (57, 'admin', '127.0.0.1', '登录成功', '2021-11-28 14:24:29');
INSERT INTO `login_log` VALUES (58, 'admin', '127.0.0.1', '登录成功', '2021-11-28 15:02:56');
INSERT INTO `login_log` VALUES (59, 'admin', '127.0.0.1', '登录成功', '2021-11-28 15:23:43');
INSERT INTO `login_log` VALUES (60, 'qqq', '127.0.0.1', '登录成功', '2021-11-28 16:17:41');
INSERT INTO `login_log` VALUES (61, 'admin', '127.0.0.1', '登录成功', '2021-11-28 16:19:39');
INSERT INTO `login_log` VALUES (62, 'qqq', '127.0.0.1', '登录成功', '2021-11-28 16:24:32');
INSERT INTO `login_log` VALUES (63, 'qqq', '127.0.0.1', '登录成功', '2021-11-28 16:49:48');
INSERT INTO `login_log` VALUES (64, 'qqq', '127.0.0.1', '登录成功', '2021-11-28 16:55:28');
INSERT INTO `login_log` VALUES (65, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:21:24');
INSERT INTO `login_log` VALUES (66, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:22:17');
INSERT INTO `login_log` VALUES (67, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:24:33');
INSERT INTO `login_log` VALUES (68, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:29:46');
INSERT INTO `login_log` VALUES (69, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:32:35');
INSERT INTO `login_log` VALUES (70, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:39:34');
INSERT INTO `login_log` VALUES (71, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:41:41');
INSERT INTO `login_log` VALUES (72, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:41:46');
INSERT INTO `login_log` VALUES (73, '乐乐好家伙', '127.0.0.1', '登录成功', '2021-11-28 17:46:17');
INSERT INTO `login_log` VALUES (74, 'admin', '127.0.0.1', '登录成功', '2021-11-28 17:46:12');
INSERT INTO `login_log` VALUES (75, '13727742757', '127.0.0.1', '登录成功', '2021-11-28 17:48:43');
INSERT INTO `login_log` VALUES (76, '乐乐好家伙', '127.0.0.1', '登录成功', '2021-11-28 17:51:46');
INSERT INTO `login_log` VALUES (77, '乐乐好家伙', '127.0.0.1', '登录成功', '2021-11-28 17:51:50');
INSERT INTO `login_log` VALUES (78, 'admin', '127.0.0.1', '登录成功', '2021-11-28 18:59:14');
INSERT INTO `login_log` VALUES (79, 'admin', '127.0.0.1', '登录成功', '2021-11-28 18:59:47');
INSERT INTO `login_log` VALUES (80, 'admin', '127.0.0.1', '登录成功', '2021-11-28 19:19:58');
INSERT INTO `login_log` VALUES (81, 'admin', '127.0.0.1', '登录成功', '2021-11-28 19:39:43');
INSERT INTO `login_log` VALUES (82, 'admin', '127.0.0.1', '登录成功', '2021-11-28 19:41:15');
INSERT INTO `login_log` VALUES (83, 'admin', '127.0.0.1', '登录成功', '2021-11-28 19:41:15');
INSERT INTO `login_log` VALUES (84, 'admin', '127.0.0.1', '登录成功', '2021-11-28 20:06:37');
INSERT INTO `login_log` VALUES (85, 'admin', '127.0.0.1', '登录成功', '2021-11-28 20:34:48');
INSERT INTO `login_log` VALUES (86, '13727742757', '127.0.0.1', '登录成功', '2021-11-28 22:52:58');
INSERT INTO `login_log` VALUES (87, '13727742757', '127.0.0.1', '登录成功', '2021-11-28 22:53:59');
INSERT INTO `login_log` VALUES (88, 'admin', '127.0.0.1', '登录成功', '2021-11-30 08:52:30');
INSERT INTO `login_log` VALUES (89, 'admin', '127.0.0.1', '登录成功', '2021-11-30 08:52:36');
INSERT INTO `login_log` VALUES (90, '13727742757', '127.0.0.1', '登录成功', '2021-11-30 08:54:22');
INSERT INTO `login_log` VALUES (91, '乐乐好家伙', '127.0.0.1', '登录成功', '2021-11-30 08:57:49');
INSERT INTO `login_log` VALUES (92, '乐乐好家伙', '127.0.0.1', '登录成功', '2021-11-30 08:57:58');
INSERT INTO `login_log` VALUES (93, '123456', '127.0.0.1', '登录成功', '2021-11-30 09:02:12');
INSERT INTO `login_log` VALUES (94, '帅', '127.0.0.1', '登录成功', '2021-11-30 09:04:28');
INSERT INTO `login_log` VALUES (95, '13727742757', '127.0.0.1', '登录成功', '2021-11-30 19:10:45');
INSERT INTO `login_log` VALUES (96, 'admin', '127.0.0.1', '登录成功', '2021-11-30 19:17:23');
INSERT INTO `login_log` VALUES (97, 'bobo', '127.0.0.1', '登录成功', '2021-11-30 19:27:36');
INSERT INTO `login_log` VALUES (98, 'admin', '127.0.0.1', '登录成功', '2021-11-30 19:30:24');
INSERT INTO `login_log` VALUES (99, 'admin', '127.0.0.1', '登录成功', '2021-11-30 20:01:29');
INSERT INTO `login_log` VALUES (100, 'admin', '127.0.0.1', '登录成功', '2021-11-30 20:12:50');
INSERT INTO `login_log` VALUES (101, '13727742757', '127.0.0.1', '登录成功', '2021-11-30 20:32:44');
INSERT INTO `login_log` VALUES (102, 'admin', '127.0.0.1', '登录成功', '2021-11-30 20:40:05');
INSERT INTO `login_log` VALUES (103, 'admin', '127.0.0.1', '登录成功', '2021-11-30 21:24:57');
INSERT INTO `login_log` VALUES (104, 'admin', '127.0.0.1', '登录成功', '2021-12-01 15:42:25');
INSERT INTO `login_log` VALUES (105, 'admin', '127.0.0.1', '登录成功', '2021-12-01 18:58:38');
INSERT INTO `login_log` VALUES (106, 'admin', '127.0.0.1', '登录成功', '2021-12-11 16:58:21');
INSERT INTO `login_log` VALUES (107, 'admin', '127.0.0.1', '登录成功', '2021-12-11 17:36:05');

-- ----------------------------
-- Table structure for relationship
-- ----------------------------
DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship`  (
  `rela_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系表 主键 关系表id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色表的id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户表的id',
  PRIMARY KEY (`rela_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of relationship
-- ----------------------------
INSERT INTO `relationship` VALUES (1, 1, 1);
INSERT INTO `relationship` VALUES (2, 2, 2);
INSERT INTO `relationship` VALUES (3, 2, 3);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表 用来存储角色 主键 角色的id',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称 比如 admin 是管理员',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin');
INSERT INTO `role` VALUES (2, 'ordinary');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表 主键 用户的id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 用户的的用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 用户的密码\r\n',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的邮箱',
  `rela_id` int(11) NULL DEFAULT NULL COMMENT '用户权限关系表 关系表id',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该用户的状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT ' 用户的创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT ' 用户的被修改的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin@email.com', NULL, NULL, '2021-11-28 15:23:25', '2021-11-28 15:23:27');
INSERT INTO `user` VALUES (2, 'susus', 'susus', '13192424@qq.com', NULL, '可用', '2021-11-24 22:35:56', '2021-11-24 22:35:56');
INSERT INTO `user` VALUES (3, 'qqq', 'qqq', 'qqq@qq.com', NULL, '可用', '2021-11-27 18:16:14', '2021-11-27 18:16:14');
INSERT INTO `user` VALUES (6, '1310', '1310', '1310@qq.com', NULL, '可用', '2021-11-27 18:47:17', '2021-11-27 18:47:17');
INSERT INTO `user` VALUES (8, 'aaa', 'aaa', 'aaa@qq.com', NULL, '可用', '2021-11-27 18:54:03', '2021-11-27 18:54:03');
INSERT INTO `user` VALUES (9, 'qqqq', 'qqqq', 'aaa@qqqq.com', NULL, '可用', '2021-11-27 19:50:53', '2021-11-27 19:50:53');
INSERT INTO `user` VALUES (10, 'qqqqqqqq', 'qqqq', '333@qq.com', NULL, '可用', '2021-11-27 19:51:46', '2021-11-27 19:51:46');
INSERT INTO `user` VALUES (11, '乐乐好家伙', '123456', '2388422385@qq.com', NULL, '可用', '2021-11-28 17:46:11', '2021-11-28 17:46:11');
INSERT INTO `user` VALUES (12, '13727742757', 'lpt.13727742757', 'lipeitaotao@126.com', NULL, '可用', '2021-11-28 17:48:16', '2021-11-28 17:48:16');
INSERT INTO `user` VALUES (13, '123456', '123', '123@qq.com', NULL, '可用', '2021-11-30 09:02:00', '2021-11-30 09:02:00');
INSERT INTO `user` VALUES (14, '帅', '123456', 'a146727@163.com', NULL, '可用', '2021-11-30 09:03:51', '2021-11-30 09:03:51');
INSERT INTO `user` VALUES (15, 'bobo', '123qweasdzxc', '1909321454@qq.com', NULL, '可用', '2021-11-30 19:27:25', '2021-11-30 19:27:25');

SET FOREIGN_KEY_CHECKS = 1;
