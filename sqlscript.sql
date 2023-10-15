CREATE DATABASE db_firebook;
USE db_firebook;

CREATE TABLE tb_admin(
cod_admin INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
senha VARCHAR(200) NOT NULL
);

CREATE TABLE tb_usuario(
cod_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
email VARCHAR(200) NOT NULL,
genero VARCHAR(200) NOT NULL,
senha VARCHAR(200) NOT NULL,
livros_fav VARCHAR(200),
cod_admin INT,
CONSTRAINT FK_admin_usuario FOREIGN KEY (cod_admin) REFERENCES tb_admin(cod_admin)
);

CREATE TABLE tb_livro(
cod_livro INT PRIMARY KEY AUTO_INCREMENT,
autor VARCHAR(200) NOT NULL,
nome VARCHAR(200) NOT NULL,
genero VARCHAR(200) NOT NULL,
cod_usuario INT,
CONSTRAINT FK_usuario_livro FOREIGN KEY (cod_usuario) REFERENCES tb_usuario(cod_usuario)
);

CREATE TABLE tb_votacao(
cod_votacao INT PRIMARY KEY AUTO_INCREMENT,
nota INT NOT NULL,
n_avaliacoes VARCHAR(200) NOT NULL,
cod_usuario INT,
cod_livro INT,
CONSTRAINT FK_usuario_votacao FOREIGN KEY (cod_usuario) REFERENCES tb_usuario(cod_usuario),
CONSTRAINT FK_livro_votacao FOREIGN KEY (cod_livro) REFERENCES tb_livro(cod_livro)
)


