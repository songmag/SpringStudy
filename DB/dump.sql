-- MySQL dump 10.17  Distrib 10.3.13-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: spring_db
-- ------------------------------------------------------
-- Server version	10.3.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES euckr */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `spring_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `spring_db` /*!40100 DEFAULT CHARACTER SET euckr */;

USE `spring_db`;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_num` int(11) NOT NULL,
  `context_num` int(11) NOT NULL,
  `post_num` int(11) NOT NULL,
  `id_num` int(11) NOT NULL,
  `menu_num` int(11) NOT NULL,
  `comment_context` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`comment_num`),
  KEY `id_num` (`id_num`),
  KEY `menu_num` (`menu_num`),
  KEY `post_num` (`post_num`),
  KEY `context_num` (`context_num`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`id_num`) REFERENCES `identity_information` (`id_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`menu_num`) REFERENCES `menu` (`menu_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`post_num`) REFERENCES `post` (`post_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_4` FOREIGN KEY (`context_num`) REFERENCES `context` (`context_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `context`
--

DROP TABLE IF EXISTS `context`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `context` (
  `context_num` int(11) NOT NULL,
  `post_num` int(11) NOT NULL,
  `id_num` int(11) NOT NULL,
  `menu_num` int(11) NOT NULL,
  `context` text DEFAULT NULL,
  PRIMARY KEY (`context_num`),
  KEY `id_num` (`id_num`),
  KEY `menu_num` (`menu_num`),
  KEY `post_num` (`post_num`),
  CONSTRAINT `context_ibfk_1` FOREIGN KEY (`id_num`) REFERENCES `identity_information` (`id_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `context_ibfk_2` FOREIGN KEY (`menu_num`) REFERENCES `menu` (`menu_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `context_ibfk_3` FOREIGN KEY (`post_num`) REFERENCES `post` (`post_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `context`
--

LOCK TABLES `context` WRITE;
/*!40000 ALTER TABLE `context` DISABLE KEYS */;
/*!40000 ALTER TABLE `context` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identity_information`
--

DROP TABLE IF EXISTS `identity_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identity_information` (
  `id_num` int(11) NOT NULL,
  `id` varchar(30) DEFAULT NULL,
  `pw` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Simple_self_instruction` text DEFAULT NULL,
  PRIMARY KEY (`id_num`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identity_information`
--

LOCK TABLES `identity_information` WRITE;
/*!40000 ALTER TABLE `identity_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `identity_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `menu_num` int(11) NOT NULL,
  `menu_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`menu_num`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `post_num` int(11) NOT NULL,
  `id_num` int(11) NOT NULL,
  `menu_num` int(11) NOT NULL,
  `post_name` varchar(100) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`post_num`),
  KEY `id_num` (`id_num`),
  KEY `menu_num` (`menu_num`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`id_num`) REFERENCES `identity_information` (`id_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`menu_num`) REFERENCES `menu` (`menu_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-02 21:54:49
