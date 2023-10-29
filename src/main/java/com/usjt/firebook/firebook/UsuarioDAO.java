package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void cadastrar(Usuario u) throws Exception {
        String sql = "INSERT INTO tb_usuario(nome, login, senha) VALUES (?, ?, ?)";
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.conectar();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getLogin());
        ps.setString(3, u.getSenha());
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
            ps.setInt(5, u.getId());
            ps.execute();
        }
    }
    
    public void deletar(Usuario u) throws Exception{
        String sql = "DELETE FROM tb_usuario WHERE id_usuario = ?";
        try(
            var conexao = new ConnectionFactory().conectar();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, u.getId());
            ps.execute();
        }
    }

    public static boolean validaLogin(String login, String senha){
        String sql = "SELECT senha from tb_usuario WHERE login = ?";
        try(
                var conexao = new ConnectionFactory().conectar();
                var ps = conexao.prepareStatement(sql);
        ){
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //Usuario usuario = new Usuario();
                //usuario.setId(rs.getInt("id_usuario"));
                //usuario.setTipo(rs.getInt("tipo"));
                //usuario.setNome(rs.getString("nome_usuario"));
                //usuario.setLogin(rs.getString("login"));
                //usuario.setSenha(rs.getString("senha"));
                if (rs.getString("senha") == senha){
                    //usuario autenticado
                    return true;
                }
                else{
                    //senha incorreta
                    return false;
                }
            } else {
                //usuario não encontrado
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}