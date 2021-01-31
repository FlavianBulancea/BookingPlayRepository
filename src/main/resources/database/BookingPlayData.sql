-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: booking_play_database
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `phone_number` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (9,'andreea98@yahoo.com','Marin Andreea',0734332145),(10,'silviu90@yahoo.com','Axinte Silviu',0728106617),(11,'silvica.ch@yahoo.com','Silvia',0753442980),(12,'cristian76@yahoo.com','Dumitriu Cristian',0236146235),(13,'ionut2001@gmail.com','Bodeanu Ionut',0752569871);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `ticket_id` int NOT NULL,
  `amount` float NOT NULL,
  `date_time` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket_id_UNIQUE` (`ticket_id`),
  KEY `fk_payment_ticket_idx` (`ticket_id`),
  KEY `fk_payment_customer_idx` (`customer_id`),
  CONSTRAINT `fk_payment_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_payment_ticket` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (5,9,98,24.99,'2021-02-02 10:10:07'),(6,9,114,24.99,'2021-02-02 12:12:57'),(7,9,120,14.99,'2021-02-03 08:10:11'),(8,9,173,24.99,'2021-02-03 21:15:11'),(9,9,222,14.99,'2021-02-03 16:15:00'),(10,9,285,14.99,'2021-02-03 16:15:20'),(11,10,115,24.99,'2021-02-02 14:25:30'),(12,10,165,14.99,'2021-02-03 10:35:31'),(13,11,157,14.99,'2021-02-02 10:15:11'),(15,12,171,24.99,'2021-02-02 10:15:12'),(17,12,194,14.99,'2021-02-02 10:44:42'),(18,12,224,14.99,'2021-02-03 10:45:02'),(19,12,262,14.99,'2021-02-03 10:35:09'),(20,12,290,14.99,'2021-02-03 09:30:00'),(21,13,261,14.99,'2021-02-03 07:30:12');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play`
--

DROP TABLE IF EXISTS `play`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `play` (
  `id` int NOT NULL AUTO_INCREMENT,
  `theater_id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `start` timestamp NOT NULL,
  `end` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_play_theater_idx` (`theater_id`),
  CONSTRAINT `fk_play_theater` FOREIGN KEY (`theater_id`) REFERENCES `theater` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play`
--

LOCK TABLES `play` WRITE;
/*!40000 ALTER TABLE `play` DISABLE KEYS */;
INSERT INTO `play` VALUES (40,6,'A treia teapa','2021-02-10 15:00:00','2021-02-10 16:00:00'),(41,5,'Act venetian','2021-02-10 15:00:00','2021-02-10 17:00:00'),(42,5,'Apus de soare','2021-02-10 18:00:00','2021-02-10 19:00:00'),(43,7,'Cafeaua domnului ministru','2021-02-10 16:00:00','2021-02-10 18:00:00'),(44,5,'Darul Muselor','2021-02-11 14:00:00','2021-02-11 15:00:00'),(45,5,'Duet','2021-02-11 18:00:00','2021-02-11 19:00:00'),(46,7,'Divort in Direct','2021-02-11 18:00:00','2021-02-11 20:00:00'),(47,6,'Fata ursului','2021-02-11 13:00:00','2021-02-11 15:00:00'),(48,6,'Greseala','2021-02-11 16:00:00','2021-02-11 17:00:00'),(49,7,'Interviu','2021-02-12 15:00:00','2021-02-12 17:00:00'),(50,5,'Umbra','2021-02-12 16:00:00','2021-02-12 17:00:00');
/*!40000 ALTER TABLE `play` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `number_of_seats` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES (5,'Teatrul Leonard',20),(6,'Teatrul Comic 90\'',16),(7,'Teatrul Modern',16);
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `theater_id` int NOT NULL,
  `play_id` int NOT NULL,
  `seat_number` int NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_customer_idx` (`customer_id`),
  KEY `fk_ticket_play_idx` (`play_id`),
  KEY `fk_ticket_theater_idx` (`theater_id`),
  CONSTRAINT `fk_ticket_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_ticket_play` FOREIGN KEY (`play_id`) REFERENCES `play` (`id`),
  CONSTRAINT `fk_ticket_theater` FOREIGN KEY (`theater_id`) REFERENCES `theater` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=293 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (97,NULL,6,40,1,24.99),(98,9,6,40,2,24.99),(99,NULL,6,40,3,24.99),(100,NULL,6,40,4,24.99),(101,NULL,6,40,5,14.99),(102,NULL,6,40,6,14.99),(103,NULL,6,40,7,14.99),(104,NULL,6,40,8,14.99),(105,NULL,6,40,9,14.99),(106,NULL,6,40,10,14.99),(107,NULL,6,40,11,14.99),(108,NULL,6,40,12,14.99),(109,NULL,6,40,13,14.99),(110,NULL,6,40,14,14.99),(111,NULL,6,40,15,14.99),(112,NULL,6,40,16,14.99),(113,NULL,5,41,1,24.99),(114,9,5,41,2,24.99),(115,10,5,41,3,24.99),(116,NULL,5,41,4,24.99),(117,NULL,5,41,5,24.99),(118,NULL,5,41,6,14.99),(119,NULL,5,41,7,14.99),(120,9,5,41,8,14.99),(121,NULL,5,41,9,14.99),(122,NULL,5,41,10,14.99),(123,NULL,5,41,11,14.99),(124,NULL,5,41,12,14.99),(125,NULL,5,41,13,14.99),(126,NULL,5,41,14,14.99),(127,NULL,5,41,15,14.99),(128,NULL,5,41,16,14.99),(129,NULL,5,41,17,14.99),(130,NULL,5,41,18,14.99),(131,NULL,5,41,19,14.99),(132,NULL,5,41,20,14.99),(133,NULL,5,42,1,24.99),(134,NULL,5,42,2,24.99),(135,NULL,5,42,3,24.99),(136,NULL,5,42,4,24.99),(137,NULL,5,42,5,24.99),(138,NULL,5,42,6,14.99),(139,NULL,5,42,7,14.99),(140,NULL,5,42,8,14.99),(141,NULL,5,42,9,14.99),(142,NULL,5,42,10,14.99),(143,NULL,5,42,11,14.99),(144,NULL,5,42,12,14.99),(145,NULL,5,42,13,14.99),(146,NULL,5,42,14,14.99),(147,NULL,5,42,15,14.99),(148,NULL,5,42,16,14.99),(149,NULL,5,42,17,14.99),(150,NULL,5,42,18,14.99),(151,NULL,5,42,19,14.99),(152,NULL,5,42,20,14.99),(153,NULL,7,43,1,24.99),(154,NULL,7,43,2,24.99),(155,NULL,7,43,3,24.99),(156,NULL,7,43,4,24.99),(157,11,7,43,5,14.99),(158,NULL,7,43,6,14.99),(159,NULL,7,43,7,14.99),(160,NULL,7,43,8,14.99),(161,NULL,7,43,9,14.99),(162,NULL,7,43,10,14.99),(163,NULL,7,43,11,14.99),(164,NULL,7,43,12,14.99),(165,10,7,43,13,14.99),(166,NULL,7,43,14,14.99),(167,NULL,7,43,15,14.99),(168,NULL,7,43,16,14.99),(169,NULL,5,44,1,24.99),(170,NULL,5,44,2,24.99),(171,12,5,44,3,24.99),(172,NULL,5,44,4,24.99),(173,9,5,44,5,24.99),(174,NULL,5,44,6,14.99),(175,NULL,5,44,7,14.99),(176,NULL,5,44,8,14.99),(177,NULL,5,44,9,14.99),(178,NULL,5,44,10,14.99),(179,NULL,5,44,11,14.99),(180,NULL,5,44,12,14.99),(181,NULL,5,44,13,14.99),(182,NULL,5,44,14,14.99),(183,NULL,5,44,15,14.99),(184,NULL,5,44,16,14.99),(185,NULL,5,44,17,14.99),(186,NULL,5,44,18,14.99),(187,NULL,5,44,19,14.99),(188,NULL,5,44,20,14.99),(189,NULL,5,45,1,24.99),(190,NULL,5,45,2,24.99),(191,NULL,5,45,3,24.99),(192,NULL,5,45,4,24.99),(193,NULL,5,45,5,24.99),(194,12,5,45,6,14.99),(195,NULL,5,45,7,14.99),(196,NULL,5,45,8,14.99),(197,NULL,5,45,9,14.99),(198,NULL,5,45,10,14.99),(199,NULL,5,45,11,14.99),(200,NULL,5,45,12,14.99),(201,NULL,5,45,13,14.99),(202,NULL,5,45,14,14.99),(203,NULL,5,45,15,14.99),(204,NULL,5,45,16,14.99),(205,NULL,5,45,17,14.99),(206,NULL,5,45,18,14.99),(207,NULL,5,45,19,14.99),(208,NULL,5,45,20,14.99),(209,NULL,7,46,1,24.99),(210,NULL,7,46,2,24.99),(211,NULL,7,46,3,24.99),(212,NULL,7,46,4,24.99),(213,NULL,7,46,5,14.99),(214,NULL,7,46,6,14.99),(215,NULL,7,46,7,14.99),(216,NULL,7,46,8,14.99),(217,NULL,7,46,9,14.99),(218,NULL,7,46,10,14.99),(219,NULL,7,46,11,14.99),(220,NULL,7,46,12,14.99),(221,NULL,7,46,13,14.99),(222,9,7,46,14,14.99),(223,NULL,7,46,15,14.99),(224,12,7,46,16,14.99),(225,NULL,6,47,1,24.99),(226,NULL,6,47,2,24.99),(227,NULL,6,47,3,24.99),(228,NULL,6,47,4,24.99),(229,NULL,6,47,5,14.99),(230,NULL,6,47,6,14.99),(231,NULL,6,47,7,14.99),(232,NULL,6,47,8,14.99),(233,NULL,6,47,9,14.99),(234,NULL,6,47,10,14.99),(235,NULL,6,47,11,14.99),(236,NULL,6,47,12,14.99),(237,NULL,6,47,13,14.99),(238,NULL,6,47,14,14.99),(239,NULL,6,47,15,14.99),(240,NULL,6,47,16,14.99),(241,NULL,6,48,1,24.99),(242,NULL,6,48,2,24.99),(243,NULL,6,48,3,24.99),(244,NULL,6,48,4,24.99),(245,NULL,6,48,5,14.99),(246,NULL,6,48,6,14.99),(247,NULL,6,48,7,14.99),(248,NULL,6,48,8,14.99),(249,NULL,6,48,9,14.99),(250,NULL,6,48,10,14.99),(251,NULL,6,48,11,14.99),(252,NULL,6,48,12,14.99),(253,NULL,6,48,13,14.99),(254,NULL,6,48,14,14.99),(255,NULL,6,48,15,14.99),(256,NULL,6,48,16,14.99),(257,NULL,7,49,1,24.99),(258,NULL,7,49,2,24.99),(259,NULL,7,49,3,24.99),(260,NULL,7,49,4,24.99),(261,13,7,49,5,14.99),(262,12,7,49,6,14.99),(263,NULL,7,49,7,14.99),(264,NULL,7,49,8,14.99),(265,NULL,7,49,9,14.99),(266,NULL,7,49,10,14.99),(267,NULL,7,49,11,14.99),(268,NULL,7,49,12,14.99),(269,NULL,7,49,13,14.99),(270,NULL,7,49,14,14.99),(271,NULL,7,49,15,14.99),(272,NULL,7,49,16,14.99),(273,NULL,5,50,1,24.99),(274,NULL,5,50,2,24.99),(275,NULL,5,50,3,24.99),(276,NULL,5,50,4,24.99),(277,NULL,5,50,5,24.99),(278,NULL,5,50,6,14.99),(279,NULL,5,50,7,14.99),(280,NULL,5,50,8,14.99),(281,NULL,5,50,9,14.99),(282,NULL,5,50,10,14.99),(283,NULL,5,50,11,14.99),(284,NULL,5,50,12,14.99),(285,9,5,50,13,14.99),(286,NULL,5,50,14,14.99),(287,NULL,5,50,15,14.99),(288,NULL,5,50,16,14.99),(289,NULL,5,50,17,14.99),(290,12,5,50,18,14.99),(291,NULL,5,50,19,14.99),(292,NULL,5,50,20,14.99);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-31 16:55:58
