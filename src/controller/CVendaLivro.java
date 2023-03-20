/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import livraria.Livraria;
import model.Livro;
import model.VendaLivro;

/**
 *
 * @author 182120039
 */
public class CVendaLivro {

    ArrayList<VendaLivro> vendas = new ArrayList<>();
    int idVendaLivro = 1;

    public int geraID() {
        return this.idVendaLivro++;
    }

    public void addVendaLivro(VendaLivro v) {
        this.vendas.add(v);
    }

    public ArrayList<VendaLivro> getvendas() {
        return this.vendas;
    }

    public void removevendalivro(VendaLivro v) {
        this.vendas.remove(v);
    }

    public void mockVendaLivros() {
        CCliente ccli = new CCliente();
        CLivro cli = new CLivro();
        VendaLivro v1 = new VendaLivro();
        v1.setIdVendaLivro(this.geraID());
        v1.setIdCliente(Livraria.cadCliente.getClienteCPF("123456789"));
        v1.setDatavenda(LocalDate.parse("2023-03-14"));
        ArrayList<Livro> livros1 = new ArrayList<>();
        livros1.add(cli.getLivroISBN("5199398292"));
        v1.setLivros(livros1);
        v1.setSubtotal(50);
        this.addVendaLivro(v1);
    }
}
