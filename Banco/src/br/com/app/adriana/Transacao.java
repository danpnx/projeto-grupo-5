package br.com.app.adriana;
import java.util.Date;

public class Transacao {

	
	// Adriana
			
		private Date data;
		private double valor;
		private String tipoMovimento;
		
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
		public String getTipoMovimento() {
			return tipoMovimento;
		}
		public void setTipoMovimento(String tipoMovimento) {
			this.tipoMovimento = tipoMovimento;
		}
		
		

}
