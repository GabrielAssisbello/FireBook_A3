package com.usjt.firebook.firebook;

public class Preferido {
    
    int idUsuario, idGenero;
    
    Preferido(int idUsuario, int idGenero){
        this.idUsuario = idUsuario;
        this.idGenero = idGenero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    
}
