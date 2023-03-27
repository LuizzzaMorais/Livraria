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
        Livro l1 = new Livro();
        l1.setIdLivro(this.geraID());
        l1.setTitulo("Os Sete Maridos de Evelyn Hugo");
        l1.setAutor("Taylor Jenkins Reid");
        l1.setAssunto("Romance");
        l1.setIsbn("123");
        l1.setEstoque(10);
        l1.setPreco((float) 50.55);
        l1.setIdEditora(Livraria.cadEditora.getEditoraCnpj("22150710000130"));
        this.addLivro(l1);
        Livro l2 = new Livro();
        l2.setIdLivro(this.geraID());
        l2.setTitulo("Harry Potter e a Pedra Filosofal");
        l2.setAutor("J.K. Rowling");
        l2.setAssunto("Ficção Aventura");
        l2.setIsbn("321");
        l2.setEstoque(20);
        l2.setPreco((float) 40.50);
        l2.setIdEditora(Livraria.cadEditora.getEditoraCnpj("22150710000130"));
        this.addLivro(l2);
        Livro l3 = new Livro();
        l3.setIdLivro(this.geraID());
        l3.setTitulo("Pequeno Principe");
        l3.setAutor("Antoine de Saint");
        l3.setAssunto("Ludico");
        l3.setIsbn("312");
        l3.setEstoque(15);
        l3.setPreco((float) 19.90);
        l3.setIdEditora(Livraria.cadEditora.getEditoraCnpj("77860014000100"));
        this.addLivro(l3);
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
