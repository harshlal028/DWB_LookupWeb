-- phpMyAdmin SQL Dump
-- version 4.0.5
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 05, 2015 at 06:20 AM
-- Server version: 5.1.73
-- PHP Version: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `places`
--

CREATE TABLE IF NOT EXISTS `places` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `category` text NOT NULL,
  `rating` float NOT NULL,
  `latitude` text NOT NULL,
  `longitude` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `places`
--

INSERT INTO `places` (`id`, `name`, `category`, `rating`, `latitude`, `longitude`) VALUES
(1, 'Pizza Hut', 'Pizza', 3.7, '12.926266', '77.517784'),
(2, 'Western Union', 'Bank', 2, '18.577562', '73.7688946'),
(3, 'Toit', 'Brewpub', 4.4, '12.979239', '77.6383966'),
(4, 'Courtyard', 'Hotel', 4.4, '13.0459002', '80.245602'),
(5, 'Goa Aquatics', 'Adventure Sports Center', 5, '15.4723016', '73.7249056'),
(6, 'Jaisalmer Fort', 'Tourist Attraction', 4.4, '26.903651', '70.8596248'),
(7, 'Ghoomakad', 'Hackerspace', 4.9, '32.1984597', '76.3646732'),
(8, 'HasGeek Workshop', 'Hackerspace', 4, '12.9609268', '77.6417689'),
(9, 'Barbeque Nation', 'Restaurant', 4.2, '12.9609268', '77.6417689'),
(10, 'iPlanet', 'Apple Store', 3.5, '12.9702272', '77.6360561'),
(11, 'Apollo Spectra Hospitals', 'Hospital', 3, '12.9271311', '77.6063377'),
(12, 'Indian Institute of Management Bangalore', 'Business School', 4.6, '12.912931', '77.5965757'),
(13, 'Sub Foreign Post Office', 'Post Office', 2, '12.9554321', '77.5867354'),
(14, 'Regional Transport Office', 'State Government Office', 1, '19.0162591', '72.8110621');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
