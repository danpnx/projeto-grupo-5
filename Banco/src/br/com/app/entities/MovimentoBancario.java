package br.com.app.entities;

import java.time.LocalDate;

public class MovimentoBancario {
	
	// Daniel
	private double valorMovimento;
	private String tipoMovimento;
	private LocalDate dataMovimento = LocalDate.now();
	
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
		return this.valorMovimento;
	}
	// Daniel
	public void setValorMovimento(double valorMovimento) {
		this.valorMovimento = valorMovimento;
	}
	// Daniel
	public String getTipoMovimento() {
		return this.tipoMovimento;
	}
	// Daniel
	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	public LocalDate getDataMovimento() {
		return this.dataMovimento;
	}

	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	// Daniel
	@Override
	public String toString() {
		return dataMovimento + "\t" + tipoMovimento + "\t" + valorMovimento;
	}
}