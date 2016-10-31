/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-10-29 22:34:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '日记id',
  `title` varchar(30) NOT NULL COMMENT '日记标题',
  `text` longtext COMMENT '日记内容',
  `lcreateTime` datetime DEFAULT NULL COMMENT '日记创建时间',
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`lid`),
  KEY `dlid_useruid` (`uid`),
  CONSTRAINT `dlid_useruid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES ('10', '火狐浏览器', 'uid可以直接登录以后将 uid 保存进session中，然后后台自己取值999999999不能修改编号了添加添加\r\n', '2016-10-25 23:08:23', '2');
INSERT INTO `diary` VALUES ('11', 'stt日记', '哈哈哈，看，基本功能实现了', '2016-10-23 14:15:07', '2');
INSERT INTO `diary` VALUES ('12', '赵六的日记', '看看刚才修改的地方有没有问题呢', '2016-10-23 14:15:11', '3');
INSERT INTO `diary` VALUES ('13', '工作笔记new11', '今天工作挺多，但我还是完成了任务new11', '2016-10-24 10:32:18', '1');
INSERT INTO `diary` VALUES ('14', '旅游日记', '出去游玩', '2016-10-23 14:22:31', '1');
INSERT INTO `diary` VALUES ('15', '大扫除日记', '今天把家里进行了大扫除，干净又舒适', '2016-10-23 14:22:31', '1');
INSERT INTO `diary` VALUES ('18', '听说今天是 1024程序猿节', '一级棒', '2016-10-29 22:27:44', '1');
INSERT INTO `diary` VALUES ('19', '再次测试', '重新测试一遍刚才修改的地方，少创建对象是对的', '2016-10-24 10:27:59', '1');
INSERT INTO `diary` VALUES ('21', '测试hidden', '测试这个标签是否可以隐身 -- 成功', '2016-10-24 19:41:29', '1');
INSERT INTO `diary` VALUES ('27', '3.0版本进入最后测试', '还剩事务管理了------乐乐了', '2016-10-25 20:15:08', '1');
INSERT INTO `diary` VALUES ('28', '再次测试3.0', '试试搜索功能行了没333333', '2016-10-25 20:19:10', '1');
INSERT INTO `diary` VALUES ('31', '测试分页1', '测试分页1', '2016-10-29 14:26:27', '1');
INSERT INTO `diary` VALUES ('32', '测试分页2', '测试分页2', '2016-10-29 14:26:30', '1');
INSERT INTO `diary` VALUES ('33', '测试分页3', '测试分页3', '2016-10-29 14:26:33', '1');
INSERT INTO `diary` VALUES ('34', '测试分页4', '测试分页4', '2016-10-29 14:26:47', '1');
INSERT INTO `diary` VALUES ('37', '我是张三12', '初次见面请多关照rest', '2016-10-29 18:34:36', '13');
INSERT INTO `diary` VALUES ('38', 'hello1', '我是测试', '2016-10-29 18:34:48', '13');
INSERT INTO `diary` VALUES ('40', 'h', 'awfefawfawe', '2016-10-29 18:35:06', '13');
INSERT INTO `diary` VALUES ('41', 'fehhhh', 'efawfawf', '2016-10-29 18:35:14', '13');
INSERT INTO `diary` VALUES ('42', 'blog4测试', 'hello啊', '2016-10-29 19:22:33', '1');
INSERT INTO `diary` VALUES ('44', '测试总记录数', '刚才好像看到了是14，应该是15', '2016-10-29 22:28:56', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户 id',
  `uname` char(16) NOT NULL COMMENT '用户姓名',
  `password` char(20) NOT NULL COMMENT '用户密码',
  `createTime` datetime DEFAULT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangSan', '12345', '2016-10-23 14:22:24');
INSERT INTO `user` VALUES ('2', 'liSi', '67890', '2016-10-23 14:02:38');
INSERT INTO `user` VALUES ('3', 'wuWang', '123456789', '2016-10-23 14:03:11');
INSERT INTO `user` VALUES ('5', '小明', 'xiaoming', '2016-10-23 20:20:11');
INSERT INTO `user` VALUES ('6', '小赵', 'xiaozhao', '2016-10-23 20:31:12');
INSERT INTO `user` VALUES ('8', '小李', 'xiaoli', '2016-10-23 20:35:28');
INSERT INTO `user` VALUES ('9', 'test', 'test', '2016-10-24 12:47:25');
INSERT INTO `user` VALUES ('10', 'hello', '1234', '2016-10-24 13:07:38');
INSERT INTO `user` VALUES ('12', 'zhangSan1', '123456', '2016-10-29 18:30:11');
INSERT INTO `user` VALUES ('13', 'zhangSan12', '12345', '2016-10-29 18:33:46');
INSERT INTO `user` VALUES ('14', 'zhangSan2', '1234', '2016-10-29 19:24:25');
