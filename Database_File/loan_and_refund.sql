-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 04, 2021 at 01:45 PM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loan_and_refund`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `beneficiaryreg`
--

CREATE TABLE `beneficiaryreg` (
  `id` int(11) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `bank` varchar(100) NOT NULL,
  `accountno` varchar(10) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `create_at` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beneficiaryreg`
--

INSERT INTO `beneficiaryreg` (`id`, `fname`, `mname`, `lname`, `fullname`, `gender`, `email`, `phone`, `bank`, `accountno`, `address`, `create_at`) VALUES
(15, 'Jamila', NULL, 'Salisu', 'Salisu Jamila', 'Female', 'support@mjtech.com.ng', '08028752833', 'Access Bank', '0694764608', 'Kano - Kaduna, Nigeria', '2021-04-04'),
(16, 'Ola', NULL, 'Solade', 'Solade Ola', 'Male', 'ola@gmail.com', '08160760574', 'Guaranty Trust Bank (GTB)', '0123456789', 'NDA Barrack, Kaduna', '2021-04-04');

-- --------------------------------------------------------

--
-- Table structure for table `businessreg`
--

CREATE TABLE `businessreg` (
  `id` int(11) NOT NULL,
  `bname` varchar(100) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `businessreg`
--

INSERT INTO `businessreg` (`id`, `bname`, `date`) VALUES
(17, 'Software Engineer', '2021-04-04'),
(18, 'Tailor', '2021-04-04'),
(19, 'Architecture', '2021-04-04'),
(20, 'Teacher', '2021-04-04'),
(21, 'Lecturer ', '2021-04-04');

-- --------------------------------------------------------

--
-- Table structure for table `deptcheck`
--

CREATE TABLE `deptcheck` (
  `id` int(11) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `accountno` varchar(10) DEFAULT NULL,
  `balamount` varchar(100) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `payduration` varchar(100) DEFAULT NULL,
  `loanamount` varchar(100) DEFAULT NULL,
  `loandate` varchar(10) DEFAULT NULL,
  `status` int(50) DEFAULT NULL,
  `loancount` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deptcheck`
--

INSERT INTO `deptcheck` (`id`, `phone`, `accountno`, `balamount`, `fullname`, `payduration`, `loanamount`, `loandate`, `status`, `loancount`) VALUES
(15, '08028752833', '0694764608', '0.00', 'Salisu Jamila', 'Monthly (max of 6-months)', '5000000', '2021-4-4', 2, NULL),
(16, '08160760574', '0123456789', '150000.00', 'Solade Ola', 'Weekly (max of 26-weeks)', '150000', '2021-4-4', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `loanpayment`
--

CREATE TABLE `loanpayment` (
  `id` int(11) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `loanduration` varchar(100) NOT NULL,
  `loandate` varchar(100) NOT NULL,
  `loanamount` varchar(100) NOT NULL,
  `balamount` varchar(100) NOT NULL,
  `payamount` varchar(100) NOT NULL,
  `paymentdate` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loanpayment`
--

INSERT INTO `loanpayment` (`id`, `fname`, `mname`, `lname`, `fullname`, `phone`, `loanduration`, `loandate`, `loanamount`, `balamount`, `payamount`, `paymentdate`, `status`) VALUES
(18, 'Jamila', NULL, 'Salisu', 'Salisu Jamila', '08028752833', 'Monthly (max of 6-months)', '2021-4-4', '5000000.00', '5000000.00', '1500000', '2021-4-4', 'Success'),
(19, 'Jamila', NULL, 'Salisu', 'Salisu Jamila', '08028752833', 'Monthly (max of 6-months)', '2021-4-4', '5000000.00', '3500000.00', '1000000', '2021-4-4', 'Success'),
(20, 'Jamila', NULL, 'Salisu', 'Salisu Jamila', '08028752833', 'Monthly (max of 6-months)', '2021-4-4', '5000000.00', '2500000.00', '1000000', '2021-4-4', 'Success'),
(21, 'Jamila', NULL, 'Salisu', 'Salisu Jamila', '08028752833', 'Monthly (max of 6-months)', '2021-4-4', '5000000.00', '1500000.00', '1500000', '2021-4-4', 'Success'),
(22, 'Ola', NULL, 'Solade', 'Solade Ola', '08160760574', 'Monthly (max of 6-months)', '2021-4-4', '500000.00', '500000.00', '150000', '2021-4-4', 'Success'),
(23, 'Ola', NULL, 'Solade', 'Solade Ola', '08160760574', 'Monthly (max of 6-months)', '2021-4-4', '500000.00', '350000.00', '84000', '2021-4-4', 'Success'),
(24, 'Ola', NULL, 'Solade', 'Solade Ola', '08160760574', 'Monthly (max of 6-months)', '2021-4-4', '500000.00', '266000.00', '182000', '2021-4-4', 'Success'),
(25, 'Ola', NULL, 'Solade', 'Solade Ola', '08160760574', 'Monthly (max of 6-months)', '2021-4-4', '500000.00', '84000.00', '84000', '2021-4-4', 'Success');

-- --------------------------------------------------------

--
-- Table structure for table `loanrequest`
--

CREATE TABLE `loanrequest` (
  `id` int(11) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `btype` varchar(100) NOT NULL,
  `payduration` varchar(100) NOT NULL,
  `amount` varchar(100) NOT NULL,
  `loandate` varchar(10) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loanrequest`
--

INSERT INTO `loanrequest` (`id`, `fname`, `mname`, `lname`, `fullname`, `email`, `phone`, `btype`, `payduration`, `amount`, `loandate`, `status`) VALUES
(20, 'Jamila', NULL, 'Salisu', 'Salisu Jamila', 'support@mjtech.com.ng', '08028752833', 'Software Engineer', 'Monthly (max of 6-months)', '5000000.00', '2021-4-4', 'Success'),
(21, 'Ola', NULL, 'Solade', 'Solade Ola', 'ola@gmail.com', '08160760574', 'Architecture', 'Monthly (max of 6-months)', '500000.00', '2021-4-4', 'Success'),
(22, 'Ola', NULL, 'Solade', 'Solade Ola', 'ola@gmail.com', '08160760574', 'Lecturer ', 'Weekly (max of 26-weeks)', '150000.00', '2021-4-4', 'Success');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `beneficiaryreg`
--
ALTER TABLE `beneficiaryreg`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `businessreg`
--
ALTER TABLE `businessreg`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deptcheck`
--
ALTER TABLE `deptcheck`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loanpayment`
--
ALTER TABLE `loanpayment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loanrequest`
--
ALTER TABLE `loanrequest`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `beneficiaryreg`
--
ALTER TABLE `beneficiaryreg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `businessreg`
--
ALTER TABLE `businessreg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `deptcheck`
--
ALTER TABLE `deptcheck`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `loanpayment`
--
ALTER TABLE `loanpayment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `loanrequest`
--
ALTER TABLE `loanrequest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
