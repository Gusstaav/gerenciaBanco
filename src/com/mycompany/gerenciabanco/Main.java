package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class Main {

   // Classe para dados pessoais e operações bancárias
   static class ContaBancaria {
       private String nome;
       private String sobrenome;
       private String cpf;
       private double saldo;

       // Construtor para inicializar a conta bancária
       public ContaBancaria(String nome, String sobrenome, String cpf) {
           this.nome = nome;
           this.sobrenome = sobrenome;
           this.cpf = cpf;
           this.saldo = 0.0; // Saldo inicial é 0
       }

       // Método para consultar saldo
       public double consultarSaldo() {
           return saldo;
       }

       // Método para realizar depósito
       public void realizarDeposito(double valor) {
           if (valor > 0) {
               saldo += valor;
               System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
           } else {
               System.out.println("Valor de depósito inválido.");
           }
       }

       // Método para realizar saque
       public void realizarSaque(double valor) {
           if (valor > 0 && valor <= saldo) {
               saldo -= valor;
               System.out.println("Saque de R$" + valor + " realizado com sucesso!");
           } else {
               System.out.println("Saldo insuficiente ou valor inválido.");
           }
       }

       // Método para exibir dados pessoais
       public void exibirDadosPessoais() {
           System.out.println("Nome: " + nome + " " + sobrenome);
           System.out.println("CPF: " + cpf);
       }
   }

   // Método para exibir o menu
   public static void exibirMenu() {
       System.out.println("\n--- Menu ---");
       System.out.println("1 - Consultar Saldo");
       System.out.println("2 - Realizar Depósito");
       System.out.println("3 - Realizar Saque");
       System.out.println("4 - Exibir Dados Pessoais");
       System.out.println("5 - Sair");
       System.out.print("Escolha uma opção: ");
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       // Coletando dados pessoais
       System.out.print("Digite seu nome: ");
       String nome = scanner.nextLine();
       System.out.print("Digite seu sobrenome: ");
       String sobrenome = scanner.nextLine();
       System.out.print("Digite seu CPF: ");
       String cpf = scanner.nextLine();

       // Criando a conta bancária
       ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);

       int opcao;
       do {
           exibirMenu();
           opcao = scanner.nextInt();

           switch (opcao) {
               case 1:
                   // Consultar saldo
                   System.out.println("Seu saldo atual é: R$" + conta.consultarSaldo());
                   break;

               case 2:
                   // Realizar depósito
                   System.out.print("Digite o valor do depósito: R$");
                   double deposito = scanner.nextDouble();
                   conta.realizarDeposito(deposito);
                   break;

               case 3:
                   // Realizar saque
                   System.out.print("Digite o valor do saque: R$");
                   double saque = scanner.nextDouble();
                   conta.realizarSaque(saque);
                   break;

               case 4:
                   // Exibir dados pessoais
                   conta.exibirDadosPessoais();
                   break;

               case 5:
                   // Encerrar o programa
                   System.out.println("Saindo da aplicação...");
                   break;

               default:
                   // Caso a opção seja inválida
                   System.out.println("Opção inválida. Tente novamente.");
           }

       } while (opcao != 5);

       scanner.close();
   }
}
