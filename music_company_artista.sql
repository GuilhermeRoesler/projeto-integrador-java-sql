-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: music_company
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista` (
  `id_artista` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `nacionalidade` varchar(50) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `biografia` text,
  `site_oficial` varchar(100) DEFAULT NULL,
  `premios` text,
  `redes_sociais` text,
  `discografia` text,
  PRIMARY KEY (`id_artista`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES (1,'Ana Carolina','MPB','Brasileira','1974-09-09','Cantora e compositora brasileira.','www.anacarolina.com','Grammy Latino','@anacarolina','Ana Carolina (2001), Estampado (2003)'),(2,'Caetano Veloso','MPB','Brasileira','1942-08-07','Cantor e compositor brasileiro.','www.caetanoveloso.com','Prêmio Shell','@caetanoveloso','Transa (1972), Livro (2004)'),(3,'Ivete Sangalo','Axé','Brasileira','1972-05-27','Cantora de axé e pop.','www.ivetesangalo.com','Prêmio Multishow','@ivetesangalo','O Canto da Cidade (1999), Live Experience (2020)'),(4,'Gilberto Gil','MPB','Brasileira','1942-06-26','Cantor, compositor e ex-ministro da Cultura.','www.gilbertogil.com','Grammy Latino','@gilbertogil','Expresso 2222 (1972), Fé na Festa (2017)'),(5,'Luan Santana','Sertanejo','Brasileira','1991-03-13','Cantor sertanejo.','www.luansantana.com.br','Prêmio de Música Brasileira','@luansantana','Ao Vivo e a Cores (2015), 1977 (2018)'),(6,'Marília Mendonça','Sertanejo','Brasileira','1995-07-22','Cantora e compositora sertaneja.','www.mariliamendonca.com.br','Grammy Latino','@mariliamendonca','Todos os Cantos (2019), Patroas (2020)'),(7,'Anitta','Pop','Brasileira','1993-03-30','Cantora, compositora e empresária.','www.anitta.com.br','MTV Europe Music Awards','@anitta','Anitta (2019), Kisses (2019)'),(8,'Zezé Di Camargo & Luciano','Sertanejo','Brasileira','1991-09-23','Dupla sertaneja.','www.zeze.com.br','Prêmio de Música Brasileira','@zezedicamargo','Zezé Di Camargo & Luciano (1991), Dez Anos (2001)'),(9,'Banda do Mar','Indie','Brasileira','2013-03-04','Banda brasileira de indie rock.','www.bandadomar.com','Prêmio Multishow','@bandadomar','Banda do Mar (2014), O Céu é o Limite (2019)'),(10,'Skank','Rock','Brasileira','1991-06-04','Banda de rock brasileira.','www.skank.com.br','Prêmio Multishow','@skankoficial','Calango (1994), O Samba Poconé (1997)'),(11,'Titãs','Rock','Brasileira','1982-09-05','Banda de rock brasileira.','www.titas.com.br','Prêmio Multishow','@titas','Titãs (1984), Õ Blésq Blom (1998)'),(12,'Legião Urbana','Rock','Brasileira','1982-09-11','Banda de rock brasileira.','www.legiaourbana.com.br','Prêmio Sharp','@legiaourbana','Legião Urbana (1985), O Descobrimento do Brasil (1993)'),(13,'Elis Regina','MPB','Brasileira','1945-03-17','Cantora brasileira.','www.elisregina.com.br','Prêmio da Música Brasileira','@elisregina','Elis & Tom (1974), Falso Brilhante (1976)'),(14,'Milton Nascimento','MPB','Brasileira','1942-10-26','Cantor e compositor brasileiro.','www.miltonnascimento.com','Grammy Latino','@miltonnascimento','Clube da Esquina (1972), Piedade (2017)'),(15,'Chico Buarque','MPB','Brasileira','1944-06-19','Cantor e compositor brasileiro.','www.chicobuarque.com','Prêmio Camões','@chicobuarque','Construção (1971), Caravanas (2017)'),(16,'Sandy e Junior','Pop','Brasileira','1989-04-05','Dupla musical brasileira.','www.sandyjúnior.com.br','Prêmio Multishow','@sandyjunior','Anos 90 (2019), Nossa História (2019)'),(17,'Belo','Sertanejo','Brasileira','1979-04-22','Cantor e compositor.','www.belo.com.br','Prêmio de Música Brasileira','@belo','Felicidade (1999), O Melhor de Belo (2010)'),(18,'Pitty','Rock','Brasileira','1977-10-07','Cantora e compositora brasileira.','www.pitty.com.br','Prêmio Multishow','@pitty','Admirável Chip Novo (2003), Sete Vidas (2014)'),(19,'Fresno','Rock','Brasileira','2001-01-01','Banda de rock brasileira.','www.fresno.com.br','Prêmio Multishow','@fresno','O Rio é Aqui (2004), Infinito (2016)'),(20,'Roupa Nova','MPB','Brasileira','1980-01-01','Banda de pop rock brasileira.','www.roupanova.com.br','Prêmio de Música Brasileira','@roupanova','Roupa Nova (1986), Ao Vivo (2010)'),(21,'Jorge Ben Jor','Samba','Brasileira','1939-03-22','Cantor e compositor brasileiro.','www.jorgebenjor.com','Grammy Latino','@jorgebenjor','Samba Esquema Novo (1970), O Melhor de Jorge Ben Jor (2018)'),(22,'Marisa Monte','MPB','Brasileira','1967-07-01','Cantora e compositora brasileira.','www.marismon.com','Grammy Latino','@marisamonte','Mais (1991), O Que Você Quer Saber de Verdade (2019)'),(23,'Luan Santana','Sertanejo','Brasileira','1991-03-13','Cantor e compositor brasileiro.','www.luansantana.com.br','Prêmio de Música Brasileira','@luansantana','Ao Vivo e a Cores (2015), 1977 (2018)'),(24,'Vanessa da Mata','MPB','Brasileira','1976-02-10','Cantora e compositora brasileira.','www.vanessadamata.com.br','Prêmio de Música Brasileira','@vanessadamata','Dos Outros (2007), O Tempo é Agora (2017)'),(25,'Adriana Calcanhotto','MPB','Brasileira','1965-09-03','Cantora e compositora brasileira.','www.adrianacalcanhotto.com','Prêmio da Música Brasileira','@adrianacalcanhotto','Enguiço (1990), A Mulher que Fazia Falta (2017)'),(26,'Jota Quest','Pop','Brasileira','1993-01-01','Banda de pop rock brasileira.','www.jotaquest.com','Prêmio Multishow','@jotaquest','Jota Quest (1996), P.O. Box (2018)');
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-29  7:10:13
