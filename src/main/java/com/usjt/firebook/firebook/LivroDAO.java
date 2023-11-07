package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;

public class LivroDAO {
    
    public static void cadastrar(Livro l) throws Exception {
        String sql = "INSERT INTO tb_livro(titulo, autor, id_genero, id_usuario) VALUES (?, ?, ?, ?)";
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.conectar();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, l.getTitulo());
        ps.setString(2, l.getAutor());
        ps.setInt(3, l.getIdGenero());
        ps.setInt(4, l.getIdUsuario());
        ps.execute();
        ps.close();
        conexao.close();
    }
    
}
