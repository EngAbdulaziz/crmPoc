-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.9-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for crmpoc
DROP DATABASE IF EXISTS `crmpoc`;
CREATE DATABASE IF NOT EXISTS `crmpoc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `crmpoc`;

-- Dumping structure for table crmpoc.customer
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Customer_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_Name` varchar(200) NOT NULL,
  `Customer_Main_Mobile` varchar(11) NOT NULL,
  `Customer_Email` varchar(200) NOT NULL,
  `Customer_Second_Mobile` varchar(11) NOT NULL,
  `Customer_Phone` varchar(11) NOT NULL,
  `Customer_Address` varchar(500) NOT NULL,
  `Customer_City` int(4) NOT NULL,
  `Customer_Governorate` int(4) NOT NULL,
  `Customer_Region` int(4) NOT NULL,
  `Customer_Type` int(4) NOT NULL,
  `Ope_Id` int(11) DEFAULT NULL,
  `Ope_Date` datetime DEFAULT NULL,
  `Deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Customer_Id`),
  KEY `FK_customer_type` (`Customer_Type`),
  KEY `FK_customer_city` (`Customer_City`),
  KEY `FK_customer_region` (`Customer_Region`),
  KEY `FK_customer_governorate` (`Customer_Governorate`),
  KEY `FK_customer_system_user_` (`Ope_Id`),
  CONSTRAINT `FK_customer_city` FOREIGN KEY (`Customer_City`) REFERENCES `lookup` (`Lookup_Id`),
  CONSTRAINT `FK_customer_governorate` FOREIGN KEY (`Customer_Governorate`) REFERENCES `lookup` (`Lookup_Id`),
  CONSTRAINT `FK_customer_region` FOREIGN KEY (`Customer_Region`) REFERENCES `lookup` (`Lookup_Id`),
  CONSTRAINT `FK_customer_system_user_` FOREIGN KEY (`Ope_Id`) REFERENCES `system_user` (`user_Id`),
  CONSTRAINT `FK_customer_type` FOREIGN KEY (`Customer_Type`) REFERENCES `lookup` (`Lookup_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table crmpoc.employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `Employee_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Employee_Name` varchar(200) NOT NULL,
  `Employee_Main_Mobile` varchar(11) NOT NULL,
  `Employee_Email` varchar(200) NOT NULL,
  `Employee_Second_Mobile` varchar(11) NOT NULL,
  `Employee_Phone` varchar(11) NOT NULL,
  `Employee_Address` varchar(500) NOT NULL,
  `Employee_User` int(11) NOT NULL,
  `Employee_Department` int(4) NOT NULL,
  `Employee_Type` int(4) NOT NULL,
  `Ope_Id` int(11) DEFAULT NULL,
  `Ope_Date` datetime DEFAULT NULL,
  `Deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Employee_Id`),
  KEY `FK_Employee_type` (`Employee_Type`),
  KEY `FK_Employee_Department` (`Employee_Department`),
  KEY `FK_employee_system_user` (`Employee_User`),
  KEY `FK_employee_system_user_2` (`Ope_Id`),
  CONSTRAINT `FK_Employee_Department` FOREIGN KEY (`Employee_Department`) REFERENCES `lookup` (`Lookup_Id`),
  CONSTRAINT `FK_Employee_type` FOREIGN KEY (`Employee_Type`) REFERENCES `lookup` (`Lookup_Id`),
  CONSTRAINT `FK_employee_system_user` FOREIGN KEY (`Employee_User`) REFERENCES `system_user` (`user_Id`),
  CONSTRAINT `FK_employee_system_user_2` FOREIGN KEY (`Ope_Id`) REFERENCES `system_user` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table crmpoc.lookup
DROP TABLE IF EXISTS `lookup`;
CREATE TABLE IF NOT EXISTS `lookup` (
  `Lookup_Id` int(4) NOT NULL AUTO_INCREMENT,
  `Lookup_Type_Id` int(4) NOT NULL,
  `Lookup_Name` varchar(100) NOT NULL,
  `Deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Lookup_Id`),
  KEY `FK_lookup_lookup_type` (`Lookup_Type_Id`),
  CONSTRAINT `FK_lookup_lookup_type` FOREIGN KEY (`Lookup_Type_Id`) REFERENCES `lookup_type` (`Lookup_Type_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table crmpoc.lookup_type
DROP TABLE IF EXISTS `lookup_type`;
CREATE TABLE IF NOT EXISTS `lookup_type` (
  `Lookup_Type_Id` int(4) NOT NULL AUTO_INCREMENT,
  `Lookup_Type_Name` varchar(100) NOT NULL,
  `Deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Lookup_Type_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table crmpoc.system_notification
DROP TABLE IF EXISTS `system_notification`;
CREATE TABLE IF NOT EXISTS `system_notification` (
  `Notification_Id` int(15) NOT NULL AUTO_INCREMENT,
  `Notification_Tittle` varchar(300) NOT NULL,
  `Notification_Body` varchar(1000) NOT NULL,
  `Notification_Creation_Date` datetime NOT NULL,
  `Notification_Created_By` int(11) NOT NULL,
  `Notification_Due_Date` datetime NOT NULL,
  `Notification_Status` int(4) NOT NULL,
  `Notification_End_Date` datetime NOT NULL,
  `Notification_Assignee_User` int(11) NOT NULL,
  `Notification_Related_Customer` int(11) DEFAULT NULL,
  `Notification_Priority` int(4) DEFAULT NULL,
  `Ope_Id` int(11) DEFAULT NULL,
  `Ope_Date` datetime DEFAULT NULL,
  `Deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Notification_Id`),
  KEY `FK_system_notification_lookup` (`Notification_Status`),
  KEY `FK_system_notification_system_user` (`Notification_Assignee_User`),
  KEY `FK_system_notification_customer` (`Notification_Related_Customer`),
  KEY `FK_system_notification_lookup_2` (`Notification_Priority`),
  KEY `FK_system_notification_system_user_2` (`Ope_Id`),
  KEY `FK_system_notification_system_user_3` (`Notification_Created_By`),
  CONSTRAINT `FK_system_notification_customer` FOREIGN KEY (`Notification_Related_Customer`) REFERENCES `customer` (`Customer_Id`),
  CONSTRAINT `FK_system_notification_lookup` FOREIGN KEY (`Notification_Status`) REFERENCES `lookup` (`Lookup_Id`),
  CONSTRAINT `FK_system_notification_lookup_2` FOREIGN KEY (`Notification_Priority`) REFERENCES `lookup` (`Lookup_Id`),
  CONSTRAINT `FK_system_notification_system_user` FOREIGN KEY (`Notification_Assignee_User`) REFERENCES `system_user` (`user_Id`),
  CONSTRAINT `FK_system_notification_system_user_2` FOREIGN KEY (`Ope_Id`) REFERENCES `system_user` (`user_Id`),
  CONSTRAINT `FK_system_notification_system_user_3` FOREIGN KEY (`Notification_Created_By`) REFERENCES `system_user` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table crmpoc.system_user
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE IF NOT EXISTS `system_user` (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Name` varchar(200) NOT NULL,
  `user_passowrd` varchar(11) NOT NULL,
  `Ope_Id` int(11) DEFAULT NULL,
  `Ope_Date` datetime DEFAULT NULL,
  `Deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_Id`),
  KEY `FK_system_user_system_user_` (`Ope_Id`),
  CONSTRAINT `FK_system_user_system_user_` FOREIGN KEY (`Ope_Id`) REFERENCES `system_user` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
