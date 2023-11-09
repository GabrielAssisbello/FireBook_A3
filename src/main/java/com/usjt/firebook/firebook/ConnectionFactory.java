package com.usjt.firebook.firebook;

//imports para a conexão com o banco
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    //cria a conexão com o banco de dados
    public static Connection conectar(java.util.Properties properties) {
        
        String host, port, db, user, password;
        
        host = properties.getProperty("DB_HOST");
        port = properties.getProperty("DB_PORT");
        db = properties.getProperty("DB_NAME");
        user = properties.getProperty("DB_USER");
        password = properties.getProperty("DB_PASSWORD");
        
        try{
            String s = String.format(
                "jdbc:mysql://%s:%s/%s",
                host, port, db
            );

            Connection c = DriverManager.getConnection(
                s, 
                user, 
                password
            );
            return c;   
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

/*
//metodo antigo, remover depois.

public class ConnectionFactory {
    
    private static final String host = "mysql-1462dbf-lucaslag-0d39.aivencloud.com";
    private static final String port = "22299";
    private static final String user = "avnadmin";
    private static final String password = "AVNS_rNvRFUUwNkZX-vaejFP";
    private static final String db = "db_firebook";
    
    public static Connection conectar() {
        try{
            String s = String.format(
                "jdbc:mysql://%s:%s/%s",
                host, port, db
            );

            Connection c = DriverManager.getConnection(
                    s, 
                    user, 
                    password
            );
            return c;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
*/