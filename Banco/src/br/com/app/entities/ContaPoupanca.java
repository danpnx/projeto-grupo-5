package br.com.app.entities;

import java.time.LocalDate;

//Autor: Adriana
public class ContaPoupanca extends Conta{
	private LocalDate diaAniversarioPoupanca=LocalDate.now();

	@Override
	public void debitarValor(double valorDebitado){
		if(this.saldoConta>=valorDebitado) {
			this.saldoConta -= valorDebitado;
			this.registrarContagemMovimentosBancarios();
			this.registrarMovimentoBancario(new MovimentoBancario(valorDebitado, "Saque"));
			}else {
				System.out.println("Saldo Insuficiente");
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
		this.creditarValor(valor);
	}
	
	public void setDiaAniversarioPoupanca(LocalDate	 diaAniversarioPoupanca) {
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}
}	
