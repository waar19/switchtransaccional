-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.27


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema infraestructuraBKP
--

CREATE DATABASE IF NOT EXISTS infraestructuraBKP;
USE infraestructuraBKP;

--
-- Definition of table `infraestructuraBKP`.`acceso_mapsite`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`acceso_mapsite`;
CREATE TABLE  `infraestructuraBKP`.`acceso_mapsite` (
  `nombre` varchar(90) NOT NULL default '',
  `uri` varchar(255) NOT NULL default '',
  `rol_id` int(10) unsigned default NULL,
  `user_id` int(10) unsigned default NULL,
  PRIMARY KEY  (`nombre`),
  KEY `FK_acceso_mapsite_1` (`rol_id`),
  KEY `FK_acceso_mapsite_2` (`user_id`),
  CONSTRAINT `FK_acceso_mapsite_1` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`rol_id`),
  CONSTRAINT `FK_acceso_mapsite_2` FOREIGN KEY (`user_id`) REFERENCES `website_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='determina acceso a las entradas del MapSite';

--
-- Dumping data for table `infraestructuraBKP`.`acceso_mapsite`
--

/*!40000 ALTER TABLE `acceso_mapsite` DISABLE KEYS */;
/*!40000 ALTER TABLE `acceso_mapsite` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`acceso_menu`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`acceso_menu`;
CREATE TABLE  `infraestructuraBKP`.`acceso_menu` (
  `menu_id` int(10) unsigned NOT NULL default '0',
  `rol_id` int(10) unsigned default '0',
  `user_id` int(10) unsigned default '0',
  `acceso_menu_id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`acceso_menu_id`),
  KEY `rol_FK` (`rol_id`),
  KEY `FK_acceso_menu_3` (`menu_id`),
  KEY `FK_acceso_menu_4` (`user_id`),
  CONSTRAINT `FK_acceso_menu_3` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `FK_acceso_menu_4` FOREIGN KEY (`user_id`) REFERENCES `website_user` (`user_id`),
  CONSTRAINT `rol_FK` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`acceso_menu`
--

/*!40000 ALTER TABLE `acceso_menu` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`acceso_menu` (`menu_id`,`rol_id`,`user_id`,`acceso_menu_id`) VALUES 
 (10,1,NULL,1),
 (1010,1,NULL,2),
 (1020,1,NULL,3),
 (1030,1,NULL,4),
 (101010,1,NULL,5),
 (101020,1,NULL,6),
 (102010,1,NULL,7),
 (102020,1,NULL,8),
 (103010,1,NULL,9),
 (103020,1,NULL,10),
 (103030,1,NULL,11),
 (103040,1,NULL,12),
 (103050,1,NULL,13),
 (103060,1,NULL,14),
 (20,1,NULL,17),
 (2010,1,NULL,18),
 (2020,1,NULL,19),
 (2030,1,NULL,20),
 (2040,1,NULL,21),
 (201010,1,NULL,22),
 (201020,1,NULL,23),
 (201030,1,NULL,24),
 (30,1,NULL,25),
 (3010,1,NULL,26),
 (3020,1,NULL,27),
 (3030,1,NULL,28),
 (3040,1,NULL,29),
 (301010,1,NULL,30),
 (103070,1,NULL,31),
 (10307010,1,NULL,32),
 (10307020,1,NULL,33),
 (10307030,1,NULL,34),
 (10307015,1,NULL,35),
 (201005,1,NULL,36),
 (2025,1,NULL,37),
 (40,1,NULL,38),
 (4010,1,NULL,39),
 (4020,1,NULL,40),
 (401010,1,NULL,41),
 (401020,1,NULL,42),
 (401030,1,NULL,43),
 (4030,1,NULL,44),
 (4040,1,NULL,45),
 (4050,1,NULL,46);
/*!40000 ALTER TABLE `acceso_menu` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`acciones_apps`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`acciones_apps`;
CREATE TABLE  `infraestructuraBKP`.`acciones_apps` (
  `accion` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(90) NOT NULL,
  `descripcion` varchar(255) default NULL,
  `observaciones` varchar(255) default NULL,
  `circuito` varchar(4) NOT NULL,
  PRIMARY KEY  (`accion`),
  KEY `circuito` (`circuito`),
  KEY `uq_acciones_aplicacion_circuito` (`circuito`,`nombre`),
  CONSTRAINT `FK_acciones_aplicacion_1` FOREIGN KEY (`circuito`) REFERENCES `circuitos_estados` (`circuito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`acciones_apps`
--

/*!40000 ALTER TABLE `acciones_apps` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`acciones_apps` (`accion`,`nombre`,`descripcion`,`observaciones`,`circuito`) VALUES 
 (1,'Finalizar Carga','Finaliza la carga de un presupuesto, ejecutando todas las reglas de negocio y validaciones al mismos',NULL,'0002'),
 (2,'Comenzar Ejecución','Comienza con la ejecución del presupuesto, conviertiendolo en proyecto',NULL,'0002'),
 (3,'Finalizar Carga','Finaliza la carga de un proyecto, ejecutando todas las reglas de negocio y validaciones al mismos',NULL,'0001'),
 (4,'Comenzar Ejecución','Comienza con la ejecución del proyecto. El proyecto está habilitado para recibir imputaciones',NULL,'0001'),
 (5,'Lotear','Asocia el parte a un lote.',NULL,'0003'),
 (6,'Lotear','Vincula partes sin lote a un lote específico','en cuanto se asigna el primer partes pasa a estado loteando. Luego se pueden seguir agregando partes','0004'),
 (7,'Validar','ejecuta las rutinas de validación (reglas de negocio) a los partes del lote',NULL,'0004'),
 (8,'Firmar','Paso final que permite dejar válido el lote de partes.','Se requere que todos los partes de un lote hayan sido revisados y esten en un estado válido','0004'),
 (9,'Anular','Anula el lote, dejándolo fuera de servicio','Reqwuere que no tenga ningún parte asociado','0004');
INSERT INTO `infraestructuraBKP`.`acciones_apps` (`accion`,`nombre`,`descripcion`,`observaciones`,`circuito`) VALUES 
 (10,'Re-Lotear','Permite re asignar un lote al parte','Se requere que el parte no esté firmado (que es un estado final)','0003'),
 (11,'Validar','Ejecuta la acción de validación sobre el parte','el resultado de la acción es dejar al parte en estado válido o inválido','0003'),
 (12,'Firmar','Permite finalizar la autorización del parte','se requere que el parte esté en estado válido o inválido','0003'),
 (13,'Anular','Permite anular al parte.',NULL,'0003');
/*!40000 ALTER TABLE `acciones_apps` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`aplica_circuito`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`aplica_circuito`;
CREATE TABLE  `infraestructuraBKP`.`aplica_circuito` (
  `tipo_objeto` varchar(15) NOT NULL,
  `nombre_objeto` varchar(45) NOT NULL,
  `tipo_detalle` varchar(15) NOT NULL,
  `nombre_detalle` varchar(45) NOT NULL,
  `circuito` varchar(4) NOT NULL,
  PRIMARY KEY  (`nombre_detalle`,`nombre_objeto`,`tipo_detalle`,`tipo_objeto`),
  KEY `circuito` (`circuito`),
  CONSTRAINT `FK_aplica_circuito_2` FOREIGN KEY (`circuito`) REFERENCES `circuitos_estados` (`circuito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`aplica_circuito`
--

/*!40000 ALTER TABLE `aplica_circuito` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`aplica_circuito` (`tipo_objeto`,`nombre_objeto`,`tipo_detalle`,`nombre_detalle`,`circuito`) VALUES 
 ('TABLA','proyectos','COLUMNA','estado','0001'),
 ('TABLA','partes_mo','COLUMNA','estado','0003');
/*!40000 ALTER TABLE `aplica_circuito` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`atributos_entidad`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`atributos_entidad`;
CREATE TABLE  `infraestructuraBKP`.`atributos_entidad` (
  `valor` varchar(255) NOT NULL COMMENT 'Valor del atributo',
  `valor_entero` int(11) default NULL,
  `valor_real` double default NULL,
  `valor_fecha` date default NULL,
  `valor_logico` char(1) default NULL,
  `atributo_id` int(15) unsigned NOT NULL COMMENT 'Identificación única de atributo de entidad',
  `entidad_id` int(15) unsigned NOT NULL,
  PRIMARY KEY  (`atributo_id`,`entidad_id`),
  KEY `atributo_id` (`atributo_id`),
  KEY `entidad_id` (`entidad_id`),
  CONSTRAINT `FK_atributos_entidad_1` FOREIGN KEY (`atributo_id`) REFERENCES `atributos_rol` (`atributo_id`),
  CONSTRAINT `FK_atributos_entidad_2` FOREIGN KEY (`entidad_id`) REFERENCES `entidad_externa` (`entidad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Atributos asociados a la entidad';

--
-- Dumping data for table `infraestructuraBKP`.`atributos_entidad`
--

/*!40000 ALTER TABLE `atributos_entidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `atributos_entidad` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`atributos_rol`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`atributos_rol`;
CREATE TABLE  `infraestructuraBKP`.`atributos_rol` (
  `atributo_id` int(15) unsigned NOT NULL auto_increment COMMENT 'Identificación única de atributo de entidad',
  `nombre` varchar(90) NOT NULL COMMENT 'Nombre único de atributo para entidad',
  `descripcion` varchar(255) default NULL COMMENT 'Descripción del atributo',
  `observaciones` varchar(255) default NULL COMMENT 'Observaciones. Comentarios sobre la definición del atributo',
  `rol` char(4) default NULL,
  `desde` date NOT NULL COMMENT 'fecha de vigencia del atributo',
  `hasta` date default NULL COMMENT 'Indica hasta que fecha el atributo está vigente',
  `clave` char(1) NOT NULL default 'F',
  `anulado` char(1) NOT NULL default 'F' COMMENT 'Indica si el registro está anulado: baja lógica',
  `obligatorio` char(1) NOT NULL default 'F' COMMENT 'Indica si el atributo es obligatorio',
  `tipo_dato` enum('entero','real','texto','fecha','logico') NOT NULL default 'texto' COMMENT 'Indica el tipo de dato del atributo',
  `lov` varchar(255) default NULL COMMENT 'Lista de valores asociada al atributo. Nulo sin lista',
  `validador` varchar(255) default NULL COMMENT 'Rutina de validación asociada al atributo. Nulo implica sin validación',
  `clase_atributo_rol_id` int(15) unsigned default NULL,
  `nombre_objeto` varchar(45) default NULL COMMENT 'Nombre del objeto de la aplicacin',
  `tipo_objeto` varchar(15) default NULL COMMENT 'tipo del objeto (TABLA, VISTA, PROGRAMA, INDICE, etc.)',
  PRIMARY KEY  (`atributo_id`),
  KEY `rol` (`rol`),
  KEY `clase_atributo_rol_id` (`clase_atributo_rol_id`),
  KEY `tipo_objeto` (`tipo_objeto`,`nombre_objeto`),
  CONSTRAINT `FK_atributos_rol_3` FOREIGN KEY (`tipo_objeto`, `nombre_objeto`) REFERENCES `diccionario_aplicacion` (`tipo_objeto`, `nombre_objeto`),
  CONSTRAINT `FK_clase_atributo_rol_1` FOREIGN KEY (`rol`) REFERENCES `rol_entidad` (`rol`),
  CONSTRAINT `FK_clase_atributo_rol_2` FOREIGN KEY (`clase_atributo_rol_id`) REFERENCES `clase_atributo_rol` (`clase_atributo_rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Define atributos y sus características para cada rol asociad';

--
-- Dumping data for table `infraestructuraBKP`.`atributos_rol`
--

/*!40000 ALTER TABLE `atributos_rol` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`atributos_rol` (`atributo_id`,`nombre`,`descripcion`,`observaciones`,`rol`,`desde`,`hasta`,`clave`,`anulado`,`obligatorio`,`tipo_dato`,`lov`,`validador`,`clase_atributo_rol_id`,`nombre_objeto`,`tipo_objeto`) VALUES 
 (1,'OJOS','Color de Ojos',NULL,NULL,'2007-01-01',NULL,'','','F','texto',NULL,NULL,NULL,NULL,NULL),
 (2,'PELO',NULL,NULL,NULL,'2007-01-01',NULL,'','','V','texto',NULL,NULL,1,NULL,NULL),
 (3,'ATR1','atributo 1',NULL,'CLIE','2007-01-01',NULL,'','F','F','entero',NULL,NULL,NULL,NULL,NULL),
 (4,'ATR2','Otro atributo',NULL,NULL,'2007-01-01',NULL,'','','F','entero',NULL,NULL,NULL,NULL,NULL),
 (5,'ATR3','Atributo 3 de proveedor',NULL,'PROV','2007-01-01',NULL,'','F','V','texto',NULL,NULL,1,NULL,NULL),
 (6,'TIPO','Tipo de proyecto',NULL,NULL,'2007-01-01',NULL,'','','V','texto',NULL,NULL,NULL,'proyectos','TABLA');
/*!40000 ALTER TABLE `atributos_rol` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`audita_estados_circuitos`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`audita_estados_circuitos`;
CREATE TABLE  `infraestructuraBKP`.`audita_estados_circuitos` (
  `audita_id` int(15) unsigned NOT NULL auto_increment COMMENT 'Identificación única del registro de auditoría',
  `circuito` varchar(4) NOT NULL COMMENT 'Circuito asociado al cambio de estado',
  `fecha` datetime NOT NULL COMMENT 'Fecha y hora en que se realiza la acción .Timestamp',
  `accion` int(10) unsigned NOT NULL COMMENT 'Acción que provoca (dispara) el cambio de estado',
  `de_estado` varchar(15) NOT NULL COMMENT 'Estado de origen inicial antes del cambio',
  `a_estado` varchar(15) NOT NULL COMMENT 'Estado destino, despues del cambio de estado',
  `user_id` int(10) unsigned NOT NULL COMMENT 'Usuario que realizó el cambio de estado',
  `clave_primaria` int(15) unsigned NOT NULL COMMENT 'Identificación de la clave primarai (ID) de la tabla donde se realiza el cambio. Objeto de la aplicación',
  `host` varchar(30) default NULL COMMENT 'equipo desde donde se realiza la acción. identificación de la máquina',
  PRIMARY KEY  (`audita_id`),
  KEY `circuito` (`circuito`),
  KEY `de_estado` (`de_estado`),
  KEY `a_estado` (`a_estado`),
  KEY `user_id` (`user_id`),
  KEY `accion` (`accion`),
  KEY `IX_audita_estados_circuitos_2` (`clave_primaria`,`circuito`),
  CONSTRAINT `FK_audita_estados_circuitos_1` FOREIGN KEY (`circuito`) REFERENCES `circuitos_estados` (`circuito`),
  CONSTRAINT `FK_audita_estados_circuitos_3` FOREIGN KEY (`de_estado`) REFERENCES `estados` (`estado`),
  CONSTRAINT `FK_audita_estados_circuitos_4` FOREIGN KEY (`a_estado`) REFERENCES `estados` (`estado`),
  CONSTRAINT `FK_audita_estados_circuitos_5` FOREIGN KEY (`user_id`) REFERENCES `website_user` (`user_id`),
  CONSTRAINT `FK_audita_estados_circuitos_6` FOREIGN KEY (`accion`) REFERENCES `acciones_apps` (`accion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Registra toda la auditoría y los cambios históricos para tod';

--
-- Dumping data for table `infraestructuraBKP`.`audita_estados_circuitos`
--

/*!40000 ALTER TABLE `audita_estados_circuitos` DISABLE KEYS */;
/*!40000 ALTER TABLE `audita_estados_circuitos` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`circuitos_estados`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`circuitos_estados`;
CREATE TABLE  `infraestructuraBKP`.`circuitos_estados` (
  `circuito` varchar(4) NOT NULL,
  `nombre` varchar(90) NOT NULL,
  `descripcion` varchar(255) default NULL,
  `observaciones` varchar(255) default NULL,
  PRIMARY KEY  (`circuito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`circuitos_estados`
--

/*!40000 ALTER TABLE `circuitos_estados` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`circuitos_estados` (`circuito`,`nombre`,`descripcion`,`observaciones`) VALUES 
 ('0001','Proyectos','Circuito para la administración de proyectos',NULL),
 ('0002','Presupuestos','Circuito para la administración de presupuestos',NULL),
 ('0003','Partes de MO','Circuito para la gestión de partes de mano de obra',NULL),
 ('0004','Lotes de partes de mano de obra','Administra el circuito grupalmente para varios partes',NULL);
/*!40000 ALTER TABLE `circuitos_estados` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`clase_atributo_rol`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`clase_atributo_rol`;
CREATE TABLE  `infraestructuraBKP`.`clase_atributo_rol` (
  `clase_atributo_rol_id` int(15) unsigned NOT NULL auto_increment COMMENT 'Identificación única para la clase de atributo',
  `etiqueta` varchar(90) NOT NULL COMMENT 'Etiqueta que le corresponde a la clase de atributos',
  PRIMARY KEY  (`clase_atributo_rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Permite agrupar atributos y de esta forma clasificarlos. Com';

--
-- Dumping data for table `infraestructuraBKP`.`clase_atributo_rol`
--

/*!40000 ALTER TABLE `clase_atributo_rol` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`clase_atributo_rol` (`clase_atributo_rol_id`,`etiqueta`) VALUES 
 (1,'Domicilio');
/*!40000 ALTER TABLE `clase_atributo_rol` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`diccionario_aplicacion`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`diccionario_aplicacion`;
CREATE TABLE  `infraestructuraBKP`.`diccionario_aplicacion` (
  `tipo_objeto` varchar(15) NOT NULL default '' COMMENT 'tipo del objeto (TABLA, VISTA, PROGRAMA, INDICE, etc.)',
  `nombre_objeto` varchar(45) NOT NULL default '' COMMENT 'Nombre del objeto de la aplicacin',
  PRIMARY KEY  (`tipo_objeto`,`nombre_objeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Permite guardar nombres de objetos usados en la aplicacin, t';

--
-- Dumping data for table `infraestructuraBKP`.`diccionario_aplicacion`
--

/*!40000 ALTER TABLE `diccionario_aplicacion` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`diccionario_aplicacion` (`tipo_objeto`,`nombre_objeto`) VALUES 
 ('TABLA','informe_devolucion'),
 ('TABLA','legajos_presentacion_delegacion'),
 ('TABLA','log_validacion_partes_mo'),
 ('TABLA','lote_carga_partes_mo'),
 ('TABLA','partes_mo'),
 ('TABLA','proyectos'),
 ('TABLA','tramites_recup_csyv');
/*!40000 ALTER TABLE `diccionario_aplicacion` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`diccionario_aplicacion_detalle`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`diccionario_aplicacion_detalle`;
CREATE TABLE  `infraestructuraBKP`.`diccionario_aplicacion_detalle` (
  `tipo_objeto` varchar(15) NOT NULL default '' COMMENT 'Tipo Objeto. Relaciona al objeto',
  `nombre_objeto` varchar(45) NOT NULL default '' COMMENT 'Nombre del objeto. relaciona al objeto',
  `tipo_detalle` varchar(15) NOT NULL default '' COMMENT 'Tipo del detalle: (COLUMNA, CAMPO, etc.)',
  `nombre_detalle` varchar(45) NOT NULL default '' COMMENT 'Nombre del detalle del objeto. Por ejemplo nombre de la columna de una tabla',
  PRIMARY KEY  (`tipo_objeto`,`nombre_objeto`,`tipo_detalle`,`nombre_detalle`),
  CONSTRAINT `FK_diccionario_aplicacion_detalle_1` FOREIGN KEY (`tipo_objeto`, `nombre_objeto`) REFERENCES `diccionario_aplicacion` (`tipo_objeto`, `nombre_objeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Detalle de un objeto de la aplicacin. En el caso de tabla, s';

--
-- Dumping data for table `infraestructuraBKP`.`diccionario_aplicacion_detalle`
--

/*!40000 ALTER TABLE `diccionario_aplicacion_detalle` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`diccionario_aplicacion_detalle` (`tipo_objeto`,`nombre_objeto`,`tipo_detalle`,`nombre_detalle`) VALUES 
 ('TABLA','informe_devolucion','COLUMNA','estado'),
 ('TABLA','informe_devolucion','COLUMNA','estado_escuela'),
 ('TABLA','informe_devolucion','COLUMNA','estado_recup_csyv'),
 ('TABLA','legajos_presentacion_delegacion','COLUMNA','estado'),
 ('TABLA','log_validacion_partes_mo','COLUMNA','estado'),
 ('TABLA','lote_carga_partes_mo','COLUMNA','estado'),
 ('TABLA','partes_mo','COLUMNA','estado'),
 ('TABLA','proyectos','COLUMNA','estado'),
 ('TABLA','tramites_recup_csyv','COLUMNA','estado');
/*!40000 ALTER TABLE `diccionario_aplicacion_detalle` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`entidad_externa`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`entidad_externa`;
CREATE TABLE  `infraestructuraBKP`.`entidad_externa` (
  `entidad_id` int(15) unsigned NOT NULL auto_increment,
  `codigo` varchar(15) default NULL COMMENT 'Código externo que identifica a la entidad',
  `nombre` varchar(90) NOT NULL,
  `descripcion` varchar(255) default NULL COMMENT 'Descripción de la entidad',
  `observaciones` varchar(255) default NULL COMMENT 'Observaciones. Comentarios sobre la entidad',
  `activo` char(1) NOT NULL default 'F' COMMENT 'Indica si la entidad está activa. Sólo entidades activas son permitidas usar. Activar garantiza las reglas de nogocio asociadas a los atributos y roles',
  `anulado` char(1) NOT NULL default 'F' COMMENT 'Indica si la entidad está nulada. Baja lógica',
  PRIMARY KEY  (`entidad_id`),
  KEY `UQ_entidad_externa_2` (`nombre`),
  KEY `UQ_entidad_externa_1` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Representa cualquier tipo de ntidad externa a la empresa: Cl';

--
-- Dumping data for table `infraestructuraBKP`.`entidad_externa`
--

/*!40000 ALTER TABLE `entidad_externa` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`entidad_externa` (`entidad_id`,`codigo`,`nombre`,`descripcion`,`observaciones`,`activo`,`anulado`) VALUES 
 (1,'0001','FABRI S.A.',NULL,NULL,'V','F'),
 (2,'0002','WEB-DB',NULL,NULL,'V','F'),
 (3,'0003','CONSTRUIR',NULL,NULL,'V','F');
/*!40000 ALTER TABLE `entidad_externa` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`estados`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`estados`;
CREATE TABLE  `infraestructuraBKP`.`estados` (
  `estado` varchar(15) NOT NULL,
  `nombre` varchar(90) NOT NULL,
  `descripcion` varchar(255) default NULL,
  `observaciones` varchar(255) default NULL,
  `circuito` varchar(15) NOT NULL,
  PRIMARY KEY  (`estado`),
  KEY `circuito` (`circuito`),
  KEY `uq_estados_nombre` (`nombre`,`circuito`),
  CONSTRAINT `FK_estados_1` FOREIGN KEY (`circuito`) REFERENCES `circuitos_estados` (`circuito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`estados`
--

/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`estados` (`estado`,`nombre`,`descripcion`,`observaciones`,`circuito`) VALUES 
 ('0001.0001','Generado',NULL,NULL,'0001'),
 ('0001.0002','Completo',NULL,NULL,'0001'),
 ('0001.0003','Aprobado',NULL,NULL,'0001'),
 ('0001.0004','Terminado',NULL,NULL,'0001'),
 ('0001.0005','Finalizado',NULL,NULL,'0001'),
 ('0001.0098','Cancelado',NULL,NULL,'0001'),
 ('0001.0099','Anulado',NULL,NULL,'0001'),
 ('0003.0001','Generado',NULL,NULL,'0003'),
 ('0003.0002','Loteado','El parte es asignado a un Lote',NULL,'0003'),
 ('0003.0003','Válido','El parte ha sido validado y está ok',NULL,'0003'),
 ('0003.0004','Inválido','El parte ha sido validado y está con errores',NULL,'0003'),
 ('0003.0005','Firmado','El parte está validado finalmente por el supervisor','este es el estado final','0003'),
 ('0003.0006','Re-Loteado','El parte estaba en un lote y ha sido reloteado. Debe pasar por los controles nuevamente',NULL,'0003'),
 ('0003.0099','Anulado','El parte a sido anulado y no se debe tener en cuenta para su contabilización',NULL,'0003'),
 ('0004.0001','Generado','El lote NO contiene partes',NULL,'0004');
INSERT INTO `infraestructuraBKP`.`estados` (`estado`,`nombre`,`descripcion`,`observaciones`,`circuito`) VALUES 
 ('0004.0002','Loteando','El lote contiene  partes en estado loteado o re-loteado',NULL,'0004'),
 ('0004.0003','Validando','El lote contiene partes en estado válido o inválido',NULL,'0004'),
 ('0004.0004','Firmado','El lote contiene todos los partes en estado firmado','estado final','0004'),
 ('0004.0099','Anulado','El lote está anulado y no contiene ningún parte asignado',NULL,'0004');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`feriados`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`feriados`;
CREATE TABLE  `infraestructuraBKP`.`feriados` (
  `feriado` date NOT NULL,
  PRIMARY KEY  (`feriado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`feriados`
--

/*!40000 ALTER TABLE `feriados` DISABLE KEYS */;
/*!40000 ALTER TABLE `feriados` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`menu`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`menu`;
CREATE TABLE  `infraestructuraBKP`.`menu` (
  `menu_id` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(90) NOT NULL default '',
  `descripcion` varchar(255) default NULL,
  `url` varchar(255) default NULL,
  `grupo` varchar(90) NOT NULL default '',
  PRIMARY KEY  (`menu_id`),
  KEY `grupo_IDX` (`grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`menu`
--

/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`menu` (`menu_id`,`nombre`,`descripcion`,`url`,`grupo`) VALUES 
 (10,'Administración','Menu de administración de la aplicación','Administracion','HomePage'),
 (20,'Proyectos','Adminsitración de proyectos','AdministracionProyectos','HomePage'),
 (30,'Presupuestos','Administración de presupuestos','AdministracionPresupuestos','HomePage'),
 (40,'Partes de MO','Administración de partes de mano de obra','MenuPartesMO','HomePage'),
 (1010,'Administra Usuarios','Administración de usuarios de la aplicacion','Usuarios','Administracion'),
 (1020,'Administra Menues','Administración de menues de la aplicacion','Menues','Administracion'),
 (1030,'Administra Aplicación','Configuración de la aplicación','ConfigAplicacion','Administracion'),
 (2010,'Configurar','Administración y Configuración de proyectos','ConfigurarProyectos','AdministracionProyectos'),
 (2020,'Crear proyecto','Crear nuevos proyectos. En blanco o a partir de Plantillas','CrearProyecto','AdministracionProyectos'),
 (2025,'Consultar Proyectos','Busca, consulta y edita proyectos existentes','ConsultaProyectos','AdministracionProyectos');
INSERT INTO `infraestructuraBKP`.`menu` (`menu_id`,`nombre`,`descripcion`,`url`,`grupo`) VALUES 
 (2030,'Crear Presupuesto','Permite crear un presupuesto basado en la estructura de un proyecto y vincularlo','CrearPresupuestoViaProyecto','AdministracionProyectos'),
 (2040,'Administrar Proyecto','Permite realizar las operaciones necesarias sobre un proyecto','AdministrarProyecto','AdministracionProyectos'),
 (3010,'Configurar','Configuración de presupuestos','ConfigurarPresupuetos','AdministracionPresupuestos'),
 (3020,'Crear Presupuesto','Crear un presupuesto nuevo','CrearPresupuesto','AdministracionPresupuestos'),
 (3030,'Administrar Presupuesto','Adminsitra y gestiona la operación de presupuestos','AdministrarPresupuesto','AdministracionPresupuestos'),
 (3040,'Asignar a Proyecto','Asigna el presupuesto a un proyecto existente o crea el proyecto a partir del pesupuesto','AsignarPresupuestoAProyecto','AdministracionPresupuestos'),
 (4010,'Configurar','Configuración de partes de mano de obra','MenuConfigurarPartes','MenuPartesMO'),
 (4020,'Cargar Partes','Cargar partes de mano de Obra','CargarPartesPlano','MenuPartesMO');
INSERT INTO `infraestructuraBKP`.`menu` (`menu_id`,`nombre`,`descripcion`,`url`,`grupo`) VALUES 
 (4030,'Gestión Partes','Gestiona partes de mano de obra','AdmLotesPartes','MenuPartesMO'),
 (4040,'Consulta Partes','Consulta y Edita Partes de Mano de Obra','ConsultaPartes','MenuPartesMO'),
 (4050,'Resumir Horas','Resume las horas por quincena por legajo de un período','ResumirHoras','MenuPartesMO'),
 (101010,'Roles','Altas/Bajas/Modificaciones/Consultas de Roles de la aplicación','AbmcRoles','Usuarios'),
 (101020,'Usuarios','Altas/Bajas/Modificaciones/Consultas de Usuarios de la aplicación','AbmcUsuarios','Usuarios'),
 (102010,'Menu','ABMC de menues de la aplicación','AbmcMenues','Menues'),
 (102020,'Acceso','Define acceso a los usuarios para los menues','AbmcAccesoMenu','Menues'),
 (103010,'Diccionario Aplicación','Describe objetos de la aplicación','AbmcDiccionarioAplicacion','ConfigAplicacion'),
 (103020,'Detalle Diccionario','Detalle (í­tems) de un objeto de la aplicación','AbmcDiccionarioAplicacionDetalle','ConfigAplicacion'),
 (103030,'Circuitos Administrativos','Definición de los distintos circuitos y sus estados posibles','AbmcCircuitosEstados','ConfigAplicacion');
INSERT INTO `infraestructuraBKP`.`menu` (`menu_id`,`nombre`,`descripcion`,`url`,`grupo`) VALUES 
 (103040,'Acciones Circuito','DefiniciÃ³n de todas las acciones permitidas en un circuito administrativo','AbmcAccionesCircuito','ConfigAplicacion'),
 (103050,'Aplica Acción','Asociación de una acción con la columna (objeto) que la representa','AbmcAplicaCircuito','ConfigAplicacion'),
 (103060,'Transición Estados','Configura el Workflow de estados para un circuito','AbmcTransicionEstados','ConfigAplicacion'),
 (103070,'Entidades Externas','Configura y administra el uso de entidades externas','ConfigEntidadesExternas','ConfigAplicacion'),
 (201005,'Atributos','Altas, Bajas, Modificaciones y Consultas de Atributos para ser usados en proyectos','AbmcAtributoProyecto','ConfigurarProyectos'),
 (201010,'Actividades','Altas, Bajas, Modificaciones y Consultas de Actividades asociadas a los proyectos','AbmcActividades','ConfigurarProyectos'),
 (201020,'Clases de Tareas','Altas, bajas, Modificaciones y Consultas de Clases de tareas','AbmcClasesTarea','ConfigurarProyectos'),
 (201030,'Plantillas','Altas, Bajas, Modificaciones y Consultas de Plantilals de Proyectos','AbmcPlantillaProyecto','ConfigurarProyectos');
INSERT INTO `infraestructuraBKP`.`menu` (`menu_id`,`nombre`,`descripcion`,`url`,`grupo`) VALUES 
 (301010,'Rubros','Altas, Bajas, Modificaciones y Consultas de rubros asignables a proyectos','AbmcRubros','ConfigurarPresupuetos'),
 (401010,'Validaciones','Altas, Bajas, Modificaciones y Consultas de Validaciones de partes','AbmcValidacionesPartes','MenuConfigurarPartes'),
 (401020,'Sectores','Sectores de trabajo donde se desempeña el personal de infa','AbmcSectorTrabajo','MenuConfigurarPartes'),
 (401030,'Supervisores','Altas, Bajas, Modificaciones y Consultas de Supervisores','AbmcSupervisores','MenuConfigurarPartes'),
 (10307010,'Clase Atributos','Altas, Bajas, Modificaciones y Consultas de Clases de Atributos de entidades','AbmcClaseAtributoRol','ConfigEntidadesExternas'),
 (10307015,'Atributos Genéricos','Altas, Bajas, Modificaciones y Consultas de atributos Genérico aplicables a todos lo sroles de entidades','AbmcAtributoGenerico','ConfigEntidadesExternas'),
 (10307020,'Rol Entidad','Altas, Bajas, Modificaciones y Consultas de Roles para entidades externas','AbmcRolEntidad','ConfigEntidadesExternas'),
 (10307030,'Entidad Externa','Altas, Bajas, Modificaciones y Consultas de entidades externas (clientes, proveedores, etc)','AbmcEntidadExterna','ConfigEntidadesExternas');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`preferencias`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`preferencias`;
CREATE TABLE  `infraestructuraBKP`.`preferencias` (
  `preferencia_id` int(10) unsigned NOT NULL default '0',
  `nombre` varchar(90) NOT NULL default '',
  `descripcion` varchar(255) default NULL,
  `observaciones` varchar(255) default NULL,
  `default` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`preferencia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`preferencias`
--

/*!40000 ALTER TABLE `preferencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferencias` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`rol_entidad`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`rol_entidad`;
CREATE TABLE  `infraestructuraBKP`.`rol_entidad` (
  `rol` char(4) NOT NULL,
  `nombre` varchar(90) NOT NULL COMMENT 'nombre del rol de entidad',
  `descripcion` varchar(255) default NULL COMMENT 'Descripción del rol de entidad',
  `observaciones` varchar(255) default NULL COMMENT 'Observaciones. Comentarios sobre el rol de la entidad',
  `desde` date NOT NULL COMMENT 'Fecha de vigencia del rol de entidad',
  `hasta` date default NULL COMMENT 'Fecha hasta donde está vigente el rol de entidad',
  `anulado` char(1) NOT NULL default 'F' COMMENT 'Indica si el registro está anulado. Baja lógica',
  PRIMARY KEY  (`rol`),
  KEY `UQ_rol_entidad_1` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Permite definir distintos roles (y comportamiento) para una ';

--
-- Dumping data for table `infraestructuraBKP`.`rol_entidad`
--

/*!40000 ALTER TABLE `rol_entidad` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`rol_entidad` (`rol`,`nombre`,`descripcion`,`observaciones`,`desde`,`hasta`,`anulado`) VALUES 
 ('CLIE','CLIENTE','Rol de cliente para entidad externa',NULL,'2007-01-01',NULL,'F'),
 ('PROV','PROVEEDOR','Rol de proveedor para entidad externa',NULL,'2007-01-01',NULL,'F');
/*!40000 ALTER TABLE `rol_entidad` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`roles`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`roles`;
CREATE TABLE  `infraestructuraBKP`.`roles` (
  `rol_id` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(90) NOT NULL default '',
  `descripcion` varchar(255) default NULL,
  `observaciones` varchar(255) default NULL,
  PRIMARY KEY  (`rol_id`),
  UNIQUE KEY `IX_roles_1` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`roles`
--

/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`roles` (`rol_id`,`nombre`,`descripcion`,`observaciones`) VALUES 
 (1,'ADMINISTRADOR','Adminsitrador de la aplicación','en general tiene acceso a todos los recursos y datos de laaplicación'),
 (2,'USUARIOS','Usuario general de la aplicación',NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`roles_entidad`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`roles_entidad`;
CREATE TABLE  `infraestructuraBKP`.`roles_entidad` (
  `desde` date NOT NULL COMMENT 'Fecha desde cuando está activo en el rol',
  `hasta` date default NULL COMMENT 'Hasta que fecha está activo en el rol',
  `activo` char(1) NOT NULL default 'F' COMMENT 'Indica si el rol est''aactivo, sino no es considerado. Activar garantiza reglas para atributos',
  `anulado` char(1) NOT NULL default 'F' COMMENT 'Indica que el registro est''aanulado. Baja lógica',
  `entidad_id` int(15) unsigned NOT NULL,
  `rol` char(4) NOT NULL,
  PRIMARY KEY  (`entidad_id`,`rol`),
  KEY `entidad_id` (`entidad_id`),
  KEY `rol` (`rol`),
  CONSTRAINT `FK_roles_entidad_1` FOREIGN KEY (`entidad_id`) REFERENCES `entidad_externa` (`entidad_id`),
  CONSTRAINT `FK_roles_entidad_2` FOREIGN KEY (`rol`) REFERENCES `rol_entidad` (`rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Roles asociados a la entidad.';

--
-- Dumping data for table `infraestructuraBKP`.`roles_entidad`
--

/*!40000 ALTER TABLE `roles_entidad` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`roles_entidad` (`desde`,`hasta`,`activo`,`anulado`,`entidad_id`,`rol`) VALUES 
 ('2007-01-01',NULL,'V','F',1,'CLIE'),
 ('2207-01-01',NULL,'V','F',1,'PROV'),
 ('2007-01-01',NULL,'V','F',2,'PROV'),
 ('2007-01-01',NULL,'V','F',3,'PROV');
/*!40000 ALTER TABLE `roles_entidad` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`sequence`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`sequence`;
CREATE TABLE  `infraestructuraBKP`.`sequence` (
  `seq_type` varchar(25) NOT NULL default '0',
  `seq_id` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`seq_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`sequence`
--

/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`sequence` (`seq_type`,`seq_id`) VALUES 
 ('infdev',89);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`transicion_estados`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`transicion_estados`;
CREATE TABLE  `infraestructuraBKP`.`transicion_estados` (
  `estado_origen` varchar(15) NOT NULL,
  `accion` int(10) unsigned NOT NULL default '0',
  `estado_destino` varchar(15) NOT NULL,
  `prompt_accion` varchar(30) default NULL,
  `validador` varchar(255) default NULL,
  PRIMARY KEY  (`accion`,`estado_origen`),
  KEY `accion` (`accion`),
  KEY `estado_destino` (`estado_destino`),
  KEY `estado_origen` (`estado_origen`),
  CONSTRAINT `FK_transicion_estados_1` FOREIGN KEY (`accion`) REFERENCES `acciones_apps` (`accion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transicion_estados_destino` FOREIGN KEY (`estado_destino`) REFERENCES `estados` (`estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transicion_estados_origen` FOREIGN KEY (`estado_origen`) REFERENCES `estados` (`estado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`transicion_estados`
--

/*!40000 ALTER TABLE `transicion_estados` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`transicion_estados` (`estado_origen`,`accion`,`estado_destino`,`prompt_accion`,`validador`) VALUES 
 ('0001.0001',3,'0001.0002','Completo',NULL),
 ('0001.0002',4,'0001.0003','Comenzar',NULL),
 ('0003.0001',5,'0003.0002','Lotear','No Validar'),
 ('0004.0001',6,'0004.0002','Lotear','No Validar'),
 ('0004.0002',7,'0004.0003','Validar','No Validar'),
 ('0004.0003',8,'0004.0004','Firmar','No Validar'),
 ('0004.0001',9,'0004.0099','Anular','No Validar'),
 ('0004.0002',9,'0004.0099','Anular','No Validar'),
 ('0004.0003',9,'0004.0099','Anular','No Validar'),
 ('0003.0003',10,'0003.0006','Re-Lotear','No Validar'),
 ('0003.0004',10,'0003.0006','Re-Lotear','No Validar'),
 ('0003.0002',11,'0003.0003','Validar','No Validar'),
 ('0003.0006',11,'0003.0003','Validar','No Validar'),
 ('0003.0003',12,'0003.0005','Firmar','No Validar'),
 ('0003.0004',12,'0003.0005','Firmar','No Validar'),
 ('0003.0001',13,'0003.0099','Anular','No Validar'),
 ('0003.0002',13,'0003.0099','Anular','No Validar'),
 ('0003.0003',13,'0003.0099','Anular','No Validar');
INSERT INTO `infraestructuraBKP`.`transicion_estados` (`estado_origen`,`accion`,`estado_destino`,`prompt_accion`,`validador`) VALUES 
 ('0003.0004',13,'0003.0099','Anular','No Validar'),
 ('0003.0006',13,'0003.0099','Anular','No Validar');
/*!40000 ALTER TABLE `transicion_estados` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`usuario_preferencias`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`usuario_preferencias`;
CREATE TABLE  `infraestructuraBKP`.`usuario_preferencias` (
  `user_id` int(10) unsigned NOT NULL default '0',
  `preferencia_id` int(10) unsigned NOT NULL default '0',
  `valor` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`preferencia_id`,`user_id`),
  KEY `FK_usuario_preferencias_2` (`user_id`),
  CONSTRAINT `FK_usuario_preferencias_2` FOREIGN KEY (`user_id`) REFERENCES `website_user` (`user_id`),
  CONSTRAINT `preferencia_FK` FOREIGN KEY (`preferencia_id`) REFERENCES `preferencias` (`preferencia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`usuario_preferencias`
--

/*!40000 ALTER TABLE `usuario_preferencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_preferencias` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`usuario_roles`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`usuario_roles`;
CREATE TABLE  `infraestructuraBKP`.`usuario_roles` (
  `user_id` int(10) unsigned NOT NULL default '0',
  `rol_id` int(10) unsigned NOT NULL default '0',
  `desde` date NOT NULL default '0000-00-00',
  `hasta` date default NULL,
  `anulado` char(1) NOT NULL default 'F',
  PRIMARY KEY  (`rol_id`,`user_id`),
  KEY `FK_usuario_roles_2` (`user_id`),
  CONSTRAINT `FK_usuario_roles_1` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`rol_id`),
  CONSTRAINT `FK_usuario_roles_2` FOREIGN KEY (`user_id`) REFERENCES `website_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`usuario_roles`
--

/*!40000 ALTER TABLE `usuario_roles` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`usuario_roles` (`user_id`,`rol_id`,`desde`,`hasta`,`anulado`) VALUES 
 (6,1,'2007-01-01',NULL,'F'),
 (7,1,'2007-01-01',NULL,'F'),
 (8,1,'2007-01-01',NULL,'F'),
 (6,2,'2007-01-01',NULL,'F'),
 (8,2,'2007-01-01',NULL,'F');
/*!40000 ALTER TABLE `usuario_roles` ENABLE KEYS */;


--
-- Definition of table `infraestructuraBKP`.`website_user`
--

DROP TABLE IF EXISTS `infraestructuraBKP`.`website_user`;
CREATE TABLE  `infraestructuraBKP`.`website_user` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `login_name` varchar(60) NOT NULL default '',
  `login_password` varchar(60) NOT NULL default '',
  `nivel_visibilidad` enum('Todo','Region','Escuela','Personal') NOT NULL default 'Todo',
  `nombre_completo` varchar(90) default NULL,
  `email` varchar(90) default NULL,
  `nro_legajo` int(11) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `infraestructuraBKP`.`website_user`
--

/*!40000 ALTER TABLE `website_user` DISABLE KEYS */;
INSERT INTO `infraestructuraBKP`.`website_user` (`user_id`,`login_name`,`login_password`,`nivel_visibilidad`,`nombre_completo`,`email`,`nro_legajo`) VALUES 
 (6,'demian','matumanu','Todo','Demian Barry','demian.barry@gmail.com',NULL),
 (7,'rpanigadi','rodolfo','Todo','Rodolfo Panigadi','rpanigado@infasa.com',NULL),
 (8,'nora','nora','Todo','Nora Bail','nora.bail@gmail.com',NULL);
/*!40000 ALTER TABLE `website_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
