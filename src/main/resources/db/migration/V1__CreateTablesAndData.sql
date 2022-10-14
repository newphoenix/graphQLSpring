CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('John', 'Smith', '34');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Amanda', 'Will', '22');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Rick', 'Miller', '42');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Suzan', 'Marin', '36');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Julie', 'Luke', '19');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Maria', 'Click', '29');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Jake', 'Baker', '67');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Oliver', 'Aston', '45');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Mark', 'Bruce', '38');
INSERT INTO `user` (`name`, `surname`, `age`) VALUES ('Ruth', 'Hunt', '25');

CREATE TABLE `order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `total_price` DECIMAL(10,2) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    
INSERT INTO `order` (`quantity`, `total_price`, `user_id`) VALUES ('2', '210.00', '1');
INSERT INTO `order` (`quantity`, `total_price`, `user_id`) VALUES ('1', '1098.99', '1');
INSERT INTO `order` (`quantity`, `total_price`, `user_id`) VALUES ('1', '999.99', '2');
INSERT INTO `order` (`quantity`, `total_price`, `user_id`) VALUES ('3', '16.50', '2');
INSERT INTO `order` (`quantity`, `total_price`, `user_id`) VALUES ('1', '29.49', '2');
INSERT INTO `order` (`quantity`, `total_price`, `user_id`) VALUES ('1', '179.95', '3');
    