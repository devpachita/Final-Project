-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 31-03-2023 a las 03:50:47
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `no_proteina` varchar(255) NOT NULL,
  `no_ensalada` varchar(255) NOT NULL,
  `desayuno` varchar(255) NOT NULL,
  `almuerzo` varchar(255) NOT NULL,
  `cena` varchar(255) NOT NULL,
  `apartamento` varchar(255) NOT NULL,
  `id_apart` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario_id`, `nombre`, `no_proteina`, `no_ensalada`, `desayuno`, `almuerzo`, `cena`, `apartamento`, `id_apart`) VALUES
(1, 'Wanda', 'Pollo', 'Payaso', 'SERVIR', 'SERVIR', 'NO SERVIR', '4\r\n', '1'),
(2, 'Francisco', 'Salchicha', 'Payaso', 'SERVIR', 'SERVIR', 'SERVIR', '1', '1'),
(3, 'Isabella', 'Todas', 'Todas', 'SERVIR', 'SERVIR', 'SERVIR', '4', '2'),
(4, 'Maria Alejandra', 'Todas', 'Todas', 'SERVIR', 'SERVIR', 'SERVIR', '4', '3'),
(5, 'Juan Solo', 'Todas', 'Ninguna', 'SERVIR', 'SERVIR', 'SERVIR', '2', '2'),
(6, 'Katrin', 'Todas', 'Payaso', 'SERVIR', 'SERVIR', 'SERVIR', '4', '4');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
