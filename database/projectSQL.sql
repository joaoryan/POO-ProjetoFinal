CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`model.Habilidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Skill` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `level` INT(3) NULL,
  `type` VARCHAR(16) NULL,
  PRIMARY KEY (`id`));
  

-- -----------------------------------------------------
-- Table `mydb`.`Personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`characterTable` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `level` VARCHAR(3) NULL,
  `classCharacter` VARCHAR(45) NULL,
  `race` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
 );

-- -----------------------------------------------------
-- Table `mydb`.`model.Montaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Mount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `level` INT(3) NULL,
  `characterTable_id` INT NOT NULL,
  PRIMARY KEY (`id`),
CONSTRAINT `fk_Character_Mount`
    FOREIGN KEY (`characterTable_id`)
    REFERENCES `mydb`.`characterTable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `mydb`.`Armas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Weapon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `type` VARCHAR(16) NULL,
  `damage` INT(6) NULL,
  `Character_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Weapon_Character`
    FOREIGN KEY (`Character_id`)
    REFERENCES `mydb`.`characterTable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Habilidade_has_Personagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Skill_has_Character` (
  `Skill_id` INT(11) NOT NULL,
  `Character_id` INT(11) NOT NULL,
  PRIMARY KEY (`Skill_id`, `Character_id`),
  CONSTRAINT `fk_Skill_has_Character_Skill1`
    FOREIGN KEY (`Skill_id`)
    REFERENCES `mydb`.`Skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Skill_has_Character_Character1`
    FOREIGN KEY (`Character_id`)
    REFERENCES `mydb`.`characterTable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
