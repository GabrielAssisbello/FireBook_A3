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

INSERT INTO tb_genero (id_genero, descricao) VALUES (1, 'romance');
INSERT INTO tb_genero (id_genero, descricao) VALUES (2, 'ficção');
INSERT INTO tb_genero (id_genero, descricao) VALUES (3, 'técnico');

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

INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro A','Autor A', 1, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro B','Autor B', 2, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro C','Autor C', 3, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro D','Autor D', 1, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro E','Autor E', 2, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro F','Autor F', 3, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro G','Autor G', 1, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro H','Autor H', 2, 1);
INSERT INTO tb_livro (titulo, autor, id_genero, id_usuario) VALUES ('Livro I','Autor I', 3, 1);

-- SELECT * FROM tb_livro;

CREATE TABLE tb_avaliacao(
id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
nota DOUBLE NOT NULL,
id_usuario INT NOT NULL,
id_livro INT NOT NULL,
CONSTRAINT FK_avaliacao_idlivro FOREIGN KEY (id_livro) REFERENCES tb_livro(id_livro),
CONSTRAINT FK_avaliacao_idusuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario)
);

INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (5, 1, 1);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (4, 1, 2);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (3, 1, 3);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (5, 1, 4);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (1, 1, 5);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (2, 1, 6);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (5, 1, 7);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (2, 1, 8);
INSERT INTO tb_avaliacao (nota, id_usuario, id_livro) VALUES (3, 1, 9);

-- SELECT * FROM tb_avaliacao;

CREATE TABLE tb_preferidos(
id_preferido INT PRIMARY KEY AUTO_INCREMENT,
id_usuario INT NOT NULL,
id_genero INT NOT NULL,
CONSTRAINT FK_preferido_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario),
CONSTRAINT FK_preferido_genero FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero)  
);

-- SELECT * FROM tb_preferidos;