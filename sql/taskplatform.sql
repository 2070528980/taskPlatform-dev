/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : taskplatform

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2021-04-06 16:53:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `projectIntroduce` varchar(255) DEFAULT NULL COMMENT '项目简介',
  `projectLabel` varchar(255) DEFAULT NULL COMMENT '项目标签',
  `ueditorContent` text COMMENT '项目步骤',
  `projectState` int(11) DEFAULT NULL COMMENT '项目状态',
  `recommendedIndex` int(11) DEFAULT NULL COMMENT '推荐指数',
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '朗玛实名', '找客服拿手机号和PUK卡号，一人5单 ，当天三单次日两单', '激活虚拟卡', '<p class=\"MsoNormal\" style=\"text-align: center;\" align=\"center\"><strong><span class=\"15\" style=\"font-family: 黑体; font-size: 16pt;\"><span style=\"font-family: 黑体;\">朗玛实名</span></span></strong></p>\n<p class=\"MsoNormal\" style=\"text-align: center;\" align=\"center\"><strong><span class=\"15\" style=\"font-family: Arial; font-size: 16pt;\">&nbsp;</span></strong></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt;\"><span style=\"font-family: 宋体;\">进群找客服拿手机号和</span><span style=\"font-family: Calibri;\">PUK</span><span style=\"font-family: 宋体;\">卡号，一人</span><span style=\"font-family: Calibri;\">5</span><span style=\"font-family: 宋体;\">单 ，当天三单次日两单</span></span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: Calibri; font-size: 10.5pt;\">&nbsp;</span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt;\"><span style=\"font-family: 宋体;\">流程如下：</span></span><img src=\"file:///C:\\Users\\20705\\AppData\\Local\\Temp\\ksohtml14028\\wps1.jpg\" width=\"180\" height=\"175\" /></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt;\">1.&nbsp;</span><span style=\"font-family: 宋体; font-size: 14pt;\"><span style=\"font-family: 宋体;\">微信公众号关注</span> <span style=\"font-family: 宋体;\">朗玛移动</span></span></p>\n<p class=\"MsoNormal\"><img src=\"file:///C:\\Users\\20705\\AppData\\Local\\Temp\\ksohtml14028\\wps2.png\" width=\"189\" height=\"410\" /><span style=\"font-family: Calibri; font-size: 14pt;\">&nbsp;</span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt;\">2.&nbsp;</span><span style=\"font-family: 宋体; font-size: 14pt;\"><span style=\"font-family: 宋体;\">点击右下角</span> <span style=\"font-family: 宋体;\">实名认证</span><span style=\"font-family: Calibri;\">/</span><span style=\"font-family: 宋体;\">激活</span></span></p>\n<p class=\"MsoNormal\"><img src=\"file:///C:\\Users\\20705\\AppData\\Local\\Temp\\ksohtml14028\\wps3.jpg\" width=\"189\" height=\"410\" /><span style=\"font-family: Calibri; font-size: 14pt;\">&nbsp;</span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt;\">3.&nbsp;</span><span style=\"font-family: 宋体; font-size: 14pt;\"><span style=\"font-family: 宋体;\">输入客服给的手机号和</span><span style=\"font-family: Calibri;\">PUK</span><span style=\"font-family: 宋体;\">码</span></span></p>\n<p class=\"MsoNormal\"><img src=\"file:///C:\\Users\\20705\\AppData\\Local\\Temp\\ksohtml14028\\wps4.png\" width=\"189\" height=\"410\" /><span style=\"font-family: Calibri; font-size: 14pt;\">&nbsp;</span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt;\">4.&nbsp;</span><span style=\"font-family: 宋体; font-size: 14pt;\"><span style=\"font-family: 宋体;\">上传身份证正面</span> <span style=\"font-family: 宋体;\">反面</span> <span style=\"font-family: 宋体;\">手持图</span></span></p>\n<p class=\"MsoNormal\"><img src=\"file:///C:\\Users\\20705\\AppData\\Local\\Temp\\ksohtml14028\\wps5.jpg\" width=\"189\" height=\"410\" /><span style=\"font-family: Calibri; font-size: 14pt;\">&nbsp;</span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt;\">5.&nbsp;</span><span style=\"font-family: 宋体; font-size: 14pt;\"><span style=\"font-family: 宋体;\">显示实名认证成功即可</span></span></p>\n<p class=\"MsoNormal\"><img src=\"file:///C:\\Users\\20705\\AppData\\Local\\Temp\\ksohtml14028\\wps6.png\" width=\"189\" height=\"400\" /><span style=\"font-family: 宋体; font-size: 12pt;\">&nbsp;</span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 12pt;\">&nbsp;</span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: 宋体; font-size: 14pt; background: #ff0000;\"><span style=\"font-family: 宋体;\">交单格式：客服给的手机号</span><span style=\"font-family: 宋体;\">+客服打合格的截图</span></span></p>\n<p class=\"MsoNormal\"><span style=\"font-family: Calibri; font-size: 14pt;\">&nbsp;</span></p>', '1', '5', '2021-04-02 15:31:44', '2021-04-06 16:50:49');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `SLOGINNAME` varchar(32) DEFAULT '' COMMENT '登录账号',
  `SPASSWORD` varchar(32) NOT NULL COMMENT '登录密码',
  `SREALNAME` varchar(32) DEFAULT '' COMMENT '用户真实姓名',
  `IROLEID` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色ID',
  `DCREATETIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `DUPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DSTATUS` int(11) DEFAULT NULL,
  `USERDESC` varchar(200) DEFAULT NULL COMMENT '用户描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=506 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('505', 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', '0', '2021-03-24 10:19:40', '2021-03-24 10:19:32', '1', null);
