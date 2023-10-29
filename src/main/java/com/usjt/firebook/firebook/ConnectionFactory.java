package com.usjt.firebook.firebook;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    
    private static final String host = "mysql-14f5acad-aluno-208e.aivencloud.com";
    private static final String port = "12853";
    private static final String user = "avnadmin";
    private static final String password = "AVNS_5h1pGTmZzoh4H4BsjVK";
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