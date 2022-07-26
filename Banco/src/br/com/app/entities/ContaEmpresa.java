package br.com.app.entities;

import br.com.app.conta.Conta;

public class ContaEmpresa extends Conta{
	
	private Double emprestimoEmpresa = new Double(10_000); 

	public Double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(Double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	public void pedirEmprestimo(double valorEmprestimo) {
		if(valorEmprestimo <= this.emprestimoEmpresa) {
			this.emprestimoEmpresa -= valorEmprestimo;
			this.creditarConta(valorEmprestimo);
		} else {
			System.out.println("Impossível realizar o empréstimo. Saldo de empréstimo disponível: R$ " + this.emprestimoEmpresa);
		}
	}
	
	@Override
	public void debitarConta(double valorDebitado) {
		this.setSaldoConta(this.getSaldoConta() - valorDebitado);
	}
}