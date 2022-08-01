package br.com.app.entities;

import java.time.LocalDate;

public class MovimentoBancario {
	// AUTOR: DANIEL
	
	private double valorMovimento;
	private String tipoMovimento;
	private LocalDate dataMovimento = LocalDate.now();
	
	public MovimentoBancario(){
	}
	
	public MovimentoBancario(double valor, String tipo){
		this.valorMovimento = valor;
		this.tipoMovimento = tipo;
	}

	public double getValorMovimento() {
		return this.valorMovimento;
	}

	public void setValorMovimento(double valorMovimento) {
		this.valorMovimento = valorMovimento;
	}

	public String getTipoMovimento() {
		return this.tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	public LocalDate getDataMovimento() {
		return this.dataMovimento;
	}

	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	@Override
	public String toString() {
		return dataMovimento + "\tR$ " + valorMovimento + "\t" + tipoMovimento;
	}
}