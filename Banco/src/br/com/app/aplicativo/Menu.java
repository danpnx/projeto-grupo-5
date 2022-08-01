package br.com.app.aplicativo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import br.com.app.entities.*;

public class Menu {
	
	private final String NOME_DO_BANCO = "[NOME DO BANCO]";
	private final String SLOGAN = "[SLOGAN]";
	
	Scanner entrada = new Scanner(System.in);
	
	public void telaCabecalho() {
		System.out.println("--------------------------------------");
		System.out.println(NOME_DO_BANCO);
		System.out.println(SLOGAN);
		System.out.println();
	}
	
	public void telaContaEspecial(ContaEspecial conta) {
		Character opcao;
		ArrayList<Character> opcoesDisponiveis = new ArrayList<>();
		Collections.addAll(opcoesDisponiveis, '1','2','3','4','5','6','7');
		
		this.telaCabecalho();
		
		System.out.println("\t1. PERFIL");
		System.out.println("\t2. TRANSFERIR");
		System.out.println("\t3. DEPOSITAR");
		System.out.println("\t4. PAGAR CONTA");
		System.out.println("\t5. EXTRATO BANCARIO");
		System.out.println("\t6. SUPORTE");
		System.out.println("\t7. SAIR");
		
		System.out.println();
		
		System.out.print("DIGITE O NUMERO DA OPCAO DESEJADA: ");
		opcao = entrada.next().charAt(0);
		entrada.nextLine();
		
		if (!opcoesDisponiveis.contains(opcao)) {
			System.out.println();
			System.out.print("OPCAO INVALIDA, TENTE NOVAMENTE: ");
			System.out.println();
			this.telaContaEspecial(conta);
		}
		
		switch (opcao) {
			case '1': 
				this.telaPerfil(conta);
				break;
			case '2':
				this.telaTransferencia(conta);
				break;
			case '3': 
				this.telaDeposito(conta);
				break;
			case '4':
				this.telaPagarConta(conta);
				break; 
			case '5': 
				this.telaExtrato(conta);
				break; 
			case '6':
				this.telaSuporte(conta);
				break;
			case '7':
				return;
		}
		
		return;
	}
	
	public void telaPerfil(ContaEspecial conta) {
		this.telaCabecalho();
		String status = conta.isContaAtiva() ? "ATIVADA" : "INATIVADA";
		System.out.println("CONTA:...............ESPECIAL");
		System.out.println("CPF:................." + conta.getCpfConta());
		System.out.println("NUMERO DA CONTA......" + conta.getNumeroConta());
		System.out.println("STATUS DA CONTA......" + status);
		System.out.println();
		System.out.println("APERTE QUALQUER TECLA PARA VOLTAR");
		entrada.nextLine();
		this.telaContaEspecial(conta);		
	}
	
	public void telaTransferencia(ContaEspecial conta) {
		this.telaCabecalho();
		System.out.print("DIGITE O VALOR QUE DESEJA TRANSFERIR: ");
		double valor = entrada.nextDouble();
		System.out.println();
		System.out.print("DIGITE O NUMERO DA CONTA: ");
		String numConta = entrada.next();
		entrada.nextLine();
		double saldoTotal = conta.getSaldoConta() + conta.getLimiteConta();
		if (saldoTotal < valor)	{
			System.out.println();
			System.out.print("VOCE NAO POSSUI SALDO SUFICIENTE");
			System.out.println();
			this.telaContaEspecial(conta);
			return;
		}
		conta.transferir(valor);
		System.out.println();
		System.out.println("TRANSFERENCIA REALIZADA COM SUCESSO!");
		System.out.println(String.format("SALDO ATUAL R$%.2f", conta.getSaldoConta()));
		System.out.println(String.format("SALDO ESPECIAL R$%.2f", conta.getLimiteConta()));
		System.out.println();
		entrada.nextLine();
		this.telaContaEspecial(conta);
	}
	
	public void telaPagarConta(ContaEspecial conta) {
		this.telaCabecalho();
		System.out.print("DIGITE O CODIGO DO BOLETO: ");
		entrada.nextLine();
		System.out.println();
		System.out.print("DIGITE O VALOR DA CONTA: ");
		double valor = entrada.nextInt();
		double saldoTotal = conta.getSaldoConta() + conta.getLimiteConta();
		if (saldoTotal < valor)	{
			System.out.println();
			System.out.print("VOCE NAO POSSUI SALDO SUFICIENTE");
			System.out.println();
			this.telaContaEspecial(conta);
			return;
		}
		conta.pagarBoleto(valor);
		System.out.println();
		System.out.println("PAGAMENTO EFETUADO COM SUCESSO!");
		System.out.println(String.format("SALDO ATUAL R$%.2f", conta.getSaldoConta()));
		System.out.println(String.format("SALDO ESPECIAL R$%.2f", conta.getLimiteConta()));
		System.out.println();
		entrada.nextLine();
		this.telaContaEspecial(conta);
		return;
	}
	
	public void telaDeposito(ContaEspecial conta) {
		this.telaCabecalho();
		System.out.print("DIGITE O VALOR QUE DESEJA DEPOSITAR: ");
		double valor = entrada.nextDouble();
		System.out.println();
		conta.depositar(valor);
		System.out.println("DEPSITO REALIZADO COM SUCESSO!");
		System.out.println(String.format("SALDO ATUAL R$%.2f", conta.getSaldoConta()));
		System.out.println(String.format("SALDO ESPECIAL R$%.2f", conta.getLimiteConta()));
		System.out.println();
		entrada.nextLine();
		this.telaContaEspecial(conta);
		return;
		
	}
	
	public void telaExtrato(ContaEspecial conta) {
		System.out.println();
		System.out.println(conta.getExtratoMovimentoBancario().toString());
		System.out.println();
		entrada.nextLine();
		this.telaContaEspecial(conta);
	}
	
	public void telaSuporte(ContaEspecial conta) {
		this.telaCabecalho();
		System.out.println("ENCONTROU ALGUM PROBLEMA EM NOSSA PLATAFORMA? ENTRE EM CONTATO!");
		System.out.println("----------------------------------------------------------------");
		System.out.println("(SAC) (21) 99876-4321 - (21) 2607-1234");
		System.out.println("(SUPORTE) suporte@email.com");
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		System.out.print("DIGITE SEU NOME: ");
		entrada.nextLine();
		System.out.println();
		System.out.print("ASSUNTO");
		entrada.nextLine();
		System.out.println();
		System.out.println("MENSAGEM:");
		entrada.nextLine();
		System.out.println("#######################################################");
		System.out.println("###########  MENSAGEM ENVIADA COM SUCESSO  ############");
		System.out.println("#######################################################");
		System.out.println();
		entrada.nextLine();
		this.telaContaEspecial(conta);
		
	}

}
