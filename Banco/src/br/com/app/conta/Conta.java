package br.com.app.conta;

import java.util.ArrayList;

public abstract class Conta {
	
	// Daniel
	private String cpfConta = "";
	private int numeroConta = 0000010;
	private double saldoConta;
	private boolean contaAtiva = false;
	private ArrayList<MovimentoBancario> extratoMovimentoBancario = new ArrayList<>();
	private String senhaUsuario = "";
	
	// Daniel
	public String getCpfConta() {
		return this.cpfConta;
	}
	// Daniel
	public void setCpfConta(String cpfConta) {
		this.cpfConta = cpfConta;
	}
	// Daniel
	public int getNumeroConta() {
		return this.numeroConta;
	}
	// Daniel
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	// Daniel
	public double getSaldoConta() {
		return this.saldoConta;
	}
	// Daniel
	public void setSaldoConta(double novoSaldo) {
		if(this.contaAtiva) {
			this.creditarConta(saldoConta);
		} else {
			this.saldoConta = novoSaldo;
		}
	}
	// Daniel
	public boolean isContaAtiva() {
		return this.contaAtiva;
	}
	// Daniel
	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}
	
	// Daniel
	public ArrayList<MovimentoBancario> getExtratoMovimentoBancario() {
		return this.extratoMovimentoBancario;
	}
	// Daniel
	public void setExtratoMovimentoBancario(ArrayList<MovimentoBancario> extratoMovimentoBancario) {
		this.extratoMovimentoBancario = extratoMovimentoBancario;
	}
	// Daniel
	public String getSenhaUsuario() {
		return this.senhaUsuario;
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