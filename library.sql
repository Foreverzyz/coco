/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-01-02 21:37:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `addbook`
-- ----------------------------
DROP TABLE IF EXISTS `addbook`;
CREATE TABLE `addbook` (
  `id` varchar(20) NOT NULL,
  `bookname` varchar(30) DEFAULT NULL COMMENT '书本名称',
  `author` varchar(20) DEFAULT NULL COMMENT '书本作者',
  `publisher` varchar(30) DEFAULT NULL COMMENT '出版社',
  `price` int(11) DEFAULT NULL COMMENT '书本价格',
  `category` varchar(10) DEFAULT NULL COMMENT '书本类目',
  `store` int(11) DEFAULT NULL,
  `bookdesc` varchar(100) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `lo` FOREIGN KEY (`id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addbook
-- ----------------------------

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(20) NOT NULL COMMENT '书本ID',
  `bookname` varchar(20) DEFAULT NULL COMMENT '书本名称',
  `author` varchar(20) DEFAULT NULL COMMENT '书本作者',
  `publisher` varchar(20) DEFAULT NULL COMMENT '出版社',
  `price` int(10) DEFAULT NULL COMMENT '书本价格',
  `category` varchar(20) DEFAULT NULL COMMENT '书本类目',
  `store` int(10) DEFAULT NULL,
  `bookdesc` varchar(1000) DEFAULT NULL,
  `location` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍数据库';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('000001', '音乐鉴赏', 'aaa', '高等教育出版社', '15', '音乐类', '19', '该书很好', '18');
INSERT INTO `book` VALUES ('000002', '高等数学', 'bbb', '高等教育出版社', '15', '数学类', '15', '该书很好', '3');
INSERT INTO `book` VALUES ('000003', '数据库设计', 'ccc', '高等教育出版社', '15', '编程类', '15', '该书很好', '3');
INSERT INTO `book` VALUES ('000004', '大学英语', 'ddd', '高等教育出版社', '15', '英语类', '15', '该书很好', '1');
INSERT INTO `book` VALUES ('000005', 'java设计', 'eee', '高等教育出版社', '15', '编程类', '8', '该书很好', '3');
INSERT INTO `book` VALUES ('000006', '音乐鉴赏', 'fff', '高等教育出版社', '15', '音乐类', '15', '该书很好', '3');

-- ----------------------------
-- Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `bookid` varchar(20) DEFAULT NULL,
  `readerid` varchar(30) DEFAULT NULL,
  `service` int(10) DEFAULT NULL,
  `borrowtime` varchar(30) NOT NULL,
  `borrowday` int(10) DEFAULT NULL,
  `complete` int(10) DEFAULT NULL,
  PRIMARY KEY (`borrowtime`),
  KEY `b_bookid` (`bookid`),
  KEY `b_reaid` (`readerid`),
  CONSTRAINT `b_reaid` FOREIGN KEY (`readerid`) REFERENCES `reader` (`readerid`),
  CONSTRAINT `b_bookid` FOREIGN KEY (`bookid`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('000002', '2016001', '-1', '2019年01月02日 00时48分43秒', '7', '0');

-- ----------------------------
-- Table structure for `reader`
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `readerid` varchar(30) NOT NULL COMMENT '读者用户名',
  `password` varchar(30) DEFAULT NULL COMMENT '读者密码',
  `name` varchar(30) DEFAULT NULL COMMENT '读者姓名',
  `sex` varchar(30) DEFAULT NULL COMMENT '读者性别',
  `status` int(10) DEFAULT NULL COMMENT '读者状态(1.正常 -1.黑名单)',
  `mail` varchar(30) DEFAULT NULL COMMENT '读者邮箱',
  `tel` varchar(30) DEFAULT NULL COMMENT '读者电话',
  `grade` int(10) DEFAULT '-1' COMMENT '读者年级',
  `classnum` int(10) DEFAULT '-1' COMMENT '读者班级',
  PRIMARY KEY (`readerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='读者表';

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('2016001', '123456', '厉好', '男', '1', '123', '8520', '6', '1');
INSERT INTO `reader` VALUES ('2016002', '123456', '户对', '女', '1', '4563', null, '3', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '用户密码',
  `name` varchar(20) DEFAULT NULL COMMENT '用户真实姓名',
  `sex` varchar(20) DEFAULT NULL COMMENT '用户性别',
  `department` varchar(20) DEFAULT NULL COMMENT '用户部门',
  `tel` varchar(20) DEFAULT NULL COMMENT '用户电话',
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123456', '测试', '男', '图书馆', '12345678901');
