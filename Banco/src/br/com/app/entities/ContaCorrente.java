package br.com.app.entities;

import java.util.Scanner;

public class ContaCorrente extends Conta{
	
	private double saldoConta;
	
	// inicio atributos exclusivos da classe ContaCorrente
	private int contadorTalao = 0;
	// colocar demais atributos
	
	// fim atributos exclusivos da classe ContaCorrente
	
	Scanner leia = new Scanner(System.in);

	public ContaCorrente(){}
	
	public ContaCorrente(String cpfConta, int numeroConta){
		this.setCpfConta(cpfConta);
		this.setNumeroConta(numeroConta);
	}
	
	@Override
	public void setSaldoConta(double novoSaldo) {
		this.saldoConta = novoSaldo;
	}
	@Override
	public double getSaldoConta() {
		return this.saldoConta;
	}

	public int getContadorTalao() {
		return contadorTalao;
	}

	public void setContadorTalao(int contadorTalao) {
		this.contadorTalao = contadorTalao;
	}
	
	public void pagarDebito(double valorDebito) {
		// escrever código
	}
	
	public void pedirTalao() {
		// escrever código relacionado a pedir talao
	}
	
	public ContaCorrente cadastrarContaCorrente() {
		ContaCorrente contaCorrenteTemp = new ContaCorrente();
		
		// escrever código para cadastrar cliente
		
		return contaCorrenteTemp;
	}
}
/*
		
		// Padronizar nome da variavel. Ex: titularConta;
		private String titular;
		
		// Tirar daqui
		private double valor;
		
		// Padronizar. Ex: contaEspecial. Encapsular
		boolean especial;
		
		// Encapsular
		double limiteEspecial;

		// Modularizar o codigo
		// Método contaCorrente() virar método criarContaCorrente()
      public ContaCorrente() {
    	 
    	  // Inserir o trem lá do tempo
    	  // Atualizar os atributos
    	    System.out.println("Olá vamos iniciar o seu cadastro!");
    	    TimeUnit.SECONDS.sleep(2);
			System.out.println("Estamos processando sua solicitação!");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Por favor informe seu Nome Completo: ");
			titular = leia.nextLine();
			System.out.println("Por favor informe seu CPF: ");
			// this.setSaldoConta(scanner);
			// Sempre depois de usar um scanner para variáveis do tipo numérico(int, double), caractere, usar logo depois
			// um scanner.nextLine() para limpar o buffer do teclado.
			cpf = leia.nextFloat();
			System.out.println("Valor de depósito inicial: (Mínimo R$ 50,00)");
			valor = leia.nextDouble();
			// Validar o valor que será depositado
			depositoInicial(valor);
			System.out.println("Bem Vindo(a), " + titular);
			System.out.println("Sua Conta Corrente já está em operação!");
		

			// fazer sobrescrita do método debitar e creditar
		boolean sacar(double valor) {
			System.out.println("Informe o valor do saque: ");
			valor = leia.nextDouble();
			if(saldo>=valor) {
			System.out.println("Realizando Saque... " + valor);
			TimeUnit.SECONDS.sleep(3);
			saldo -= valor;
			return true;
		}else{
			if(especial){
				double limite = limiteEspecial + saldo;
				if(limite>=valor){
				saldo -= valor;
				return true;
				}else{
				return false;
				}else{
				return false;
				}
			}
		}
		}
		public double depositar(double valor) {
			System.out.println("Informe o valor do depósito: ");
			valor = leia.nextDouble();
			
			System.out.println("Realizando Depósito... " + valor);
			return saldo = saldo + valor;
		}

		public double depositoInicial(double valor) {
			return saldo = saldo + valor;
		}

		public void transferir(Conta c, double valor) {
			System.out.println("Informe o valor da Transferência: ");
			valor = leia.nextDouble();
			System.out.println("Transferindo valor... " + valor);
			System.out.println("Saldo: " + getSaldo());
			sacar();
			c.depositar();
	}
*/