package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public static void cadastrar(Usuario u) throws Exception {
        String sql = "INSERT INTO tb_usuario(nome, login, senha, idade, genero, id_tipo_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.conectar();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getLogin());
        ps.setString(3, u.getSenha());
        ps.setInt(4, u.getIdade());
        ps.setString(5, u.getGenero());
        ps.setInt(6, u.getTipo());
        ps.execute();
        ps.close();
        conexao.close();
    }
    
    public void atualizar(Usuario u) throws Exception{
        String sql = 
        "UPDATE tb_usuario SET nome = ?, login = ?, senha = ?, tipo = ? WHERE id_usuario = ?;";
        try(
            var conexao = ConnectionFactory.conectar();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setString(1, u.getNome());
            ps.setString(2, u.getLogin());
            ps.setString(3, u.getSenha());
            ps.setInt(4, u.getTipo());
            ps.setInt(5, u.getIdUsuario());
            ps.execute();
        }
    }
    
    public void deletar(Usuario u) throws Exception{
        String sql = "DELETE FROM tb_usuario WHERE id_usuario = ?";
        try(
            var conexao = new ConnectionFactory().conectar();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, u.getIdUsuario());
            ps.execute();
        }
    }

    public static boolean validaLogin(Usuario usuario)  throws Exception{
        String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
        try (var conn = ConnectionFactory.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    public static void receberDados(Usuario usuario)  throws Exception{
        String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
        try (var conn = ConnectionFactory.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try(ResultSet rs = ps.executeQuery()) {
                rs.next();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setTipo(rs.getInt("id_tipo_usuario"));
            }
        }
    }
}