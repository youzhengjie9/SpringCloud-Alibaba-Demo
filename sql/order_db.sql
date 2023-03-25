CREATE DATABASE order_db;
USE order_db;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
                          `id` bigint(0) NOT NULL,
                          `product_id` bigint(0) NOT NULL,
                          `count` int(0) NOT NULL,
                          `create_time` datetime(0) NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
                             `id` bigint(0) NOT NULL AUTO_INCREMENT,
                             `branch_id` bigint(0) NOT NULL,
                             `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             `rollback_info` longblob NOT NULL,
                             `log_status` int(0) NOT NULL,
                             `log_created` datetime(0) NOT NULL,
                             `log_modified` datetime(0) NOT NULL,
                             `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;