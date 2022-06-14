-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema typdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `typdb` ;

-- -----------------------------------------------------
-- Schema typdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `typdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `typdb` ;

-- -----------------------------------------------------
-- Table `typdb`.`area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `typdb`.`area` ;

CREATE TABLE IF NOT EXISTS `typdb`.`area` (
  `area_id` INT NOT NULL AUTO_INCREMENT,
  `area_name` INT NOT NULL,
  `area_address` VARCHAR(255) NOT NULL,
  `are_selectednum` TINYINT NOT NULL,
  PRIMARY KEY (`area_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `typdb`.`keyword`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `typdb`.`keyword` ;

CREATE TABLE IF NOT EXISTS `typdb`.`keyword` (
  `kw_id` BIGINT NOT NULL,
  `kw_withnum` INT NOT NULL,
  `kw_house` INT NOT NULL,
  `kw_foodprice` INT NOT NULL,
  `kw_nature` INT NOT NULL,
  `kw_history` INT NOT NULL,
  `kw_resting` INT NOT NULL,
  `kw_performance` INT NOT NULL,
  `kw_culture` INT NOT NULL,
  `kw_leports` INT NOT NULL,
  `kw_shopping` INT NOT NULL,
  `kw_food` INT NOT NULL,
  `place_place_id` INT NOT NULL,
  PRIMARY KEY (`kw_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `typdb`.`place`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `typdb`.`place` ;

CREATE TABLE IF NOT EXISTS `typdb`.`place` (
  `place_id` INT NOT NULL AUTO_INCREMENT,
  `place_name` VARCHAR(255) NULL DEFAULT NULL,
  `place_description` VARCHAR(255) NULL DEFAULT NULL,
  `place_address` VARCHAR(255) NULL DEFAULT NULL,
  `place_image` VARCHAR(255) NULL DEFAULT NULL,
  `area_area_id` INT NOT NULL,
  `keyword_kw_id` BIGINT NOT NULL,
  PRIMARY KEY (`place_id`),
  INDEX `fk_place_area1_idx` (`area_area_id` ASC) VISIBLE,
  INDEX `fk_place_keyword1_idx` (`keyword_kw_id` ASC) VISIBLE,
  CONSTRAINT `fk_place_area1`
    FOREIGN KEY (`area_area_id`)
    REFERENCES `mydb`.`area` (`area_id`),
  CONSTRAINT `fk_place_keyword1`
    FOREIGN KEY (`keyword_kw_id`)
    REFERENCES `typdb`.`keyword` (`kw_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `typdb`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `typdb`.`team` ;

CREATE TABLE IF NOT EXISTS `typdb`.`team` (
  `team_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`team_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `typdb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `typdb`.`user` ;

CREATE TABLE IF NOT EXISTS `typdb`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(255) NOT NULL,
  `user_pwd` VARCHAR(255) NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `user_birthdate` DATE NOT NULL,
  `user_phonenum` VARCHAR(50) NOT NULL,
  `user_gender` INT NOT NULL,
  `user_status` TINYINT NOT NULL,
  `user_image` VARCHAR(255) NULL DEFAULT NULL,
  `keyword_kw_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_keyword1_idx` (`keyword_kw_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_keyword1`
    FOREIGN KEY (`keyword_kw_id`)
    REFERENCES `typdb`.`keyword` (`kw_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `typdb`.`team_join`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `typdb`.`team_join` ;

CREATE TABLE IF NOT EXISTS `typdb`.`team_join` (
  `team_join_id` INT NOT NULL AUTO_INCREMENT,
  `team_team_id` INT NOT NULL,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`team_join_id`),
  INDEX `fk_team_join_team_idx` (`team_team_id` ASC) VISIBLE,
  INDEX `fk_team_join_user1_idx` (`user_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_team_join_team`
    FOREIGN KEY (`team_team_id`)
    REFERENCES `typdb`.`team` (`team_id`),
  CONSTRAINT `fk_team_join_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `typdb`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
