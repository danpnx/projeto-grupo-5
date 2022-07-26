// Daniel
package br.com.app.entities;
// Daniel
import br.com.app.conta.Conta;
// Daniel
public class ContaEmpresa extends Conta{
	// Daniel
	private Double emprestimoEmpresa = new Double(10_000); 
	// Daniel
	public Double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}
	// Daniel
	public void setEmprestimoEmpresa(Double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
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
