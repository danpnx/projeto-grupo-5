package br.com.app.conta;

import java.util.ArrayList;

public abstract class Conta {
	
	// Daniel
	private String cpfConta = "";
	private int numeroConta;
	private double saldoConta;
	private boolean contaAtiva = false;
	private ArrayList<MovimentoBancario> extratoMovimentoBancario = new ArrayList<>();
	private String senhaUsuario = "";
	
	// Daniel
	public String getCpfConta() {
		return cpfConta;
	}
	// Daniel
	public void setCpfConta(String cpfConta) {
		this.cpfConta = cpfConta;
	}
	// Daniel
	public int getNumeroConta() {
		return numeroConta;
	}
	// Daniel
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	// Daniel
	public double getSaldoConta() {
		return saldoConta;
	}
	// Daniel
	public void setSaldoConta(double novoSaldo) {
		if(this.contaAtiva) {
			this.creditarConta(saldoConta);
			System.out.println("Utilizando o método creditarConta()");
		} else {
			this.saldoConta = novoSaldo;
			System.out.println("Utilizando a referência pro atributo this.saldoConta");
		}
	}
	// Daniel
	public boolean isContaAtiva() {
		return contaAtiva;
	}
	// Daniel
	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}
	
	// Daniel
	public ArrayList<MovimentoBancario> getExtratoMovimentoBancario() {
		return extratoMovimentoBancario;
	}
	// Daniel
	public void setExtratoMovimentoBancario(ArrayList<MovimentoBancario> extratoMovimentoBancario) {
		this.extratoMovimentoBancario = extratoMovimentoBancario;
	}
	// Daniel
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	// Daniel
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	// Daniel
	public abstract void debitarConta(double valorDebitado);
	
	// Daniel
	public void creditarConta(double valorCreditado){
		this.saldoConta += valorCreditado;
		
		// Adiciona transação bancária ao extrato
		this.extratoMovimentoBancario.add(new MovimentoBancario(valorCreditado, "Crédito"));
	}
}