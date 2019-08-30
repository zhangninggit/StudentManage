/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.26 : Database - day4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`day4` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `day4`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `student_id` int(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(32) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`student_id`,`name`,`age`,`sex`,`birthday`) values (1,23,'张三',66,'男','1986-01-14'),(3,27,'王六',24,'男','2019-01-11'),(4,25,'李华',23,'男','2019-01-05'),(6,668,'小华',23,'女','2019-01-05'),(12,33,'大华',23,'男','2019-01-13'),(13,34,'fy',24,'男','2019-01-06'),(22,56,'小龙女',38,'女','1980-01-06'),(23,76,'杨过',45,'男','1979-01-15'),(24,79,'周伯通',67,'男','1913-01-12'),(25,666,'张飞',43,'男','2019-01-08'),(26,666,'张飞',43,'男',NULL),(27,666,'张飞',43,'男',NULL),(28,666,'张飞',43,'男',NULL),(30,666,'张飞',43,'男',NULL),(31,666,'张飞',43,'男',NULL),(32,666,'张飞',43,'男',NULL),(33,666,'张飞',43,'男',NULL),(34,667,'张飞',43,'女','2019-01-14'),(37,666,'张飞',43,'男',NULL),(38,666,'张飞',43,'男',NULL),(39,666,'张飞',43,'男',NULL),(40,666,'张飞',43,'男',NULL),(41,666,'张飞',43,'男',NULL),(42,666,'张飞',43,'男',NULL),(43,666,'张飞',43,'男',NULL),(44,666,'张飞',43,'男',NULL),(45,666,'张飞',43,'男',NULL),(47,666,'张飞',43,'男',NULL),(48,666,'张飞',43,'男',NULL),(49,666,'张飞',43,'男',NULL),(50,666,'张飞',43,'男',NULL),(51,666,'张飞',43,'男',NULL),(52,666,'张飞',43,'男',NULL),(54,666,'张飞',43,'男',NULL),(55,666,'张飞',43,'男',NULL),(56,666,'张飞',43,'男',NULL),(57,666,'张飞',43,'男',NULL),(58,666,'张飞',43,'男',NULL),(59,666,'张飞',43,'男',NULL),(60,666,'张飞',43,'男',NULL),(61,666,'张飞',43,'男',NULL),(62,666,'张飞',43,'男',NULL),(63,666,'张飞',43,'男',NULL),(64,666,'张飞',43,'男',NULL),(65,666,'张飞',43,'男',NULL),(66,666,'张飞',43,'男',NULL),(67,666,'张飞',43,'男',NULL),(68,666,'张飞',43,'男',NULL),(69,666,'张飞',43,'男',NULL),(70,666,'张飞',43,'男',NULL),(71,666,'张飞',43,'男',NULL),(72,423,'小雨',28,'男','2019-01-12'),(73,888,'一叶知秋',22,'男','1996-01-24'),(74,234,'张于',35,'男','2017-01-10'),(76,67,'田七',43,'男','2019-01-28'),(77,889,'小张',43,'男','2017-01-11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
