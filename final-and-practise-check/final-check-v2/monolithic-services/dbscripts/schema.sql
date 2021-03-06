-- MySQL Script generated by MySQL Workbench
-- 05/29/19 23:19:59
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema movie_cruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema movie_cruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movie_cruiser` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `movie_cruiser` ;

-- -----------------------------------------------------
-- Table `movie_cruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  `us_first_name` VARCHAR(60) NULL,
  `us_last_name` VARCHAR(60) NULL,
  `us_password` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_cruiser`.`movie_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`movie_list` (
  `mo_id` INT NOT NULL AUTO_INCREMENT,
  `mo_title` VARCHAR(100) NULL,
  `mo_box_office` BIGINT NULL,
  `mo_active` VARCHAR(3) NULL,
  `mo_date_of_launch` DATE NULL,
  `mo_genre` VARCHAR(45) NULL,
  `mo_has_teaser` VARCHAR(3) NULL,
  `mo_image`VARCHAR(10000)NULL,
  `mo_description`TEXT NULL,
  `mo_rating`VARCHAR(60)NULL,
  `mo_language`VARCHAR(60)NULL,
  `mo_runtime`VARCHAR(60)NULL,
  `mo_like`VARCHAR(60)NULL,
  `mo_trailer`VARCHAR(60)NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_cruiser`.`favoritefavoritemovie_listuser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`favorite` (
  `fa_id` INT NOT NULL AUTO_INCREMENT,
  `fa_us_id` INT NULL,
  `fa_mo_id` INT NULL,
  PRIMARY KEY (`fa_id`),
  INDEX `fa_us_fk_idx` (`fa_us_id` ASC),
  INDEX `fa_mo_fk_idx` (`fa_mo_id` ASC),
  CONSTRAINT `fa_us_fk`
    FOREIGN KEY (`fa_us_id`)
    REFERENCES `movie_cruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fa_mo_fk`
    FOREIGN KEY (`fa_mo_id`)
    REFERENCES `movie_cruiser`.`movie_list` (`mo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `movie_cruiser`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `movie_cruiser`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`user_role` (
  `ur_id` INT NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT NULL,
  `ur_ro_id` INT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `ur_us_fk_idx` (`ur_us_id` ASC),
  INDEX `ur_ro_fk_idx` (`ur_ro_id` ASC),
  CONSTRAINT `ur_us_fk`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `movie_cruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ur_ro_fk`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `movie_cruiser`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `movie_cruiser`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`genre` (
  `ge_id` INT NOT NULL AUTO_INCREMENT,
  `ge_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ge_id`))
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
