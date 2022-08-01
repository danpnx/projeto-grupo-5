package br.com.app.entities;

import java.time.LocalDate;

//Autor: Adriana
public class ContaPoupanca extends Conta{
	private LocalDate diaAniversarioPoupanca=LocalDate.now();
	private String nomeConta;

	public ContaPoupanca() {}
	
	public ContaPoupanca(String nome, int numero, String cpf, String senha, double saldo, boolean ativa) {
		this.setNomeConta(nome);
		this.setNumeroConta(numero);
		this.setCpfConta(cpf);
		this.setSenhaUsuario(senha);
		this.saldoConta = saldo;
		this.setContaAtiva(ativa);
	}
	
	@Override
	public void debitarValor(double valorDebitado){
		if(this.saldoConta>=valorDebitado) {
			this.saldoConta -= valorDebitado;
			this.registrarContagemMovimentosBancarios();
			this.registrarMovimentoBancario(new MovimentoBancario(valorDebitado, "Saque"));
			System.out.println("Processando o saque...");
			System.out.println("Saque realizado com sucesso!");
			}else {
				System.out.println("Saldo Insuficiente");
				System.out.println();
	 }
	}	
	
	@Override
	public void creditarValor(double valorCreditado) {
		this.saldoConta +=valorCreditado;
		this.registrarContagemMovimentosBancarios();
		this.registrarMovimentoBancario(new MovimentoBancario(valorCreditado, "Depósito"));
	}
	
	public boolean verificarAniversario(LocalDate data) {
		if(this.diaAniversarioPoupanca.equals(data)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void corrigirSaldo(double valor) {
		this.saldoConta+=(this.saldoConta*0.005);
	}
	
	public void setDiaAniversarioPoupanca(LocalDate	 diaAniversarioPoupanca) {
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}
	
	public LocalDate getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}
}	
