/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import Util.Validadores;
import controller.CCliente;
import controller.CEditora;
import controller.CLivro;
import controller.CVendaLivro;
import java.util.Scanner;
import model.Cliente;

/**
 *
 * @author 182120039
 */
public class Livraria {

    public static CCliente cadCliente = new CCliente();
    public static CEditora cadEditora = new CEditora();
    public static CLivro cadLivro = new CLivro();
    public static CVendaLivro cadVendaLivro = new CVendaLivro();
    public static Scanner leia = new Scanner(System.in);

    public static int leiaNumInt() {
        int num = 99;
        try {
            num = leia.nextInt();
        } catch (Exception e) {
            System.out.println("Tente novamente");
            leia.nextLine();
        }
        return num;
    }

    public static void menuP() {
        System.out.println("--: Livraria :--");
        System.out.println("1 - Gerenciar Clientes");
        System.out.println("2 - Gerenciar Editoras");
        System.out.println("3 - Gerenciar Livros");
        System.out.println("4 - Gerenciar Vendas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma das opções acima: ");
    }

    public static void subMenu(int op) {
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Cliente";
                break;
            case 2:
                tpCad = "Editora";
                break;
            case 3:
                tpCad = "Livro";
                break;

        }
        System.out.println(".: Gerenciar " + tpCad + " :.");
        System.out.println("1 - Cadastrar " + tpCad);
        System.out.println("2 - Editar " + tpCad);
        System.out.println("3 - Listar " + tpCad + "s");
        System.out.println("4 - Deletar " + tpCad);
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma das opções acima: ");

    }

    public static void cadCliente() {
        int idCliente;
        String nomeCliente;
        String cpf;
        String cnpj = null;
        String endereco;
        String telefone;

        System.out.println("--Cadastro de Cliente");
        System.out.print("Informe o CPF: ");
        boolean cpfIs;
        int opCPF;
        do {
            cpf = leia.nextLine();
            cpfIs = Validadores.isCPF(cpf);
            if (!cpfIs) {
                System.out.println("CPF inválido." + "\nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opCPF = leiaNumInt();
                if (opCPF == 1) {
                    System.out.print("Informe o CPF:");
                } else if (opCPF == 2) {
                    System.out.println("Cadastro cancelado pelo usuário.");
                    break;
                }
            }
        }while(!cpfIs);
        if (cadCliente.getClienteCPF(cpf) != null){
            System.out.println("CPF já cadastrado");
        }else{
            System.out.print("Informe o nome: ");
            nomeCliente = leia.nextLine();
            System.out.println("Informe o telefone");
            telefone = leia.nextLine();
            System.out.println("Informe o endereço");
            endereco = leia.nextLine();
            idCliente = cadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            cadCliente.addCliente(cli);
            System.out.println("Cliente cadastrado com sucesso");
            
        }
    }

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        //CCliente cadCliente = new CCliente();
        cadEditora.mockeditoras();
        cadCliente.mockclientes();
        cadLivro.mocklivros();
        cadVendaLivro.mockVendaLivros();
        int opM;

        do {
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                case 3:
                    int opSM;
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                System.out.println("-- Cadastrar --");
                                cadCliente();
                                break;
                            case 2:
                                System.out.println("-- Editar --");
                                break;
                            case 3:
                                System.out.println("-- Listar --");
                                System.out.println(cadCliente.getclientes().toString());
                                break;
                            case 4:
                                System.out.println("-- Deletar --");
                                break;
                            case 0:
                                System.out.println("-- Menu Principal --");
                                break;
                            default:
                                System.out.println("Opção Inválida, tente novamente.");
                                break;
                        }
                    } while (opSM != 0);
                    break;
                case 4:
                    System.out.println("--Venda Livro--");
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário.");
                    break;
                default:
                    System.out.println("Opção inváldida, tente novamente.");
            }
        } while (opM != 0);
    }
}
