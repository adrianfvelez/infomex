﻿CREATE TABLE comentarista(
	correo_com varchar(100) NOT NULL,
	usuario_com varchar(200) UNIQUE NOT NULL,
	contrasenia_com varchar(30) NOT NULL,
	CONSTRAINT "PK_comentarista" PRIMARY KEY (correo_com)
);

COMMENT ON TABLE comentarista IS 'Tabla que contiene la información relacionada con los comentaristas teniendo como llave primaria su correo electrónico.';

CREATE TABLE informador(
	correo_inf varchar(100) NOT NULL,
	usuario_inf varchar(200) UNIQUE NOT NULL,
	contrasenia_inf varchar(30) NOT NULL,
	CONSTRAINT "PK_informador" PRIMARY KEY (correo_inf)
);

COMMENT ON TABLE informador IS 'Tabla que contiene la información relacionada con los informadores y el administrador, teniendo como llave primaria su correo electrónico.';

CREATE TABLE tema(
	id_tema serial,
	nombre_tema varchar(100),
	correo_inf varchar(100),
	CONSTRAINT "PK_tema" PRIMARY KEY (id_tema),
	CONSTRAINT "FK_tema_informador" FOREIGN KEY (correo_inf) REFERENCES informador(correo_inf)
);

COMMENT ON TABLE tema IS 'Tabla que contiene toda la información de los temas.';

CREATE TABLE marcador(
	id_mar serial,
	id_tema int,
	correo_inf varchar(100),
	nombre_mar varchar(100),
	descripcion_mar varchar(200) NOT NULL,
	longitud double precision NOT NULL,
	latitud double precision NOT NULL,
	CONSTRAINT "PK_marcador" PRIMARY KEY (id_mar),
	CONSTRAINT "FK_marcador_tema" FOREIGN KEY (id_tema) REFERENCES tema(id_tema) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT "FK_marcador_informador" FOREIGN KEY (correo_inf) REFERENCES informador(correo_inf)
);

COMMENT ON TABLE marcador IS 'Tabla con la información de todos los marcadores.';

CREATE TABLE comentario(
	id_comentario serial,
	id_mar int,
	id_tema int,
	correo_com varchar(100),
	descripcion varchar(600),
	CONSTRAINT "PK_comentario" PRIMARY KEY (id_comentario),
	CONSTRAINT "FK_comentario_marcador" FOREIGN KEY (id_mar) REFERENCES marcador(id_mar) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT "FK_comentario_comentarista" FOREIGN KEY (correo_com) REFERENCES comentarista(correo_com) ON DELETE CASCADE ON UPDATE CASCADE
);

COMMENT ON TABLE comentario IS 'Tabla con la información de todos los comentarios.';

CREATE TABLE calificacion(
	id_califiacion serial,
	id_comentario int,
	correo_com varchar(100),
	calificacion int,
	CONSTRAINT "PK_calificacion" PRIMARY KEY (id_califiacion),
	CONSTRAINT "FK_calificacion_comentario" FOREIGN KEY (id_comentario) REFERENCES comentario(id_comentario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT "FK_calificacion_comentarista" FOREIGN KEY (correo_com) REFERENCES comentarista(correo_com) ON DELETE CASCADE ON UPDATE CASCADE
);

COMMENT ON TABLE calificacion IS 'Tabla con las calificaciones de los comentarios.';

INSERT INTO informador VALUES ('admin@admin.com','admin', 'nimda');



