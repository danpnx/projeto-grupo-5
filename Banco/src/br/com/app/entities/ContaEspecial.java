package br.com.app.entities;

public class ContaEspecial extends Conta{
	
	private double saldoConta;
	private double limiteConta = 1000;

	
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
	
	public boolean usarLimite(double valor) {
		boolean temLimite = this.getLimiteConta() >= valor ? true : false;
		if ( temLimite ) {
			this.setLimiteConta(this.getLimiteConta() - valor);
			return true;
		}
		return false;
	}
	@Override
	public void debitarValor(double valorDebitado) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void creditarValor(double valorCreditado) {
		// TODO Auto-generated method stub
		
	}
}