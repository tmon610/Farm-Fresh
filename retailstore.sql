-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2015 at 08:20 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `retailstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE IF NOT EXISTS `bill` (
  `pro_name` varchar(20) NOT NULL,
  `quantity` varchar(20) NOT NULL,
  `price` varchar(20) NOT NULL,
  PRIMARY KEY (`pro_name`),
  UNIQUE KEY `pro_name` (`pro_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) NOT NULL,
  `emp_dob` varchar(12) NOT NULL,
  `emp_phno` varchar(15) NOT NULL,
  `emp_address` varchar(100) NOT NULL,
  `emp_username` varchar(20) NOT NULL,
  `emp_password` varchar(20) NOT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_username` (`emp_username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `emp_dob`, `emp_phno`, `emp_address`, `emp_username`, `emp_password`) VALUES
(1, 'Taufiq Monghal', '06-10-1996', '9920063057', 'Bandra', 'tmon610', '12345'),
(2, 'saba', '01-11-1992', '9833662736', 'bandra', 'saba', 'saba');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `pro_id` int(10) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(20) NOT NULL,
  `pro_price` int(10) NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pro_id`, `pro_name`, `pro_price`) VALUES
(1, 'Milk', 50),
(2, 'Chocolate', 30),
(3, 'Cheese', 100),
(4, 'Milano Biscuit', 25),
(5, 'Soap', 20),
(6, 'Toothpaste', 35),
(7, 'Nutella', 130),
(8, 'Oil', 650),
(9, 'Spices', 150),
(10, 'Bread', 20);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `sup_id` int(10) NOT NULL AUTO_INCREMENT,
  `sup_name` varchar(20) NOT NULL,
  `sup_phno` varchar(12) NOT NULL,
  `sup_address` varchar(100) NOT NULL,
  `sup_username` varchar(20) NOT NULL,
  `sup_password` varchar(20) NOT NULL,
  PRIMARY KEY (`sup_id`),
  UNIQUE KEY `sup_username` (`sup_username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
