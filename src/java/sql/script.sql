CREATE DATABASE proyecto; -- DROP DATABASE proyecto
USE proyecto;

CREATE TABLE tipo_usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo INT
);


INSERT INTO tipo_usuario VALUES(NULL,1); #administrador
INSERT INTO tipo_usuario VALUES(NULL,2); #alumno

CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    run VARCHAR(15),
    pass VARCHAR(16),
    nombre VARCHAR(20),
    tipo_fk INT REFERENCES tipo_usuario (id)
);

INSERT INTO usuario VALUES(NULL,"11-1",'pass',"Arcangel",1); #admin
INSERT INTO usuario VALUES(NULL,"22-2",'pass',"Victor",2); #alumno

SELECT * FROM usuario

CREATE TABLE palabra(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion VARCHAR(300),
    ejemplo VARCHAR(300),
    imagen VARCHAR(600)
);

INSERT INTO palabra VALUES(NULL,'Planificacion','planear una accion','Planear la clase a ejecutar', 'https://image.slidesharecdn.com/planificaciondeeducacionparvularia2y3-091221200313-phpapp02/95/planificacion-de-educacion-parvularia-2-y-3-1-728.jpg?cb=1261425831');
INSERT INTO palabra VALUES(NULL,'Esfinter','Músculo en forma de anillo que cierra y abre la abertura de determinados conductos naturales del cuerpo','Un niño que no puede aguantarse las ganas de orinar','http://saludycuidadosdelparvulo.blogspot.com/2011/12/control-de-esfinter.html')

CREATE TABLE usuario_palabra(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fk_usuario INT REFERENCES usuario(id),
    fk_palabra INT REFERENCES palabra(id)
);

INSERT INTO usuario_palabra VALUES(NULL,1,1);
INSERT INTO usuario_palabra VALUES(NULL,2,2);

CREATE TABLE asignatura(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);

INSERT INTO asignatura VALUES(NULL,'matematicas');
INSERT INTO asignatura VALUES(NULL,'psicologia infantil');
INSERT INTO asignatura VALUES(NULL,'computacion basica');
INSERT INTO asignatura VALUES(NULL,'cantar como anuel');

CREATE TABLE asignatura_palabra(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fk_palabra INT REFERENCES palabra(id),
    fk_asignatura INT REFERENCES asignatura(id)
);

INSERT INTO asignatura_palabra VALUES(NULL,1,4);
INSERT INTO asignatura_palabra VALUES(NULL,2,2);

CREATE TABLE sigla(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    definicion VARCHAR(300),
    fk_asignatura INT REFERENCES asignatura(id)
);

INSERT INTO sigla VALUES(NULL,'CCCC','CACA CACA',1);
INSERT INTO sigla VALUES(NULL,'AAA','UNA PILA PAL CONTROL REMOTO',3);

CREATE TABLE sigla_usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fk_sigla INT REFERENCES sigla(id),
    fk_usuario INT REFERENCES usuario(id)
);

INSERT INTO sigla_usuario VALUES(NULL,1,1);
INSERT INTO sigla_usuario VALUES(NULL,2,2);


SELECT 	palabra.id, palabra.nombre, palabra.descripcion, palabra.ejemplo 
FROM 	palabra, usuario, usuario_palabra 
WHERE 	(usuario_palabra.fk_palabra = palabra.id AND usuario_palabra.fk_usuario = usuario.id)
AND 	usuario.id = 2

SELECT MAX(id) FROM palabra

SELECT COUNT(*) FROM palabra WHERE nombre LIKE '%java%'
