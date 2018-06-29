CREATE DATABASE  IF NOT EXISTS `elweb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `elweb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: elweb
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `pessoa_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `altura` double NOT NULL,
  `ativo` bit(1) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `massa` double NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,1.73,'\0','965.183.150-24',85,'Joãozinho'),(2,1.82,'','764.229.360-79',97,'Ednaldo Pereira'),(3,1.8,'','678.224.540-05',77.5,'Gil da Esfiha'),(4,1.79,'','416.186.320-94',82,'João das Neves'),(5,1.81,'','501.540.480-89',102.53,'Fausto Silva'),(6,1.69,'','239.043.910-11',68,'Tio do Café'),(7,1.92,'','231.579.660-14',110.25,'Galvão Bueno'),(8,1.91,'','183.243.940-28',92,'Arnold Schwarzenegger'),(9,2.15,'','010.988.520-10',107.5,'Scorpion'),(10,1.69,'','331.936.920-26',62,'Naruto'),(11,1.68,'','013.680.630-98',55,'Jaylin Super Saiyan'),(12,1.41,'','325.542.310-44',35,'Gugu Gaiteiro'),(13,1.6,'','967.507.200-80',49.5,'Yudi Playstation'),(14,1.85,'','535.839.900-30',82,'Homem de Ferro'),(15,2,'','590.302.160-34',99,'Paulão Desmaio'),(16,1.79,'','992.521.270-70',69,'Serjão Berranteiro'),(17,1.72,'','304.589.310-47',47,'Nunes Filho');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-29 12:44:29
