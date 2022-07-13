-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 17-Jun-2022 às 21:20
-- Versão do servidor: 5.7.36
-- versão do PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `trabalhop2m2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `ID` int(11) NOT NULL,
  `ID_Dono` int(11) NOT NULL,
  `Nome` text NOT NULL,
  `Raca` text NOT NULL,
  `Especie` varchar(20) NOT NULL,
  `genero` text NOT NULL,
  `Observacao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Nome do PET';

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`ID`, `ID_Dono`, `Nome`, `Raca`, `Especie`, `genero`, `Observacao`) VALUES
(1, 1, 'Yoda', 'Calopsita', 'Passaro', 'M', NULL),
(2, 1, 'Leia', 'Calopsita', 'Passaro', 'F', NULL),
(3, 1, 'Ana', 'Calopsita', 'Passaro', 'F', NULL),
(4, 2, 'Valkiria', 'Arabe', 'Cavalo', 'F', NULL),
(5, 2, 'Thor', 'Arabe', 'Cavalo', 'M', NULL),
(6, 3, 'Diego', 'Bengala', 'Tigre', 'M', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `dono`
--

DROP TABLE IF EXISTS `dono`;
CREATE TABLE IF NOT EXISTS `dono` (
  `ID` int(11) NOT NULL COMMENT 'ID Cliente',
  `Nome` text NOT NULL,
  `Telefone` varchar(20) NOT NULL,
  `Endereco` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Cadastro Cliente';

--
-- Extraindo dados da tabela `dono`
--

INSERT INTO `dono` (`ID`, `Nome`, `Telefone`, `Endereco`) VALUES
(1, 'Daniel Wppslander', '47 999 111 555', 'AV Brasil, 000, ap 01'),
(2, 'Khard', '88 999 222 111', '370, Itapema'),
(3, 'Danielle Martins', '66 777 888 999', 'Rua 3700 ap 404, Bairro Not Found.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `os`
--

DROP TABLE IF EXISTS `os`;
CREATE TABLE IF NOT EXISTS `os` (
  `ID` int(11) NOT NULL,
  `ID_Animal` int(11) NOT NULL,
  `DATA` date NOT NULL,
  `Servico` text NOT NULL,
  `Preco` double NOT NULL,
  `Observacao` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `os`
--

INSERT INTO `os` (`ID`, `ID_Animal`, `DATA`, `Servico`, `Preco`, `Observacao`) VALUES
(1, 1, '2021-12-07', 'Aplicação de antibiotico', 100, '3 aplicações, Passaro estava com uma asa infeccionada, provavelmente uma pena encravada.'),
(2, 4, '2022-01-01', 'Aplicação de antibiotico', 400, 'Quantas necessarias, Casco da pata inferior esquerda infeccionada, o casco foi limpo e tradado.'),
(3, 4, '2022-04-01', 'Check Up', 100, 'Valkiria esta gravida, marcado dia para realizar o acompanhamento do nascimento.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
