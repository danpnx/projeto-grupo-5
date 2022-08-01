package br.com.app.aplicativo;

import br.com.app.entities.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Aplicativo {

	static ContaCorrente minhaContaCorrente = new ContaCorrente();
	static ContaEmpresa minhaContaEmpresa = new ContaEmpresa();
	static ContaEspecial minhaContaEspecial = new ContaEspecial();
	static ContaEstudantil minhaContaEstudantil = new ContaEstudantil();
	static ContaPoupanca minhaContaPoupanca = new ContaPoupanca();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		menuInicial();

		scanner.close();
	}
	
	// AUTOR: DANIEL
	public static void menuInicial() throws InterruptedException {
		Character escolhaMenuInicial = '0';
		do {
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println("\t1. LOGIN");
			System.out.println("\t2. CRIAR CONTA");
			System.out.println("\t3. FECHAR APLICATIVO");
			System.out.println();
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaMenuInicial = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!escolhaMenuInicial.equals('1') && !escolhaMenuInicial.equals('2') && !escolhaMenuInicial.equals('3')) {
				System.out.print("⚠ CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaMenuInicial = scanner.next().charAt(0);
				scanner.nextLine();
			}
			System.out.println();
			if(escolhaMenuInicial.equals('1')) {
				login();
			}else if(escolhaMenuInicial.equals('2')) {
				menuCriarConta();
			}else {
				break;
			}
		} while(!escolhaMenuInicial.equals('3'));
	}
	
	// AUTOR: DANIEL
	public static void login() throws InterruptedException {	
		Character escolhaLogin = '0';
		do {
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println("\t1. PESSOA FÍSICA");
			System.out.println("\t2. PESSOA JURÍDICA");
			System.out.println("\t3. VOLTAR");
			System.out.println();
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaLogin = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!escolhaLogin.equals('1') && !escolhaLogin.equals('2') && !escolhaLogin.equals('3')) {
				System.out.println("⚠ CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaLogin = scanner.next().charAt(0);
				scanner.nextLine();
			}	
			System.out.println("------------------------------");
			if(escolhaLogin.equals('1')) {
				// Pessoa Física
				System.out.println("[NOME DO BANCO]");
				System.out.println("[SLOGAN]");
				System.out.println();
				
				System.out.print("CPF: ");
				String cpfLogin = scanner.nextLine();
				System.out.print("SENHA: ");
				String senhaLogin = scanner.nextLine();
				
				Character retornoVerificarLoginPessoaFisica = '0';
				retornoVerificarLoginPessoaFisica = verificarLoginPessoaFisica(cpfLogin, senhaLogin);
				
				// Ao efetuar o login, abrirá o menu referente à conta
				if(retornoVerificarLoginPessoaFisica.equals('1')) {
					menuContaPoupanca();
					
				} else if(retornoVerificarLoginPessoaFisica.equals('2')) {
					menuContaCorrente();
					
				} else if(retornoVerificarLoginPessoaFisica.equals('3')) {
					menuContaEspecial();
					
				}else if(retornoVerificarLoginPessoaFisica.equals('4')) {
					menuContaEstudantil();
					
				} else {
					System.out.println("⚠ CPF OU SENHA INVÁLIDA.");
				}				
			}else if(escolhaLogin.equals('2')) {
				System.out.print("CNPJ: ");
				String cnpjLogIn = scanner.nextLine();
				System.out.print("SENHA: ");
				String senhaLogIn = scanner.nextLine();
				
				Character retornoVerificarLogInPessoaJuridica = '0';
				retornoVerificarLogInPessoaJuridica = verificarLoginPessoaJuridica(cnpjLogIn, senhaLogIn);
				if(retornoVerificarLogInPessoaJuridica.equals('1')) {
					System.out.println("------------------------------");
					menuContaEmpresa();
				} else {
					System.out.println("⚠ CPF OU SENHA INVÁLIDA.");
					System.out.println("------------------------------");
				}		
			}else {
				break;
			}
		}while(!escolhaLogin.equals('3'));
	}
	
	// AUTOR: DANIEL
	public static Character verificarLoginPessoaFisica(String cpfLogin, String senhaLogin) {
		char verificaLogIn = '0';
		
		if(minhaContaPoupanca.getCpfConta().equals(cpfLogin) && minhaContaPoupanca.getSenhaUsuario().equals(senhaLogin)) {
			verificaLogIn = '1';
			
		} else if(minhaContaCorrente.getCpfConta().equals(cpfLogin) && minhaContaCorrente.getSenhaUsuario().equals(senhaLogin)) {
			verificaLogIn = '2';
			
		}else if(minhaContaEspecial.getCpfConta().equals(cpfLogin) && minhaContaEspecial.getSenhaUsuario().equals(senhaLogin)) {
			verificaLogIn = '3';
			
		}else if(minhaContaEstudantil.getCpfConta().equals(cpfLogin) && minhaContaEstudantil.getSenhaUsuario().equals(senhaLogin)) {
			verificaLogIn = '4';
			
		}else {
			verificaLogIn = '0';	
		}
		
		return verificaLogIn;
	}
	
	// AUTOR: DANIEL
	public static Character verificarLoginPessoaJuridica(String cnpjLogin, String senhaLogin) {
		char verificaLogIn = '0';
		
		if(minhaContaEmpresa.getCnpjEmpresa().equals(cnpjLogin) && minhaContaEmpresa.getSenhaUsuario().equals(senhaLogin)) {
			verificaLogIn = '1';
		} else {
			verificaLogIn = '0';
		}
		
		return verificaLogIn;
	}
	
	// AUTOR: DANIEL
	public static void menuCriarConta() throws InterruptedException {
		Character escolhaMenuCriarConta = '0';
		
		do {
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println("\t1. CONTA POUPANÇA");
			System.out.println("\t2. CONTA CORRENTE");
			System.out.println("\t3. CONTA ESPECIAL");
			System.out.println("\t4. CONTA EMPRESA");
			System.out.println("\t5. CONTA ESTUDANTIL");
			System.out.println("\t6. VOLTAR");
			System.out.println();
			
			ArrayList<Character> opcoesMenuCriarConta = new ArrayList<>();
			Collections.addAll(opcoesMenuCriarConta, '1', '2', '3', '4', '5', '6');
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaMenuCriarConta = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!opcoesMenuCriarConta.contains(escolhaMenuCriarConta)) {
				System.out.print("⚠ CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaMenuCriarConta = scanner.next().charAt(0);
				scanner.nextLine();
			}
			System.out.println();
			switch(escolhaMenuCriarConta) {
			case '1':{
				// Criar Conta Poupança
				break;
				}
			case '2':{
				// AUTOR: LUCAS PEREIRA
				System.out.println("Olá aguarde já iremos iniciar o seu cadastro!");
			    TimeUnit.SECONDS.sleep(2);
				System.out.println("Por favor informe seu Nome: ");
				String nomeClienteTemp = scanner.nextLine().toUpperCase();
				System.out.println("Por favor informe seu CPF: ");
				String cpfConta = scanner.nextLine();
				System.out.println("Digite a Senha:");
				String senhaTemp = scanner.nextLine();
								
				boolean verificacaoSenha = verificarSenha(senhaTemp);
				while(!verificacaoSenha) {
					System.out.println();
					System.out.print("⚠ A SUA SENHA DEVE CONTER PELO MENOS UM CARACTERE ESPECIAL. POR FAVOR, DIGITE NOVAMENTE: ");
					senhaTemp = scanner.nextLine();
					verificacaoSenha = verificarSenha(senhaTemp);
					System.out.println();
				}
					
				System.out.println();
				ContaCorrente contaCorrenteTemp = new ContaCorrente(nomeClienteTemp, cpfConta, senhaTemp);
				minhaContaCorrente = contaCorrenteTemp;
				System.out.println("xxxxxxConta Corrente criada com Sucessoxxxxx!");
				System.out.println();
				System.out.println("Saldo:" + minhaContaCorrente.getSaldoConta());
				
				menuContaCorrente();
							
				break;
				}
			case '3':{
				// Criar Conta Especial
				System.out.println("------------------------------");
				
				System.out.print("CPF: ");
				String cpf = scanner.nextLine();
				
				System.out.print("NÚMERO DA CONTA: ");
				int numero = scanner.nextInt();
				
				System.out.print("SENHA: ");
				String senha = scanner.nextLine();
				
				boolean senhaValida = verificarSenha(senha);
				while (!senhaValida) {
					System.out.println();
					System.out.println("A SUA SENHA DEVE CONTER PELO MENOS UM CARACTERE ESPECIAL. POR FAVOR, DIGITE NOVAMENTE: ");
					System.out.print("SENHA: ");
					senha = scanner.nextLine();
					senhaValida = verificarSenha(senha);
				}
				
				minhaContaEspecial = new ContaEspecial(cpf, numero);
				System.out.println();
				System.out.println("CONTA ESPECIAL CRIADA COM SUCESSO!");
				menuContaEspecial();
				break;
				
				}
			case '4':{
				// Criar Conta Empresarial
				// AUTOR: DANIEL
				System.out.println("------------------------------");
				System.out.print("NOME DA EMPRESA: ");
				String nomeTemp = scanner.nextLine().toUpperCase();
				System.out.print("CNPJ: ");
				String cnpjTemp = scanner.nextLine();
				System.out.print("NÚMERO DA CONTA: ");
				int numeroTemp = Integer.parseInt(scanner.nextLine());
				System.out.print("SENHA: ");
				String senhaTemp = scanner.nextLine();
				
				
				boolean verificacaoSenha = verificarSenha(senhaTemp);
				while(!verificacaoSenha) {
					System.out.println();
					System.out.print("⚠ A SUA SENHA DEVE CONTER PELO MENOS UM CARACTERE ESPECIAL. POR FAVOR, DIGITE NOVAMENTE: ");
					senhaTemp = scanner.nextLine();
					verificacaoSenha = verificarSenha(senhaTemp);
				}
				// FIM VERIFICAÇÃO SENHA
				
				scanner.nextLine();
				System.out.println("A SUA CONTA PJ ESTÁ SENDO CRIADA...");
				ContaEmpresa contaEmpresaTemp = new ContaEmpresa(nomeTemp, cnpjTemp, numeroTemp, senhaTemp);
				minhaContaEmpresa = contaEmpresaTemp;
				System.out.println("CONTA PJ FOI CRIADA COM SUCESSO!");
				minhaContaEmpresa.ativarConta();
				System.out.println("------------------------------");
				menuContaEmpresa();
				break;
				}
			case '5':{
				// Criar Conta Estudantil
				System.out.println("---------------------------------------------------");
				System.out.println("                      BANK-DO                      ");
				System.out.println("                'UNDER YOUR CONTROL'               ");
				System.out.println("Seja bem vindo a um novo conceito de banco digital.");
				System.out.println("---------------------------------------------------");
				System.out.println("              CONTA [CONTA ESTUDANTIL]             ");
				System.out.println("---------------------------------------------------");
				System.out.println("Deseja cadastrar sua conta? Digite S ou N");
				System.out.print("para encerrar a operação: ");
				char escolha = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
				
				while(escolha != 'N' && escolha != 'S') {
				System.out.print("Digite uma opção válida: ");
				escolha = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
				}
				
				if(escolha == 'S') {
				System.out.println("");
				System.out.print("Digite o seu nome: ");
				String nome = scanner.nextLine();
				System.out.print("Digite o número da sua agência: ");
				String agencia = scanner.nextLine();
				System.out.print("Digite o número da sua Conta: ");
				int numero = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Digite o número do seu CPF: ");
				String CPF = scanner.nextLine();
				System.out.print("Digite a sua senha: ");
				String senha = scanner.nextLine();
				boolean verificar = verificarSenha(senha);
				while (!verificar) {
				System.out.println("Digite uma senha que contenha pelo menos um caractere especial: ");
				senha = scanner.nextLine();
				verificar = verificarSenha(senha);
				}
				ContaEstudantil ContaTemp = new ContaEstudantil(nome, agencia, numero, CPF, senha);
				minhaContaEstudantil = ContaTemp;
				minhaContaEstudantil.setContaAtiva(true);
				
				minhaContaEstudantil.ativarSaldo();
				
				System.out.println("---------------------------------------------------");
				System.out.println("                          "+ minhaContaEstudantil.getNome() +"                  ");
				System.out.println("");
				System.out.println("          Conta: " + minhaContaEstudantil.getNumeroConta() + "  -  " + "Agência: " + minhaContaEstudantil.getAgencia());
				System.out.println("");
				System.out.println(" Sua conta foi cadastrada!" + " Seu saldo é: R$ " + minhaContaEstudantil.getSaldoConta());
				System.out.println("----------------------------------------------------");
				menuContaEstudantil();
				
				} else {
				System.out.println();	
				System.out.println("Sua operação foi encerrada.");
				System.out.println();	
				return ;
				}
				break;
				}
			case '6':{
				break;
				}
			}
		}while(!escolhaMenuCriarConta.equals('6'));
	}
	
	// AUTOR: DANIEL
	public static boolean verificarSenha(String senha) {
		boolean verificacao;
		ArrayList<String> listaCaracteresEspeciais = new ArrayList<>();
		Collections.addAll(listaCaracteresEspeciais, " ", "!", "\"", "#", "$", "%", "&", "\'", "(", ")", "*", "+", ",",
			"-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "´", "`", "{", "|", "}", "~");
		
		ArrayList<String> listaCaracteresSenhaUsuario = new ArrayList<String>(Arrays.asList(senha.split("")));
		listaCaracteresSenhaUsuario.retainAll(listaCaracteresEspeciais);
		
		if(listaCaracteresSenhaUsuario.size() == 0) {
			verificacao = false;
		} else {
			verificacao = true;
		}
		
		return verificacao;
	}
	
	// Autor
	public static void menuContaPoupanca() {
		// Criar Menu Conta Poupança
	}
	
	// Autor LUCAS
	public static void menuContaCorrente() throws InterruptedException {
		// Criar Menu Conta Corrente
			char opcaoMenu = '0';
			do {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("xxxxxxEscolha alguma das opções abaixo:xxxxx ");
			System.out.println();
			System.out.println("1. Depósito");
			System.out.println("2. Talão de Cheque");
			System.out.println("3. Pagamentos");
			System.out.println("4. Extrato da conta");
			System.out.println("5. Sair");	
			System.out.println();
			System.out.print("Digite a opção desejada: ");
			opcaoMenu = scanner.next().charAt(0);
			scanner.nextLine();
			switch (opcaoMenu) {
				case '1': {
				System.out.println("Digite o valor que deseja depositar: ");
			    double valor = scanner.nextDouble();
			    scanner.nextLine();
			    minhaContaCorrente.creditarValor(valor);
			    System.out.println("Deposito efetuado com Sucesso!");
			    System.out.println("Saldo:" + minhaContaCorrente.getSaldoConta());
			    System.out.println();
			    
						
			break;
			}
			case '2':{
			     System.out.println("Informe a quantidade de talão de cheque que irá querer: ");
			     int valor = scanner.nextInt();
			     scanner.nextLine();
			     minhaContaCorrente.pediTalao(valor);
			        System.out.println("Saldo:" + minhaContaCorrente.getSaldoConta());
				    System.out.println();
			     break;
			}
			case '3':{
			     System.out.println("Digite o valor que deseja efetuar o pagamento: ");
			     double valor = scanner.nextDouble();
			     scanner.nextLine();
			     minhaContaCorrente.debitarValor(valor);
			        System.out.println("Saldo:" + minhaContaCorrente.getSaldoConta());
				    System.out.println();
			     break;
			}
			case '4':{
				System.out.println("Aguarde que estamos gerando seu Extrato de Movimentação");
				TimeUnit.SECONDS.sleep(2);
				for (MovimentoBancario transacao: minhaContaCorrente.getExtratoMovimentoBancario()) {
					System.out.println(transacao.toString());
					System.out.println("-------------Extrato de Movimentação-----------!");
				    System.out.println();
				}
				break;
				}
			case '5':{
				System.out.println("Sair");
			}		
			}
			}while(opcaoMenu!= '5');
			
	}
	
	// Autor
	public static void menuContaEspecial() throws InterruptedException {
		// Criar Menu Conta Especial
		Menu menu = new Menu();
		menu.telaContaEspecial(minhaContaEspecial);
		menuInicial();
		
	}
	
	// AUTOR: DANIEL
	public static void menuContaEmpresa() {
		// Criar Menu Conta Empresa
		Character escolhaMenuContaEmpresa = '0';
		 do {
			ArrayList<Character> opcoesMenuContaEmpresa = new ArrayList<>();
			Collections.addAll(opcoesMenuContaEmpresa, '1','2','3','4','5','6','7','8');
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println(minhaContaEmpresa.getNomeEmpresa());
			System.out.println("CONTA PJ\t" + minhaContaEmpresa.getNumeroConta());
			System.out.println();
			
			if(minhaContaEmpresa.isContaAtiva()) {
				System.out.printf("SALDO: %.2f\n", minhaContaEmpresa.getSaldoConta());
			} else {
				System.out.println("CONTA INATIVA");
			}
			System.out.println();
			
			System.out.println("\t1. PERFIL");
			System.out.println("\t2. ÁREA PIX");
			System.out.println("\t3. PAGAR");
			System.out.println("\t4. RECEBER");
			System.out.println("\t5. EMPRÉSTIMO");
			System.out.println("\t6. EXTRATO");
			System.out.println("\t7. CÂMBIO");
			System.out.println("\t8. SAIR");
			System.out.println();
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaMenuContaEmpresa = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!opcoesMenuContaEmpresa.contains(escolhaMenuContaEmpresa)) {
				System.out.print("⚠ CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaMenuContaEmpresa = scanner.next().charAt(0);
				scanner.nextLine();
				System.out.println();
			}
			System.out.println("------------------------------");
			switch(escolhaMenuContaEmpresa) {
			case '1':{
				// PERFIL
				System.out.println("\t★ [NOME DO BANCO]");
				System.out.println();
				System.out.println("AGÊNCIA " + minhaContaEmpresa.getAgenciaEmpresa() + "\t" + "CONTA " + minhaContaEmpresa.getNumeroConta());
				System.out.println(minhaContaEmpresa.getNomeEmpresa() + "\t" + "CNPJ " + minhaContaEmpresa.getCnpjEmpresa());
				System.out.println("BANCO 123 ★ [NOME BANCO] INC.");
				System.out.println("------------------------------");
				break;
				}
			case '2':{
				// ÁREA PIX
				System.out.println("\t★ [NOME DO BANCO]");
				System.out.println();
				System.out.println("\t1. CADASTRAR CHAVE PIX");
				System.out.println("\t2. MINHA CHAVE PIX");
				System.out.println("\t3. VOLTAR");
				System.out.println();
				
				System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
				Character escolhaPix = scanner.next().charAt(0);
				scanner.nextLine();
				
				while(escolhaPix != '1' && escolhaPix != '2' && escolhaPix != '3') {
					System.out.print("⚠ CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
					escolhaPix = scanner.next().charAt(0);
					scanner.nextLine();
				}
				System.out.println("------------------------------");
				if(escolhaPix.equals('1')) {
					// CADASTRAR CHAVE PIX
					minhaContaEmpresa.cadastrarChavePix();
					System.out.println("------------------------------");
				}else if(escolhaPix.equals('2')) {
					// MINHA CHAVE PIX
					minhaContaEmpresa.mostrarChavePix();
					System.out.println("------------------------------");
				} else {
					break;
				}
				break;
				}
			case '3':{
				// PAGAR
				System.out.println("\t★ [NOME DO BANCO]");
				System.out.println();
				System.out.println("SELECIONE A FORMA DE PAGAMENTO");
				System.out.println();
				
				System.out.println("\t1. DÉBITO");
				System.out.println("\t2. PIX");
				System.out.println("\t3. BOLETO");
				System.out.println("\t4. VOLTAR");
				
				System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
				Character escolhaPagamento = scanner.next().charAt(0);
				scanner.nextLine();
				
				while(escolhaPagamento != '1' && escolhaPagamento != '2' && escolhaPagamento != '3'&& escolhaPagamento != '4') {
					System.out.print("⚠ CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
					escolhaPagamento = scanner.next().charAt(0);
					scanner.nextLine();
				}
				System.out.println("------------------------------");
				if(escolhaPagamento.equals('1')) {
					// DÉBITO
					if(minhaContaEmpresa.isContaAtiva()) {
						System.out.println("PAGUE À VISTA");
						System.out.printf("SALDO ATUAL: %.2f\n", minhaContaEmpresa.getSaldoConta());
						System.out.println();
						System.out.print("VALOR: ");
						double valorTemp = Double.parseDouble(scanner.nextLine());
						
						while(valorTemp <= 0.0) {
							System.out.print("⚠ DIGITE UM VALOR ACIMA DE R$ 0.00: ");
							valorTemp = Double.parseDouble(scanner.nextLine());
						}
						
						System.out.print("SENHA: ");
						String senhaTemp = scanner.nextLine();
						
						while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
							System.out.print("⚠ SENHA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
							senhaTemp = scanner.nextLine();
						}
						
						if(minhaContaEmpresa.getSaldoConta() >= valorTemp) {
							System.out.println("PROCESSANDO O PAGAMENTO...");
							minhaContaEmpresa.debitarValor(valorTemp);
							System.out.println("PAGAMENTO EFETUADO!");
							minhaContaEmpresa.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "DÉBITO AUTOMÁTICO"));
							System.out.println("------------------------------");
						}else {
							System.out.println("SALDO INSUFICIENTE ☹");
							System.out.println("------------------------------");
						}
					}else {
						minhaContaEmpresa.ativarConta();
						System.out.println("------------------------------");
					}
				} else if(escolhaPagamento.equals('2')) {
					// PIX
					System.out.println("FORMA DE PAGAMENTO: PIX");
					System.out.printf("SALDO ATUAL: %.2f\n", minhaContaEmpresa.getSaldoConta());
					System.out.println();
					System.out.print("CHAVE PIX: ");
					String chavePixTemp = scanner.nextLine();
					System.out.print("VALOR: ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					
					while(valorTemp <= 0.0) {
						System.out.print("⚠ DIGITE UM VALOR ACIMA DE R$ 0.00: ");
						valorTemp = Double.parseDouble(scanner.nextLine());
					}
					System.out.print("SENHA: ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.print("⚠ SENHA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
						senhaTemp = scanner.nextLine();
					}
					
					System.out.println();
					System.out.println("PROCESSANDO O PAGAMENTO...");
					System.out.println();
					minhaContaEmpresa.pagarPix(valorTemp, chavePixTemp);
					System.out.println("------------------------------");
				} else if(escolhaPagamento.equals('3')){
					// BOLETO
					if(minhaContaEmpresa.isContaAtiva()) {
						System.out.println("FORMA DE PAGAMENTO: BOLETO BANCÁRIO");
						System.out.printf("SALDO ATUAL: %.2f\n", minhaContaEmpresa.getSaldoConta());
						System.out.println();
						
						System.out.print("VALOR DO BOLETO: ");
						double valorTemp = Double.parseDouble(scanner.nextLine());
						
						while(valorTemp <= 0.0) {
							System.out.print("⚠ DIGITE UM VALOR ACIMA DE R$ 0.00: ");
							valorTemp = Double.parseDouble(scanner.nextLine());
						}
						
						System.out.print("SENHA: ");
						String senhaTemp = scanner.nextLine();
						
						while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
							System.out.print("⚠ SENHA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
							senhaTemp = scanner.nextLine();
						}
						
						String boletoTemp = minhaContaEmpresa.gerarBoleto(valorTemp);
						System.out.println("CÓDIGO DO BOLETO: " + boletoTemp);
						
						if(minhaContaEmpresa.getSaldoConta() >= valorTemp) {
							System.out.println("PROCESSANDO PAGAMENTO...");
							minhaContaEmpresa.pagarBoleto(valorTemp, boletoTemp);
							System.out.println("------------------------------");
						}else {
							System.out.println("SALDO INSUFICIENTE ☹");
							System.out.println("------------------------------");
						}
					}else {
						minhaContaEmpresa.ativarConta();
						System.out.println("------------------------------");
					}
				} else {
					break;
				}
				break;
				}
			case '4':{
				// RECEBER
				System.out.println("\t★ [NOME DO BANCO]");
				System.out.println();
				if(minhaContaEmpresa.isContaAtiva()) {
					double contRecebiveis = 0;
					for(double recebivel: minhaContaEmpresa.getRecebiveisEmpresa()) {
						contRecebiveis += recebivel;
					}
					
					System.out.println("VOCÊ POSSUI UM TOTAL DE R$ " + contRecebiveis + " A RECEBER!");
					System.out.println("\t1. VER CONTAS A RECEBER");
					System.out.println("\t2. CADASTRAR CONTA A RECEBER");
					System.out.println("\t3. ANTECIPAR RECEBÍVEL");
					System.out.println("\t4. UTILIZE OS DADOS DA SUA CONTA PARA RECEBER TRANSFERÊNCIAS USANDO PIX, TED E DOC");
					System.out.println("\t5. VOLTAR");
					System.out.println();
					ArrayList<Character> menuReceber = new ArrayList<>();
					Collections.addAll(menuReceber, '1','2','3','4','5');
					
					System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
					Character escolhaMenuReceber = scanner.next().charAt(0);
					scanner.nextLine();
					
					while(!menuReceber.contains(escolhaMenuReceber)) {
						System.out.print("⚠ CÓDIGO INVÁLIDO! POR FAVOR, DIGITE NOVAMENTE: ");
						escolhaMenuReceber = scanner.next().charAt(0);
						scanner.nextLine();
					}
					System.out.println("------------------------------");
					if(escolhaMenuReceber.equals('1')) {
						// MOSTRAR CONTAS A RECEBER
						minhaContaEmpresa.mostrarRecebiveis();
						System.out.println("------------------------------");
					} else if(escolhaMenuReceber.equals('2')) {
						// CADASTRAR CONTA A RECEBER
						minhaContaEmpresa.cadastrarRecebivel();
						System.out.println("------------------------------");
					} else if(escolhaMenuReceber.equals('3')) {
						// ANTECIPAR RECEBÍVEL
						minhaContaEmpresa.anteciparRecebivel();
						System.out.println("------------------------------");
					}else if(escolhaMenuReceber.equals('4')){
						// MOSTRAR DADOS
						minhaContaEmpresa.mostrarDadosContaEmpresa();
						System.out.println("------------------------------");
					}else {
						break;
					}
				}else {
					minhaContaEmpresa.ativarConta();
					System.out.println("------------------------------");
				}
				break;
				}
			case '5':{
				// EMPRÉSTIMO
				System.out.println("\t★ [NOME DO BANCO]");
				System.out.println();
				if(minhaContaEmpresa.isContaAtiva()) {
					System.out.println("VALOR DISPONÍVEL PARA EMPRÉSTIMO: " + minhaContaEmpresa.getEmprestimoEmpresa());
					System.out.print("DIGITE O VALOR QUE DESEJA SOLICITAR: ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					System.out.print("SENHA: ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.print("⚠ SENHA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
						senhaTemp = scanner.nextLine();
					}
					System.out.println();
					System.out.println("PROCESSANDO EMPRÉSTIMO...");
					minhaContaEmpresa.pedirEmprestimo(valorTemp);
					System.out.println("------------------------------");
				}else {
					minhaContaEmpresa.ativarConta();
					System.out.println("------------------------------");
				}
				break;
				}
			case '6':{
				// EXTRATO
				System.out.println("\t★ [NOME DO BANCO]");
				System.out.println();
				minhaContaEmpresa.extratoContaEmpresa();
				System.out.println("------------------------------");
				break;
				}
			case '7':{
				// CÂMBIO
				System.out.println("\t★ [NOME DO BANCO]");
				System.out.println();
				System.out.println("TRANSFERÊNCIA INTERNACIONAL");
				System.out.println("ENVIE E RECEBA DINHEIRO DO EXTERIOR");
				System.out.printf("SALDO ATUAL: %.2f\n", minhaContaEmpresa.getSaldoConta());
				System.out.println();
				
				System.out.println("1. ENVIAR");
				System.out.println("2. RECEBER");
				System.out.println("3. VOLTAR");
				System.out.println();
				
				System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
				Character escolhaCambio = scanner.next().charAt(0);
				scanner.nextLine();
				
				while(escolhaCambio != '1' && escolhaCambio != '2' && escolhaCambio != '3') {
					System.out.print("⚠ CÓDIGO INVÁLIDO! POR FAVOR, DIGITE NOVAMENTE: ");
					escolhaCambio = scanner.next().charAt(0);
					scanner.nextLine();
				}
				
				System.out.println("------------------------------");
				
				if(escolhaCambio.equals('1')) {
					// ENVIAR
					
					System.out.println("ENVIADO \t\t RECEBIDO");
					System.out.println("R$ 500,00 \t→ \tU$D 96,66");
					System.out.println();
					
					System.out.println("1. DÓLAR");
					System.out.println("2. EURO");
					System.out.println("3. VOLTAR");
					System.out.println();
					
					System.out.print("DIGITE O CÓDIGO DA SUA ESCOLHA: ");
					Character escolhaMoeda = scanner.next().charAt(0);
					scanner.nextLine();
					
					while(!escolhaMoeda.equals('1') && !escolhaMoeda.equals('2') && !escolhaMoeda.equals('3')) {
						System.out.print("⚠ OPÇÃO INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
						escolhaMoeda = scanner.next().charAt(0);
						scanner.nextLine();
					}
					
					System.out.print("DIGITE UM VALOR PARA SER ENVIADO: ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					
					while(valorTemp <= 0.0) {
						System.out.print("⚠ DIGITE UM VALOR ACIMA DE R$ 0,0: ");
						valorTemp = Double.parseDouble(scanner.nextLine());
					}
					
					System.out.print("DIGITE A SUA SENHA: ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.print("⚠ SENHA INCORRETA! POR FAVOR, DIGITE NOVAMENTE: ");
						senhaTemp = scanner.nextLine();
					}
					
					if(escolhaMoeda.equals('1')) {
						minhaContaEmpresa.enviarCambio(valorTemp, escolhaMoeda);
						System.out.println("------------------------------");
					} else if(escolhaMoeda.equals('2')) {
						minhaContaEmpresa.enviarCambio(valorTemp, escolhaMoeda);
						System.out.println("------------------------------");
					}else {
						break;
					}
				} else if(escolhaCambio.equals('2')) {
					// RECEBER
					System.out.println("RECEBIDO \t\t ENVIADO");
					System.out.println("R$ 2.586,40 \t→ \tU$D 500,00");
					System.out.println();
					
					System.out.println("1. DÓLAR");
					System.out.println("2. EURO");
					System.out.println("3. VOLTAR");
					System.out.println();
					
					System.out.print("DIGITE O CÓDIGO DA SUA ESCOLHA: ");
					Character escolhaMoeda = scanner.next().charAt(0);
					scanner.nextLine();
					
					while(!escolhaMoeda.equals('1') && !escolhaMoeda.equals('2') && !escolhaMoeda.equals('3')) {
						System.out.print("⚠ OPÇÃO INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
						escolhaMoeda = scanner.next().charAt(0);
						scanner.nextLine();
					}
					
					System.out.print("DIGITE O VALOR QUE SERÁ RECEBIDO: ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					
					while(valorTemp <= 0.0) {
						System.out.print("⚠ DIGITE UM VALOR ACIMA DE R$ 0,0: ");
						valorTemp = Double.parseDouble(scanner.nextLine());
					}
					
					System.out.print("DIGITE A SUA SENHA: ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.print("⚠ SENHA INCORRETA! POR FAVOR, DIGITE NOVAMENTE: ");
						senhaTemp = scanner.nextLine();
					}
					
					if(escolhaMoeda.equals('1')) {
						minhaContaEmpresa.receberCambio(valorTemp, escolhaMoeda);
						System.out.println("------------------------------");
					} else if(escolhaMoeda.equals('2')) {
						minhaContaEmpresa.receberCambio(valorTemp, escolhaMoeda);
						System.out.println("------------------------------");
					}else {
						break;
					}
				}else {
					break;
				}
				break;
			}
			case '8':{
				break;
				}
			}
		 }while(!escolhaMenuContaEmpresa.equals('8'));
	}
	
	// Autor: Rizia
		public static void menuContaEstudantil() {
		char escolha = '0';
		do {
		System.out.println("Seu saldo atual é: R$ " + minhaContaEstudantil.getSaldoConta());	
		System.out.println();	
		System.out.println("1. Extrato da conta");
		System.out.println("2. Depósito");
		System.out.println("3. Pagamentos");
		System.out.println("4. Transferência");
		System.out.println("5. Empréstimo");
		System.out.println("6. Pagar empréstimo");
		System.out.println("7. Simulador de investimentos");
		System.out.println("8. Sair");	
		System.out.println();
		System.out.print("Digite a opção desejada: ");
		escolha = scanner.next().charAt(0);
		scanner.nextLine();
		
		if (minhaContaEstudantil.getContagemMovimentos() == 10) {
			System.out.println("Seu limite disponível é: " + minhaContaEstudantil.getLimiteEstudantil());
			System.out.print("Deseja realizar um empréstimo? ");
			char escol = '0';
			escol = Character.toUpperCase(scanner.next().charAt(0));
			
		    while (escol != 'S' && escol != 'N') {
		    	System.out.print("Digite uma opção válida: ");
		    	escol = Character.toUpperCase(scanner.next().charAt(0));
		    	}
		    
		    System.out.print("Digite o valor que deseja utilizar como empréstimo: ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.print("Digite a sua senha: ");
			String senhaTemp = scanner.nextLine();
			while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			System.out.print("Digite a senha correta: ");
			senhaTemp = scanner.nextLine();}
			minhaContaEstudantil.usarEstudantil(valor);
			System.out.println();
		    }
		
		System.out.println();
		switch (escolha) {
		case '1':{
			for (MovimentoBancario transacao: minhaContaEstudantil.getExtratoMovimentoBancario()) {
				System.out.println(transacao.toString());
				 System.out.println();
				 System.out.println("Quantidade de movimentos bancários: " + minhaContaEstudantil.getContagemMovimentos()); 
			}
		break;
		}
		case '2':{
		     System.out.print("Digite o valor que deseja depositar: ");
		     double valor = scanner.nextDouble();
		     scanner.nextLine();
		     System.out.print("Digite a sua senha: ");
			 String senhaTemp = scanner.nextLine();
			 while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			 System.out.println("Digite a senha correta: ");
			 senhaTemp = scanner.nextLine();}
		     minhaContaEstudantil.creditarValor(valor);
		     minhaContaEstudantil.registrarMovimentoBancario(new MovimentoBancario(valor, "C"));
		     System.out.println();
		     break;
		}
		case '3':{
		     System.out.print("Digite o valor que deseja debitar: ");
		     double valor = scanner.nextDouble();
		     scanner.nextLine();
		     System.out.print("Digite a sua senha: ");
			 String senhaTemp = scanner.nextLine();
			 while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			 System.out.println("Digite a senha correta: ");
			 senhaTemp = scanner.nextLine();}
		     minhaContaEstudantil.debitarValor(valor);
		     System.out.println();
		     System.out.println("Baixe o app de investimentos do banco para investir agora.");
		     break;
			 }
		case '4':{
			System.out.print("Digite o valor que deseja enviar: ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.print("Digite os dados da conta da pessoa para o qual deseja enviar: ");
		    int contaTransferencia = scanner.nextInt();
		    scanner.nextLine();
		    System.out.print("Digite a sua senha: ");
		    String senhaTemp = scanner.nextLine();
		    while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
		    	System.out.println("Digite a senha correta: ");
		    	senhaTemp = scanner.nextLine();
		    }
		    minhaContaEstudantil.enviarValor(valor);
		    System.out.println();
			break;
		}
		case '5':{
			System.out.println("Seu limite disponível é: " + minhaContaEstudantil.getLimiteEstudantil());
		    System.out.print("Digite o valor que deseja utilizar como empréstimo: ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.print("Digite a sua senha: ");
			String senhaTemp = scanner.nextLine();
			while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			System.out.println("Digite a senha correta: ");
			senhaTemp = scanner.nextLine();}
			minhaContaEstudantil.usarEstudantil(valor);
			System.out.println();
			break;
		}
		case '6':{
			System.out.println("Você possui de saldo na conta: R$ " + minhaContaEstudantil.getSaldoConta());
			System.out.println("e um débito de empréstimo no valor de : R$ " + minhaContaEstudantil.getEmprestimoSolicitado());
			System.out.print("Quanto você deseja pagar desse débito? ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.print("Digite a sua senha: ");
			String senhaTemp = scanner.nextLine();
			while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			System.out.println("Digite a senha correta: ");
			senhaTemp = scanner.nextLine();}
			if (minhaContaEstudantil.getSaldoConta() >= valor) {
			minhaContaEstudantil.pagarEmprestimo(valor);
			System.out.println();
			}
			else {
				System.out.println("Você não possui saldo para efetuar essa operação.");
			}
			break;
		}	
		case '7':{
			char opcao = '0';
			do {
			System.out.println("Seu saldo atual é: R$ " + minhaContaEstudantil.getSaldoConta());	
			System.out.println();	
			System.out.println("1. CDB");
			System.out.println("2. CDI");
			System.out.println("3. IPCA");
			System.out.println("4. SELIC");
			System.out.println("5. Sair");	
			System.out.println();
			System.out.print("Digite a opção desejada: ");
			opcao = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.println();
			
			switch (opcao) {
			case '1':{
				System.out.print("Digite a quantidade de meses de sua aplicação: ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Digite o valor que deseja investir: ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double CDB = valor + (valor * 0.05) * meses;
				System.out.print("O valor investido ao final do período será de: R$ " + CDB);
				System.out.println();
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
				break; 
			}
			case '2':{
				System.out.print("Digite a quantidade de meses de sua aplicação: ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Digite o valor que deseja investir: ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double CDI = valor + (valor * 0.05) * meses;
				System.out.print("O valor investido ao final do período será de: R$ " + CDI);
				System.out.println();
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
			    break;
			}
			case '3':{
				System.out.print("Digite a quantidade de meses de sua aplicação: ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Digite o valor que deseja investir: ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double IPCA = valor + (valor * 0.05) * meses;
				System.out.print("O valor investido ao final do período será de: R$ " + IPCA);
				System.out.println();
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
			    break;
			}
			case '4':{
				System.out.print("Digite a quantidade de meses de sua aplicação: ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Digite o valor que deseja investir: ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double SELIC = valor + (valor * 0.05) * meses;
				System.out.print("O valor investido ao final do período será de: R$ " + SELIC);
				System.out.println();
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
			    break;
			}
			case '5':{
				break;
				}
			} 
			} while (opcao != '5');
		    }
			break;
		}
		} while(escolha != '8');
		}
}