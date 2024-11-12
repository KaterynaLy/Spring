CREATE DATABASE clinica_dental;
USE clinica_dental;
show tables;


-- Table `clinica_dental`.`paciente`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`paciente` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `telefono` VARCHAR(20) NULL DEFAULT NULL,
  `direccion` VARCHAR(255) NULL DEFAULT NULL,
  `fechaNacimiento` DATE NULL DEFAULT NULL,
  `genero` ENUM('M', 'F', 'Otro') NULL DEFAULT NULL,
  `origenCliente` ENUM('convenios', 'redes', 'grupon', 'BNI', 'otros', 'colegios', 'centro_de_mayores') NOT NULL,
  `fechaCreacion` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `documentoIdentidad` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC),
  INDEX `idx_nombre` (`nombre`),
  INDEX `idx_apellido` (`apellido`),
  INDEX `idx_telefono` (`telefono`)
);


-- Table `clinica_dental`.`financiacion`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`financiacion` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `montoTotal` DECIMAL(10,2) NOT NULL,
  `cuotas` INT NOT NULL,
  `montoCuota` DECIMAL(10,2) NOT NULL,
  `fechaInicio` DATE NULL DEFAULT NULL,
  `fechaFin` DATE NULL DEFAULT NULL,
  `metodoFinanciacion` ENUM('banco', 'clinica') NULL DEFAULT NULL,
  `interes` DECIMAL(5,2) NULL DEFAULT NULL,
  `idPaciente` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPaciente` (`idPaciente` ASC),
  CONSTRAINT `financiacion_ibfk_1`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `clinica_dental`.`paciente` (`id`)
    ON DELETE CASCADE
);


-- Table `clinica_dental`.`caja`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`caja` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `fechaPago` DATE NOT NULL,
  `monto` DECIMAL(10,2) NOT NULL,
  `metodoPago` ENUM('efectivo', 'tarjeta', 'financiado') NULL DEFAULT NULL,
  `financiador` VARCHAR(255) NULL DEFAULT NULL,
  `idPaciente` BIGINT NULL,
  `idFinanciacion` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPaciente` (`idPaciente` ASC),
  INDEX `idFinanciacion` (`idFinanciacion` ASC),
  CONSTRAINT `caja_ibfk_1`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `clinica_dental`.`paciente` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `caja_ibfk_2`
    FOREIGN KEY (`idFinanciacion`)
    REFERENCES `clinica_dental`.`financiacion` (`id`)
    ON DELETE SET NULL
);


-- Table `clinica_dental`.`tratamiento`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`tratamiento` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descripcion` TEXT NOT NULL,
  `fechaInicio` DATE NULL DEFAULT NULL,
  `fechaFin` DATE NULL DEFAULT NULL,
  `idPaciente` BIGINT NULL,
  `nombre` VARCHAR(150) NOT NULL,
  `presupuesto` DECIMAL(10,2) NOT NULL,
  `aprobado` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPaciente` (`idPaciente` ASC),
  CONSTRAINT `tratamiento_ibfk_1`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `clinica_dental`.`paciente` (`id`)
    ON DELETE CASCADE
);


-- Table `clinica_dental`.`documento`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`documento` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombreDocumento` VARCHAR(255) NOT NULL,
  `fechaFirma` DATE NULL DEFAULT NULL,
  `idPaciente` BIGINT NULL,
  `firmado` BIT(1) NULL DEFAULT NULL,
  `idTratamiento` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPaciente` (`idPaciente` ASC),
  INDEX `idTratamiento` (`idTratamiento` ASC),
  CONSTRAINT `documento_ibfk_1`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `clinica_dental`.`paciente` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `documento_ibfk_2`
    FOREIGN KEY (`idTratamiento`)
    REFERENCES `clinica_dental`.`tratamiento` (`id`)
    ON DELETE SET NULL
);


-- Table `clinica_dental`.`presupuesto`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`presupuesto` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descripcion` TEXT NOT NULL,
  `monto` DECIMAL(10,2) NOT NULL,
  `fechaCreacion` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `fechaAceptacion` DATE NULL DEFAULT NULL,
  `idPaciente` BIGINT NULL,
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idPaciente` (`idPaciente` ASC),
  CONSTRAINT `presupuesto_ibfk_1`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `clinica_dental`.`paciente` (`id`)
    ON DELETE CASCADE
);


-- Table `clinica_dental`.`rol`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`rol` (
  `idRol` BIGINT NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idRol`)
);


-- Table `clinica_dental`.`usuario`
CREATE TABLE IF NOT EXISTS `clinica_dental`.`usuario` (
  `idUsuario` BIGINT NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `idRol` BIGINT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `email` (`email` ASC),
  INDEX `idRol` (`idRol` ASC),
  CONSTRAINT `usuario_ibfk_1`
    FOREIGN KEY (`idRol`)
    REFERENCES `clinica_dental`.`rol` (`idRol`)
);
drop table cita;
CREATE TABLE cita (
    idCita BIGINT AUTO_INCREMENT PRIMARY KEY,
    idPaciente BIGINT, -- Relación con el paciente
    fechaCita DATETIME NOT NULL, -- Fecha y hora de la cita
    estado VARCHAR(20) DEFAULT 'Pendiente', -- Estado de la cita (Pendiente, Aprobada, Rechazada)
    notas TEXT, -- Notas adicionales
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idPaciente) REFERENCES paciente(id)
);

show tables;

SELECT 
    *
FROM
    caja;
SELECT 
    *
FROM
    documento;
SELECT 
    *
FROM
    financiacion;
SELECT 
    *
FROM
    paciente;
SELECT 
    *
FROM
    presupuesto;
SELECT 
    *
FROM
    rol;
SELECT 
    *
FROM
    tratamiento;
SELECT 
    *
FROM
    usuario; 
select * from cita;











