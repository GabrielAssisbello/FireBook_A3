package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;

public class PreferidoDAO {
    
    public static void registrar(Preferido p) throws Exception {
        String sql = "INSERT INTO tb_preferidos (id_usuario, id_genero) VALUES (?, ?)";
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.conectar();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, p.getIdUsuario());
        ps.setInt(2, p.getIdGenero());
        ps.execute();
        ps.close();
        conexao.close();
    }
    
}
