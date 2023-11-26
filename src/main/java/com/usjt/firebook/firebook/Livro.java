package com.usjt.firebook.firebook;

public class Livro implements Comparable <Livro>{
    
    private double nota;
    private int idLivro, idGenero, idUsuario, numAvaliacoes;
    private String titulo, autor;

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getNumAvaliacoes() {
        return numAvaliacoes;
    }

    public void setNumAvaliacoes(int numAvaliacoes) {
        this.numAvaliacoes = numAvaliacoes;
    }
    
    @Override
    public int compareTo(Livro l){
        
        // começa comparando por nota
        if(this.getNota() == l.getNota()){
            
            // desempata por numero de avaliacoes
            if(this.getNumAvaliacoes() == l.getNumAvaliacoes()){
                
                // desempata de novo por titulo
                return this.getTitulo().compareTo(l.getTitulo());
                        
            }
            
            else if(this.getNumAvaliacoes() > l.getNumAvaliacoes()) return 1;
        
            else return -1;
            
        }
        
        else if(this.getNota() > l.getNota()) return 1;
        
        else return -1;
    }
    
    
    
    
}
