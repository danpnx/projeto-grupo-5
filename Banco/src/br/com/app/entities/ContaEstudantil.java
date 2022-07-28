package br.com.app.entities;

public class ContaEstudantil extends Conta{
	private double limiteEstudantil = 5000;
	private double saldoConta;

	@Override
	public void setSaldoConta(double novoSaldo) {
		this.saldoConta = novoSaldo;
	}
	
	@Override
	public double getSaldoConta() {
		return this.saldoConta;
	}
	public double getLimiteEstudantil() {
		return this.limiteEstudantil;
	}
	public void setLimiteEstudantil(double limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
	}
	
	private void pagarDebito(double valorDebito) {
		// escrever código
	}
	
	public void usarEstudantil() {
		// escrever código
	}
	/*
	 @Override
	public void debitarConta(double valorDebitado) {
		// TODO Auto-generated method stub	
	}
	 */
}