SHOW DATABASES;

CREATE DATABASE livros;
USE livros;

CREATE TABLE titulos (
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    lancamento DATE NOT NULL,
    genero VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
SHOW TABLES;

INSERT INTO titulos (nome, lancamento, genero) VALUES ("Ossos", "2003/01/01", "Romance Policial");
SELECT * FROM titulos;

DELETE FROM titulos WHERE id="6";