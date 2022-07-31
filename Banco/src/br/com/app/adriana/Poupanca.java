package br.com.app.adriana;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Adriana

// extrato com DEZ movimentos
// debito private - Reduzir valor saque do saldo e informar atualizado
// credito publico - Aumentar valor saque do saldo e informar atualizado
// valor não pode ficar negativo

		public class Poupanca {

	 	
	 	private double saldo;
		private List<Transacao> transacoes = new ArrayList<>();
		public String nome;
		public int conta;
		
//		Scanner input = new Scanner(System.in);
		
		public int menupoup;
		
		
//		double inicial;
//		double entrada
//		date data:	
//		Scanner deposito = new Scanner(System.in);
//				
//		List<double> valor  = new		
//		
//		public Conta(String nome, int conta, doule saldoinicial) {
//			this.nome=nome;
//			this.conta=conta;
//			saldo=saldoinicial;
//			
//		}
//		
//	}

		public void deposito(double valor) {   // public double deposito(double valor)
			Transacao tr = new Transacao();
			tr.setData(new Date());
			tr.setTipoMovimento("Crédito");
			tr.setValor(valor);
			System.out.println("Informe o valor depósito: ");
			transacoes.add(tr);
			saldo += valor;
			System.out.println("Saldo Atualizado" + saldo);
			
		}

		public void saque(double valor) {   // publig string sacar(double valor)
			Transacao tr = new Transacao();
			tr.setData(new Date());
			tr.setTipoMovimento("Débito");
			tr.setValor(valor);
			System.out.println("Informe o valor para saque: ");
				if(saldo < valor) {
					System.out.println("Saldo Insuficiente");   // return "Saldo Insuficiente"
				}else {
					transacoes.add(tr);
					saldo -= valor;
					System.out.println("Saque efetuado com sucesso");
					System.out.println("Saldo Atualizado" + saldo);  //return saldo
				}
		}

			public void extrato() {
				System.out.println("EXTRATO");
				System.out.println("Conta: " + this.conta);
				System.out.println("Nome: " + this.nome);
				System.out.println("Saldo Atual: " + this.saldo);
				for (int i=0; i<transacoes.size(); i++) {
					System.out.println(transacoes.get(i).getData() + "  " + transacoes.get(i).getTipoMovimento() +  "  " + transacoes.get(i).getValor());
				}
		}				
				
				
		
//		
//	public void calculoRendimento
//	if diaRendimento = datahoje
//		
//	saldo = (saldo *0.05)+saldo          \\     saldo += saldo * 0,05
//	
//			Calendar hoje = calendar.getInstance();
//	if (diaRendimento == hoje.get(Calendar.day_of_month)) {
//	saldo += saldo * taxaRendimento;
		
		
		
//		public void menu() {
//			do {
//			System.out.println("Escolha a opção desejada: ");
//			System.out.println("1. Depósito");
//			System.out.println("2. Saque");
//			System.out.println("3. Extrato");
//			System.out.println("4. Deseja acessar outro tipo de conta");
//			System.out.println("5. Sair");
//			System.out.print("Opção: ");
//				opmenupoup = input.nextInt();
//			}while(opmenupoup!=5);
//		
//		public void selecionarOpcao(int opcao) {
//			double valor;
//			switch(opcao) {
//			case 1:
//				deposito();
//				break;
//			case 2:
//				saque();
//				break;
//			case 3:
//				extrato();
//				break;
//			case 4:
//				menuInicial();
//				break;
//			case 5: 
//				System.out.println("Sistema Finalizado");
//				break
//				
//				default:
//					System.out.println("Opção Inválida");	
//		
//			}
//		}
//		
//		
//		public void menuPrincipal() {
//			
//			System.out.println("1. Conta Poupança");
//			System.out.println("2. Conta Corrente");
//			System.out.println("3. Conta Especial");
//			System.out.println("4. Conta Empresa");
//			System.out.println("5. Conta Estudantil");
//			System.out.println("6. Sair");
//			System.out.println("Digite a opção selecionada: );
//			
//					
//					
//					public void selecionarOpcao2(int opcao2) {
//						double valor;
//						switch(opcao2) {
//						case 1:
//							Conta Poupanca;
//							break;
//						case 2:
//							Conta Corrente;
//							break;
//						case 3:
//						Conta Especial;
//							break
//						case 4:
//						Conta Empresa;
//							break
//						case 5:
//							Conta Estudantil;
//							break;
//						case 6:
//							Sair
//							System.out.println("Sistema Finalizado");
//							break
//							
//							default:
//								System.out.println("Opção Inválida");
//						}
//					}
//					
		}
	