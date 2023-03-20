/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 182120039
 */
public class VendaLivro {
    private int idVendaLivro;
    private Cliente idCliente;
    private ArrayList<Livro>livros;
    private float subtotal;
    private LocalDate datavenda;

    public VendaLivro() {
    }

    public VendaLivro(int idVendaLivro, Cliente idCliente, ArrayList<Livro> livros, float subtotal, LocalDate datavenda) {
        this.idVendaLivro = idVendaLivro;
        this.idCliente = idCliente;
        this.livros = livros;
        this.subtotal = subtotal;
        this.datavenda = datavenda;
    }

    public int getIdVendaLivro() {
        return idVendaLivro;
    }

    public void setIdVendaLivro(int idVendaLivro) {
        this.idVendaLivro = idVendaLivro;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDate getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(LocalDate datavenda) {
        this.datavenda = datavenda;
    }

    @Override
    public String toString() {
        return "VendaLivro{" + "idVendaLivro=" + idVendaLivro + ", idCliente=" + idCliente + ", livros=" + livros + ", subtotal=" + subtotal + ", datavenda=" + datavenda + '}';
    }

  
    

}


    