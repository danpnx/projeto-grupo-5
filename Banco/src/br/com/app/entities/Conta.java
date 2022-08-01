package br.com.app.entities;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Conta { 
	// AUTOR: DANIEL
	
	// ATRIBUTOS SUPERCLASSE CONTA
	private String cpfConta = "";
	private String senhaUsuario = "";
	private int numeroConta;
	private int contagemMovimentos = 0;
	protected double saldoConta;
	private boolean contaAtiva = false;
	private ArrayList<MovimentoBancario> extratoMovimentoBancario = new ArrayList<>();	
	static Scanner scanner = new Scanner(System.in);
	
	// MÉTODOS SUPERCLASSE CONTA
	public abstract void debitarValor(double valorDebitado);
	public abstract void creditarValor(double valorCreditado);
	
	public void registrarMovimentoBancario(MovimentoBancario movTemp) {
		this.extratoMovimentoBancario.add(movTemp);
	}
	
	public void registrarContagemMovimentosBancarios() {
		this.contagemMovimentos++;
	}
	
	// GETTERS AND SETTERS
	public String getCpfConta() {
		return this.cpfConta;
	}
	
	public void setCpfConta(String cpfConta) {
		this.cpfConta = cpfConta;
	}
	
	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}
	
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	public int getNumeroConta() {
		return this.numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public int getContagemMovimentos() {
		return contagemMovimentos;
	}
	
	public double getSaldoConta() {
		return this.saldoConta;
	}
	
	public boolean isContaAtiva() {
		return this.contaAtiva;
	}
	
	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}
	
	public ArrayList<MovimentoBancario> getExtratoMovimentoBancario() {
		return this.extratoMovimentoBancario;
	}
}