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
		System.out.println("Conatus Inc.");
		System.out.println("Transformando o dinheiro em oportunidade");
		System.out.println();
	}
	
	public void telaContaEspecial(ContaEspecial conta) {
		Character opcao;
		ArrayList<Character> opcoesDisponiveis = new ArrayList<>();
		Collections.addAll(opcoesDisponiveis, '1','2','3','4','5','6','7');
		
		this.telaCabecalho();
		
		System.out.println("\t1. Perfil");
		System.out.println("\t2. Transferir");
		System.out.println("\t3. Depositar");
		System.out.println("\t4. Pagar Conta");
		System.out.println("\t5. Extrato Bancário");
		System.out.println("\t6. Suporte");
		System.out.println("\t7. Sair");
		
		System.out.println();
		
		System.out.println("Digite o número da opção desejada");
		System.out.print("→ ");
		opcao = entrada.next().charAt(0);
		entrada.nextLine();
		
		if (!opcoesDisponiveis.contains(opcao)) {
			System.out.println();
			System.out.println("Opção inválida. Por favor, digite novamente");
			System.out.print("→ ");
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
		System.out.println("Digite o valor que deseja transferir");
		System.out.print("→ R$ ");
		double valor = entrada.nextDouble();
		entrada.nextLine();
		System.out.println();
		System.out.println("Digite o número da conta");
		System.out.print("→ ");
		String numConta = entrada.nextLine();
		//entrada.nextLine();
		double saldoTotal = conta.getSaldoConta() + conta.getLimiteConta();
		if (saldoTotal < valor)	{
			System.out.println();
			System.out.print("Você não possui saldo suficiente");
			System.out.println();
			this.telaContaEspecial(conta);
			return;
		}
		conta.transferir(valor);
		System.out.println();
		System.out.println("Transferência realizada com sucesso!");
		System.out.println(String.format("SALDO ATUAL R$%.2f", conta.getSaldoConta()));
		System.out.println(String.format("SALDO ESPECIAL R$%.2f", conta.getLimiteConta()));
		System.out.println();
		this.telaContaEspecial(conta);
	}
	
	public void telaPagarConta(ContaEspecial conta) {
		this.telaCabecalho();
		System.out.println("Digite o código do boleto");
		System.out.print("→ ");
		entrada.nextLine();
		System.out.println();
		System.out.println("Digite o valor da conta");
		System.out.print("→ R$ ");
		double valor = entrada.nextInt();
		entrada.nextLine();
		double saldoTotal = conta.getSaldoConta() + conta.getLimiteConta();
		if (saldoTotal < valor)	{
			System.out.println();
			System.out.print("Você não possui saldo suficiente");
			System.out.println();
			this.telaContaEspecial(conta);
			return;
		}
		conta.pagarBoleto(valor);
		System.out.println();
		System.out.println("Pagamento efetuado com sucesso!");
		System.out.println(String.format("SALDO ATUAL R$%.2f", conta.getSaldoConta()));
		System.out.println(String.format("SALDO ESPECIAL R$%.2f", conta.getLimiteConta()));
		System.out.println();
		this.telaContaEspecial(conta);
		return;
	}
	
	public void telaDeposito(ContaEspecial conta) {
		this.telaCabecalho();
		System.out.println("Digite o valor que deseja depositar");
		System.out.print("→ R$ ");
		double valor = entrada.nextDouble();
		entrada.nextLine();
		System.out.println();
		conta.depositar(valor);
		System.out.println("Depósito realizado com sucesso!");
		System.out.println(String.format("SALDO ATUAL R$%.2f", conta.getSaldoConta()));
		System.out.println(String.format("SALDO ESPECIAL R$%.2f", conta.getLimiteConta()));
		System.out.println();
		this.telaContaEspecial(conta);
		return;
		
	}
	
	public void telaExtrato(ContaEspecial conta) {
		System.out.println();
		System.out.println(">>>>> Extrato de Movimentação Bancária <<<<<");
		for(MovimentoBancario movimento: conta.getExtratoMovimentoBancario()) {
			System.out.println(movimento.toString());
		}
		System.out.println();
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
		System.out.println("Digite o seu nome");
		System.out.print("→ ");
		entrada.nextLine();
		System.out.println();
		System.out.println("ASSUNTO");
		System.out.print("→ ");
		entrada.nextLine();
		System.out.println();
		System.out.println("MENSAGEM");
		System.out.print("→ ");
		entrada.nextLine();
		System.out.println();
		System.out.println("#######################################################");
		System.out.println("###########  MENSAGEM ENVIADA COM SUCESSO  ############");
		System.out.println("#######################################################");
		System.out.println();
		this.telaContaEspecial(conta);
		
	}

}
