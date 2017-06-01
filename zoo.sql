CREATE DATABASE  IF NOT EXISTS `zoo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zoo`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zoo
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `agenda_consulta`
--

DROP TABLE IF EXISTS `agenda_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda_consulta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_agendamento` date NOT NULL,
  `horario_agendamento` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `veterinario_id` int(11) NOT NULL,
  `animal_codigo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_agenda_consulta_veterinario1_idx` (`veterinario_id`),
  KEY `fk_agenda_consulta_animal1_idx` (`animal_codigo`),
  CONSTRAINT `fk_agenda_consulta_animal1` FOREIGN KEY (`animal_codigo`) REFERENCES `animal` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agenda_consulta_veterinario1` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda_consulta`
--

LOCK TABLES `agenda_consulta` WRITE;
/*!40000 ALTER TABLE `agenda_consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `regiao_origem` varchar(255) NOT NULL,
  `data_nascimento` date NOT NULL,
  `peso` double NOT NULL,
  `especie` varchar(255) NOT NULL,
  `rotina_codigo` int(11) NOT NULL,
  `boletim_saude_id` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `id_UNIQUE` (`codigo`),
  KEY `fk_animal_rotina1_idx` (`rotina_codigo`),
  KEY `fk_animal_boletim_saude1_idx` (`boletim_saude_id`),
  CONSTRAINT `fk_animal_boletim_saude1` FOREIGN KEY (`boletim_saude_id`) REFERENCES `boletim_saude` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_rotina1` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_tratador`
--

DROP TABLE IF EXISTS `animal_tratador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal_tratador` (
  `animal_codigo` int(11) NOT NULL,
  `tratador_id` int(11) NOT NULL,
  PRIMARY KEY (`animal_codigo`,`tratador_id`),
  KEY `fk_animal_has_tratador_tratador1_idx` (`tratador_id`),
  KEY `fk_animal_has_tratador_animal1_idx` (`animal_codigo`),
  CONSTRAINT `fk_animal_has_tratador_animal1` FOREIGN KEY (`animal_codigo`) REFERENCES `animal` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_has_tratador_tratador1` FOREIGN KEY (`tratador_id`) REFERENCES `tratador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_tratador`
--

LOCK TABLES `animal_tratador` WRITE;
/*!40000 ALTER TABLE `animal_tratador` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal_tratador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletim`
--

DROP TABLE IF EXISTS `boletim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletim` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `estado_animal` varchar(45) NOT NULL,
  `animal_codigo` int(11) NOT NULL,
  `tratador_id` int(11) NOT NULL,
  `observacoes` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_boletim_animal1_idx` (`animal_codigo`),
  KEY `fk_boletim_tratador1_idx` (`tratador_id`),
  CONSTRAINT `fk_boletim_animal1` FOREIGN KEY (`animal_codigo`) REFERENCES `animal` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_boletim_tratador1` FOREIGN KEY (`tratador_id`) REFERENCES `tratador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletim`
--

LOCK TABLES `boletim` WRITE;
/*!40000 ALTER TABLE `boletim` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletim_saude`
--

DROP TABLE IF EXISTS `boletim_saude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletim_saude` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletim_saude`
--

LOCK TABLES `boletim_saude` WRITE;
/*!40000 ALTER TABLE `boletim_saude` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletim_saude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_atendimento` date DEFAULT NULL,
  `hora_atendimento` varchar(10) DEFAULT NULL,
  `agenda_consulta_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_consulta_agenda_consulta1_idx` (`agenda_consulta_id`),
  CONSTRAINT `fk_consulta_agenda_consulta1` FOREIGN KEY (`agenda_consulta_id`) REFERENCES `agenda_consulta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` int(11) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'carlos luiz reiter','marumbi',107,'jf','mg');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita`
--

DROP TABLE IF EXISTS `receita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receita` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_envio` date NOT NULL,
  `observacoes` longtext NOT NULL,
  `dose` varchar(45) NOT NULL,
  `frequencia_de_aplicacao` varchar(45) NOT NULL,
  `veterinario_id` int(11) NOT NULL,
  `rotina_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_receita_veterinario1_idx` (`veterinario_id`),
  KEY `fk_receita_rotina1_idx` (`rotina_codigo`),
  CONSTRAINT `fk_receita_rotina1` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_veterinario1` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita`
--

LOCK TABLES `receita` WRITE;
/*!40000 ALTER TABLE `receita` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita_medicamento`
--

DROP TABLE IF EXISTS `receita_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receita_medicamento` (
  `receita_id` int(11) NOT NULL,
  `medicamento_id` int(11) NOT NULL,
  PRIMARY KEY (`receita_id`,`medicamento_id`),
  KEY `fk_receita_has_medicamento_medicamento1_idx` (`medicamento_id`),
  KEY `fk_receita_has_medicamento_receita_idx` (`receita_id`),
  CONSTRAINT `fk_receita_has_medicamento_medicamento1` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_has_medicamento_receita` FOREIGN KEY (`receita_id`) REFERENCES `receita` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita_medicamento`
--

LOCK TABLES `receita_medicamento` WRITE;
/*!40000 ALTER TABLE `receita_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_clinico`
--

DROP TABLE IF EXISTS `registro_clinico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_clinico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diagnostico` longtext NOT NULL,
  `tipo_atendimento` varchar(45) NOT NULL,
  `observacao_geral` longtext NOT NULL,
  `boletim_saude_id` int(11) NOT NULL,
  `veterinario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_registro_clinico_boletim_saude1_idx` (`boletim_saude_id`),
  KEY `fk_registro_clinico_veterinario1_idx` (`veterinario_id`),
  CONSTRAINT `fk_registro_clinico_boletim_saude1` FOREIGN KEY (`boletim_saude_id`) REFERENCES `boletim_saude` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registro_clinico_veterinario1` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_clinico`
--

LOCK TABLES `registro_clinico` WRITE;
/*!40000 ALTER TABLE `registro_clinico` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_clinico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotina`
--

DROP TABLE IF EXISTS `rotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotina` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `data_validade` date NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotina`
--

LOCK TABLES `rotina` WRITE;
/*!40000 ALTER TABLE `rotina` DISABLE KEYS */;
/*!40000 ALTER TABLE `rotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarefas`
--

DROP TABLE IF EXISTS `tarefas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` longtext NOT NULL,
  `rotina_codigo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tarefas_rotina1_idx` (`rotina_codigo`),
  CONSTRAINT `fk_tarefas_rotina1` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefas`
--

LOCK TABLES `tarefas` WRITE;
/*!40000 ALTER TABLE `tarefas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarefas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratador`
--

DROP TABLE IF EXISTS `tratador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_tratador_endereco1_idx` (`endereco_id`),
  CONSTRAINT `fk_tratador_endereco1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratador`
--

LOCK TABLES `tratador` WRITE;
/*!40000 ALTER TABLE `tratador` DISABLE KEYS */;
INSERT INTO `tratador` VALUES (1,'30274','tiago','3226-6416',1,'123');
/*!40000 ALTER TABLE `tratador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratador_has_rotina`
--

DROP TABLE IF EXISTS `tratador_has_rotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratador_has_rotina` (
  `tratador_id` int(11) NOT NULL,
  `rotina_codigo` int(11) NOT NULL,
  PRIMARY KEY (`tratador_id`,`rotina_codigo`),
  KEY `fk_tratador_has_rotina_rotina1_idx` (`rotina_codigo`),
  KEY `fk_tratador_has_rotina_tratador1_idx` (`tratador_id`),
  CONSTRAINT `fk_tratador_has_rotina_rotina1` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tratador_has_rotina_tratador1` FOREIGN KEY (`tratador_id`) REFERENCES `tratador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratador_has_rotina`
--

LOCK TABLES `tratador_has_rotina` WRITE;
/*!40000 ALTER TABLE `tratador_has_rotina` DISABLE KEYS */;
/*!40000 ALTER TABLE `tratador_has_rotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `registro_clinico_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_vacina_registro_clinico1_idx` (`registro_clinico_id`),
  CONSTRAINT `fk_vacina_registro_clinico1` FOREIGN KEY (`registro_clinico_id`) REFERENCES `registro_clinico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinario`
--

DROP TABLE IF EXISTS `veterinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veterinario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `CRMV` varchar(45) NOT NULL,
  `data_registro` date NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `CRMV_UNIQUE` (`CRMV`),
  KEY `fk_veterinario_endereco1_idx` (`endereco_id`),
  CONSTRAINT `fk_veterinario_endereco1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veterinario`
--

LOCK TABLES `veterinario` WRITE;
/*!40000 ALTER TABLE `veterinario` DISABLE KEYS */;
/*!40000 ALTER TABLE `veterinario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-01 17:55:13
