package org.example;

import javax.swing.*;
//@actor kaiogabriel
public class CadastroCliente {

    private No inicio;
    private No fim;

    public void adicionarCliente(Cliente cliente) {
        No novoNo = new No(cliente);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
        JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso: " + cliente);
    }

    public void removerCliente(int codigo) {
        No atual = inicio;
        while (atual != null && atual.getCliente().getCodigo() != codigo) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Cliente com código " + codigo + " não encontrado.");
        } else {
            if (atual.getAnterior() != null) {
                atual.getAnterior().setProximo(atual.getProximo());
            } else {
                inicio = atual.getProximo();
            }

            if (atual.getProximo() != null) {
                atual.getProximo().setAnterior(atual.getAnterior());
            } else {
                fim = atual.getAnterior();
            }

            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso: " + atual.getCliente());
        }
    }

    public void alterarCliente(int codigo) {
        No atual = inicio;
        while (atual != null && atual.getCliente().getCodigo() != codigo) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Cliente com código " + codigo + " não encontrado.");
        } else {
            String nome = JOptionPane.showInputDialog("Novo nome:");
            atual.getCliente().setNome(nome);
            String dataNascimento = JOptionPane.showInputDialog("Nova data de nascimento:");
            atual.getCliente().setDataNascimento(dataNascimento);
            String telefone = JOptionPane.showInputDialog("Novo telefone:");
            atual.getCliente().setTelefone(telefone);
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso: " + atual.getCliente());
        }
    }

    public void exibirCliente(int codigo) {
        No atual = inicio;
        while (atual != null && atual.getCliente().getCodigo() != codigo) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Cliente com código " + codigo + " não encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Dados do cliente: " + atual.getCliente());
        }
    }

    public void exibirTodosClientes() {
        No atual = inicio;
        StringBuilder clientes = new StringBuilder();
        while (atual != null) {
            clientes.append(atual.getCliente()).append("\n");
            atual = atual.getProximo();
        }
        JOptionPane.showMessageDialog(null, clientes.toString());
    }

}
