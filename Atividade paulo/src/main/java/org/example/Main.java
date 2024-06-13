package org.example;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        CadastroCliente cadastro = new CadastroCliente();
        String[] options = {"Adicionar Cliente", "Remover Cliente", "Alterar Cliente", "Exibir Cliente", "Exibir Todos Clientes", "Sair"};
        int opcao;

        do {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (opcao) {
                case 0:
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código:"));
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento:");
                    String telefone = JOptionPane.showInputDialog("Telefone:");
                    Cliente novoCliente = new Cliente(codigo, nome, dataNascimento, telefone);
                    cadastro.adicionarCliente(novoCliente);
                    break;
                case 1:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do cliente a remover:"));
                    cadastro.removerCliente(codigo);
                    break;
                case 2:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do cliente a alterar:"));
                    cadastro.alterarCliente(codigo);
                    break;
                case 3:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do cliente a exibir:"));
                    cadastro.exibirCliente(codigo);
                    break;
                case 4:
                    cadastro.exibirTodosClientes();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 5);
    }
    }
