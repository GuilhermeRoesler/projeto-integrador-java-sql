-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: art_music
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
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `id_evento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `data` datetime NOT NULL,
  `local` varchar(100) NOT NULL,
  `id_artista` int DEFAULT NULL,
  `preco_ingresso` decimal(10,2) DEFAULT NULL,
  `capacidade` int DEFAULT NULL,
  `descricao` text,
  `tipo_evento` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `id_artista` (`id_artista`),
  CONSTRAINT `evento_ibfk_1` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Show de Verão','2023-12-01 20:00:00','Estádio do Morumbi',1,150.00,50000,'Um grande show com Ana Carolina e convidados.','Show','Confirmado'),(2,'Festival de Música do Rio','2023-11-15 18:00:00','Praia de Copacabana',2,200.00,100000,'Festival com artistas de todo o Brasil.','Festival','Confirmado'),(3,'Balada Sertaneja','2023-10-20 22:00:00','Casa de Shows São Paulo',5,100.00,2000,'Uma noite de muita música sertaneja.','Show','Planejado'),(4,'Festa do Peão','2023-09-10 19:00:00','Parque do Peão',6,80.00,30000,'Tradicional festa com rodeio e shows.','Festival','Confirmado'),(5,'Rock na Praia','2023-08-12 21:00:00','Praia de Ipanema',9,120.00,15000,'Show com as melhores bandas de rock brasileiro.','Show','Planejado'),(6,'Noite do Samba','2023-07-05 20:30:00','Sambódromo',10,50.00,20000,'Uma noite de muito samba e alegria.','Show','Confirmado'),(7,'Carnaval de Salvador','2024-02-10 15:00:00','Caminho do Barra',3,250.00,100000,'O maior carnaval do mundo com Ivete Sangalo.','Festival','Confirmado'),(8,'Aniversário de São Paulo','2023-01-25 17:00:00','Parque Ibirapuera',8,30.00,50000,'Comemoração com shows ao ar livre.','Festival','Planejado'),(9,'Encontro de Bandas','2023-05-15 19:00:00','Centro Cultural',7,90.00,3000,'Evento com bandas independentes.','Show','Planejado'),(10,'Festa Junina','2023-06-24 18:00:00','Praça Central',4,25.00,10000,'Festa típica com comida e música junina.','Festival','Confirmado'),(11,'Festival de Inverno','2023-08-01 19:00:00','Centro de Eventos',1,120.00,25000,'Festival com artistas de MPB.','Festival','Planejado'),(12,'Show Internacional','2023-09-15 21:00:00','Arena Anhembi',2,300.00,20000,'Show com artista internacional.','Show','Confirmado'),(13,'Sertanejo Universitário','2023-11-10 20:00:00','Ginásio do Ibirapuera',5,90.00,10000,'Show com os melhores do sertanejo universitário.','Show','Planejado'),(14,'Rock Festival','2023-10-01 18:00:00','Estádio do Maracanã',9,150.00,70000,'Festival com bandas de rock nacional.','Festival','Confirmado'),(15,'Noite da MPB','2023-07-30 19:30:00','Teatro Municipal',4,70.00,500,'Show com grandes nomes da MPB.','Show','Planejado'),(16,'Samba no Pé','2023-12-20 18:00:00','Casa de Cultura',10,35.00,2000,'Uma noite de samba ao vivo.','Show','Confirmado'),(17,'Aniversário do Artista','2023-03-15 21:00:00','Casa de Shows',3,120.00,3000,'Show especial em comemoração ao aniversário do artista.','Show','Planejado'),(18,'Virada Cultural','2024-05-01 10:00:00','Centro de São Paulo',8,0.00,50000,'Evento gratuito com várias atrações.','Festival','Planejado'),(19,'Festa do Milho','2023-11-25 16:00:00','Fazenda do Artista',6,40.00,1000,'Festa típica com shows de música caipira.','Festival','Confirmado'),(20,'Baile de Máscaras','2024-02-15 22:00:00','Clube da Música',7,60.00,1500,'Baile de Carnaval com shows ao vivo.','Festival','Planejado'),(21,'Festa do Peão de Barretos','2023-08-15 18:00:00','Parque do Peão',5,200.00,30000,'Tradicional rodeio com shows.','Festival','Confirmado'),(22,'Show de Fim de Ano','2023-12-31 22:00:00','Praça da Liberdade',1,150.00,25000,'Show especial de Réveillon.','Show','Confirmado'),(23,'Rock in Rio','2024-09-20 20:00:00','Parque Olímpico',2,400.00,70000,'O maior festival de rock do Brasil.','Festival','Planejado'),(24,'Encontro de Sertanejos','2023-07-20 18:00:00','Estádio do Mineirão',6,100.00,50000,'Show com os melhores artistas sertanejos.','Show','Confirmado'),(25,'Festa do Pôr do Sol','2023-09-01 17:30:00','Praia do Leme',3,50.00,10000,'Evento ao ar livre com música ao vivo.','Festival','Planejado'),(26,'Cultura em Movimento','2023-10-10 14:00:00','Centro Cultural',8,0.00,3000,'Evento gratuito com várias atrações culturais.','Festival','Planejado'),(27,'Show de Natal','2023-12-24 20:00:00','Teatro Municipal',4,80.00,1500,'Show especial de Natal.','Show','Confirmado'),(28,'Festival de Gastronomia','2023-08-05 12:00:00','Parque da Cidade',9,30.00,20000,'Festival com comidas e shows ao vivo.','Festival','Planejado'),(29,'Canto da Primavera','2023-09-21 18:00:00','Praça da Sé',10,25.00,5000,'Show em comemoração à chegada da primavera.','Show','Confirmado'),(30,'Roda de Samba','2023-07-15 20:00:00','Casa de Samba',10,10.00,200,'Noite de samba com várias rodas de samba.','Show','Confirmado');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-07  9:56:46
