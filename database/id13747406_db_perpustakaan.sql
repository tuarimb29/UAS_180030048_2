-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 29, 2020 at 02:17 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id13747406_db_perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_buku`
--

CREATE TABLE `t_buku` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `gambar` varchar(100) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `halaman` int(5) NOT NULL,
  `bahasa` varchar(20) NOT NULL,
  `penulis` varchar(100) NOT NULL,
  `tahun` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_buku`
--

INSERT INTO `t_buku` (`id`, `judul`, `gambar`, `jenis`, `halaman`, `bahasa`, `penulis`, `tahun`) VALUES
(2, 'Drum Lessons USA', 'https://api-buku.000webhostapp.com/perpusuas/img/redbook.png', 'Musik', 450, 'Indonesia', 'Brook Gates', 2005),
(3, 'Citra Digital', 'https://api-buku.000webhostapp.com/perpusuas/img/orangebook.png', 'Multimedia', 100, 'Indonesia', 'Putri Susan Astuti', 2015),
(4, 'Network Topology', 'https://api-buku.000webhostapp.com/perpusuas/img/greenbook.png', 'Jaringan', 500, 'Inggris', 'Duta Susila', 2000),
(5, 'Positive Thinking', 'https://api-buku.000webhostapp.com/perpusuas/img/pinkbook.png', 'Motivasi', 380, 'Inggris', 'Charles Pearl', 2019),
(9, 'Router Tips', 'https://api-buku.000webhostapp.com/perpusuas/img/greenbook.png', 'Jaringan', 500, 'Indonesia', 'Ari Purnomo', 2000),
(10, 'Mind Set', 'https://api-buku.000webhostapp.com/perpusuas/img/pinkbook.png', 'Motivasi', 355, 'Inggris', 'Sutomo Arya', 2019),
(12, 'Guitar Tips', 'https://api-buku.000webhostapp.com/perpusuas/img/redbook.png', 'Musik', 900, 'Indonesia', 'Albert Wesker', 2000),
(13, 'Premiere Pro Tips', 'https://api-buku.000webhostapp.com/perpusuas/img/orangebook.png', 'Multimedia', 200, 'Indonesia', 'Alan Suryajana', 2020),
(15, 'Guitar Melody', 'https://api-buku.000webhostapp.com/perpusuas/img/redbook.png', 'Musik', 300, 'Indonesia', 'Synyster Gates', 2020);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_buku`
--
ALTER TABLE `t_buku`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_buku`
--
ALTER TABLE `t_buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
