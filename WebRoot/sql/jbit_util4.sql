/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50129
Source Host           : localhost:3306
Source Database       : jbit_util4

Target Server Type    : MYSQL
Target Server Version : 50129
File Encoding         : 65001

Date: 2016-08-04 10:43:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_email`
-- ----------------------------
DROP TABLE IF EXISTS `t_email`;
CREATE TABLE `t_email` (
  `e_id` varchar(32) NOT NULL DEFAULT '' COMMENT '邮件ID',
  `e_title` varchar(32) DEFAULT NULL COMMENT '邮件标题',
  `e_content` text COMMENT '邮件内容',
  `e_receive` varchar(20) DEFAULT NULL COMMENT '邮件接收者',
  `e_sender` varchar(20) DEFAULT NULL COMMENT '邮件发送者',
  `e_isread` int(1) DEFAULT '0' COMMENT '是否已读0未读1已读',
  `e_isdel` int(1) DEFAULT '0' COMMENT '是否删除0未删1已删',
  `e_receivetime` datetime DEFAULT NULL COMMENT '接收时间',
  `e_upfile` varchar(255) DEFAULT NULL COMMENT '文件上传地址',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_email
-- ----------------------------
INSERT INTO `t_email` VALUES ('06b21db95cff44ae864ee8c8c30b74b9', '235', '34343', 'accp', 'admin', '1', '0', '2016-07-25 09:58:05', '2016-07-18_111030.jpg');
INSERT INTO `t_email` VALUES ('1f6df581f86f4d9c9e34cf5b3901061b', '我的中国心', '我的中国心', 'admin', 'admin', '1', '0', '2016-08-01 19:13:18', '20160801191317211563.jpg');
INSERT INTO `t_email` VALUES ('24fbb57e24e64a32b7f463640a5fb3e0', 'dfdf', 'dfdfd', 'general', 'admin', '1', '1', '2016-07-26 11:34:43', '2016-07-23_101434.jpg');
INSERT INTO `t_email` VALUES ('342e1a8c5133497aa287b6a1de1911e0', 'fdfdf', 'ddfdd', 'general', 'admin', '1', '1', '2016-07-26 11:34:53', '2016-07-23_101434.jpg');
INSERT INTO `t_email` VALUES ('3ea1d38a586445999baeab5e14f8b6c8', 'dfdf', 'dfdf', '102', 'accp', '1', '0', '2016-07-27 03:15:59', 'wKgNclQQrCSAY4cBAAFquZ73nXY691.jpg');
INSERT INTO `t_email` VALUES ('400db178c8144b4b9c98b8dc0d46caf9', '232323', 'sdsddsdsd', 'admin', '102', '1', '0', '2016-08-02 15:48:42', '20160802154841721414.jpg');
INSERT INTO `t_email` VALUES ('4bffc849681a407eb0c59c7be11aae06', 'dfdf', 'dfdfd', 'general', 'accp', '1', '0', '2016-07-27 03:03:47', '2016-07-18_111030.jpg');
INSERT INTO `t_email` VALUES ('5998c420433348bc9f7a774f2a7aab90', '圩圩', '国国国', 'general', 'admin', '1', '0', '2016-07-26 08:35:36', 'wKgNclQQrCSAY4cBAAFquZ73nXY691.jpg');
INSERT INTO `t_email` VALUES ('64aa66e1ceda4047a3c3cf779a56f9b0', '232323', 'ffggfgg', 'accp', 'admin', '1', '0', '2016-08-02 15:49:57', '20160802154956058653.jpg');
INSERT INTO `t_email` VALUES ('6b8dd877eb204eebb114ee7bef379bb2', 'fgf', 'fgfgfgf', 'general', 'admin', '1', '0', '2016-07-26 11:37:21', '2016-07-23_101434.jpg');
INSERT INTO `t_email` VALUES ('771031853b1b4aa29f4291a8916ed0eb', 'dfdfd', 'dfdfdf', 'general', 'admin', '1', '0', '2016-07-26 09:00:11', '2016-07-23_101434.jpg');
INSERT INTO `t_email` VALUES ('7c073f271d6e49a9ab03f8834f2becf6', 'dfd', 'dfdf', 'general', 'accp', '1', '0', '2016-07-27 03:04:00', '2016-07-26_212303.jpg');
INSERT INTO `t_email` VALUES ('8a5fdaa6f2bd4e1fa30b9dab03b90980', '235', '45454', 'accp', 'admin', '1', '1', '2016-07-25 09:59:11', '2016-07-23_101434.jpg');
INSERT INTO `t_email` VALUES ('8c74ff5bfc9d4185a3fb2ad74b114d2e', 'fdfdf', 'dfdfdf', 'general', 'admin', '1', '0', '2016-07-26 11:35:22', '2016-07-23_101434.jpg');
INSERT INTO `t_email` VALUES ('97db7bb025a841acad91e06d1137a7ef', '232323232', 'dfdfdfd', 'admin', 'general', '1', '1', '2016-08-02 13:03:59', '20160802130357851823.jpg');
INSERT INTO `t_email` VALUES ('9cc6d5651d864483a1ad7e7bcc1e2d6f', '235', 'gffgfgfgfg', 'admin', 'general', '1', '1', '2016-07-24 10:34:11', '2016-07-20_113054.jpg');
INSERT INTO `t_email` VALUES ('b4c9e3611ebc4fc1b251cae4f9615dae', 'dfdf', 'dfdf', 'general', 'accp', '0', '0', '2016-07-27 03:04:17', '2016-07-18_113326.jpg');
INSERT INTO `t_email` VALUES ('d6a6929d73d349329a64cc6fbbaac6aa', 'dfdf', 'ddfdf', 'admin', 'general', '1', '0', '2016-07-27 02:58:41', '2016-07-23_101434.jpg');

-- ----------------------------
-- Table structure for `t_tree`
-- ----------------------------
DROP TABLE IF EXISTS `t_tree`;
CREATE TABLE `t_tree` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '节点ID',
  `pid` varchar(32) DEFAULT NULL COMMENT '父节点',
  `name` varchar(20) DEFAULT NULL COMMENT '节点名称',
  `url` varchar(255) DEFAULT NULL COMMENT '节点URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tree
-- ----------------------------
INSERT INTO `t_tree` VALUES ('1', '0', '用户管理', null);
INSERT INTO `t_tree` VALUES ('10', '1', '个人信息', 'jsp/user/user.jsp');
INSERT INTO `t_tree` VALUES ('2', '0', '邮箱管理', null);
INSERT INTO `t_tree` VALUES ('20', '2', '写邮件', 'jsp/email/write.jsp');
INSERT INTO `t_tree` VALUES ('21', '2', '收件箱', 'jsp/email/receive.jsp');
INSERT INTO `t_tree` VALUES ('22', '2', '回收站', 'jsp/email/recycle.jsp');
INSERT INTO `t_tree` VALUES ('3', '0', '休假管理', null);
INSERT INTO `t_tree` VALUES ('30', '3', '休假', 'jsp/vacation/vacation.jsp');
INSERT INTO `t_tree` VALUES ('4', '0', '账户管理', null);
INSERT INTO `t_tree` VALUES ('40', '4', '账户管理', 'jsp/user/account_list.jsp');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `u_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `u_nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `u_pwd` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `u_sex` int(1) DEFAULT '0' COMMENT '用户性别   0女1男',
  `u_age` varchar(3) DEFAULT NULL COMMENT '用户年龄',
  `u_phone` varchar(11) DEFAULT NULL COMMENT '用户电话',
  `u_addr` varchar(200) DEFAULT NULL COMMENT '用户地址',
  `u_role` int(1) DEFAULT '0' COMMENT '用户权限 0员工1经理',
  `u_isread` int(1) DEFAULT '0' COMMENT '是否读取 0未读1已读',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '管理员', 'admin', '1', '24', '18201508823', '花果山', '1', '0');
INSERT INTO `t_user` VALUES ('a8564281016f47e5b99b95e183ad8cee', 'general', '普通员工', 'general', '1', '24', '18201508823', '北京昌平', '0', '0');
INSERT INTO `t_user` VALUES ('c19418d10a5247c1b0af029f27bef73e', 'accp', 'accp', '1234', '1', '23', '18201508823', '北京昌平', '0', '0');
INSERT INTO `t_user` VALUES ('ff32a9f6f27f49e8aaa45b264f705e25', '102', '102', '1234', '0', '23', '18201508823', '北京昌平', '0', '0');

-- ----------------------------
-- Table structure for `t_vacation`
-- ----------------------------
DROP TABLE IF EXISTS `t_vacation`;
CREATE TABLE `t_vacation` (
  `v_id` varchar(32) NOT NULL DEFAULT '' COMMENT '假期ID',
  `v_name` varchar(20) DEFAULT NULL COMMENT '请假人',
  `v_starttime` varchar(20) DEFAULT NULL COMMENT '起始时间',
  `v_endtime` varchar(20) DEFAULT NULL COMMENT '结束时间',
  `v_days` varchar(3) DEFAULT NULL COMMENT '天数',
  `v_reason` varchar(200) DEFAULT NULL COMMENT '请假原因',
  `v_checker` varchar(20) DEFAULT NULL COMMENT '审批人',
  `v_state` int(1) DEFAULT '0' COMMENT '审核状态0未审核1已审核3审核未通过4已取消审核',
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vacation
-- ----------------------------
INSERT INTO `t_vacation` VALUES ('07ad928febbc4de8abccbe5ea8872d60', 'general', '2016-08-02', '2016-08-11', '30', 'dfdfdfdf', '102', '1');
INSERT INTO `t_vacation` VALUES ('35b2a2106801418595a86127fceb9e55', 'admin', '2016-08-16', '2016-08-11', '30', 'dfdfdfd', '102', '3');
INSERT INTO `t_vacation` VALUES ('8a5105f648424cddb13af36e3df50048', 'admin', '2016-07-25 ', '2016-07-29 ', '34', 'fddfd', 'general', '1');
INSERT INTO `t_vacation` VALUES ('9d3389c75fe04098826cbf5c87a5fcc1', 'general', '2016-08-24', '2016-08-25', '1', 'sdsdsd', 'accp', '4');
INSERT INTO `t_vacation` VALUES ('bc021238f192456589c378d014e9ef83', 'accp', '2016-07-27', '2016-07-27', '1', 'aaa', '102', '3');
INSERT INTO `t_vacation` VALUES ('db748a5530ff4a24a551e4c47f92d730', 'admin', '2016-07-27', '2016-07-29', '2', 'wewew', 'general', '4');
INSERT INTO `t_vacation` VALUES ('f857a664f5cc42479909d762590e01a6', 'accp', '2016-08-04', '2016-08-07', '3', '回家吃香瓜', 'admin', '1');
