package br.com.app.adriana;

public class TestaPoupanca {

	public static void main(String[] args) {

		
		// Adriana
		Poupanca poup = new Poupanca();
		
		poup.deposito(10);
		poup.deposito(15);
		poup.saque(20);

		poup.extrato();
	}

}
