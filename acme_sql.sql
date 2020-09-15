SET GLOBAL time_zone = '-3:00';
CREATE DATABASE  IF NOT EXISTS `service-automotor` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `service-automotor`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: service-automotor
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='-03:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autos`
--

DROP TABLE IF EXISTS `autos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `autos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patente` char(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `marca` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modelo` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `anio` int(4) NOT NULL,
  `color` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `duenio` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `patente_UNIQUE` (`patente`),
  KEY `fk_id_clientes_autos_idx` (`duenio`),
  CONSTRAINT `fk_id_clientes_autos` FOREIGN KEY (`duenio`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autos`
--

LOCK TABLES `autos` WRITE;
/*!40000 ALTER TABLE `autos` DISABLE KEYS */;
INSERT INTO `autos` VALUES (1,'IZ846EE','Uolsfagen','Hol',2013,'Negro',163),(2,'TC96LB','Uolsfagen','Cora',2012,'Azul',110),(3,'PV684ZE','Giat','Qalio',2005,'Negro',104),(4,'GQ738JU','Uolsfagen','Cora',2006,'Beige',106),(5,'ZE444IH','Goord','Giesta',2007,'Azul',164),(6,'NC761ZO','Debrolet','Qrisma',2007,'Gris',169),(7,'BI557FZ','Giat','Qalio',2012,'Beige',108),(8,'UB311PC','Queugeot','309',2008,'Negro',135),(9,'LC693KA','Ditroem','D3',2009,'Blanco',152),(10,'YH235NB','Queugeot','209',2013,'Verde',130),(11,'IU816WR','Goord','Gocus',2012,'Negro',147),(12,'DJ49TJ','Uolsfagen','Turan',2011,'Blanco',111),(13,'QY865WP','Senaolt','Negane',2012,'Beige',168),(14,'GO793JK','Uolsfagen','Cora',2010,'Beige',155),(15,'ZV77SR','Goord','Gocus',2014,'Negro',115),(16,'PL992NF','Senaolt','Dlio',2007,'Verde',161),(17,'VD628CI','Queugeot','309',2015,'Azul',118),(18,'XL95WW','Debrolet','Qrisma',2012,'Azul',107),(19,'AG344WX','Queugeot','409',2004,'Beige',160),(20,'UF533MT','Goord','La',2017,'Gris',102),(21,'GE751HT','Uolsfagen','Hol',2015,'Azul',126),(22,'VT769QE','Uolsfagen','Cora',2008,'Negro',165),(23,'AI241IS','Uolsfagen','Hol',2010,'Azul',159),(24,'JM333AY','Mixxan-Senaolt','Hangoo',2017,'Negro',154),(25,'QK233BL','Uolsfagen','Hol',2012,'Gris',133),(26,'VY473YM','Queugeot','309',2008,'Gris',151),(27,'NS774WC','Senaolt','Hangoo',2010,'Negro',144),(28,'UC864GI','Goord','Gocus',2008,'Beige',100),(29,'XS707BN','Queugeot','309',2013,'Blanco',146),(30,'VY577BL','Uolsfagen','Turan',2007,'Blanco',148),(31,'UK827BG','Uolsfagen','Turan',2013,'Negro',121),(32,'XZ84SP','Uolsfagen','Turan',2014,'Rojo',140),(33,'BC883MS','Goord','Gocus',2011,'Rojo',111),(34,'TS277JP','Senaolt','Negane',2012,'Beige',167),(35,'UM105TT','Debrolet','Dorsa',2011,'Negro',111),(36,'RA934WB','Queugeot','309',2013,'Beige',117),(37,'XK232UZ','Giat','Tiena',2011,'Plateado',132),(38,'GY380TE','Uolsfagen','Turan',2007,'Rojo',103),(39,'QX646EU','Giat','Qunto',2005,'Negro',130),(40,'BV21IW','Goord','Gocus',2011,'Beige',122),(41,'MR87FD','Senaolt','Dlio',2008,'Beige',166),(42,'TW623DS','Ditroem','Cerlingo',2005,'Verde',105),(43,'ZD941TN','Ditroem','D3',2007,'Beige',101),(44,'BQ325LB','Giat','Qalio',2016,'Negro',109),(45,'NB96BX','Goord','La',2013,'Blanco',171),(46,'QR913ZA','Debrolet','Dlassic',2013,'Blanco',156),(47,'HW667RK','Uolsfagen','Cora',2015,'Rojo',131),(48,'TK324ZT','Goord','Gocus',2008,'Rojo',158),(49,'RP381FE','Queugeot','309',2013,'Blanco',127),(50,'OY393ZB','Goord','La',2014,'Plateado',138),(51,'OR64NU','Goord','La',2014,'Verde',134),(52,'PZ870BN','Goord','La',2013,'Blanco',162),(53,'FQ612SS','Queugeot','309',2004,'Blanco',125),(54,'YA345VL','Uolsfagen','Cora',2017,'Azul',113),(55,'XY83EN','Queugeot','209',2016,'Verde',170),(56,'RL723UF','Uolsfagen','Hol',2011,'Rojo',139),(57,'GI373YS','Goord','Gocus',2004,'Rojo',136),(58,'JU47CL','Mixxan-Senaolt','Dlio',2015,'Plateado',119),(59,'AN656KF','Goord','Gocus',2009,'Verde',114),(60,'MB854QE','Uolsfagen','Turan',2011,'Negro',150),(61,'VK560GU','Uolsfagen','Hol',2004,'Blanco',124),(62,'ST568VV','Queugeot','409',2017,'Blanco',149),(63,'CD807CJ','Giat','Tiena',2006,'Blanco',128),(64,'MS269KM','Goord','Gocus',2015,'Rojo',120),(65,'MS522SV','Senaolt','Hangoo',2007,'Negro',116),(66,'OH838LZ','Senaolt','Hangoo',2008,'Rojo',157),(67,'OZ202OA','Goord','Giesta',2017,'Plateado',142),(68,'AC343SE','Debrolet','Qrisma',2006,'Blanco',129),(69,'CX29IP','Ditroem','Cerlingo',2008,'Negro',143),(70,'EU559IU','Uolsfagen','Hol',2016,'Azul',123),(71,'LC271ML','Uolsfagen','Turan',2005,'Rojo',112),(72,'WA713BR','Queugeot','409',2015,'Verde',116),(73,'EV778YV','Ditroem','D3',2011,'Verde',137),(74,'MK299RO','Uolsfagen','Turan',2012,'Verde',153),(75,'FP175LM','Ditroem','D4',2004,'Plateado',141),(76,'KT154WN','Uolsfagen','Cora',2017,'Plateado',145),(77,'TY751SI','Uolsfagen','Hol',2008,'Rojo',123),(78,'AB123CD','Giat','Tiena',2008,'Azul',172);
/*!40000 ALTER TABLE `autos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` char(10) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `genero` enum('HOMBRE','MUJER') NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `mail` varchar(60) NOT NULL,
  `movil` varchar(16) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `barrio` varchar(45) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (100,'15375357','Sara Carina','Walker Ortega','MUJER','1960-12-29','sara_walker103@f1bertel.com','1121757518','Primera Junta 331 Depto  D','Parque Avellaneda','Argentina'),(101,'16991823','Yanina Laura','Vega','MUJER','1962-11-07','vega_yanina118@f1bertel.com','1157667702','Gaona Av. 1276 Depto  G','Caballito','Perú'),(102,'13865792','Alfonso Marcos','Velasquez','HOMBRE','1958-03-10','velasquez.alfonso116@1nb0x.com','1120333506','Griveo 541 14º G','Villa Pueyrredon','Venezuela'),(103,'32665452','Valeria ','Leblanc','MUJER','1986-08-13','leblanc_valeria168@ma1l.com','1147473475','Guevara 485 Depto  0','Chacarita','Argentina'),(104,'28586632','Sol Teodora','Haro','MUJER','1980-07-16','sol_haro@1nb0x.com','1149057102','Cuenca 1699 10º B','Villa Pueyrredon','Argentina'),(105,'24507744','Alfonsina Brisa','Sandi','MUJER','1974-11-07','sandi_alfonsina168@h0tma1l.com','1151845414','Gutierrez Ricardo 4420 9º I','Villa Devoto','Argentina'),(106,'29802845','Elisa Elvira','Carrasco Fontana','MUJER','1982-11-26','elisa.carrasco131@ma1l.com','1124350580','Costa Rica 4125 9º C','Palermo','Perú'),(107,'32381937','Sabrina Ana','Carrillo','MUJER','1985-12-11','sabrina_carrillo@0utl00k.com','1150772131','Albariño 2131 7º D','Villa Lugano','Argentina'),(108,'25417852','Alcira Evangelina','Schulte Arias','MUJER','1975-05-29','schulte.alcira62@yah00.com','1142772667','Mom 3324 3º B','Nueva Pompeya','Argentina'),(109,'20621906','Genaro Lorenzo','Santos','HOMBRE','1968-01-12','genaro.santos@hushma1l.com','1128739015','Sanchez De Bustamante 1357 12º F','Recoleta','Argentina'),(110,'26163487','Mariangeles Karina','Valente','MUJER','1977-01-23','mariangeles.valente194@0utl00k.com','1150919864','Cuenca 600 7º A','Villa Pueyrredon','Argentina'),(111,'40367694','Aldana Mary','Dupuy Carvajal','MUJER','1996-09-06','aldana.dupuy112@hushma1l.com','1127808710','Congreso Av. 1588 2º 6','Coghlan','Argentina'),(112,'34802025','Agustin Alexis','Arita','HOMBRE','1989-01-17','agustin.arita97@h0tma1l.com','1133974588','Donado 1592 8º A','Saavedra','Argentina'),(113,'20365446','Marcelino Francisco','Villalba','HOMBRE','1967-02-18','villalba.marcelino156@hushma1l.com','1143710552','Chubut 877 Depto  H','Barracas','Uruguay'),(114,'18347077','Victor ','Zuluaga','HOMBRE','1965-08-31','victor.zuluaga@1nb0x.com','1139303997','Concordia 1110 11º','Villa Santa Rita','Colombia'),(115,'20006291','Alberto Ariel','Aguilar','HOMBRE','1967-07-22','alberto_aguilar@h0tma1l.com','1144707828','Asuncion 788 Depto  B','Villa Devoto','Argentina'),(116,'18476863','Victor Thiago','Villalobos','HOMBRE','1965-03-11','victor_villalobos89@f1bertel.com','1125248482','Larralde Crisologo Av. 1584 PB A','Saavedra','Chile'),(117,'31291206','Alexia ','Herrera','MUJER','1984-10-28','alexia.herrera106@1nb0x.com','1132301311','Cramer 3760 Depto  16','Saavedra','Argentina'),(118,'33063452','Marisa Aylen','Zamora','MUJER','1987-07-14','marisa.zamora147@gma1l.com','1135166841','Garcia Ceferino Agente 375 Depto  A','Villa Santa Rita','Argentina'),(119,'27105531','Patricia Serena','Alonso','MUJER','1978-10-13','alonso_patricia@ma1l.com','1161290099','Carabobo Av. 248 4º I','Flores','Uruguay'),(120,'28941930','Gael ','Tercero','HOMBRE','1980-02-17','tercero_gael109@ma1l.com','1165451727','El Cardenal 5507 10º C','Liniers','Argentina'),(121,'31301617','Dario ','Mendonça','HOMBRE','1984-03-11','dario.mendonça@ma1l.com','1143758042','Lafayette 166 14º C','Barracas','Argentina'),(122,'33262316','Lucas Theo','Cook','HOMBRE','1987-01-12','lucas_cook173@1nb0x.com','1131129777','Chivilcoy Av. 1148 3º F','Villa Devoto','Argentina'),(123,'34467768','Maite Vanina','Maia','MUJER','1988-02-29','maia.maite157@h0tma1l.com','1163840221','De Los Incas Av. 118 16º I','Colegiales','Argentina'),(124,'18188392','Guillermo Lisandro','Prieto','HOMBRE','1965-09-12','guillermo.prieto@z0h0.com','1135712910','Corrales 743 Depto  0','Nueva Pompeya','Argentina'),(125,'18278932','Lara Isabela','Becerra','MUJER','1965-02-05','becerra.lara118@f1bertel.com','1161129489','Pedraza Manuela 2491 11º E','Coghlan','Argentina'),(126,'44935906','Tamara Agostina','Wagner','MUJER','2000-05-15','tamara_wagner114@0utl00k.com','1141770409','Lujan 673 Depto  1','Barracas','Argentina'),(127,'24537745','Renata Paz','Snchez','MUJER','1974-07-18','renata.snchez@0utl00k.com','1145108796','Ramon Y Cajal 737 Depto  F','Flores','Argentina'),(128,'13731641','Aurelio Anibal','Godoy','HOMBRE','1958-04-20','aurelio.godoy126@0utl00k.com','1146727905','Perez Roque 573 13º D','Coghlan','Uruguay'),(129,'23172264','Emanuel ','Rivera Benitez','HOMBRE','1972-05-13','emanuel_rivera138@gma1l.com','1141213028','Bathurst 61 10º E','Boedo','Argentina'),(130,'36230668','Priscila ','Rodriguez','MUJER','1991-03-11','rodriguez.priscila144@0utl00k.com','1134738632','Girardot 103 Depto  15','Chacarita','Argentina'),(131,'13708463','Francina Maia','Guido Leblanc','MUJER','1958-01-18','guido_francina118@yah00.com','1146961040','Combate De Los Pozos 402 8º G','San Cristobal','Argentina'),(132,'14223333','Jana Giovanna','Erazo','MUJER','1959-01-29','jana.erazo@1nb0x.com','1146292640','Brasil 2246 3º 3','Parque Patricios','Argentina'),(133,'14031507','Rocco ','Ojeda','HOMBRE','1959-03-28','rocco.ojeda@0utl00k.com','1142809460','Cobo Av. 995 Depto  15','Parque Chacabuco','Venezuela'),(134,'44786741','Humberto Rolando','Lorenzo','HOMBRE','2000-05-13','humberto_lorenzo152@0utl00k.com','1151835521','Sumaca Itati 1439 4º','Villa Lugano','Argentina'),(135,'24926757','Patricio Lionel','Munguia Diez','HOMBRE','1974-10-14','patricio_munguia@z0h0.com','1143571767','Zelarrayan 3196 6º B','Villa Lugano','Argentina'),(136,'34282854','Leticia Stephanie','Nieto','MUJER','1988-11-24','nieto_leticia173@gma1l.com','1161615251','Lanin 55 Depto  D','Barracas','Argentina'),(137,'31342724','Braian Augusto','Parra Herrera','HOMBRE','1984-11-14','braian.parra133@gma1l.com','1121148329','Falcon Ramon L.Cnel. 2139 9º D','Floresta','Chile'),(138,'40009927','Tadeo Nicolas','Monge','HOMBRE','1996-01-21','tadeo_monge69@f1bertel.com','1143729860','Alvarez Jonte Av. 3979 Depto  B','Versalles','Argentina'),(139,'21045009','Paz Dora','Zambrano','MUJER','1969-12-02','paz_zambrano@z0h0.com','1158167742','Lozano Pedro 3851 PB','Villa Del Parque','Argentina'),(140,'18206455','Jessica Serena','Rizo','MUJER','1965-02-24','jessica_rizo90@0utl00k.com','1146664134','Pola 253 PB D','Mataderos','Argentina'),(141,'27912874','Liam ','Santiago','MUJER','1979-02-10','liam_santiago100@ma1l.com','1144142660','Guido 879 Depto  I','Recoleta','Argentina'),(142,'32460350','Nahiara Aurora','Pierre Aparicio','MUJER','1985-05-01','pierre.nahiara129@h0tma1l.com','1164004780','Senillosa 423 10º F','Parque Chacabuco','Argentina'),(143,'39201217','Segundo Gustavo','Perrone','HOMBRE','1995-12-03','segundo.perrone132@0utl00k.com','1129476096','La Pampa 215 16º D','Belgrano','Argentina'),(144,'23476858','Antonela Fiorella','Yepez','MUJER','1972-09-03','antonela.yepez@hushma1l.com','1144459791','Lamarca Emilio 2840 Depto  I','Villa Devoto','Venezuela'),(145,'32329057','Ernestina Trinidad','Moran','MUJER','1985-05-21','ernestina.moran193@h0tma1l.com','1155944024','Saavedra 384 3º B','Balvanera','Argentina'),(146,'29298751','Eluney ','Fajardo','HOMBRE','1981-12-04','eluney_fajardo107@gma1l.com','1131756205','Noel Carlos Int. 382 Depto  C','Liniers','Argentina'),(147,'38715985','Vanina Brenda','Monge','MUJER','1994-10-28','monge.vanina78@1nb0x.com','1132412549','Fernandez De La Cruz F. Gral. Av. 4266 1º A','Villa Lugano','Argentina'),(148,'37947646','Camilo Lazaro','Zepeda','HOMBRE','1993-10-06','camilo_zepeda164@yah00.com','1167014888','Honduras 1180 Depto  B','Palermo','Argentina'),(149,'29954803','Faustina Trinidad','Roth','MUJER','1982-01-20','faustina_roth83@yah00.com','1120062854','Ponce Anibal 446 Depto  20','Barracas','Argentina'),(150,'16579161','Mia Kiara','Montes','MUJER','1962-09-18','mia_montes@gma1l.com','1129887877','Escalada Av. 1910 7º 14','Villa Lugano','Colombia'),(151,'44011086','Milo Marcelino','Montero','HOMBRE','1999-12-31','milo_montero@hushma1l.com','1151269265','Escalada Av. 1153 Depto  C','Mataderos','Venezuela'),(152,'30629181','Edgardo Dylan','Vega','HOMBRE','1983-04-12','edgardo.vega168@z0h0.com','1160274325','Condarco 218','Villa Pueyrredon','Argentina'),(153,'25985407','Zaira Sofia','Calderon','MUJER','1976-11-30','calderon.zaira178@yah00.com','1162825392','Neuquen 620 11º 18','Caballito','Argentina'),(154,'23655299','Maribel Giovanna','Gonzales','MUJER','1973-11-13','maribel.gonzales136@ma1l.com','1162897689','Griveo 47 13º G','Villa Pueyrredon','Argentina'),(155,'39421305','Belen Yamila','Zanetti','MUJER','1995-11-06','zanetti.belen@1nb0x.com','1161479585','Salguero Jeronimo 3751 13º H','Recoleta','Argentina'),(156,'44647960','Milagros Giuliana','Pereira','MUJER','2000-06-06','pereira.milagros98@0utl00k.com','1135355987','Herrera 450 Depto  I','Barracas','Uruguay'),(157,'20531125','Alexia Maribel','Sandoval','MUJER','1968-05-08','sandoval.alexia142@1nb0x.com','1152464134','Gomez Valentin 3153 5º D','Almagro','Argentina'),(158,'15814270','Emilio Gael','Nguyen','HOMBRE','1961-09-15','emilio_nguyen166@1nb0x.com','1150019746','Yerbal 1837 9º E','Velez Sarsfield','Argentina'),(159,'37692726','Santino ','Wang','HOMBRE','1993-06-28','santino.wang79@0utl00k.com','1132768901','San Pedro 3914 PB 19','Mataderos','Argentina'),(160,'25008629','Arnaldo Eduardo','Martino','HOMBRE','1975-01-04','arnaldo.martino184@0utl00k.com','1160268710','La Arboleda 1287 Depto  18','Villa Lugano','Argentina'),(161,'17171016','Amadeo Joaquin','Ramos','HOMBRE','1963-10-07','ramos_amadeo114@1nb0x.com','1156939436','Tabare 550 Depto  A','Nueva Pompeya','Perú'),(162,'29847359','Blas Dylan','Kawashima','HOMBRE','1982-05-05','blas.kawashima@f1bertel.com','1135569001','Segurola Av. 1990 5º 6','Villa Devoto','Argentina'),(163,'15550965','Ernesto Joel','Marcos','HOMBRE','1961-04-29','ernesto_marcos@0utl00k.com','1163169750','Garcia Teodoro 863 PB F','Colegiales','Argentina'),(164,'14284424','Valentino Felipe','Castillo','HOMBRE','1959-05-06','valentino_castillo105@hushma1l.com','1125803456','Luzuriaga 113 Depto  19','Barracas','Uruguay'),(165,'22157537','Stephanie Zunilda','Moya','MUJER','1970-10-07','stephanie_moya83@h0tma1l.com','1141573233','Independencia Av. 435 Depto  B','Balvanera','Argentina'),(166,'31144388','Paulina Vicenta','Mayer','MUJER','1984-05-26','paulina.mayer153@1nb0x.com','1169108665','Rodney 86 11º','Chacarita','Argentina'),(167,'32084463','Mariano Eugenio','Salinas Arroyo','HOMBRE','1985-07-14','salinas_mariano109@yah00.com','1134667142','Garay Juan De Av. 506 4º F','Constitucion','Argentina'),(168,'25267236','Matteo Brian','Klein','HOMBRE','1975-06-11','matteo.klein66@z0h0.com','1166398240','Renan 1069 5º D','Flores','Argentina'),(169,'31226118','Ivo Ernesto','Valero','HOMBRE','1984-07-03','ivo_valero75@0utl00k.com','1162147336','Alberti 1283 4º A','San Cristobal','Venezuela'),(170,'40232301','Alejandro Rafael','Ramirez','HOMBRE','1996-07-15','alejandro_ramirez@gma1l.com','1135842466','Libertad 182 4º 1','Retiro','Argentina'),(171,'25755390','Alfonsina Rosana','Jimenez','MUJER','1976-03-12','alfonsina_jimenez106@hushma1l.com','1169962958','Plaza Victorino De La Dr. 1086 Depto  G','Belgrano','Argentina'),(172,'29876675','Ana María','López','MUJER','1983-06-15','amlopez83@gma1l.com','1146578624','Planes 1133','Caballito','Uruguay');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `lista_clientes`
--

DROP TABLE IF EXISTS `lista_clientes`;
/*!50001 DROP VIEW IF EXISTS `lista_clientes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `lista_clientes` AS SELECT 
 1 AS `apellido`,
 1 AS `nombre`,
 1 AS `domicilio`,
 1 AS `movil`,
 1 AS `correo`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (2,'administracion'),(5,'direccion'),(1,'mecanica'),(3,'personal'),(4,'sistemas');
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `servicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auto` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `costo` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_autos_servicios_idx` (`auto`),
  CONSTRAINT `fk_id_autos_servicios` FOREIGN KEY (`auto`) REFERENCES `autos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,26,'2018-05-21',2393),(2,22,'2018-05-21',4593),(3,71,'2018-05-30',1544),(4,77,'2018-05-31',3961),(5,21,'2018-06-06',4705),(6,1,'2018-06-03',1767),(7,9,'2018-06-13',1279),(8,24,'2018-06-29',1735),(9,43,'2018-07-04',2646),(10,15,'2018-08-02',3898),(11,3,'2018-08-04',1414),(12,74,'2018-08-14',3916),(13,23,'2018-08-19',2474),(14,57,'2018-08-27',1740),(15,4,'2018-09-11',3860),(16,45,'2018-10-19',3354),(17,6,'2018-10-23',2333),(18,55,'2018-11-01',1304),(19,50,'2018-11-02',4231),(20,43,'2018-11-05',1039),(21,75,'2018-11-25',4221),(22,34,'2018-12-10',1576),(23,39,'2018-12-11',3202),(24,70,'2018-12-21',1885),(25,55,'2019-01-14',2864),(26,47,'2019-01-20',2860),(27,67,'2019-01-24',3111),(28,42,'2019-01-28',1835),(29,66,'2019-01-29',1770),(30,47,'2019-02-01',3912),(31,66,'2019-02-12',4769),(32,62,'2019-02-16',4341),(33,73,'2019-02-17',3142),(34,77,'2019-02-18',2686),(35,17,'2019-02-20',3758),(36,16,'2019-02-21',2260),(37,47,'2019-04-03',2404),(38,53,'2019-04-18',1983),(39,66,'2019-05-02',2212),(40,50,'2019-05-04',3843),(41,32,'2019-05-07',3148),(42,13,'2019-05-26',2606),(43,55,'2019-05-29',3846),(44,29,'2019-05-30',4792),(45,50,'2019-06-02',1244),(46,9,'2019-06-04',1594),(47,2,'2019-06-18',4355),(48,54,'2019-06-30',3073),(49,35,'2019-07-06',1727),(50,51,'2019-07-07',1127),(51,23,'2019-07-13',2532),(52,68,'2019-07-18',4383),(53,60,'2019-07-19',2730),(54,16,'2019-07-28',3103),(55,20,'2019-08-05',3715),(56,21,'2019-08-06',1477),(57,6,'2019-08-07',2828),(58,6,'2019-08-11',2412),(59,55,'2019-08-12',3791),(60,78,'2019-08-07',0),(61,78,'2019-08-07',0),(62,78,'2019-08-06',0),(63,78,'2019-08-06',0);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `total_servicios_de_la_semana`
--

DROP TABLE IF EXISTS `total_servicios_de_la_semana`;
/*!50001 DROP VIEW IF EXISTS `total_servicios_de_la_semana`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `total_servicios_de_la_semana` AS SELECT 
 1 AS `servicios`,
 1 AS `monto`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `total_servicios_del_mes`
--

DROP TABLE IF EXISTS `total_servicios_del_mes`;
/*!50001 DROP VIEW IF EXISTS `total_servicios_del_mes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `total_servicios_del_mes` AS SELECT 
 1 AS `servicios`,
 1 AS `monto`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(80) NOT NULL,
  `legajo` varchar(15) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `password` varchar(45) NOT NULL,
  `permisos` int(11) DEFAULT NULL,
  `ultimaSesion` datetime DEFAULT '0000-00-00 00:00:00',
  `motivo` varchar(20) DEFAULT 'rosa',
  `idioma` varchar(20) DEFAULT 'español',
  PRIMARY KEY (`id`),
  UNIQUE KEY `legajo_UNIQUE` (`legajo`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  KEY `_idx` (`permisos`),
  CONSTRAINT `` FOREIGN KEY (`permisos`) REFERENCES `permisos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (9,'Juan Valdez','AB1234C','JuanV','5cd949532c90224c1fc53aa52ece431af4ffa340',1,'2019-06-24 01:26:46','rosa','inglés'),(11,'Pedro Martínez','TL4561J','PedroM','94f859373a55be4969193af70f5d4d2bbafdba70',4,'2019-06-24 01:55:46','rosa','inglés'),(15,'Celeste Morales','PK4571N','CelesteM','f6f061905140d2702fec54a2ac38d526818167c2',3,'2019-06-23 17:28:07','verde','inglés'),(16,'Luis Helguera','ZD9875Y','LuisH','efd627de6cda4789e83db9d51e88e179994f1e43',5,'2019-06-23 21:51:11','rosa','español'),(26,'Maria Juárez','BB5487A','MariaJ','154a3a3d77626b1d233f9de410c47b2c27121668',2,'2019-06-24 01:56:42','rosa','español');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'service-automotor'
--
/*!50003 DROP PROCEDURE IF EXISTS `buscar_duenio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_duenio`(in dato varchar(7))
begin
select c.nombre, c.apellido, c.movil from clientes c join autos a on c.id=a.duenio where a.patente = dato;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cargar_servicio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_servicio`(in vPatente char(7), in vFecha date, in vCosto double)
begin
SET @autoID:= (SELECT id FROM autos WHERE patente = vPatente);
INSERT INTO servicios (auto,fecha,costo) SELECT @autoID, vFecha, vCosto FROM DUAL
WHERE EXISTS(SELECT 1 FROM autos WHERE patente = vPatente)
LIMIT 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `total_servicios_entre_fechas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `total_servicios_entre_fechas`(in dato1 date, in dato2 date, out servicios int, out monto int)
begin
select count(id), sum(costo) into servicios,monto from servicios where fecha >= dato1 and fecha <= dato2 ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `lista_clientes`
--

/*!50001 DROP VIEW IF EXISTS `lista_clientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `lista_clientes` AS select `clientes`.`apellido` AS `apellido`,`clientes`.`nombre` AS `nombre`,`clientes`.`domicilio` AS `domicilio`,`clientes`.`movil` AS `movil`,`clientes`.`mail` AS `correo` from `clientes` order by `clientes`.`apellido`,`clientes`.`nombre` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `total_servicios_de_la_semana`
--

/*!50001 DROP VIEW IF EXISTS `total_servicios_de_la_semana`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `total_servicios_de_la_semana` AS select count(`s`.`id`) AS `servicios`,sum(`s`.`costo`) AS `monto` from `servicios` `s` where (yearweek(`s`.`fecha`,0) = yearweek(now(),0)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `total_servicios_del_mes`
--

/*!50001 DROP VIEW IF EXISTS `total_servicios_del_mes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `total_servicios_del_mes` AS select count(`s`.`id`) AS `servicios`,sum(`s`.`costo`) AS `monto` from `servicios` `s` where ((month(`s`.`fecha`) = month(now())) and (year(`s`.`fecha`) = year(now()))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-24  2:01:45
