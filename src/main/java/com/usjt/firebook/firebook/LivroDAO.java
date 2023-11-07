package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
    public static void receberDados(Livro l)  throws Exception{
        String sql = "SELECT * FROM tb_livro WHERE titulo = ? AND id_usuario = ?";
        try (var conn = ConnectionFactory.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, l.getTitulo());
            ps.setInt(2, l.getIdUsuario());
            try(ResultSet rs = ps.executeQuery()) {
                rs.next();
                l.setIdLivro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setIdGenero(rs.getInt("id_genero"));
                l.setIdUsuario(rs.getInt("id_usuario"));
            }
        }
    }
    
}
