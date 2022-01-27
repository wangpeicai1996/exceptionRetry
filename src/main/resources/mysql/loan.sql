DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan`  (
                         `bill_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借据号',
                         `cust_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户号',
                         `cust_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称',
                         `cert_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件类型',
                         `cert_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件号码',
                         `lending_date` date NOT NULL COMMENT '放款日期',
                         `lending_amt` decimal(15, 2) NOT NULL COMMENT '放款金额',
                         `version` int(64) NOT NULL COMMENT '版本号',
                         PRIMARY KEY (`bill_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;