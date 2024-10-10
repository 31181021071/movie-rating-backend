CREATE DATABASE projectmovie
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

use projectmovie;

CREATE TABLE `m_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(500) NOT NULL,
  `role` varchar(100) NOT NULL,
  `is_enable` bit(1) NOT NULL,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `m_codes` (
  `code_type` varchar(10) NOT NULL,
  `code_type_name` varchar(150) NOT NULL,
  `code` varchar(10) NOT NULL,
  `code_name` varchar(45) NOT NULL,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(200) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`code_type`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `m_movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(100) NOT NULL,
  `country` varchar(10) NOT NULL,
  `release_year` int DEFAULT NULL,
  `genre` varchar(100) NOT NULL,
  `description` longtext NOT NULL,
  `image` longblob,
  `rating` decimal(1,1) DEFAULT NULL,
  `is_show` bit(1) DEFAULT b'1',
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;