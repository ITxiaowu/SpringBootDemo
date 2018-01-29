/*
Navicat MySQL Data Transfer

Source Server         : SpringBootDemo
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-29 22:03:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `userage` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '181');
INSERT INTO `user` VALUES ('2', '李四', '19');
INSERT INTO `user` VALUES ('3', '小明', '18');
INSERT INTO `user` VALUES ('4', 'Tony', '24');
INSERT INTO `user` VALUES ('5', '大王', '11');
INSERT INTO `user` VALUES ('6', '小K', '12');
INSERT INTO `user` VALUES ('7', '小星星', '19');
INSERT INTO `user` VALUES ('8', 'Sam', '201');
INSERT INTO `user` VALUES ('c007702c56db4ddaa3d9', '测试', '12');
INSERT INTO `user` VALUES ('d3698f33a2044563b64d', '12', '12');
INSERT INTO `user` VALUES ('f2db400e0df14317a5d0', '测试', '12');
