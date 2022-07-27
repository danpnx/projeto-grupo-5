package br.com.app.conta;

public class MovimentoBancario {
	
	// Daniel
	private double valorMovimento;
	private String tipoMovimento;
	
	// Daniel
	public MovimentoBancario(){
	}
	
	// Daniel
	public MovimentoBancario(double valor, String tipo){
		this.valorMovimento = valor;
		this.tipoMovimento = tipo;
	}
	// Daniel
	public double getValorMovimento() {
		return valorMovimento;
	}
	// Daniel
	public void setValorMovimento(double valorMovimento) {
		this.valorMovimento = valorMovimento;
	}
	// Daniel
	public String getTipoMovimento() {
		return tipoMovimento;
	}
	// Daniel
	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	// Daniel
	@Override
	public String toString() {
		return valorMovimento + " _ " + tipoMovimento;
	}
}