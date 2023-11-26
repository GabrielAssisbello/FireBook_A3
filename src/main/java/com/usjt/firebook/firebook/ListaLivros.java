package com.usjt.firebook.firebook;

import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ListaLivros {
    
    public static void listar(JList jList){

        try{
            // criando um Array de livros
            ArrayList<Livro> listaDeLivros = new ArrayList<Livro>();
            
            // fazendo um select de todos os livros e armazenando eles no Array
            LivroDAO.listarTodos(listaDeLivros);
        
            // fazendo todos os livros receberem suas notas
            for(Livro livro : listaDeLivros){
                LivroDAO.receberAvaliacao(livro);
            }

            // ordena a lista:
            Collections.sort(listaDeLivros);

            // isso passa os elementos do nosso ArrayList para o DefaultListModel:
            DefaultListModel model = new DefaultListModel();
            for(Livro livro : listaDeLivros){
                model.addElement("Titulo: " + livro.getTitulo());
                model.addElement("Nota: " + livro.getNota());
                model.addElement("Avaliações: " + livro.getNumAvaliacoes());
                model.addElement("-----");
            }

            // isso passa os elementos do nosso DefaultListModel para o jList:
            jList.setModel(model);
        
        } catch(Exception e) {
            System.out.print(e);
        }
    }
}
