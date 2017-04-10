-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2017 at 05:48 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `money_interest_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `area`
--

CREATE TABLE `area` (
  `Id` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `Id` int(11) NOT NULL,
  `Name` varchar(150) NOT NULL,
  `Code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contract_status`
--

CREATE TABLE `contract_status` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer_store_map`
--

CREATE TABLE `customer_store_map` (
  `Id` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  `Store_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Id` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_store_map`
--

CREATE TABLE `employee_store_map` (
  `Id` int(11) NOT NULL,
  `Employee_Id` int(11) NOT NULL,
  `Store_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `interestperiod`
--

CREATE TABLE `interestperiod` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `interest_period`
--

CREATE TABLE `interest_period` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `interest_rate`
--

CREATE TABLE `interest_rate` (
  `Id` int(11) NOT NULL,
  `Name` int(11) NOT NULL,
  `Value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `merchandise`
--

CREATE TABLE `merchandise` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Code` varchar(10) NOT NULL,
  `Money` decimal(10,0) NOT NULL,
  `Area_Id` int(11) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `Interest_Period_Id` int(11) NOT NULL,
  `OverDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `CityId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ratio`
--

CREATE TABLE `ratio` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `revenue_management`
--

CREATE TABLE `revenue_management` (
  `Id` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Investment_Type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `Id` int(11) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `IsRoot` tinyint(1) NOT NULL,
  `ParentRoleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Address` varchar(150) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Investment` varchar(100) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `CashFund` decimal(20,0) NOT NULL,
  `person_represent` varchar(30) NOT NULL,
  `created_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `time_pay`
--

CREATE TABLE `time_pay` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transactionhistory`
--

CREATE TABLE `transactionhistory` (
  `Id` int(10) NOT NULL,
  `StoreId` int(10) NOT NULL,
  `UserId` int(10) NOT NULL,
  `AmountMoney` decimal(20,0) NOT NULL,
  `CreatedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(80) NOT NULL,
  `IdentityNumber` varchar(20) NOT NULL,
  `BankIdentityNumber` varchar(20) NOT NULL,
  `ProvinceId` int(11) NOT NULL,
  `Pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `Name`, `Phone`, `Email`, `IdentityNumber`, `BankIdentityNumber`, `ProvinceId`, `Pass`) VALUES
(1, 'sam', '0123456789', 'sam@gmail.com', '125412541', '12365471', 0, '$2a$10$3Yy8a6NPPpPtfqRF.kEP6ePwgkumzpEcmEq.1cGrBzMi2y1YIG33C');

-- --------------------------------------------------------

--
-- Table structure for table `userrolemap`
--

CREATE TABLE `userrolemap` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `RoleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userstoremap`
--

CREATE TABLE `userstoremap` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `StoreId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_authorities_map`
--

CREATE TABLE `user_authorities_map` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `authorities` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_authorities_map`
--

INSERT INTO `user_authorities_map` (`id`, `user_id`, `authorities`) VALUES
(1, 1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `user_contract_map`
--

CREATE TABLE `user_contract_map` (
  `Id` int(11) NOT NULL,
  `FromDate` date NOT NULL,
  `ToDate` date NOT NULL,
  `Contract_Status_Id` int(11) NOT NULL,
  `Money_Give_To_Guest` decimal(10,0) NOT NULL,
  `Ratio_Id` int(11) NOT NULL,
  `Money_Paid` decimal(10,0) NOT NULL,
  `Old_Debt_Money` decimal(10,0) NOT NULL,
  `Must_Pay` date NOT NULL,
  `Borrow_Days` int(11) NOT NULL,
  `Date_Must_Pay` date NOT NULL,
  `Contract_State` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `ROLE_ID` varchar(50) NOT NULL,
  `USERNAME` varchar(36) NOT NULL,
  `USER_ROLE` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`ROLE_ID`, `USERNAME`, `USER_ROLE`) VALUES
('1', 'sam', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `user_token_map`
--

CREATE TABLE `user_token_map` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `jwtToken` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `contract_status`
--
ALTER TABLE `contract_status`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `customer_store_map`
--
ALTER TABLE `customer_store_map`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `employee_store_map`
--
ALTER TABLE `employee_store_map`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `interestperiod`
--
ALTER TABLE `interestperiod`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `interest_period`
--
ALTER TABLE `interest_period`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `interest_rate`
--
ALTER TABLE `interest_rate`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `merchandise`
--
ALTER TABLE `merchandise`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `ratio`
--
ALTER TABLE `ratio`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `revenue_management`
--
ALTER TABLE `revenue_management`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `time_pay`
--
ALTER TABLE `time_pay`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `transactionhistory`
--
ALTER TABLE `transactionhistory`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `userrolemap`
--
ALTER TABLE `userrolemap`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `userstoremap`
--
ALTER TABLE `userstoremap`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `user_authorities_map`
--
ALTER TABLE `user_authorities_map`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_contract_map`
--
ALTER TABLE `user_contract_map`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`ROLE_ID`),
  ADD UNIQUE KEY `USER_ROLE_UK` (`USERNAME`,`USER_ROLE`);

--
-- Indexes for table `user_token_map`
--
ALTER TABLE `user_token_map`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contract_status`
--
ALTER TABLE `contract_status`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `customer_store_map`
--
ALTER TABLE `customer_store_map`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_store_map`
--
ALTER TABLE `employee_store_map`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `interestperiod`
--
ALTER TABLE `interestperiod`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `interest_period`
--
ALTER TABLE `interest_period`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `interest_rate`
--
ALTER TABLE `interest_rate`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `merchandise`
--
ALTER TABLE `merchandise`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ratio`
--
ALTER TABLE `ratio`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `revenue_management`
--
ALTER TABLE `revenue_management`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `store`
--
ALTER TABLE `store`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `time_pay`
--
ALTER TABLE `time_pay`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transactionhistory`
--
ALTER TABLE `transactionhistory`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `userrolemap`
--
ALTER TABLE `userrolemap`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `userstoremap`
--
ALTER TABLE `userstoremap`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_authorities_map`
--
ALTER TABLE `user_authorities_map`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_contract_map`
--
ALTER TABLE `user_contract_map`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_token_map`
--
ALTER TABLE `user_token_map`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
