package br.com.app.entities;

import java.util.Scanner;

public class ContaCorrente extends Conta{

	private int contagemTalao = 3;
	private String nomeCliente = "";
	
	Scanner entrada = new Scanner(System.in);
	
	public ContaCorrente(){}
	
	public ContaCorrente(String nome, String cpf,String senhaUsuario){
		this.setNomeCliente(nome);
		this.setCpfConta(cpf);
		this.setSenhaUsuario(senhaUsuario);
	}
	
	public void pediTalao(int qtd) {
		if (this.contagemTalao < qtd) {
			System.out.println("Não possui mais Talão de cheque disponível!");
		}else {
		if(this.saldoConta >= 30 * qtd) {
			this.contagemTalao-=qtd;
			this.debitarValor(30*qtd);
			this.registrarContagemMovimentosBancarios();
			System.out.println("Talão de cheque disponibilizado com sucesso");
		}else {
			System.out.println("Saldo insuficiente, efetue um deposito. ");
			}
		}	
	}
	
	public int getContagemTalao() {
		return this.contagemTalao;
	}

	public void setContagemTalao(int contagemTalao) {
		this.contagemTalao = contagemTalao;
	}

	@Override
	public void debitarValor(double valorDebitado) {
			if(this.saldoConta>=valorDebitado){
				this.saldoConta -= valorDebitado;
				this.registrarContagemMovimentosBancarios();
				this.registrarMovimentoBancario(new MovimentoBancario(valorDebitado, "D"));
				System.out.println("Pagamento efetuado com Sucesso!");
				
			}else {
				System.out.println("Saldo insuficiente");
			}
			}
		
	@Override 
	public void creditarValor(double valorCreditado) {
		
		this.saldoConta += valorCreditado;
		this.registrarContagemMovimentosBancarios();
		this.registrarMovimentoBancario(new MovimentoBancario(valorCreditado,"C"));
	}
	
	public void extratoContaCorrente() {
		for(MovimentoBancario movimento: this.getExtratoMovimentoBancario()) {
			System.out.println(movimento.toString());
		}
		System.out.println("TOTAL DE MOVIMENTAÇÕES BANCÁRIAS: " + this.getContagemMovimentos());
	}
		
	public void depositoConta() {
		System.out.println();
		System.out.print("Deseja realizar uma deposito? S/N: ");
		Character depositarAgora = '0';
		depositarAgora = Character.toUpperCase(scanner.next().charAt(0));
		scanner.nextLine();
		
		while(depositarAgora != 'S' && depositarAgora != 'N') {
			System.out.println();
			System.out.print("Por favor verifique novamente! S/N: ");
			depositarAgora = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
		}
		
		if(depositarAgora.equals('S')) {
			System.out.print("Digite o valor do deposito: ");
			double valorTemp = Double.parseDouble(scanner.nextLine());
			this.creditarValor(valorTemp);
			this.setContaAtiva(true);
			System.out.println("Deposito realizado com Sucesso!");
					}
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}	
	