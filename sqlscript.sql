-- CREATE DATABASE db_firebook
-- USE DATABASE db_firebook

-- INSERT INTO `tb_tipo_usuario`(`tipo_usuario`, `descricao`) VALUES ('1','admin');
-- INSERT INTO `tb_tipo_usuario`(`tipo_usuario`, `descricao`) VALUES ('2','usuario');

/*CREATE TABLE tb_tipo_usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(10) NOT NULL
);*/


-- ALTER TABLE tb_usuario ADD COLUMN genero VARCHAR(10) NOT NULL;

/*CREATE TABLE tb_usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
tipo_usuario INT NOT NULL,
CONSTRAINT FK_tipo_usuario FOREIGN KEY (tipo_usuario) REFERENCES tb_tipo_usuario(tipo_usuario) ON DELETE CASCADE ON UPDATE CASCADE 
);*/

/*CREATE TABLE tb_livro(
id_livro INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(30) NOT NULL,
id_genero INT NOT NULL,
id_usuario INT NOT NULL,
CONSTRAINT FK_genero FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_usuario_cadastrou FOREIGN KEY (id_usuario ) REFERENCES tb_usuario(id_usuario ) ON DELETE CASCADE ON UPDATE CASCADE
);*/

/*CREATE TABLE tb_avaliacao(
id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
nota INT NOT NULL,
id_usuario INT NOT NULL,
id_livro INT NOT NULL,
CONSTRAINT FK_avaliacao_livro FOREIGN KEY (id_livro) REFERENCES tb_livro(id_livro) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_idusuario_avaliacao FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE 
);*/

/*CREATE TABLE tb_preferidos(
id_preferido INT PRIMARY KEY AUTO_INCREMENT,
id_usuario INT NOT NULL,
id_genero INT NOT NULL,
CONSTRAINT FK_preferido_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_genero_preferido FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero) ON DELETE CASCADE ON UPDATE CASCADE   
);*/

-- INSERT INTO `tb_genero`(`id_genero`, `descricao`) VALUES ('1','Biografia');
-- INSERT INTO `tb_genero`(`id_genero`, `descricao`) VALUES ('2','Técnico');
-- INSERT INTO `tb_genero`(`id_genero`, `descricao`) VALUES ('3','Infantil');
-- INSERT INTO `tb_genero`(`id_genero`, `descricao`) VALUES ('4','Romance');
-- INSERT INTO `tb_genero`(`id_genero`, `descricao`) VALUES ('5','Ficção');
-- INSERT INTO `tb_genero`(`id_genero`, `descricao`) VALUES ('6','Aventura');
/*CREATE TABLE tb_genero(
id_genero INT PRIMARY KEY;
descricao VARCHAR(30)
);*/