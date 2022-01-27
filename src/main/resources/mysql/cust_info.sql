DROP TABLE IF EXISTS `cust_info`;
CREATE TABLE `cust_info`  (
                              `cust_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户号',
                              `cust_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户姓名',
                              `cert_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件类型',
                              `cert_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件号',
                              PRIMARY KEY (`cust_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;