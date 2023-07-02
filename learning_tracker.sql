# Host: localhost  (Version: 5.5.5-10.4.28-MariaDB)
# Date: 2023-07-02 19:04:51
# Generator: MySQL-Front 5.3  (Build 1.18)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "tipo_task"
#

DROP TABLE IF EXISTS `tipo_task`;
CREATE TABLE `tipo_task` (
  `nombre_tipoTask` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre_tipoTask`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "tipo_task"
#

INSERT INTO `tipo_task` VALUES ('Ayudantia'),('Prueba'),('Taller'),('Tarea');

#
# Source for table "tipo_usuario"
#

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE `tipo_usuario` (
  `nombre_tipoUsuario` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre_tipoUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "tipo_usuario"
#

INSERT INTO `tipo_usuario` VALUES ('Academico'),('Estudiante');

#
# Source for table "estudiante"
#

DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE `estudiante` (
  `numero_matricula` int(11) NOT NULL,
  `nombre_estudiante` varchar(90) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `rut` varchar(9) NOT NULL,
  `correo_institucional` varchar(90) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `carrera` varchar(90) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `tipo_usuario` varchar(50) NOT NULL,
  PRIMARY KEY (`numero_matricula`),
  KEY `fk_tipoUsuario1_idx` (`tipo_usuario`),
  CONSTRAINT `fk_tipoUsuario1` FOREIGN KEY (`tipo_usuario`) REFERENCES `tipo_usuario` (`nombre_tipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "estudiante"
#

INSERT INTO `estudiante` VALUES (20,'Eliezer','P','M','20','e@a.cl','Masculino','Ing_Civil','eliezerPM','zhi','Estudiante');

#
# Source for table "academico"
#

DROP TABLE IF EXISTS `academico`;
CREATE TABLE `academico` (
  `rut` varchar(9) NOT NULL,
  `nombre_academico` varchar(90) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `correo_institucional` varchar(90) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `depto` varchar(90) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `tipo_usuario` varchar(50) NOT NULL,
  PRIMARY KEY (`rut`),
  KEY `fk_nombreUsuario1_idx` (`nombre_usuario`),
  KEY `fk_tipoUsuario0_idx` (`tipo_usuario`),
  CONSTRAINT `fk_tipoUsuario0` FOREIGN KEY (`tipo_usuario`) REFERENCES `tipo_usuario` (`nombre_tipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "academico"
#


#
# Source for table "asignatura"
#

DROP TABLE IF EXISTS `asignatura`;
CREATE TABLE `asignatura` (
  `cod_asignatura` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_asignatura` varchar(45) NOT NULL,
  `modulo` int(2) NOT NULL,
  `semestre` int(2) NOT NULL,
  `rut_academico` varchar(9) NOT NULL,
  PRIMARY KEY (`cod_asignatura`),
  KEY `fk_rutAcademico_idx` (`rut_academico`),
  CONSTRAINT `fk_rutAcademico` FOREIGN KEY (`rut_academico`) REFERENCES `academico` (`rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "asignatura"
#


#
# Source for table "task"
#

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `cod_task` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_task` varchar(45) NOT NULL,
  `cod_asignatura` int(11) NOT NULL,
  `tipo_task` varchar(45) NOT NULL,
  `fecha_task` date NOT NULL,
  PRIMARY KEY (`cod_task`),
  KEY `fk_tipoTask_idx` (`tipo_task`),
  KEY `fk_codAsignatura_idx` (`cod_asignatura`),
  CONSTRAINT `fk_codAsignatura1` FOREIGN KEY (`cod_asignatura`) REFERENCES `asignatura` (`cod_asignatura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipoTask1` FOREIGN KEY (`tipo_task`) REFERENCES `tipo_task` (`nombre_tipoTask`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "task"
#


#
# Source for table "inscripcion"
#

DROP TABLE IF EXISTS `inscripcion`;
CREATE TABLE `inscripcion` (
  `cod_inscripcion` int(11) NOT NULL,
  `matricula_estudiante` int(11) NOT NULL,
  `cod_asignatura` int(11) NOT NULL,
  `semestre` int(2) NOT NULL,
  `rut_academico` varchar(9) NOT NULL,
  PRIMARY KEY (`cod_inscripcion`),
  KEY `fk_matriculaEstudiante2_idx` (`matricula_estudiante`),
  KEY `fk_codAsignatura3_idx` (`cod_asignatura`),
  KEY `fk_rutAcademico1_idx` (`rut_academico`),
  CONSTRAINT `fk_codAsignatura3` FOREIGN KEY (`cod_asignatura`) REFERENCES `asignatura` (`cod_asignatura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matriculaEstudiante2` FOREIGN KEY (`matricula_estudiante`) REFERENCES `estudiante` (`numero_matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rutAcademico1` FOREIGN KEY (`rut_academico`) REFERENCES `academico` (`rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "inscripcion"
#


#
# Source for table "calificacion"
#

DROP TABLE IF EXISTS `calificacion`;
CREATE TABLE `calificacion` (
  `cod_calificacion` int(11) NOT NULL,
  `matricula_estudiante` int(11) NOT NULL,
  `cod_asignatura` int(11) NOT NULL,
  `tipo_evaluacion` varchar(45) NOT NULL,
  `nota` double NOT NULL,
  `rut_academico` varchar(9) NOT NULL,
  PRIMARY KEY (`cod_calificacion`),
  KEY `fk_matriculaEstudiante2_idx` (`matricula_estudiante`),
  KEY `fk_codAsignatura4_idx` (`cod_asignatura`),
  KEY `fk_rutAcademico3_idx` (`rut_academico`),
  CONSTRAINT `fk_codAsignatura4` FOREIGN KEY (`cod_asignatura`) REFERENCES `asignatura` (`cod_asignatura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matriculaEstudiante3` FOREIGN KEY (`matricula_estudiante`) REFERENCES `estudiante` (`numero_matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rutAcademico3` FOREIGN KEY (`rut_academico`) REFERENCES `academico` (`rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "calificacion"
#


#
# Source for table "asistencia"
#

DROP TABLE IF EXISTS `asistencia`;
CREATE TABLE `asistencia` (
  `cod_asistencia` int(11) NOT NULL AUTO_INCREMENT,
  `numeroMatricula_estudiante` int(11) NOT NULL,
  `cod_asignatura` int(11) NOT NULL,
  `fecha_clase` date NOT NULL,
  PRIMARY KEY (`cod_asistencia`),
  KEY `fk_codAsignatura2_idx` (`cod_asignatura`),
  KEY `fk_matriculaEstudiante_idx` (`numeroMatricula_estudiante`),
  CONSTRAINT `fk_codAsignatura2` FOREIGN KEY (`cod_asignatura`) REFERENCES `asignatura` (`cod_asignatura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matriculaEstudiante` FOREIGN KEY (`numeroMatricula_estudiante`) REFERENCES `estudiante` (`numero_matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "asistencia"
#


#
# Source for table "apunte"
#

DROP TABLE IF EXISTS `apunte`;
CREATE TABLE `apunte` (
  `cod_apunte` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_apunte` varchar(45) NOT NULL,
  `cod_asignatura` int(11) NOT NULL,
  `fecha_apunte` date NOT NULL,
  `texto_apunte` text NOT NULL,
  PRIMARY KEY (`cod_apunte`),
  KEY `fk_codAsignatura_idx` (`cod_asignatura`),
  CONSTRAINT `fk_codAsignatura` FOREIGN KEY (`cod_asignatura`) REFERENCES `asignatura` (`cod_asignatura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

#
# Data for table "apunte"
#


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
