-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2018 at 07:59 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `osa`
--

-- --------------------------------------------------------

--
-- Table structure for table `myusers`
--

CREATE TABLE `myusers` (
  `id` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `myusers`
--

INSERT INTO `myusers` (`id`, `email`, `password`, `name`, `address`, `phone`, `birthday`) VALUES
(1, 'solaiman@gmail.com', 'admin', 'Mohammad Solaiman', 'mirpur-10  dahaka', '01914667359', '1995-03-19'),
(2, 't1@gmail.com', 'admin', 'razon ahmed', 'mirpur-10  dahaka', '01914444444', '2018-03-27');

-- --------------------------------------------------------

--
-- Table structure for table `solaimangmailcom`
--

CREATE TABLE `solaimangmailcom` (
  `id` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `solaimangmailcom`
--

INSERT INTO `solaimangmailcom` (`id`, `image`, `pname`, `price`) VALUES
(1, 'https://bd.daraz.io/Mg6_pMcmAIivyj7YAHAPBP1cbzs=/fit-in/220x220/filters:fill(white):sharpen(1,0,false):quality(80)/product/13/4453/1.jpg?0581', 'Red Sunglass For Women', '333.00'),
(2, 'https://bd.daraz.io/DOY3VLP_9dwwmCXJDJbrK6hVK28=/fit-in/220x220/filters:fill(white):sharpen(1,0,false):quality(80)/product/44/7003/1.jpg?8361', 'Red Sunglasses For Women', '350.00');

-- --------------------------------------------------------

--
-- Table structure for table `t1gmailcom`
--

CREATE TABLE `t1gmailcom` (
  `id` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t1gmailcom`
--

INSERT INTO `t1gmailcom` (`id`, `image`, `pname`, `price`) VALUES
(1, 'https://bd.daraz.io/6XkTk4NKNnZRhR-cgVWQRwXn6tE=/fit-in/220x220/filters:fill(white):sharpen(1,0,false):quality(80)/product/76/2344/1.jpg?7661', 'Stylish Sunglass - Blue', '850.00'),
(2, 'https://bd.daraz.io/KzeNgCqk7U7ccc8oDz83-FgU9fU=/fit-in/220x220/filters:fill(white):sharpen(1,0,false):quality(80)/product/55/9082/1.jpg?1692', 'Blue Metal Frame Sunglasses For Men', '1,030.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `myusers`
--
ALTER TABLE `myusers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `solaimangmailcom`
--
ALTER TABLE `solaimangmailcom`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t1gmailcom`
--
ALTER TABLE `t1gmailcom`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `myusers`
--
ALTER TABLE `myusers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `solaimangmailcom`
--
ALTER TABLE `solaimangmailcom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `t1gmailcom`
--
ALTER TABLE `t1gmailcom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
