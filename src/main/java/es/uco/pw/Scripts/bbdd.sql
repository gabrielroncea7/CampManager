-- --------------------------------------------------------
-- 
-- Estructura de tabla para la tabla Actividad
-- 

DROP TABLE IF EXISTS `Actividad`;
CREATE TABLE IF NOT EXISTS `Actividad` (
  `Nombre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nEducativo` ENUM('Infantil', 'Juvenil', 'Adolescente') DEFAULT NULL,
  `hActividad` ENUM('Mañana', 'Tarde') DEFAULT NULL,
  `nParticipantes` int DEFAULT NULL,
  `nMonitores` int DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 
-- Fin de la estructura de la tabla Actividad
-- 

-- 
-- Estructura de tabla para la tabla Asistente
-- 

DROP TABLE IF EXISTS `Asistente`;
CREATE TABLE IF NOT EXISTS `Asistente` (
  `Id_persona` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Apellidos` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fecha_Nacimiento` DATE DEFAULT NULL,
  `Atencion_Especial` TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (`Id_persona`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 
-- Fin de la estructura de la tabla Actividad
-- 

-- 
-- Estructura de tabla para la tabla `Monitor`
-- 

DROP TABLE IF EXISTS `Monitor`;
CREATE TABLE IF NOT EXISTS `Monitor` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Apellidos` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Ed_Especial` TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 
-- Volcar la base de datos para la tabla `Monitor`
-- 


-- 
-- Estructura de tabla para la tabla Campamento
-- 

DROP TABLE IF EXISTS Campamento;
CREATE TABLE IF NOT EXISTS Campamento (
  Id int NOT NULL AUTO_INCREMENT,
  fechaInicio DATE DEFAULT NULL,
  fechaFin DATE DEFAULT NULL,
  nivelEducativo ENUM('Infantil', 'Juvenil', 'Adolescente') DEFAULT NULL,
  NumeroMaxAsistentes int NOT NULL,
  AsistentesInscritos int NOT NULL DEFAULT 0,
  monitorAsignado TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (Id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 
-- Volcar la base de datos para la tabla Campamento
-- 

-- 
-- Estructura de tabla para la tabla Campamento
-- 

DROP TABLE IF EXISTS `Inscripcion`;
CREATE TABLE IF NOT EXISTS `Inscripcion` (
  `Id_ins` int NOT NULL AUTO_INCREMENT,
  `Id_asistente` int NOT NULL,
  `Id_campamento` int NOT NULL,
  `Fecha_inscripcion` DATE DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `tipoRegistro` TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (`Id_asistente`, `Id_campamento`, `Id_ins`),
  FOREIGN KEY (`Id_asistente`) REFERENCES `Asistente` (Id_persona),
  FOREIGN KEY (`Id_campamento`) REFERENCES `Campamento` (Id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- Estructura de tabla para la tabla Monitor_Actividad
DROP TABLE IF EXISTS `Monitor_Actividad`;
CREATE TABLE IF NOT EXISTS Monitor_Actividad (
  MonitorId int NOT NULL,
  ActividadNombre varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (MonitorId, ActividadNombre),
  FOREIGN KEY (MonitorId) REFERENCES Monitor(Id),
  FOREIGN KEY (ActividadNombre) REFERENCES Actividad(Nombre)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- Estructura de tabla para la tabla Campamento_Actividad
DROP TABLE IF EXISTS `Campamento_Actividad`;
CREATE TABLE IF NOT EXISTS Campamento_Actividad (
  CampamentoId int NOT NULL,
  ActividadNombre varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (CampamentoId, ActividadNombre),
  FOREIGN KEY (CampamentoId) REFERENCES Campamento(Id),
  FOREIGN KEY (ActividadNombre) REFERENCES Actividad(Nombre)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- Estructura de tabla para la tabla Monitor_Campamento
DROP TABLE IF EXISTS `Monitor_Campamento`;
CREATE TABLE IF NOT EXISTS Monitor_Campamento (
  MonitorId int NOT NULL,
  CampamentoId int NOT NULL,
  PRIMARY KEY (MonitorId, CampamentoId),
  FOREIGN KEY (MonitorId) REFERENCES Monitor(Id),
  FOREIGN KEY (CampamentoId) REFERENCES Campamento(Id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 
-- Estructura de tabla para la tabla `Usuarios`
-- 

CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `atencionEsp` tinyint(1) DEFAULT '0',
  `esAdmin` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1 AUTO_INCREMENT=45;