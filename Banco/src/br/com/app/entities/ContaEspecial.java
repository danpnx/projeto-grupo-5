package br.com.app.entities;

public class ContaEspecial extends Conta{
	
	private double saldoConta;
	private double limiteConta = 1000;

	@Override
	public void setSaldoConta(double novoSaldo) {
		this.saldoConta = novoSaldo;
	}
	@Override
	public double getSaldoConta() {
		return this.saldoConta;
	}
	
	public double getLimiteConta() {
		return this.limiteConta;
	}
	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}
	
	private void pagarDebito(double valorDebito) {
		// escrever código
	}
	
	public void usarLimite() {
		// escrever código
	}
}