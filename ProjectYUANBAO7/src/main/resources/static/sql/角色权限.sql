CREATE TABLE `sys_role`  (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8;

CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8;

CREATE TABLE `sys_user_role`  (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `fk_role_id`(`role_id`)
) ENGINE = InnoDB CHARACTER SET = utf8;

ALTER TABLE `sys_user_role` ADD CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `sys_user_role` ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

insert into SYS_USER (id,name, password) values (1,'admin', 'admin');
insert into SYS_USER (id,name, password) values (2,'yuan', 'yuan');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into sys_user_role(user_id,role_id) values(1,1);
insert into sys_user_role(user_id,role_id) values(2,2);