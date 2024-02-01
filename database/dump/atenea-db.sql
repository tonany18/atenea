-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema atenea-db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `atenea-db` ;

-- -----------------------------------------------------
-- Schema atenea-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `atenea-db` DEFAULT CHARACTER SET utf8 ;
USE `atenea-db` ;

-- -----------------------------------------------------
-- Table `atenea-db`.`tipo_activo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atenea-db`.`tipo_activo` ;

CREATE TABLE IF NOT EXISTS `atenea-db`.`tipo_activo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atenea-db`.`estado_activo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atenea-db`.`estado_activo` ;

CREATE TABLE IF NOT EXISTS `atenea-db`.`estado_activo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atenea-db`.`ciudad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atenea-db`.`ciudad` ;

CREATE TABLE IF NOT EXISTS `atenea-db`.`ciudad` (
  `id` INT NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atenea-db`.`area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atenea-db`.`area` ;

CREATE TABLE IF NOT EXISTS `atenea-db`.`area` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sigla` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `ciudad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_area_ciudad_idx` (`ciudad_id` ASC) VISIBLE,
  CONSTRAINT `fk_area_ciudad`
    FOREIGN KEY (`ciudad_id`)
    REFERENCES `atenea-db`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atenea-db`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atenea-db`.`persona` ;

CREATE TABLE IF NOT EXISTS `atenea-db`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_documento` VARCHAR(2) NOT NULL,
  `num_documento` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(1000) NOT NULL,
  `apellido` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atenea-db`.`activo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atenea-db`.`activo` ;

CREATE TABLE IF NOT EXISTS `atenea-db`.`activo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(1000) NULL,
  `serial` VARCHAR(255) NOT NULL,
  `num_interno` INT NOT NULL,
  `peso` FLOAT NULL,
  `alto` FLOAT NULL,
  `ancho` FLOAT NULL,
  `largo` FLOAT NULL,
  `valor_compra` DECIMAL NOT NULL,
  `fecha_compra` DATE NOT NULL,
  `fecha_baja` DATE NULL,
  `color` VARCHAR(255) NULL,
  `estado_activo_id` INT NOT NULL,
  `tipo_activo_id` INT NOT NULL,
  `asigna_area` BIT NOT NULL,
  `persona_id` INT NULL,
  `area_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_activo_persona1_idx` (`persona_id` ASC) VISIBLE,
  INDEX `fk_activo_area1_idx` (`area_id` ASC) VISIBLE,
  INDEX `fk_activo_estado_activo1_idx` (`estado_activo_id` ASC) VISIBLE,
  INDEX `fk_activo_tipo_activo1_idx` (`tipo_activo_id` ASC) VISIBLE,
  CONSTRAINT `fk_activo_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `atenea-db`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_activo_area1`
    FOREIGN KEY (`area_id`)
    REFERENCES `atenea-db`.`area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_activo_estado_activo1`
    FOREIGN KEY (`estado_activo_id`)
    REFERENCES `atenea-db`.`estado_activo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_activo_tipo_activo1`
    FOREIGN KEY (`tipo_activo_id`)
    REFERENCES `atenea-db`.`tipo_activo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `atenea-db`.`tipo_activo`
-- -----------------------------------------------------
START TRANSACTION;
USE `atenea-db`;
INSERT INTO `atenea-db`.`tipo_activo` (`id`, `nombre`) VALUES (1, 'Bienes inmuebles');
INSERT INTO `atenea-db`.`tipo_activo` (`id`, `nombre`) VALUES (2, 'Maquinaria');
INSERT INTO `atenea-db`.`tipo_activo` (`id`, `nombre`) VALUES (3, 'Material de oficina');

COMMIT;


-- -----------------------------------------------------
-- Data for table `atenea-db`.`estado_activo`
-- -----------------------------------------------------
START TRANSACTION;
USE `atenea-db`;
INSERT INTO `atenea-db`.`estado_activo` (`id`, `nombre`) VALUES (1, 'Activo');
INSERT INTO `atenea-db`.`estado_activo` (`id`, `nombre`) VALUES (2, 'Dado de baja');
INSERT INTO `atenea-db`.`estado_activo` (`id`, `nombre`) VALUES (3, 'En reparación');
INSERT INTO `atenea-db`.`estado_activo` (`id`, `nombre`) VALUES (4, 'Disponible');
INSERT INTO `atenea-db`.`estado_activo` (`id`, `nombre`) VALUES (5, 'Asignado');

COMMIT;


-- -----------------------------------------------------
-- Data for table `atenea-db`.`ciudad`
-- -----------------------------------------------------
START TRANSACTION;
USE `atenea-db`;
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (1, '81001', 'ARAUCA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (2, '63001', 'ARMENIA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (3, '8001', 'BARRANQUILLA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (4, '11001', 'BOGOTA. D.C.');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (5, '68001', 'BUCARAMANGA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (6, '76001', 'CALI');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (7, '13001', 'CARTAGENA DE INDIAS');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (8, '18001', 'FLORENCIA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (9, '73001', 'IBAGUE');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (10, '94001', 'INIRIDA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (11, '91001', 'LETICIA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (12, '17001', 'MANIZALES');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (13, '5001', 'MEDELLIN');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (14, '97001', 'MITU');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (15, '86001', 'MOCOA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (16, '23001', 'MONTERIA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (17, '41001', 'NEIVA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (18, '52001', 'PASTO');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (19, '66001', 'PEREIRA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (20, '19001', 'POPAYAN');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (21, '99001', 'PUERTO CARREÃ‘O');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (22, '27001', 'QUIBDO');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (23, '44001', 'RIOHACHA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (24, '88001', 'SAN ANDRES');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (25, '54001', 'SAN JOSE DE CUCUTA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (26, '95001', 'SAN JOSE DEL GUAVIARE');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (27, '47001', 'SANTA MARTA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (28, '70001', 'SINCELEJO');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (29, '15001', 'TUNJA');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (30, '20001', 'VALLEDUPAR');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (31, '50001', 'VILLAVICENCIO');
INSERT INTO `atenea-db`.`ciudad` (`id`, `codigo`, `nombre`) VALUES (32, '85001', 'YOPAL');

COMMIT;


-- -----------------------------------------------------
-- Data for table `atenea-db`.`area`
-- -----------------------------------------------------
START TRANSACTION;
USE `atenea-db`;
INSERT INTO `atenea-db`.`area` (`id`, `sigla`, `nombre`, `ciudad_id`) VALUES (1, 'TI', 'Departamento de TI', 1);
INSERT INTO `atenea-db`.`area` (`id`, `sigla`, `nombre`, `ciudad_id`) VALUES (2, 'CN', 'Contabilidad', 12);
INSERT INTO `atenea-db`.`area` (`id`, `sigla`, `nombre`, `ciudad_id`) VALUES (3, 'TS', 'Tesoreria', 16);
INSERT INTO `atenea-db`.`area` (`id`, `sigla`, `nombre`, `ciudad_id`) VALUES (4, 'IV', 'Inventarios', 14);
INSERT INTO `atenea-db`.`area` (`id`, `sigla`, `nombre`, `ciudad_id`) VALUES (5, 'AF', 'Activos fijos', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `atenea-db`.`persona`
-- -----------------------------------------------------
START TRANSACTION;
USE `atenea-db`;
INSERT INTO `atenea-db`.`persona` (`id`, `tipo_documento`, `num_documento`, `nombre`, `apellido`) VALUES (1, 'CC', '1123123123', 'Juan Carlos', 'Rodriguez');
INSERT INTO `atenea-db`.`persona` (`id`, `tipo_documento`, `num_documento`, `nombre`, `apellido`) VALUES (2, 'CC', '447416123', 'Jose Eduardo', 'Perez');
INSERT INTO `atenea-db`.`persona` (`id`, `tipo_documento`, `num_documento`, `nombre`, `apellido`) VALUES (3, 'CC', '123123', 'Maria de los Angeles', 'Lucumi');
INSERT INTO `atenea-db`.`persona` (`id`, `tipo_documento`, `num_documento`, `nombre`, `apellido`) VALUES (4, 'CC', '123123123', 'Josefina ', 'Martinez');

COMMIT;

