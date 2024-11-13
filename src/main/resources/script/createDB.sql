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
  `release_date` date DEFAULT NULL,
  `genre` varchar(100) NOT NULL,
  `director` varchar(100) NOT NULL,
  `actor` varchar(500) NOT NULL,
  `description` longtext NOT NULL,
  `image` longblob,
  `rating` decimal(1,1) DEFAULT NULL,
  `is_show` varchar(1) DEFAULT '1',
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `m_director` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `country` varchar(10) NOT NULL,
  `birth` date DEFAULT NULL,
  `description` longtext NOT NULL,
  `image` longblob,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `m_actor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `country` varchar(10) NOT NULL,
  `birth` date DEFAULT NULL,
  `description` longtext NOT NULL,
  `image` longblob,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_movie_img` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int NOT NULL,
  `img_name` varchar(100) NOT NULL,
  `img_byte` longblob NOT NULL,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_movie_review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int NOT NULL,
  `user_id` int NOT NULL,
  `review` longtext,
  `rating` decimal(1,1) DEFAULT NULL,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_movie_review_report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_review_id` int NOT NULL,
  `user_review_id` int NOT NULL,
  `user_report_id` int NOT NULL,
  `valid_flag` bit(1) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;