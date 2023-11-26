CREATE DATABASE db_firebook;
USE db_firebook;

-- DROP  DATABASE db_firebook;

CREATE TABLE tb_tipo_usuario(
id_tipo_usuario INT PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(10) NOT NULL
);

INSERT INTO `tb_tipo_usuario`(`id_tipo_usuario`, `descricao`) VALUES ('1','admin');
INSERT INTO `tb_tipo_usuario`(`id_tipo_usuario`, `descricao`) VALUES ('2','usuario');
-- SELECT * FROM tb_tipo_usuario;

CREATE TABLE tb_usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
login VARCHAR(20) NOT NULL UNIQUE,
senha VARCHAR(20) NOT NULL,
nome VARCHAR(30) NOT NULL,
idade INT,
genero VARCHAR(20),
id_tipo_usuario INT NOT NULL,
CONSTRAINT FK_usuario_tipo FOREIGN KEY (id_tipo_usuario) REFERENCES tb_tipo_usuario(id_tipo_usuario)
);

INSERT INTO tb_usuario (login, senha, nome, idade, genero, id_tipo_usuario) VALUES ('admin', 'admin', 'administrador', 20, 'masculino', 1); 
-- SELECT * FROM tb_usuario;

CREATE TABLE tb_genero(
id_genero INT PRIMARY KEY,
descricao VARCHAR(30)
);

INSERT INTO tb_genero (id_genero, descricao) VALUES ('1','romance');
INSERT INTO tb_genero (id_genero, descricao) VALUES ('2','ficção');
INSERT INTO tb_genero (id_genero, descricao) VALUES ('3','técnico');

-- SELECT * FROM tb_genero;

CREATE TABLE tb_livro(
id_livro INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(50) NOT NULL,
autor VARCHAR(50) NOT NULL,
id_genero INT NOT NULL,
id_usuario INT NOT NULL,
CONSTRAINT FK_livro_genero FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero),
CONSTRAINT FK_livro_usuario FOREIGN KEY (id_usuario ) REFERENCES tb_usuario(id_usuario)
);

-- SELECT * FROM tb_livro

CREATE TABLE tb_avaliacao(
id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
nota DOUBLE NOT NULL,
id_usuario INT NOT NULL,
id_livro INT NOT NULL,
CONSTRAINT FK_avaliacao_idlivro FOREIGN KEY (id_livro) REFERENCES tb_livro(id_livro),
CONSTRAINT FK_avaliacao_idusuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario)
);

-- SELECT * FROM tb_avaliacao;

CREATE TABLE tb_preferidos(
id_preferido INT PRIMARY KEY AUTO_INCREMENT,
id_usuario INT NOT NULL,
id_genero INT NOT NULL,
CONSTRAINT FK_preferido_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario),
CONSTRAINT FK_preferido_genero FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero)  
);

-- SELECT * FROM tb_preferidos;