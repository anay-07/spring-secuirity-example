use fincity;

create table if not exists car (
  id bigint not null auto_increment,
  car_name varchar(200) not null,
  manufacture_name varchar(200) not null,
  model varchar(200) null,
  manufacturing_year bigint null,
  color varchar(50),
  primary key (id)
);

/*CREATE TABLE  if not exists `fincity`.`user` (
  `id` INT NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `active` VARCHAR(45) NULL,
  `roles` VARCHAR(45) NULL);*/


CREATE TABLE if not exists `fincity`.`user` (
  `id` INT NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `active` TINYINT NULL,
  `roles` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


