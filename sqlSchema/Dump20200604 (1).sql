-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `Author` varchar(45) NOT NULL,
  `age_limit` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'LOTR','J.R.R. Tolkien',16),(2,'Harry Potter','J.K. Rowling',14),(3,'Da vinci kód','Dan Brown',14),(4,'Angyalok és Démonok','Dan Brown',14),(5,'A világegyetem dióhéjban','Stephen Hawking',12);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_copy`
--

DROP TABLE IF EXISTS `book_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_copy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_book_cover_hard` tinyint(1) NOT NULL,
  `publication_year` date NOT NULL,
  `book_id` int NOT NULL,
  `ISBN` varchar(50) NOT NULL,
  `status` enum('available','rented') NOT NULL DEFAULT 'available',
  PRIMARY KEY (`id`),
  KEY `fk_book_copy_book1_idx` (`book_id`),
  CONSTRAINT `fk_book_copy_book1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_copy`
--

LOCK TABLES `book_copy` WRITE;
/*!40000 ALTER TABLE `book_copy` DISABLE KEYS */;
INSERT INTO `book_copy` VALUES (1,1,'2000-01-01',1,'546465466T','available'),(3,0,'2001-01-01',1,'646564646J','available'),(4,1,'2005-06-12',2,'464654213B','rented'),(6,1,'2002-12-01',3,'222222222Z','rented'),(7,0,'2008-10-05',4,'555555555A','available'),(8,0,'2007-10-05',5,'666666666N','rented'),(11,1,'2002-12-01',3,'2234234423','rented'),(12,1,'2002-12-01',3,'2234234423','available'),(13,0,'2007-10-05',5,'666666666N','available'),(14,0,'2007-10-05',5,'666666666N','available');
/*!40000 ALTER TABLE `book_copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_has_genre`
--

DROP TABLE IF EXISTS `book_has_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_has_genre` (
  `book_id` int NOT NULL,
  `genre_id` int NOT NULL,
  PRIMARY KEY (`book_id`,`genre_id`),
  KEY `fk_book_has_genre_genre1_idx` (`genre_id`),
  KEY `fk_book_has_genre_book_idx` (`book_id`),
  CONSTRAINT `fk_book_has_genre_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `fk_book_has_genre_genre1` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_has_genre`
--

LOCK TABLES `book_has_genre` WRITE;
/*!40000 ALTER TABLE `book_has_genre` DISABLE KEYS */;
INSERT INTO `book_has_genre` VALUES (1,2),(2,2),(3,6),(4,6),(5,7),(1,8),(2,8);
/*!40000 ALTER TABLE `book_has_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_rent`
--

DROP TABLE IF EXISTS `book_rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_rent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rent_date` date NOT NULL,
  `user_id` int NOT NULL,
  `book_copy_id` int NOT NULL,
  `return_date` date DEFAULT NULL,
  `expected_return_date` date NOT NULL,
  `prolongation_attempts` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lend_user1_idx` (`user_id`),
  KEY `fk_lend_book_copy1_idx` (`book_copy_id`),
  CONSTRAINT `fk_lend_book_copy1` FOREIGN KEY (`book_copy_id`) REFERENCES `book_copy` (`id`),
  CONSTRAINT `fk_lend_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_rent`
--

LOCK TABLES `book_rent` WRITE;
/*!40000 ALTER TABLE `book_rent` DISABLE KEYS */;
INSERT INTO `book_rent` VALUES (11,'2020-06-02',1,1,'2020-06-03','2020-07-02',NULL),(12,'2020-06-02',1,7,'2020-06-03','2020-07-02',NULL),(13,'2020-06-03',2,3,NULL,'2020-07-03',NULL),(14,'2020-06-02',3,8,NULL,'2020-07-03',NULL),(15,'2020-06-03',2,1,NULL,'2020-07-03',NULL),(16,'2020-06-03',1,8,NULL,'2020-07-03',NULL),(17,'2020-06-03',2,11,NULL,'2020-07-03',NULL),(18,'2020-06-04',2,4,NULL,'2020-07-04',NULL);
/*!40000 ALTER TABLE `book_rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `genre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'comic'),(2,'fantasy'),(3,'sci-fi'),(4,'drama'),(5,'romantic'),(6,'crime'),(7,'scientific'),(8,'novel'),(9,'');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `addres` varchar(45) NOT NULL,
  `e-mail` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) NOT NULL,
  `Identity_card` varchar(45) NOT NULL,
  `birth_date` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Teke Mate','Hos utca 8, Budapest','tekemate@gmail.com','0670165632','4645123','1997-09-08'),(2,'Botos János','Október 6. utca Budapest','botosjanos@email.com','06701234567','8832PA','1991-06-08'),(3,'Tóth Csaba','Ó utca 12, Szeged','tcsabi@email.com','06209967920','TCS9912','1992-07-02'),(4,'Tatiana Ankudo','Váci utca 12, Budapesten','tatiana@freemail.hu','06305125578','TA8976','1991-10-12'),(5,'Sikura Csaba','Nefelejcs utca 22, Budapest','sikuracsabi@gmail.com','06705124478','SCS7843','2000-10-01'),(6,'asdfsd','aékgljélkjg','3édsfklajés','59874358973','éadj3kj3','1991-06-08');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 13:16:12
