package com.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tela tela = new Tela();
        
        int resposta = 0;
        List<Conta> contas = new ArrayList<Conta>();
        Banco banco = new Banco();
     
        while(resposta != 4){
            tela.mostrarMenuInicial();
            resposta = scanner.nextInt();
            if(resposta == 1){
                Conta conta = tela.criarConta();
                contas.add(conta);
            }
            else if(resposta == 2){
                tela.logar(contas);
            }
            else if(resposta == 3){
                System.out.println();
                banco.listarClientes(contas);
            }
        }
        
        System.out.println("\nPrograma finalizado.");
        
        scanner.close();
    }
}
