/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import livraria.Livraria;
import model.Livro;

/**
 *
 * @author 182120039
 */
public class CLivro {

    ArrayList<Livro> livros = new ArrayList<>();
    int idLivro = 1;

    public int geraID() {
        return this.idLivro++;
    }

    public void addLivro(Livro l) {
        this.livros.add(l);
    }

    public java.util.ArrayList<Livro> getlivros() {
        return this.livros;
    }

    public void removelivro(Livro l) {
        this.livros.remove(l);
    }

    public void mocklivros() {
        CEditora ed = new CEditora();
        Livro l1 = new Livro();
        l1.setIdLivro(this.geraID());
        l1.setTitulo("Os Sete Maridos de Evelyn Hugo");
        l1.setAutor("Taylor Jenkins Reid");
        l1.setAssunto("Romance");
        l1.setIsbn("5199398292");
        l1.setEstoque(10);
        l1.setPreco((float) 50.55);
        l1.setIdEditora(Livraria.cadEditora.getEditoraCnpj("10000000000"));
        this.addLivro(l1);
    }

    public Livro getLivroISBN(String isbn) {
        Livro l = null;
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                l = livro;
                break;
            }

        }
        return l;

    }

    public boolean atualizaEstoqueLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                if (livro.getEstoque() > 0) {
                    livro.setEstoque(livro.getEstoque() - 1);
                }
                return true;
            }
            break;
        }
        return false;
    }

}
