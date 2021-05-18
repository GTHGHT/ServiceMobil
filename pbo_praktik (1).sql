-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2021 at 07:02 AM
-- Server version: 10.4.10-MariaDB
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
-- Database: `pbo_praktik`
--

-- --------------------------------------------------------

--
-- Table structure for table `cust`
--

CREATE TABLE `cust` (
  `id_cust` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nohp` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dt_service`
--

CREATE TABLE `dt_service` (
  `id_dt` int(11) NOT NULL,
  `id_utama` int(11) NOT NULL,
  `id_service` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jenis`
--

CREATE TABLE `jenis` (
  `id_service` int(11) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `mobil_cust`
--

CREATE TABLE `mobil_cust` (
  `plat` varchar(16) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `id_cust` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `utama`
--

CREATE TABLE `utama` (
  `id_utama` int(11) NOT NULL,
  `id_cust` int(11) NOT NULL,
  `plat` varchar(16) NOT NULL,
  `waktu_masuk` datetime NOT NULL,
  `waktu_keluar` datetime NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cust`
--
ALTER TABLE `cust`
  ADD PRIMARY KEY (`id_cust`);

--
-- Indexes for table `dt_service`
--
ALTER TABLE `dt_service`
  ADD PRIMARY KEY (`id_dt`),
  ADD KEY `id_utama` (`id_utama`),
  ADD KEY `id_service` (`id_service`);

--
-- Indexes for table `jenis`
--
ALTER TABLE `jenis`
  ADD PRIMARY KEY (`id_service`);

--
-- Indexes for table `mobil_cust`
--
ALTER TABLE `mobil_cust`
  ADD PRIMARY KEY (`plat`),
  ADD KEY `id_cust` (`id_cust`);

--
-- Indexes for table `utama`
--
ALTER TABLE `utama`
  ADD PRIMARY KEY (`id_utama`),
  ADD KEY `id_cust` (`id_cust`),
  ADD KEY `plat` (`plat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cust`
--
ALTER TABLE `cust`
  MODIFY `id_cust` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dt_service`
--
ALTER TABLE `dt_service`
  MODIFY `id_dt` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `utama`
--
ALTER TABLE `utama`
  MODIFY `id_utama` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dt_service`
--
ALTER TABLE `dt_service`
  ADD CONSTRAINT `dt_service_ibfk_1` FOREIGN KEY (`id_service`) REFERENCES `jenis` (`id_service`),
  ADD CONSTRAINT `dt_service_ibfk_2` FOREIGN KEY (`id_utama`) REFERENCES `utama` (`id_utama`);

--
-- Constraints for table `mobil_cust`
--
ALTER TABLE `mobil_cust`
  ADD CONSTRAINT `mobil_cust_ibfk_1` FOREIGN KEY (`id_cust`) REFERENCES `cust` (`id_cust`);

--
-- Constraints for table `utama`
--
ALTER TABLE `utama`
  ADD CONSTRAINT `utama_ibfk_1` FOREIGN KEY (`id_cust`) REFERENCES `cust` (`id_cust`),
  ADD CONSTRAINT `utama_ibfk_2` FOREIGN KEY (`plat`) REFERENCES `mobil_cust` (`plat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
