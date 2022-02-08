CREATE TABLE app_user (
  app_user_id bigint auto_increment,
  name varchar(100) not null,
  mail_address varchar(100) not null,
  password varchar(255) not null,
  primary key (app_user_id)
);

CREATE TABLE role (
    role_id bigint auto_increment,
    role_name varchar(20),
    app_user_id bigint not null,
    primary key (role_id),
    foreign key (app_user_id) references app_user(app_user_id)
);

CREATE TABLE `cards` (
  `card_id` bigint NOT NULL AUTO_INCREMENT,
  `card_number` varchar(100) NOT NULL,
  `app_user_id` bigint NOT NULL,
  `total_limit` bigint NOT NULL,
  `amount_used` bigint NOT NULL,
  `available_amount` bigint NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`app_user_id`) ON DELETE CASCADE
);

insert into app_user(name, mail_address, password)
values('Alice', 'alice@example.com', 'password');
insert into app_user(name, mail_address, password)
values('Bob', 'bob@example.com', 'password');
insert into app_user(name, mail_address, password)
values('Hoge', 'hoge@example.com', 'password');

insert into role(role_name, app_user_id) values('ROLE_USER', 1);
insert into role(role_name, app_user_id) values('ROLE_ADMIN', 1);
insert into role(role_name, app_user_id) values('ROLE_ROOT', 1);
insert into role(role_name, app_user_id) values('ROLE_USER', 2);
insert into role(role_name, app_user_id) values('ROLE_ADMIN', 2);
insert into role(role_name, app_user_id) values('ROLE_USER', 3);

INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(1, 23066, 2430, 18947, '3cd9a3e5-5ca6-4ba8-9c08-d6af28c9c9e1', '2021-03-22');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(1, 24933, 18828, 650, 'bb41a940-1008-4b99-ab07-38d4450fff04', '2021-01-17');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(1, 18604, 299, 6258, '3e551328-6a80-44e5-953a-6bd860ad053b', '2021-02-06');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(1, 16600, 29288, 40316, '511e4566-7369-4a5c-8fde-b64cabc2fae8', '2021-02-13');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(1, 76160, 4681, 9854, '0ec12d11-fe2a-484b-ab85-cf1b20803992', '2021-01-16');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(1, 28953, 27374, 41046, '8bb0af16-9c0e-4134-80a5-d537efbecdf2', '2021-01-14');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(1, 44519, 33594, 25046, '3be83003-9fb3-4fb3-8a3d-3949e58c0cb8', '2021-03-23');

INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(2, 37684, 45719, 43703, '0a3bee4e-1493-4b25-aaf2-953b3ee4668e', '2021-01-15');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(2, 16001, 46887, 25267, '99ac8a17-1c03-42ef-af4d-6d6fd58e1821', '2021-03-12');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(2, 46249, 26157, 23563, '3f234337-77a7-4ff0-8cbd-5c2f575a47d4', '2021-03-04');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(2, 45395, 21179, 17810, '94b2952f-231f-432e-a4f3-e5083abc82c1', '2021-02-11');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(2, 40546, 43746, 17588, 'caf26f88-b73d-4126-837f-084289836931', '2021-01-23');

INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 46356, 31868, 11133, '9663a7d7-dce2-49b5-9a44-7232085b7898', '2021-01-14');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 51857, 33892, 8489, 'e2322cf8-bfd7-4b94-b5de-7a83a12ad565', '2021-01-29');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 35147, 19263, 37366, '0a456876-cb84-42ce-a2a1-a77453027788', '2021-03-08');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 8307, 32170, 27529, '38827ddd-6c99-48c9-b625-5eadc3adfc6e', '2021-01-27');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 87955, 14692, 32455, '202e1cb8-c70f-413c-9189-2f127440cf9d', '2021-01-28');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 88061, 16165, 6946, '577d4fce-ab8b-41d8-ab36-c3c919c36903', '2021-02-25');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 77110, 12757, 20236, '4c10aa3e-58a5-4dff-9c2c-c1d6a3818517', '2021-01-18');
INSERT INTO cards (app_user_id, total_limit, amount_used, available_amount, card_number, create_dt)
VALUES(3, 4700, 38718, 15730, '3be3145e-6086-4193-876b-6133abe5f261', '2021-01-21');

