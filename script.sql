USE [master]
GO
/****** Object:  Database [WorkShop1]    Script Date: 6/15/2017 9:54:11 PM ******/
CREATE DATABASE [WorkShop1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'WorkShop1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.QUYPC\MSSQL\DATA\WorkShop1.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'WorkShop1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.QUYPC\MSSQL\DATA\WorkShop1_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [WorkShop1] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [WorkShop1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [WorkShop1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [WorkShop1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [WorkShop1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [WorkShop1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [WorkShop1] SET ARITHABORT OFF 
GO
ALTER DATABASE [WorkShop1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [WorkShop1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [WorkShop1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [WorkShop1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [WorkShop1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [WorkShop1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [WorkShop1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [WorkShop1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [WorkShop1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [WorkShop1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [WorkShop1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [WorkShop1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [WorkShop1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [WorkShop1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [WorkShop1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [WorkShop1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [WorkShop1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [WorkShop1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [WorkShop1] SET  MULTI_USER 
GO
ALTER DATABASE [WorkShop1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [WorkShop1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [WorkShop1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [WorkShop1] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [WorkShop1] SET DELAYED_DURABILITY = DISABLED 
GO
USE [WorkShop1]
GO
/****** Object:  Table [dbo].[tbl_Mobile]    Script Date: 6/15/2017 9:54:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Mobile](
	[mobileID] [nvarchar](10) NOT NULL,
	[description] [nvarchar](250) NOT NULL,
	[price] [float] NULL,
	[mobileName] [nvarchar](20) NOT NULL,
	[yearofProduction] [int] NULL,
	[quantity] [int] NULL,
	[notSale] [bit] NULL,
 CONSTRAINT [PK_tbl_Mobile] PRIMARY KEY CLUSTERED 
(
	[mobileID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 6/15/2017 9:54:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_User](
	[userID] [nvarchar](20) NOT NULL,
	[password] [int] NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[role] [int] NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_UserPay]    Script Date: 6/15/2017 9:54:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_UserPay](
	[userID] [nvarchar](10) NULL,
	[mobileID] [nvarchar](10) NULL,
	[quantity] [int] NULL
) ON [PRIMARY]

GO
INSERT [dbo].[tbl_Mobile] ([mobileID], [description], [price], [mobileName], [yearofProduction], [quantity], [notSale]) VALUES (N'Ip111', N'greybrown', 548.530029296875, N'Iphone', 2016, 7410, 1)
INSERT [dbo].[tbl_Mobile] ([mobileID], [description], [price], [mobileName], [yearofProduction], [quantity], [notSale]) VALUES (N'Ip112', N'pink', 21854, N'Iphone', 2017, 999, 1)
INSERT [dbo].[tbl_Mobile] ([mobileID], [description], [price], [mobileName], [yearofProduction], [quantity], [notSale]) VALUES (N'ip2569', N'hotpink,red', 569, N'iphone9S', 2569, 2, 0)
INSERT [dbo].[tbl_Mobile] ([mobileID], [description], [price], [mobileName], [yearofProduction], [quantity], [notSale]) VALUES (N'ip999', N'hotpink', 95.5999984741211, N'iphone', 1999, 3, 1)
INSERT [dbo].[tbl_Mobile] ([mobileID], [description], [price], [mobileName], [yearofProduction], [quantity], [notSale]) VALUES (N'LG187', N'red', 4887, N'LG', 2015, 100, 1)
INSERT [dbo].[tbl_Mobile] ([mobileID], [description], [price], [mobileName], [yearofProduction], [quantity], [notSale]) VALUES (N'Op007', N'white', 157.6, N'Oppo', 2017, 99, 0)
INSERT [dbo].[tbl_Mobile] ([mobileID], [description], [price], [mobileName], [yearofProduction], [quantity], [notSale]) VALUES (N'SS226', N'black', 698.99, N'Samsung', 2018, 999, 0)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'admin', 123, N'admin', 1)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'quy', 123, N'quy', 2)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'thien', 456, N'thien', 0)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'tien', 123, N'tien san', 0)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'user', 123, N'user', 0)
INSERT [dbo].[tbl_UserPay] ([userID], [mobileID], [quantity]) VALUES (N'thien', N'Ip111', 1)
INSERT [dbo].[tbl_UserPay] ([userID], [mobileID], [quantity]) VALUES (N'thien', N'Ip111', 1)
INSERT [dbo].[tbl_UserPay] ([userID], [mobileID], [quantity]) VALUES (N'user', N'Ip112', 1)
USE [master]
GO
ALTER DATABASE [WorkShop1] SET  READ_WRITE 
GO
