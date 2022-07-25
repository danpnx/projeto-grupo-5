package br.com.app.entities;

public class ContaEmpresa {
	
	private Double emprestimoEmpresa = new Double(10_000); 

	public Double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(Double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	public void pedirEmprestimo() {
	}

}
