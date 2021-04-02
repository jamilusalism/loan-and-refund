-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2019 at 07:13 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 5.6.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loanscheme`
--

-- --------------------------------------------------------

--
-- Table structure for table `activeloan`
--

CREATE TABLE `activeloan` (
  `id` int(11) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `accountno` varchar(10) NOT NULL,
  `btype` varchar(100) NOT NULL,
  `payduration` varchar(100) NOT NULL,
  `amount` varchar(100) NOT NULL,
  `loandate` varchar(50) NOT NULL,
  `status` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `activeloan`
--

INSERT INTO `activeloan` (`id`, `fname`, `mname`, `lname`, `fullname`, `email`, `phone`, `accountno`, `btype`, `payduration`, `amount`, `loandate`, `status`) VALUES
(1, 'Jamilu', 'A', 'Salisu', 'Salisu Jamilu A', 'jamilusalis@gmail.com', '0802875', '', 'Bussiness Man', 'Weekly (max of 26-weeks)', '4000.00', 'Mon, 26-8-2019', 'Success'),
(2, 'Muhd', 'Sani', 'Hamidu', 'Hamidu Muhd Sani', 'hamidu@gmail.com', '0803322', '', 'Lecturing', 'Monthly (max of 6-months)', '10000.00', 'Mon, 26-8-2019', 'Success');

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
  `address` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beneficiaryreg`
--

INSERT INTO `beneficiaryreg` (`id`, `fname`, `mname`, `lname`, `fullname`, `gender`, `email`, `phone`, `bank`, `accountno`, `address`) VALUES
(1, 'Jamilu', NULL, 'Salisu', 'Salisu Jamilu', 'Male', 'jamilusalis@gmail.com', '08028752833', 'Access Bank', '0694764608', 'KadPoly ICT, Kaduna State'),
(2, 'Jamila Adamu', NULL, 'Salisu', 'Salisu Jamila Adamu', 'Female', 'talk2majorstation@gmail.com', '08068535322', 'Access Bank (Diamond Bank)', '0001112223', 'BUK ICT, New Site, Kano State');

-- --------------------------------------------------------

--
-- Table structure for table `businessreg`
--

CREATE TABLE `businessreg` (
  `id` int(11) NOT NULL,
  `bname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `businessreg`
--

INSERT INTO `businessreg` (`id`, `bname`) VALUES
(1, 'Teaching'),
(2, 'Lecturing'),
(3, 'Nigerian Navy'),
(4, 'Nigerian Army'),
(5, 'Programmer'),
(6, 'Software and Web Developer ');

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
  `loandate` varchar(100) DEFAULT NULL,
  `status` int(50) DEFAULT NULL,
  `loancount` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deptcheck`
--

INSERT INTO `deptcheck` (`id`, `phone`, `accountno`, `balamount`, `fullname`, `payduration`, `loanamount`, `loandate`, `status`, `loancount`) VALUES
(1, '08028752833', '0694764608', '600000.00', 'Salisu Jamilu', 'Monthly (max of 6-months)', '1000000', 'Tue, 27-8-2019', 1, NULL),
(2, '08068535322', '0001112223', '0.00', 'Salisu Jamila Adamu', 'Weekly (max of 26-weeks)', '1000000', 'Tue, 27-8-2019', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `eligiblecheck`
--

CREATE TABLE `eligiblecheck` (
  `id` int(11) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `amount` varchar(100) NOT NULL,
  `status` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'Jamilu', NULL, 'Salisu', 'Salisu Jamilu', '08028752833', 'Monthly (max of 6-months)', 'Tue, 27-8-2019', '1000000.00', '1000000.00', '400000', 'Tue, 27-8-2019', 'Success'),
(2, 'Jamila Adamu', NULL, 'Salisu', 'Salisu Jamila Adamu', '08068535322', 'Weekly (max of 26-weeks)', 'Tue, 27-8-2019', '1000000.00', '1000000.00', '500000', 'Tue, 27-8-2019', 'Success'),
(3, 'Jamila Adamu', NULL, 'Salisu', 'Salisu Jamila Adamu', '08068535322', 'Weekly (max of 26-weeks)', 'Tue, 27-8-2019', '1000000.00', '500000.00', '500000', 'Tue, 27-8-2019', 'Success');

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
  `loandate` varchar(50) NOT NULL,
  `status` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loanrequest`
--

INSERT INTO `loanrequest` (`id`, `fname`, `mname`, `lname`, `fullname`, `email`, `phone`, `btype`, `payduration`, `amount`, `loandate`, `status`) VALUES
(1, 'Jamilu', NULL, 'Salisu', 'Salisu Jamilu', 'jamilusalis@gmail.com', '08028752833', 'Programmer', 'Monthly (max of 6-months)', '1000000.00', 'Tue, 27-8-2019', 'Success'),
(2, 'Jamila Adamu', NULL, 'Salisu', 'Salisu Jamila Adamu', 'talk2majorstation@gmail.com', '08068535322', 'Software and Web Developer ', 'Weekly (max of 26-weeks)', '1000000.00', 'Tue, 27-8-2019', 'Success');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activeloan`
--
ALTER TABLE `activeloan`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `eligiblecheck`
--
ALTER TABLE `eligiblecheck`
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
-- AUTO_INCREMENT for table `activeloan`
--
ALTER TABLE `activeloan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `beneficiaryreg`
--
ALTER TABLE `beneficiaryreg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `businessreg`
--
ALTER TABLE `businessreg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `deptcheck`
--
ALTER TABLE `deptcheck`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `eligiblecheck`
--
ALTER TABLE `eligiblecheck`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loanpayment`
--
ALTER TABLE `loanpayment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `loanrequest`
--
ALTER TABLE `loanrequest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
