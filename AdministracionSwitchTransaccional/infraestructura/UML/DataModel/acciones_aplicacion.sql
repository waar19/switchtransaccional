CREATE TABLE acciones_aplicacion (
       accion INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
     , nombre VARCHAR(90) NOT NULL
     , descripcion VARCHAR(255)
     , observaciones VARCHAR(255)
     , circuito VARCHAR(4) NOT NULL
     , PRIMARY KEY (accion)
     , INDEX (circuito)
     , CONSTRAINT FK_acciones_aplicacion_1 FOREIGN KEY (circuito)
                  REFERENCES circuitos_estados (circuito) ON DELETE NO ACTION ON UPDATE NO ACTION
)TYPE=InnoDB;
CREATE INDEX uq_acciones_aplicacion_circuito ON acciones_aplicacion (circuito ASC, nombre ASC);

