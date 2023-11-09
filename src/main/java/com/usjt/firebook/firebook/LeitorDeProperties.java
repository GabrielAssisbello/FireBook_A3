package com.usjt.firebook.firebook;

import javax.swing.JOptionPane;

//imports para a leitura de dados do arquivo conf.properties
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class LeitorDeProperties {
    
    public static Properties ler(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(new File("conf.properties")));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog (null, "Erro ao tentar ler o arquivo conf.properties");
            e.printStackTrace();
        }
        return properties;
    }
}
