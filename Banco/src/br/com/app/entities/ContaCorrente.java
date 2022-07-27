package br.com.app.entities;

public class ContaCorrente {

	int contadorTalao;

	public void pediTalao() {
		
		Scanner leia = new Scanner(System.in);
		private String titular;
		private float cpf;
		private double valor;
		private double saldo;
		boolean especial;
		double limiteEspecial;

      public ContaCorrente() {
    	 
    	    System.out.println("Olá vamos iniciar o seu cadastro!");
    	    TimeUnit.SECONDS.sleep(2);
			System.out.println("Estamos processando sua solicitação!");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Por favor informe seu Nome Completo: ");
			titular = leia.nextLine();
			System.out.println("Por favor informe seu CPF: ");
			cpf = leia.nextFloat();
			System.out.println("Valor de depósito inicial: (Mínimo R$ 50,00)");
			valor = leia.nextDouble();
			depositoInicial(valor);
			System.out.println("Bem Vindo(a), " + titular);
			System.out.println("Sua Conta Corrente já está em operação!");
		

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
		
		

		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}

		public float getCpf() {
			return cpf;
		}

		public void setCpf(float cpf) {
			this.cpf = cpf;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		}
		
	
	}

}
