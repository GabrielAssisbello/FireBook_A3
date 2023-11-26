package com.usjt.firebook.firebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreferidoDAO {
    
    public static void registrar(Preferido p) throws Exception {
        String sql = "INSERT INTO tb_preferidos (id_usuario, id_genero) VALUES (?, ?)";
        var conexao = ConnectionFactory.conectar(LeitorDeProperties.ler());
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, p.getIdUsuario());
        ps.setInt(2, p.getIdGenero());
        ps.execute();
        ps.close();
        conexao.close();
    }
}
