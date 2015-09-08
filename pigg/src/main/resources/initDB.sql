-- --------------------------------------------------------
-- 主機:                           127.0.0.1
-- 服務器版本:                        5.1.50-community - MySQL Community Server (GPL)
-- 服務器操作系統:                      Win32
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 導出 lamb 的資料庫結構
DROP DATABASE IF EXISTS `lamb`;
CREATE DATABASE IF NOT EXISTS `lamb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lamb`;


-- 導出  表 lamb.t_account 結構
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE IF NOT EXISTS `t_account` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 資料導出被取消選擇。


-- 導出  表 lamb.t_bill 結構
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE IF NOT EXISTS `t_bill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `cost` decimal(10,2) DEFAULT '0.00' COMMENT '花费',
  `usefor` varchar(200) DEFAULT NULL COMMENT '用途',
  `use_time` datetime DEFAULT NULL COMMENT '花费时间',
  `log_time` datetime DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单';

-- 資料導出被取消選擇。


-- 導出  表 lamb.t_blog 結構
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE IF NOT EXISTS `t_blog` (
  `blog_id` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` longtext,
  `author` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 資料導出被取消選擇。


-- 導出  表 lamb.t_user 結構
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 資料導出被取消選擇。


-- 導出  表 lamb.t_user_login_log 結構
DROP TABLE IF EXISTS `t_user_login_log`;
CREATE TABLE IF NOT EXISTS `t_user_login_log` (
  `account` varchar(50) NOT NULL,
  `login_time` datetime DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 資料導出被取消選擇。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
