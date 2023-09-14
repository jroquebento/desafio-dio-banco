package com.banco;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Banco{
    private String nome;
    private List<Conta> contas;

    public void listarClientes(List<Conta> contas){
        System.out.println("Lista de Clientes:");
        for (Conta conta : contas) {
            System.out.println(conta.cliente.getNome());
        }
    }
}