/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.Cliente;

/**
 *
 * @author 182120039
 */
public class CCliente {

    ArrayList<Cliente> clientes = new ArrayList<>();
    int idCliente = 1;

    public int geraID() {
        return this.idCliente++;
    }

    public void addCliente(Cliente c) {
        this.clientes.add(c);
    }

    public ArrayList<Cliente> getclientes() {
        return this.clientes;
    }

    public void removecliente(Cliente c) {
        this.clientes.remove(c);
    }

    public void mockclientes() {
        Cliente c1 = new Cliente();
        c1.setIdCliente(this.geraID());
        c1.setNomeCliente("Marlize Morais");
        c1.setCpf("52605299015");
        c1.setEndereco("Souza Costa, 50");
        c1.setTelefone("51993744232");
        this.addCliente(c1);
        Cliente c2 = new Cliente();
        c2.setIdCliente(this.geraID());
        c2.setNomeCliente("Luiza Garcia");
        c2.setCpf("60076121046");
        c2.setEndereco("Souza Costa, 50");
        c2.setTelefone("51989344232");
        this.addCliente(c2);
    }

    public Cliente getClienteCPF(String cpf) {
        Cliente c = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                c = cliente;
                break;
            }

        }
        return c;

    }

}
