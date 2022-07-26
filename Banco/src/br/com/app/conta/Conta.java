package br.com.app.conta;

public abstract class Conta {
	
	// Inicio do codigo Daniel
	
	private String cpfConta;
	private int numeroConta;
	private double saldoConta;
	private boolean contaAtiva = false;
	
	public String getCpfConta() {
		return cpfConta;
	}
	public void setCpfConta(String cpfConta) {
		this.cpfConta = cpfConta;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldoConta() {
		return saldoConta;
	}
	public void setSaldoConta(double novoSaldo) {
		if(this.contaAtiva) {
			this.creditarConta(saldoConta);
			System.out.println("Utilizando o método creditarConta()");
		} else {
			this.saldoConta = novoSaldo;
			System.out.println("Utilizando a referência pro atributo this.saldoConta");
		}
		// this.saldoConta = saldoConta;
	}
	public boolean isContaAtiva() {
		return contaAtiva;
	}
	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}
	public abstract void debitarConta(double valorDebitado);
	
	public void creditarConta(double valorCreditado){
		this.saldoConta += valorCreditado;
	}
	// Fim do codigo Daniel
	
	/*
	String CPF;
	int numero;
	double saldo;
	boolean ativo;
	
	public void debito(){}
	public void credito(){}
	
	public Conta(String CPF, int numero) {
		super();
		this.CPF = CPF;
		this.numero = numero;
	}
	*/
}