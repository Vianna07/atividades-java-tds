package caixaEletronico;

import java.util.HashMap;

public class Conta {
	private static final int[] NOTAS = {100, 50, 20, 10, 5, 2};
	private static final HashMap<String, Integer> HASHMAP_NOTAS = new HashMap<String, Integer>() {
		{
			put("100", 0);
			put("50", 0);
			put("20", 0);
			put("10", 0);
			put("5", 0);
			put("2", 0);
		}
	};

	private static int LAST_CODE = 0;
	private String nome;
	private double saldo;
	private int codigo;
	private int saques;
	
	public Conta(String nome, double saldo) {
		try {			
			validarValor(saldo,  "O valor do saldo deve ser um número inteiro postivo");
		} catch (Exception e) {}
		
		this.setNome(nome);
		this.setSaldo(saldo);
		this.setCodigo(Conta.LAST_CODE++ + 1);
		this.setSaques(0);
	}
	
	public Conta(String nome) {
		this.setNome(nome);
		this.setSaldo(0);
		this.setCodigo(Conta.LAST_CODE++ + 1);
		this.setSaques(0);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getSaques() {
		return saques;
	}

	public void setSaques(int saques) {
		this.saques = saques;
	}
	
	public void extrato() {
		System.out.println("\nExtrato");
		System.out.println("Nome: " + this.nome);
		System.out.println("Codigo da conta: " + this.codigo);
		System.out.println("Saldo: R$" + this.saldo);
		System.out.println("Saques realizados hoje: " + this.saques);
	}
	
	public void sacar(double valor) throws Exception {
		validarValor(valor, "O valor do saque deve ser um número inteiro postivo");

		if (valor > this.saldo) {
			throw new Exception("Saldo insuficiente para realizar o saque");
		}
		
		this.saldo -= valor;
		this.saques++;
		
		String mensagemValorSaque = "\nValor do saque: R$" + String.valueOf(valor);
		
		HashMap<String, Integer> notas = HASHMAP_NOTAS;
	
		for (Integer nota : Conta.NOTAS) {
			 notas.put(nota.toString(), (int) (valor / nota));
			 valor = valor % nota;
		}
		
		if (valor != 0) {
			throw new Error("Não é possível sacar esse valor");
		}
		
		System.out.println(mensagemValorSaque);
		
		for (Integer nota : Conta.NOTAS) {
			System.out.println("Notas de R$" + nota + ": " + notas.get(nota.toString()));
		}
		
		System.out.println("\nSaque finalizado");
	}
	
	public void depositar(double valor) throws Exception {
		validarValor(valor, "O valor do saque deve ser um número inteiro postivo");
		
		this.saldo += valor;
		
		System.out.println("Deposito finalizado");
	}
	
	public void validarValor(double valor, String mensagem) throws Exception {
		if (valor < 0) {
			throw new Exception(mensagem);
		}
	}
}
