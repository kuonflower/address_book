-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 
-- サーバのバージョン： 5.6.34-log
-- PHP Version: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kadai`
--
CREATE DATABASE IF NOT EXISTS `kadai` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `kadai`;

-- --------------------------------------------------------

--
-- テーブルの構造 `friend`
--

DROP TABLE IF EXISTS `friend`;
CREATE TABLE IF NOT EXISTS `friend` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `AGE` int(20) NOT NULL,
  `ADDRESS` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- テーブルの構造 `userdata`
--

DROP TABLE IF EXISTS `userdata`;
CREATE TABLE IF NOT EXISTS `userdata` (
  `USERID` varchar(20) NOT NULL,
  `PASS` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `AGE` int(20) NOT NULL,
  `ADDRESS` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `userdata`
--

INSERT INTO `userdata` (`USERID`, `PASS`, `NAME`, `AGE`, `ADDRESS`) VALUES
('minato', '1234', '湊', 23, '関東'),
('tanigawa', '5678', '谷川', 32, '西日本'),
('tanigawa', '5678', '谷川', 32, '西日本'),
('asaka', '12345', '朝香', 22, '東日本'),
('sugawara', '12345', 'スガワラ', 33, '東日本'),
('mobu', '1234567890', 'モブA', 100, '東日本'),
('mobu2', '2222', 'もぶB', 22, '東日本'),
('mobu3', '3333', 'もぶｃ', 33, '西日本'),
('mobu4', '4444', 'もぶｄ', 44, '沖縄'),
('minato11', '1111', '名前', 11, '西日本'),
('', '', '', 0, ''),
('tomodatchiA', '1111', '友くん', 1000, '北海道'),
('mobu3', '3333', 'もぶ３', 33, '北海道');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
