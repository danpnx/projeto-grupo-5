package br.com.app.entities;

import java.time.LocalDate;

//Adriana
public class ContaPoupanca extends Conta{
	private int diaAniversarioPoupanca;
	private double saldoConta;

	// Adriana
	@Override
	public void setSaldoConta(double novoSaldo) {
		this.saldoConta = novoSaldo;
	}
	
	// Adriana
	@Override
	public double getSaldoConta() {
		return this.saldoConta;
	}
	
	// Adriana
	public void pagarDebito(double valorDebito) {
		// escrever código
	}
	
	// Adriana
	public void correcao() {
		// escrever código
	}
	
	// Adriana
	public int getDiaAniversarioPoupanca() {
		return this.diaAniversarioPoupanca;
	}
	
	// Adriana
	public void setDiaAniversarioPoupanca(int diaAniversarioPoupanca) {
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}
	
	// Adriana
	public void saque(double valor) {   // publig string sacar(double valor)
		MovimentoBancario tr = new MovimentoBancario();
		LocalDate dataTemp = LocalDate.now();
		tr.setDataMovimento(dataTemp);
		tr.setTipoMovimento("Saque");
		tr.setValorMovimento(valor);
		System.out.println("Informe o valor para saque: ");
		if(this.saldoConta < valor) {
			System.out.println("Saldo Insuficiente");   // return "Saldo Insuficiente"
		}else {
			this.registrarMovimentoBancario(tr);
			this.saldoConta -= valor;
			System.out.println("Saque efetuado com sucesso");
			System.out.println("Saldo Atualizado" + this.saldoConta);  //return saldo
		}
	}
}