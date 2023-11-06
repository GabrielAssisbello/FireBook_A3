package com.usjt.firebook.firebook;

import java.sql.Connection;
import java.sql.DriverManager;
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