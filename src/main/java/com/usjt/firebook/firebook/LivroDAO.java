package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LivroDAO {
    
    public static void cadastrar(Livro l) throws Exception {
        String sql = "INSERT INTO tb_livro(titulo, autor, id_genero, id_usuario) VALUES (?, ?, ?, ?)";
        var conexao = ConnectionFactory.conectar(LeitorDeProperties.ler());
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
        try (var conexao = ConnectionFactory.conectar(LeitorDeProperties.ler());
            PreparedStatement ps = conexao.prepareStatement(sql)){
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
    
    public static void listarTodos(ArrayList<Livro> listaDeLivros)  throws Exception{
        String sql = "SELECT * FROM tb_livro";
        try (
            var conexao = ConnectionFactory.conectar(LeitorDeProperties.ler());
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                Livro l = new Livro();
                l.setIdLivro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setIdGenero(rs.getInt("id_genero"));
                l.setIdUsuario(rs.getInt("id_usuario"));
                listaDeLivros.add(l);
            }
        }
    }
    
    
    // Talvez isso devesse estar em AvaliacaoDAO...
    
    public static void receberAvaliacao(Livro l)  throws Exception{
        String sql = "SELECT * FROM tb_avaliacao WHERE id_livro = ?";
        try (
            var conexao = ConnectionFactory.conectar(LeitorDeProperties.ler());
            var ps = conexao.prepareStatement(sql);
            
        ){
            ps.setInt(1, l.getIdLivro());
            ResultSet rs = ps.executeQuery();
            
            double notasSomadas = 0;
            int numAvaliacoes = 0;
            
            while (rs.next()){
                
                notasSomadas += rs.getDouble("nota");
                System.out.print(rs.getDouble("nota"));
                numAvaliacoes++;
                
            }
            
            l.setNota( notasSomadas / numAvaliacoes );
            l.setNumAvaliacoes(numAvaliacoes);
            
        }
    }
}
