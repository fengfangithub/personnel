/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : personnel

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-14 14:10:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `tb_attendance`;
CREATE TABLE `tb_attendance` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_date` date NOT NULL,
  `a_worktime` int(3) NOT NULL,
  `a_latetime` int(1) NOT NULL,
  `a_leavetime` int(1) NOT NULL,
  `e_id` int(11) NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `tb_attendance_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `tb_employee` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_attendance
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_category`
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(10) NOT NULL,
  `c_money` int(3) NOT NULL,
  `c_holiday` int(1) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_department`
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_no` varchar(3) NOT NULL,
  `d_established` date NOT NULL,
  `d_name` varchar(20) NOT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_department
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_employee`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_no` varchar(9) NOT NULL,
  `e_name` varchar(20) NOT NULL,
  `e_state` int(1) NOT NULL,
  `e_birth` date NOT NULL,
  `e_phone` varchar(13) DEFAULT NULL,
  `e_mobile` varchar(11) NOT NULL,
  `e_emil` varchar(20) DEFAULT NULL,
  `e_card` varchar(18) NOT NULL,
  `e_address` varchar(30) NOT NULL,
  `e_image` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of tb_employee
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_employee_position`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee_position`;
CREATE TABLE `tb_employee_position` (
  `ep_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`ep_id`),
  KEY `e_id` (`e_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `tb_employee_position_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `tb_employee` (`e_id`) ON UPDATE CASCADE,
  CONSTRAINT `tb_employee_position_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `tb_position` (`p_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee_position
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_overtime`
-- ----------------------------
DROP TABLE IF EXISTS `tb_overtime`;
CREATE TABLE `tb_overtime` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_hours` int(6) NOT NULL,
  `o_date` date NOT NULL,
  `o_content` varchar(50) NOT NULL,
  `o_place` varchar(40) NOT NULL,
  `c_id` int(11) NOT NULL,
  `e_id` int(11) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `c_id` (`c_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `tb_overtime_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `tb_category` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_overtime_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `tb_employee` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_overtime
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_position`
-- ----------------------------
DROP TABLE IF EXISTS `tb_position`;
CREATE TABLE `tb_position` (
  `p_id` int(5) NOT NULL AUTO_INCREMENT,
  `p_no` varchar(3) NOT NULL,
  `p_name` varchar(20) NOT NULL,
  `p_salary` int(8) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_position
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_position_deparment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_position_deparment`;
CREATE TABLE `tb_position_deparment` (
  `pd_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) NOT NULL,
  `d_id` int(11) NOT NULL,
  PRIMARY KEY (`pd_id`),
  KEY `p_id` (`p_id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `tb_position_deparment_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `tb_position` (`p_id`) ON UPDATE CASCADE,
  CONSTRAINT `tb_position_deparment_ibfk_2` FOREIGN KEY (`d_id`) REFERENCES `tb_department` (`d_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_position_deparment
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_vacate`
-- ----------------------------
DROP TABLE IF EXISTS `tb_vacate`;
CREATE TABLE `tb_vacate` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_date` date NOT NULL,
  `v_day` int(4) NOT NULL,
  `v_state` int(1) NOT NULL,
  `v_cause` varchar(100) DEFAULT NULL,
  `v_category` varchar(10) NOT NULL,
  `v_paid` int(1) NOT NULL,
  `e_id` int(11) NOT NULL,
  PRIMARY KEY (`v_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `tb_vacate_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `tb_employee` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_vacate
-- ----------------------------
