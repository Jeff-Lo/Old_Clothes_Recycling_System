-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: finalproject
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clothes`
--

DROP TABLE IF EXISTS `clothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clothes` (
  `clothes_id` int NOT NULL AUTO_INCREMENT,
  `clothes_color` varchar(20) NOT NULL,
  `clothes_size` varchar(20) NOT NULL,
  `clothes_situation` varchar(20) NOT NULL,
  `clothes_type` varchar(20) NOT NULL,
  `clothes_price` varchar(20) NOT NULL,
  `clothes_from_users_id` varchar(20) NOT NULL,
  `clothes_donate_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `clothes_check` varchar(5) NOT NULL,
  `images` varchar(200) DEFAULT NULL,
  `clothes_sold` varchar(5) NOT NULL,
  PRIMARY KEY (`clothes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothes`
--

LOCK TABLES `clothes` WRITE;
/*!40000 ALTER TABLE `clothes` DISABLE KEYS */;
INSERT INTO `clothes` VALUES (1,'red','L','10','man','100','1','2021-05-25 09:24:03','Y','Red_Man_l.jpg','N'),(2,'blue','M','8','woman','50','3','2021-05-25 09:24:03','Y','Blue_Woman_s.jpg','N'),(3,'yellow','XL','8','woman','150','2','2021-05-25 09:24:03','Y','Yellow_Woman_s.jpg','N'),(4,'red','S','8','woman','50','4','2021-05-25 09:24:00','Y','Red_Woman_s.jpg','N'),(5,'black','L','6','man','100','5','2021-05-25 09:24:03','Y','Black_Man_l.jpg','N'),(6,'white','L','8','man','100','6','2021-05-25 09:24:03','Y','White_Man_l.jpg','N'),(7,'white','M','6','woman','100','7','2021-05-25 09:24:03','Y','White_Woman_l.jpg','N'),(8,'white','S','6','woman','100','8','2021-05-25 09:24:03','Y','White_Woman_s.jpg','N'),(9,'purple','M','8','woman','100','9','2021-05-25 09:24:00','Y','Purple_Woman_l.jpg','N'),(10,'red','XXL','8','man','100','10','2021-05-25 09:24:03','Y','Red_Man_s.jpg','N'),(11,'gray','XS','8','children','50','5','2021-05-27 06:10:44','Y','Gray_Kid_s.jpg','N'),(12,'blue','S','8','man','150','5','2021-05-27 06:15:30','Y','Blue_Man_s.jpg','N'),(13,'yellow','M','8','woman','50','5','2021-06-01 09:37:56','Y','Yellow_Woman_l.jpg','N'),(14,'black','L','8','man','100','3','2021-06-10 06:45:12','Y','Black_Man_l.jpg','Y'),(17,'brown','XL','10','children','50','1','2021-06-16 12:49:13','Y','Brown_Kid_l.jpg','N'),(18,'orange','L','9','man','150','1','2021-06-17 06:36:56','Y','Orange_Man_l.jpg','N'),(19,'orange','L','9','man','100','1','2021-06-17 15:45:47','Y','Orange_Man_l.jpg','Y'),(20,'blue','L','8','man','0','20','2021-06-18 06:56:50','U','null','null'),(21,'blue','M','6','man','0','1','2021-06-18 08:57:43','U','null','null'),(22,'brown','L','10','man','0','1','2021-06-18 12:59:19','U','null','null'),(23,'brown','M','8','woman','0','3','2021-06-18 13:47:26','U','null','null'),(24,'black','L','8','man','0','9','2021-06-18 14:44:08','U','null','null'),(25,'brown','XXL','10','children','0','1','2021-06-18 15:31:35','U','null','null'),(26,'orange','L','10','man','0','23','2021-06-19 06:05:32','U','null','null'),(27,'orange','L','9','children','0','24','2021-06-26 06:15:06','U','null','null'),(28,'orange','XS','10','man','0','3','2021-06-26 06:19:45','U','null','null'),(29,'black','M','7','man','0','25','2021-06-26 06:37:00','U','null','null');
/*!40000 ALTER TABLE `clothes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-26 17:47:05
