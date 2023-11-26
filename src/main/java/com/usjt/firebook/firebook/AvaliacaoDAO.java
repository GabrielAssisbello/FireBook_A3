package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AvaliacaoDAO {
    
    public static void cadastrar(Avaliacao a) throws Exception {
        String sql = "INSERT INTO tb_avaliacao(nota, id_usuario, id_livro) VALUES (?, ?, ?)";
        var conexao = ConnectionFactory.conectar(LeitorDeProperties.ler());
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, a.getNota());
        ps.setInt(2, a.getIdUsuario());
        ps.setInt(3, a.getIdLivro());
        ps.execute();
        ps.close();
        conexao.close();
    }
}