/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import Util.Validadores;
import static Util.Validadores.isCNPJ;
import controller.CCliente;
import controller.CEditora;
import controller.CLivro;
import controller.CVendaLivro;
import java.util.Scanner;
import model.Cliente;
import model.Editora;
import model.Livro;

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
            cpf = leia.next();
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
        } while (!cpfIs);
        if (cadCliente.getClienteCPF(cpf) != null) {
            System.out.println("CPF já cadastrado");
        } else {
            System.out.print("Informe o nome: ");
            nomeCliente = leia.next();
            System.out.print("Informe o telefone: ");
            telefone = leia.next();
            System.out.println("Informe o endereço: ");
            endereco = leia.next();
            idCliente = cadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            cadCliente.addCliente(cli);
            System.out.println("Cliente cadastrado com sucesso");

        }
    }

    public static void deletarCliente() {
        System.out.println("Deletar Cliente");
        System.out.print("Informe o cpf: ");
        String cpf = leia.next();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                cadCliente.removecliente(cli);
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Cliente não conta na base de dados.");
            }
        } else {
            System.out.println("CPF inválido.");
        }
    }

    public static void listarCliente() {

        System.out.println("-- Listar --");
        for (Cliente cli : cadCliente.getclientes()) {
            System.out.println("===");
            System.out.println("CPF:\t" + cli.getCpf());
            System.out.println("Nome:\t" + cli.getNomeCliente());
            System.out.println("Fone:\t" + cli.getTelefone());

        }
    }

    private static void editarCliente() {
        System.out.println("-- Editar Cliente --");
        System.out.print("Informe o CPF: ");
        String cpf = leia.next();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                System.out.println("1 - Nome:\t" + cli.getNomeCliente());
                System.out.println("2 - Endereço:\t" + cli.getEndereco());
                System.out.println("3 - Fone:\t" + cli.getTelefone());
                System.out.println("4 - Todos os campos acima");
                System.out.print("Qual campo deseja alterar?" + "\nDigite aqui: ");
                int opEditar = leiaNumInt();
                switch (opEditar) {
                    case 1:
                        System.out.print("Informe o nome a ser alterado: ");
                        cli.setNomeCliente(leia.next());
                        break;
                    case 2:
                        System.out.print("Informe o endereço a ser alterado: ");
                        cli.setEndereco(leia.next());
                        break;
                    case 3:
                        System.out.print("Informe o telefone a ser alterado: ");
                        cli.setTelefone(leia.next());
                        break;
                    case 4:
                        System.out.print("Informe todos os campos abaixo: ");
                        System.out.print("Informe o nome a ser alterado: ");
                        cli.setNomeCliente(leia.next());
                        System.out.print("Informe o endereço a ser alterado: ");
                        cli.setEndereco(leia.next());
                        System.out.print("Informe o telefone a ser alterado: ");
                        cli.setTelefone(leia.next());
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                System.out.println("Cliente:\n" + cli.toString());
            } else {
                System.out.println("Cliente não cadastrado na base de dados.");
            }
        } else {
            System.out.println("CPF inválido.");
        }

    }

    public static void cadEditora() {
        int idEditora;
        String nomeEditora;
        String cnpj;
        String endereco;
        String telefone;
        String gerente;

        System.out.println("--Cadastro de Editora");
        System.out.print("Informe o CNPJ: ");
        boolean cnpjIs;
        int opCNPJ;
        do {
            cnpj = leia.next();
            cnpjIs = Validadores.isCNPJ(cnpj);
            if (!cnpjIs) {
                System.out.println("CNPJ inválido." + "\nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opCNPJ = leiaNumInt();
                if (opCNPJ == 1) {
                    System.out.print("Informe o CNPJ:");
                } else if (opCNPJ == 2) {
                    System.out.println("Cadastro cancelado pelo usuário.");
                    break;
                }
            }
        } while (!cnpjIs);
        if (cadEditora.getEditoraCnpj(cnpj) != null) {
            System.out.println("CNPJ já cadastrado. ");
        } else {
            System.out.print("Informe o nome da editora: ");
            nomeEditora = leia.next();
            System.out.print("Informe o telefone: ");
            telefone = leia.next();
            System.out.print("Informe o endereço: ");
            endereco = leia.next();
            System.out.print("Informe o gerente: ");
            gerente = leia.next();
            idEditora = cadEditora.geraID();
            Editora edi = new Editora(idEditora, nomeEditora, cnpj, endereco, telefone, gerente);
            cadEditora.addEditora(edi);
            System.out.println("Editora cadastrada com sucesso. ");

        }
    }

    public static void deletarEditora() {
        System.out.println("Deletar Editora");
        System.out.print("Informe o CNPJ: ");
        String cnpj = leia.next();
        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = cadEditora.getEditoraCnpj(cnpj);
            if (edi != null) {
                cadEditora.removeeditora(edi);
                System.out.println("Editora deletada com sucesso!");
            } else {
                System.out.println("Editora não conta na base de dados.");
            }
        } else {
            System.out.println("CNPJ inválido.");
        }
    }

    public static void listarEditora() {

        System.out.println("-- Listar --");
        for (Editora edi : cadEditora.geteditoras()) {
            System.out.println("===");
            System.out.println("CNPJ:\t" + edi.getCnpj());
            System.out.println("Nome:\t" + edi.getNomeEditora());
            System.out.println("Fone:\t" + edi.getTelefone());

        }
    }

    private static void editarEditora() {
        System.out.println("-- Editar Editora --");
        System.out.print("Informe o CNPJ: ");
        String cnpj = leia.next();
        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = cadEditora.getEditoraCnpj(cnpj);
            if (edi != null) {
                System.out.println("1 - Nome:\t" + edi.getNomeEditora());
                System.out.println("2 - Endereço:\t" + edi.getEndereco());
                System.out.println("3 - Fone:\t" + edi.getTelefone());
                System.out.println("4 - Gerente:\t" + edi.getGerente());
                System.out.println("5 - Todos os campos acima");
                System.out.print("Qual campo deseja alterar?" + "\nDigite aqui: ");
                int opEditar = leiaNumInt();
                switch (opEditar) {
                    case 1:
                        System.out.print("Informe o nome a ser alterado: ");
                        edi.setNomeEditora(leia.next());
                        break;
                    case 2:
                        System.out.print("Informe o endereço a ser alterado: ");
                        edi.setEndereco(leia.next());
                        break;
                    case 3:
                        System.out.print("Informe o telefone a ser alterado: ");
                        edi.setTelefone(leia.next());
                        break;
                    case 4:
                        System.out.print("Informe o gerente a ser alterado: ");
                        edi.setGerente(leia.next());
                        break;
                    case 5:
                        System.out.print("Informe todos os campos abaixo: ");
                        System.out.print("Informe o nome a ser alterado: ");
                        edi.setNomeEditora(leia.next());
                        System.out.print("Informe o endereço a ser alterado: ");
                        edi.setEndereco(leia.next());
                        System.out.print("Informe o telefone a ser alterado: ");
                        edi.setTelefone(leia.next());
                        System.out.print("Informe o gerente a ser alterado: ");
                        edi.setGerente(leia.next());
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                System.out.println("Editora:\n" + edi.toString());
            } else {
                System.out.println("Editora não cadastrado na base de dados.");
            }
        } else {
            System.out.println("CNPJ inválido.");
        }

    }

    private static void cadLivro() {
        System.out.println("--Cadastro de Livro--");
        System.out.print("Informe o ISBN: ");
        String isbn = leia.nextLine();
        if (cadLivro.getLivroISBN(isbn) != null) {
            System.out.println("Livro já cadastrado. ");
        } else {
            int idLivro = cadLivro.geraID();
            System.out.print("Informe o título do livro: ");
            String titulo = leia.nextLine();
            System.out.print("Informe o autor: ");
            String autor = leia.nextLine();
            System.out.print("Informe o assunto: ");
            String assunto = leia.nextLine();
            System.out.print("Informe o estoque: ");
            int estoque = leiaNumInt();
            System.out.println("Informe o preço: ");
            float preco = leia.nextFloat();
            boolean isCNPJ = false;
            Editora idEditora = null;
            do{
                System.out.print("Informe o CNPJ da editora: ");
                String cnpj = leia.nextLine();
                        isCNPJ = Validadores.isCNPJ(cnpj);
                        if(isCNPJ){
                            idEditora = cadEditora.getEditoraCnpj(cnpj);
                            if(idEditora == null){
                                System.out.println("Editora sob este CNPJ não cadastrada. ");
                            }
                        }else{
                            System.out.println("CNPJ inválido. ");
                        }
            }while(isCNPJ);
            Livro li = new Livro(idLivro, titulo, autor, assunto, isbn, estoque, preco, idEditora);
            cadLivro.addLivro(li);
            System.out.println("Livro cadastrado com sucesso");
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
                                if (opM == 1) {
                                    cadCliente();
                                } else if (opM == 2) {
                                    cadEditora();
                                } else if (opM == 3) {
                                    cadLivro();
                                }
                                break;
                            case 2:
                                System.out.println("-- Editar --");
                                if (opM == 1) {
                                    editarCliente();
                                } else if (opM == 2) {
                                    editarEditora();
                                } else if (opM == 3) {
                                    editarLivro();
                                }
                                break;
                            case 3:
                                System.out.println("-- Listar --");
                                if (opM == 1) {
                                    listarCliente();
                                } else if (opM == 2) {
                                    listarEditora();
                                } else if (opM == 3) {
                                    listarLivro();
                                }
                                break;
                            case 4:
                                System.out.println("-- Deletar --");
                                if (opM == 1) {
                                    deletarCliente();
                                } else if (opM == 2) {
                                    deletarEditora();
                                } else if (opM == 3) {
                                    deletarLivro();
                                }

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

    private static void editarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void listarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void deletarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
