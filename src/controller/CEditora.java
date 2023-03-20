/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.Editora;

/**
 *
 * @author 182120039
 */
public class CEditora {
    
    ArrayList<Editora> editoras = new ArrayList<>();
    int idEditora = 1;

    public int geraID() {
        return this.idEditora++;
    }

    public void addEditora(Editora e) {
        this.editoras.add(e);
    }

    public ArrayList<Editora> geteditoras() {
        return this.editoras;
    }

    public void removeeditora(Editora e) {
        this.editoras.remove(e);
    }
    
    public void mockeditoras() {
        Editora e1 = new Editora();
        e1.setIdEditora(this.geraID());
        e1.setCnpj("10000000000");
        e1.setEndereco("Protasio Alves");
        e1.setGerente("Jorge");
        e1.setNomeEditora("Companhia das Letras");
        this.addEditora(e1);

    }

    public Editora getEditoraCnpj(String cnpj) {
        Editora e = null;
        for (Editora editora : editoras) {
            if (editora.getCnpj().equals(cnpj)) {
                e = editora;
                break;
            }

        }
        return e;

    }
}
