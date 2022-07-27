package br.com.app.entities;

import br.com.app.conta.Conta;

public class ContaEstudantil extends Conta{
	private double limiteEstudantil;

	public double getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(double limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
	}

	public void usarEstudantil() {
	}

	@Override
	public void debitarConta(double valorDebitado) {
		// TODO Auto-generated method stub
		
	}

}
