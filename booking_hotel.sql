SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `phone` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `bookinghistory` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `customerId` int(128) NOT NULL,
  `hotelId` int(128) NOT NULL,
  `price` varchar(128) NOT NULL,
  `created` datetime NOT NULL DEFAULT current_timestamp(),
  `checkin` datetime NOT NULL DEFAULT current_timestamp(),
  `checkout` datetime NOT NULL DEFAULT current_timestamp(),
  `status` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bookingHistoryCustomerId` (`customerId`),
  KEY `bookingHistoryHotelId` (`hotelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `price` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `address` varchar(128) NOT NULL,
  `star` int(128) DEFAULT NULL,
  `price` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `hotelservice` (
  `hotelId` int(128) NOT NULL,
  `serviceId` int(128) NOT NULL,
  PRIMARY KEY (`hotelId`,`serviceId`),
  KEY `hotelId` (`hotelId`),
  KEY `hotelServiceServiceId` (`serviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `paymenthistory` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `customerId` int(128) NOT NULL,
  `price` varchar(128) NOT NULL,
  `created` datetime NOT NULL DEFAULT current_timestamp(),
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `paymentHistoryCustomerId` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `service` (
  `id` int(128) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `bookinghistory`
  ADD CONSTRAINT `bookingHistoryCustomerId` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `bookingHistoryHotelId` FOREIGN KEY (`hotelId`) REFERENCES `hotel` (`id`);

ALTER TABLE `hotelservice`
  ADD CONSTRAINT `hotelServiceHotelId` FOREIGN KEY (`hotelId`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `hotelServiceServiceId` FOREIGN KEY (`serviceId`) REFERENCES `service` (`id`);

ALTER TABLE `paymenthistory`
  ADD CONSTRAINT `paymentHistoryCustomerId` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
