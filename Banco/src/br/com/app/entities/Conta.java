package br.com.app.entities;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Conta {
	
	// Daniel
	private String cpfConta = "";
	private int numeroConta;
	private double saldoConta;
	private boolean contaAtiva = false;
	private ArrayList<MovimentoBancario> extratoMovimentoBancario = new ArrayList<>();
	private String senhaUsuario = "";	
	private int contagemMovimentos = 0;
	static Scanner scanner = new Scanner(System.in);
	
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
	
	// Cada subclasse deve sobrescrever os métodos get e set saldoConta, além de criar um atributo saldoConta.
	// Daniel
	public abstract double getSaldoConta();
	
	// Daniel
	public abstract void setSaldoConta(double novoSaldo);
	
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
	public int getContagemMovimentos() {
		return contagemMovimentos;
	}
	// Daniel
	public void setContagemMovimentos(int contagemMovimentos) {
		this.contagemMovimentos = contagemMovimentos;
	}
	
	// Daniel
	private void pagarDebito(double valorDebito) {};
	
	// Daniel
	public void depositarConta(double valorDeposito) {
		// Este método já considera que o valor seja plausível para cada situação
		// Ex: Conta Empresa o depósito inicial é de no mínimo R$100.00, então a verificação deve ser feita antes
		this.saldoConta += valorDeposito;
		
		// Adiciona transação bancária ao extrato
		this.extratoMovimentoBancario.add(new MovimentoBancario(valorDeposito, "DEPÓSITO"));
					
		// Atualizando contagem de movimentações financeiras
		this.contagemMovimentos++;
	}
	// Daniel
	public void registrarMovimentoBancario(MovimentoBancario movTemp) {
		this.extratoMovimentoBancario.add(movTemp);
	}
	// Daniel
	public void registrarContagemMovimentosBancarios() {
		this.contagemMovimentos++;
	}
	
	// private void debitarConta(double valorDebitado){};
	
	/*
	public void creditarConta(double valorCreditado) {
		this.saldoConta += valorCreditado;
		this.registrarMovimentoBancario(new MovimentoBancario(valorCreditado, "Crédito adicionado à conta"));
		this.registrarContagemMovimentosBancarios();
	}
	*/
}