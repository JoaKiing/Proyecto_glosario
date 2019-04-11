CREATE DATABASE PROYECTO;
USE PROYECTO;

CREATE TABLE tipo_usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo INT
);

CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    run VARCHAR(15),
    pass VARCHAR(16),
    nombre VARCHAR(20),
    tipo_fk INT REFERENCES tipo_usuario (id)
);

CREATE TABLE palabra(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion VARCHAR(300),
    ejemplo VARCHAR(300),
    imagen VARCHAR(150)
);

CREATE TABLE usuario_palabra(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fk_usuario INT REFERENCES usuario(id),
    fk_palabra INT REFERENCES palabra(id)
);

CREATE TABLE asignatura(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
    
);

CREATE TABLE asignatura_palabra(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fk_palabra INT REFERENCES palabra(id),
    fk_asignatura INT REFERENCES asignatura(id)
);

CREATE TABLE sigla(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    definicion VARCHAR(300),
    fk_asignatura INT REFERENCES asignatura(id)
);