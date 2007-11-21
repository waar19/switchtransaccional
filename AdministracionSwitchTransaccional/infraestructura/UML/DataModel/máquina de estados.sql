CREATE TABLE circuitos_estados (
       circuito VARCHAR(4) NOT NULL
     , nombre VARCHAR(90) NOT NULL
     , descripcion VARCHAR(255)
     , observaciones VARCHAR(255)
     , PRIMARY KEY (circuito)
)TYPE=InnoDB;

CREATE TABLE acciones_aplicacion (
       accion INT(10) NOT NULL AUTO_INCREMENT
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

CREATE TABLE estados (
       estado VARCHAR(15) NOT NULL
     , nombre VARCHAR(90) NOT NULL
     , descripcion VARCHAR(255)
     , observaciones VARCHAR(255)
     , circuito VARCHAR(15) NOT NULL
     , PRIMARY KEY (estado)
     , INDEX (circuito)
     , CONSTRAINT FK_estados_1 FOREIGN KEY (circuito)
                  REFERENCES circuitos_estados (circuito) ON DELETE NO ACTION ON UPDATE NO ACTION
)TYPE=InnoDB;
CREATE INDEX uq_estados_nombre ON estados (nombre ASC, circuito ASC);

CREATE TABLE aplica_circuito (
       tipo_objeto VARCHAR(15) NOT NULL
     , nombre_objeto VARCHAR(45) NOT NULL
     , tipo_detalle VARCHAR(15) NOT NULL
     , nombre_detalle VARCHAR(45) NOT NULL
     , circuito VARCHAR(4) NOT NULL
     , PRIMARY KEY (nombre_detalle, nombre_objeto, tipo_detalle, tipo_objeto)
     , INDEX (circuito)
     , CONSTRAINT FK_aplica_circuito_2 FOREIGN KEY (circuito)
                  REFERENCES circuitos_estados (circuito) ON DELETE NO ACTION ON UPDATE NO ACTION
)TYPE=InnoDB;

CREATE TABLE transicion_estados (
       estado_origen VARCHAR(15) NOT NULL
     , accion INT(10) NOT NULL DEFAULT 0
     , estado_destino VARCHAR(15) NOT NULL
     , prompt_accion VARCHAR(30)
     , validador VARCHAR(255)
     , PRIMARY KEY (accion, estado_origen)
     , INDEX (accion)
     , CONSTRAINT FK_transicion_estados_1 FOREIGN KEY (accion)
                  REFERENCES acciones_aplicacion (accion) ON DELETE NO ACTION ON UPDATE NO ACTION
     , INDEX (estado_destino)
     , CONSTRAINT fk_transicion_estados_destino FOREIGN KEY (estado_destino)
                  REFERENCES estados (estado) ON DELETE NO ACTION ON UPDATE NO ACTION
     , INDEX (estado_origen)
     , CONSTRAINT fk_transicion_estados_origen FOREIGN KEY (estado_origen)
                  REFERENCES estados (estado) ON DELETE NO ACTION ON UPDATE NO ACTION
)TYPE=InnoDB;

