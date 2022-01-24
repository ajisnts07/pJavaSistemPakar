-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 24, 2022 at 12:36 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javasikar`
--

-- --------------------------------------------------------

--
-- Table structure for table `aturan`
--

CREATE TABLE `aturan` (
  `kode_aturan` varchar(11) NOT NULL,
  `jika` varchar(15) NOT NULL,
  `maka` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `aturan`
--

INSERT INTO `aturan` (`kode_aturan`, `jika`, `maka`) VALUES
('A01', 'G01ANDG02ANDG03', 'P01'),
('A02', 'G01ANDG04ANDG05', 'P02'),
('A03', 'G01ANDG06ANDG07', 'P03');

-- --------------------------------------------------------

--
-- Table structure for table `gejala`
--

CREATE TABLE `gejala` (
  `kode_gejala` varchar(11) NOT NULL,
  `nama_gejala` varchar(50) NOT NULL,
  `pertanyaan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gejala`
--

INSERT INTO `gejala` (`kode_gejala`, `nama_gejala`, `pertanyaan`) VALUES
('G01', 'Lemas atau Mudah Lelah', 'Apakah anda merasakan lemas dan mudah lelah?'),
('G02', 'Demam', 'Apakah anda sekarang demam?'),
('G03', 'Mual dan Muntah', 'Apakah anda mual lalu muntah?'),
('G04', 'Sesak Nafas', 'Apakah nafas anda terasa sesak?'),
('G05', 'Kulit Pucat', 'Apakah kulit anda terlihat pucat?'),
('G06', 'Penglihatan Buram', 'Apakah anda merasakan penglihatan buram?'),
('G07', 'Mulut Kering', 'Apakah mulut anda mengering?');

-- --------------------------------------------------------

--
-- Table structure for table `orang`
--

CREATE TABLE `orang` (
  `id` varchar(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `level` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orang`
--

INSERT INTO `orang` (`id`, `nama`, `username`, `password`, `level`) VALUES
('SPK001', 'Super Admin', 'admin', 'admin', 'Admin'),
('SPK002', 'Super User', 'user', 'user', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `penyakit`
--

CREATE TABLE `penyakit` (
  `kode_penyakit` varchar(11) NOT NULL,
  `nama_penyakit` varchar(35) NOT NULL,
  `deskripsi_penyakit` varchar(1000) NOT NULL,
  `solusi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penyakit`
--

INSERT INTO `penyakit` (`kode_penyakit`, `nama_penyakit`, `deskripsi_penyakit`, `solusi`) VALUES
('P01', 'Hepatitis B', 'Hepatitis B adalah peradangan organ hati yang disebabkan oleh virus hepatitis B. Virus ini dapat menular melalui hubungan seksual atau berbagi jarum suntik', 'Diberikan vaksin untuk memperkuat sistem imunitas tubuh guna mencegah perkembangan virus dalam tubuh'),
('P02', 'Anemia', 'Anemia adalah kondisi ketika tubuh kekurangan sel darah merah yang sehat atau ketika sel darah merah tidak berfungsi dengan baik. Akibatnya, organ tubuh tidak mendapat cukup oksigen, sehingga membuat penderita anemia pucat dan mudah lelah', 'Perbanyak mengonsumsi makanan kaya zat besi dan asam folat, suplemen penambah darah dan vitamin'),
('P03', 'Diabetes Gestasional', 'Diabetes gestasional adalah diabetes yang muncul pada masa kehamilan, dan hanya berlangsung hingga proses melahirkan. Kondisi ini dapat terjadi di usia kehamilan berapa pun, namun lazimnya berlangsung di minggu ke-24 sampai ke-28 kehamilan', 'Disarankan melakukan tes darah secara lebih rutin, terutama pada 3 bulan terakhir masa kehamilan, melakukan diet sehat, dan olahraga serta mengonsumsi obat-obatan yang diresepkan dokter');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aturan`
--
ALTER TABLE `aturan`
  ADD PRIMARY KEY (`kode_aturan`);

--
-- Indexes for table `gejala`
--
ALTER TABLE `gejala`
  ADD PRIMARY KEY (`kode_gejala`);

--
-- Indexes for table `orang`
--
ALTER TABLE `orang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penyakit`
--
ALTER TABLE `penyakit`
  ADD PRIMARY KEY (`kode_penyakit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
