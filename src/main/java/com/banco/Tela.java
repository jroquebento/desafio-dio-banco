package com.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Tela {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
   
    public void mostrarMenuInicial(){
        System.out.println();
        System.out.println("Bem Vindo ao Banco xpto!");
        System.out.println("1 - Criar nova conta");
        System.out.println("2 - Entrar");
        System.out.println("3 - Listar Clientes");
        System.out.println("4 - Encerrar");
    }

    public Conta criarConta(){
        System.out.print("\nDigite seu nome: ");
        String nome = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();
        
        Cliente cliente = new Cliente(nome,senha);

        System.out.println("\np = conta poupança | c = conta corrente");
        System.out.print("Digite o tipo de conta(p ou c): ");
        String tipoConta = scanner.next();
       
        System.out.println();
        Conta conta;
        if(tipoConta.equals("c")  || tipoConta.equals("C")){
            conta = new ContaCorrente(cliente);            
        }
        else{
            conta = new ContaPoupanca(cliente);
        }

        List<Conta> contas = new ArrayList<Conta>();
        contas.add(conta);

        conta.imprimirExtrato();

        return conta;
    }

    public void logar(List<Conta> contas){
        System.out.print("\nDigite o número da conta: ");
        int numeroConta = scanner.nextInt();
       
        System.out.print("Digite a sua senha: ");
        String senha = scanner.next();

        for (Conta conta : contas) {
            if(conta.cliente.getSenha().equals(senha) && conta.numero == numeroConta){
                acessarConta(conta,contas);
            }
        }
    }

    public void mostrarMenuOperacoes(){
        System.out.println("\nQual operação deseja fazer?");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - Transferir");
        System.out.println("4 - Logout");
    }

    public void acessarConta(Conta conta,List<Conta> contas){
        int resposta = 0;
        while(resposta != 4){
            mostrarMenuOperacoes();
            resposta = scanner.nextInt();
            
            System.out.println();
            if(resposta == 1){
                System.out.print("\nDigite o valor para sacar: ");
                double valor = scanner.nextDouble();
                conta.sacar(valor);
            }
            else if(resposta == 2){
                System.out.print("Digite o valor para depositar: ");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
            }   
            else if(resposta == 3){
                System.out.print("Digite o valor para transferência: ");
                double valor = scanner.nextDouble();
                System.out.print("Digite o número da conta de destino: ");
                int contaDestino = scanner.nextInt();

                for (Conta c: contas) {
                    if(contaDestino == c.numero){
                        conta.transferir(valor, c); 
                    }
                }
            }    
            System.out.println();
            conta.imprimirExtrato();   
        }        
    }
}
