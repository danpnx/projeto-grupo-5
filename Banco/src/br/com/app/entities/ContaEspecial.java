package br.com.app.entities;

public class ContaEspecial extends Conta{
	
	private double saldoConta = 0;
	private double limiteConta = 1000;
	
	public ContaEspecial(){}
	
	public ContaEspecial(String cpf, int numeroDaConta) {
		this.setCpfConta(cpf);
		this.setNumeroConta(numeroDaConta);
		this.setContaAtiva(true);
	}
	
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
	
	public void transferir(double valor) {
		this.debitarValor(valor);
		this.registrarMovimentoBancario(new MovimentoBancario(valor, "TRANSFERENCIA"));
	}
	
	public void pagarBoleto(double valor) {
		this.debitarValor(valor);
		this.registrarMovimentoBancario(new MovimentoBancario(valor, "PAGAMENTO BOLETO"));
	}
	
	public void depositar(double valor) {
		this.creditarValor(valor);
		this.registrarMovimentoBancario(new MovimentoBancario(valor, "DEPOSITO BANCARIO"));
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
		if (valorDebitado > this.getSaldoConta()) {
			this.usarLimite(valorDebitado - this.getSaldoConta());
			this.setSaldoConta(0);
			return;
		}
		this.setSaldoConta(this.getSaldoConta() - valorDebitado);
		return;
		
	}
	@Override
	public void creditarValor(double valorCreditado) {
		if (this.getLimiteConta() < 1000) {
			double pagarLimiteEspecial = 1000 - this.getLimiteConta();
			if (valorCreditado >= pagarLimiteEspecial) {
				this.setLimiteConta(1000);
				this.setSaldoConta(valorCreditado-pagarLimiteEspecial);
				return;
			}
			this.setLimiteConta(this.getLimiteConta() + valorCreditado);
			return;
		}
		this.setSaldoConta(valorCreditado);
		return;
		
	}
}