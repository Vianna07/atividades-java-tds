package caixaEletronico;

import java.util.Scanner;
import java.util.HashMap;

public class CaixaEletronico {	
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public static void menu() {
		int opcao;
		
		System.out.println("\nDigite um nome: ");
		String nome = CaixaEletronico.SCANNER.nextLine();
		
		System.out.println("Digite um valor inicial na conta: ");
		Double saldo = CaixaEletronico.SCANNER.nextDouble();
		
		Conta conta = new Conta(nome, saldo);
		
		do {
			System.out.println("\nMenu");
			System.out.println("1 - Extrato");
			System.out.println("2 - Sacar");
			System.out.println("3 - Depositar");
			System.out.println("4 - Sair");
			System.out.println("\n Escolha uma opção: ");
			opcao = CaixaEletronico.SCANNER.nextInt();
			
			System.out.println("");
			
			switch(opcao) {
				case 1:
					conta.extrato();
					break;
				case 2:
					try {
						System.out.println("Digite um valor a sacar: ");
						conta.sacar(CaixaEletronico.SCANNER.nextDouble());
					} catch (Exception e) {
						System.out.println("Erro ao sacar: " + e.getMessage());
					}

					break;
				case 3:
					try {
						System.out.println("Digite um valor a depositar: ");
						conta.depositar(CaixaEletronico.SCANNER.nextDouble());
					} catch (Exception e) {
						System.out.println("Erro ao depositar: " + e.getMessage());
					}
					break;
				case 4:
					System.out.println("Obrigado por utilizar o caixa eletrônico");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente");
			}
		} while (opcao != 4);
	}
	
	
	public static void main(String[] args) {
		CaixaEletronico.menu();
	}
}
