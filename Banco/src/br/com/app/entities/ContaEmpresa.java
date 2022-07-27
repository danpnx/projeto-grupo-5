package br.com.app.entities;
import br.com.app.conta.Conta;

public class ContaEmpresa extends Conta{
	// Daniel
	private Double emprestimoEmpresa = new Double(10_000); 
	private String nomeEmpresa;
	private String cnpjEmpresa;
	
	// Daniel
	public Double getEmprestimoEmpresa() {
		return this.emprestimoEmpresa;
	}
	// Daniel
	public void setEmprestimoEmpresa(Double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	// Daniel
	public String getNomeEmpresa() {
		return this.nomeEmpresa;
	}
	// Daniel
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	// Daniel
	public String getCnpjEmpresa() {
		return this.cnpjEmpresa;
	}
	// Daniel
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	
	// Daniel
	public void pedirEmprestimo(double valorEmprestimo) {
		if(valorEmprestimo <= this.emprestimoEmpresa) {
			this.emprestimoEmpresa -= valorEmprestimo;
			this.creditarConta(valorEmprestimo);
		} else {
			System.out.println("Impossível realizar o empréstimo. Saldo de empréstimo disponível: R$ " + this.emprestimoEmpresa);
		}
	}
	// Daniel
	@Override
	public void debitarConta(double valorDebitado) {
		this.setSaldoConta(this.getSaldoConta() - valorDebitado);
	}
}
