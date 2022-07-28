package br.com.app.aplicativo;

import br.com.app.entities.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Aplicativo {

	// Daniel
	static ContaCorrente minhaContaCorrente = new ContaCorrente();
	static ContaEmpresa minhaContaEmpresa = new ContaEmpresa();
	static ContaEspecial minhaContaEspecial = new ContaEspecial();
	static ContaEstudantil minhaContaEstudantil = new ContaEstudantil();
	static ContaPoupanca minhaContaPoupanca = new ContaPoupanca();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("..........................................");
		menuInicial();

		scanner.close();
	}
	
	// Daniel
	public static void menuInicial() {
		Character escolhaMenuInicial = '0';
		do {
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println("\t1. LOGIN");
			System.out.println("\t2. CRIAR CONTA");
			System.out.println("\t3. FECHAR APLICATIVO");
			System.out.println();
			
			ArrayList<Character> opcoesMenuInicial = new ArrayList<>();
			Collections.addAll(opcoesMenuInicial, '1', '2', '3');
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaMenuInicial = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!opcoesMenuInicial.contains(escolhaMenuInicial)) {
				System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaMenuInicial = scanner.next().charAt(0);
				scanner.nextLine();
				System.out.println();
			}
			System.out.println("..........................................");
			if(escolhaMenuInicial.equals('3')) {
				break;
			} else {
				switch(escolhaMenuInicial) {
				case '1': {
					// Efetuar LogIn
					logIn();
					break;
					}
				case '2': {
					// Criar Conta
					menuCriarConta();
					break;
					}
				}
			}		
		} while(escolhaMenuInicial != '3');
	}
	
	// Daniel
	public static void logIn() {
		// Efetuando LogIn
		
		Character escolhaLogIn = '0';
		do {
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println("\t1. PESSOA FÍSICA");
			System.out.println("\t2. PESSOA JURÍDICA / EMPRESA");
			System.out.println("\t3. VOLTAR");
			System.out.println();
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaLogIn = scanner.next().charAt(0);
			scanner.nextLine();
			ArrayList<Character> opcoesMenuLogIn = new ArrayList<>();
			Collections.addAll(opcoesMenuLogIn, '1', '2', '3');
			
			while(!opcoesMenuLogIn.contains(escolhaLogIn)) {
				System.out.println("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaLogIn = scanner.next().charAt(0);
				scanner.nextLine();
				System.out.println();
			}
			System.out.println("..........................................");
			if(escolhaLogIn.equals('3')) {
				// Voltar
				return;
			} else {
				switch(escolhaLogIn) {
				case '1': {
					// Pessoa Física
					System.out.println("[NOME DO BANCO]");
					System.out.println("[SLOGAN]");
					System.out.println();
					
					System.out.print("CPF: ");
					String cpfLogIn = scanner.nextLine();
					System.out.print("SENHA: ");
					String senhaLogIn = scanner.nextLine();
					System.out.println();
					
					Character retornoVerificarLogInPessoaFisica = '0';
					retornoVerificarLogInPessoaFisica = verificarLogInPessoaFisica(cpfLogIn, senhaLogIn);
					
					// Ao efetuar o login, abrirá o menu referente à conta
					if(retornoVerificarLogInPessoaFisica.equals('1')) {
						menuContaPoupanca();
						
					} else if(retornoVerificarLogInPessoaFisica.equals('2')) {
						menuContaCorrente();
						
					} else if(retornoVerificarLogInPessoaFisica.equals('3')) {
						menuContaEspecial();
						
					}else if(retornoVerificarLogInPessoaFisica.equals('4')) {
						menuContaEstudantil();
						
					} else {
						System.out.println("CPF OU SENHA INVÁLIDA.");
						System.out.println("..........................................");
					}
					
					break;
					}
				case '2': {
					// Pessoa Jurídica
					
					System.out.println("[NOME DO BANCO]");
					System.out.println("[SLOGAN]");
					System.out.println();
					
					System.out.print("CNPJ: ");
					String cnpjLogIn = scanner.nextLine();
					System.out.print("SENHA: ");
					String senhaLogIn = scanner.nextLine();
					System.out.println();
					
					Character retornoVerificarLogInPessoaJuridica = '0';
					retornoVerificarLogInPessoaJuridica = verificarLogInPessoaJuridica(cnpjLogIn, senhaLogIn);
					if(retornoVerificarLogInPessoaJuridica.equals('1')) {
						System.out.println("..........................................");
						menuContaEmpresa();
					} else {
						System.out.println("CPF OU SENHA INVÁLIDA.");
						System.out.println("..........................................");
					}
					break;
					}
				}
			}
		}while(!escolhaLogIn.equals('3'));
	}
	
	// Daniel
	public static Character verificarLogInPessoaFisica(String cpfLogIn, String senhaLogIn) {
		char verificaLogIn = '0';
		
		if(minhaContaPoupanca.getCpfConta().equals(cpfLogIn) && minhaContaPoupanca.getSenhaUsuario().equals(senhaLogIn)) {
			verificaLogIn = '1';
			
		//} else if(minhaContaCorrente.getCpfConta().equals(cpfLogIn) && minhaContaCorrente.getSenhaUsuario().equals(senhaLogIn)) {
			//verificaLogIn = '2';
			
		}else if(minhaContaEspecial.getCpfConta().equals(cpfLogIn) && minhaContaEspecial.getSenhaUsuario().equals(senhaLogIn)) {
			verificaLogIn = '3';
			
		}else if(minhaContaEstudantil.getCpfConta().equals(cpfLogIn) && minhaContaEstudantil.getSenhaUsuario().equals(senhaLogIn)) {
			verificaLogIn = '4';
			
		}else {
			verificaLogIn = '0';	
		}
		
		return verificaLogIn;
	}
	
	// Daniel
	public static Character verificarLogInPessoaJuridica(String cnpjLogIn, String senhaLogIn) {
		char verificaLogIn = '0';
		
		if(minhaContaEmpresa.getCnpjEmpresa().equals(cnpjLogIn) && minhaContaEmpresa.getSenhaUsuario().equals(senhaLogIn)) {
			verificaLogIn = '1';
		} else {
			verificaLogIn = '0';
		}
		
		return verificaLogIn;
	}
	
	// Daniel
	public static void menuCriarConta() {
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
				System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaMenuCriarConta = scanner.next().charAt(0);
				scanner.nextLine();
				System.out.println();
			}
			System.out.println("..........................................");
			if(escolhaMenuCriarConta.equals('6')) {
				break;
			} else {
				switch(escolhaMenuCriarConta) {
				case '1': {
					// Criar Conta Poupança
					break;
					}
				case '2': {
					// Criar Conta Corrente
					break;
					}
				case '3': {
					// Criar Conta Especial
					break;
					}
				case '4': {
					// Criar Conta Empresarial
					// Daniel
					String cpfTemp;
					int numeroTemp;
					
					System.out.println("[NOME DO BANCO]");
					System.out.println("[SLOGAN]");
					System.out.println();
					
					System.out.print("CPF: ");
					cpfTemp = scanner.nextLine();
					//minhaContaEmpresa.setCpfConta(scanner.nextLine());
					System.out.print("NÚMERO DA CONTA: ");
					numeroTemp = Integer.parseInt(scanner.nextLine());
					
					ContaEmpresa contaEmpresaTemp = new ContaEmpresa(cpfTemp, numeroTemp);
					
					System.out.print("CPNJ: ");
					contaEmpresaTemp.setCnpjEmpresa(scanner.nextLine());
					System.out.print("NOME DA EMPRESA: ");
					contaEmpresaTemp.setNomeEmpresa(scanner.nextLine().toUpperCase());
					System.out.print("SENHA: ");
					contaEmpresaTemp.setSenhaUsuario(scanner.nextLine());
					
					ArrayList<String> listaCaracteresSenhaUsuario = verificarSenha(contaEmpresaTemp.getSenhaUsuario());
					
					while(listaCaracteresSenhaUsuario.size() == 0) {
						System.out.print("A SUA SENHA DEVE CONTER PELO MENOS UM CARACTERE ESPECIAL. POR FAVOR, DIGITE NOVAMENTE: ");
						contaEmpresaTemp.setSenhaUsuario(scanner.nextLine());
						System.out.println();
						listaCaracteresSenhaUsuario = verificarSenha(contaEmpresaTemp.getSenhaUsuario());
					}

					System.out.println("CRIANDO A CONTA...");
					System.out.println();
		
					System.out.println("A SUA CONTA EMPRESA FOI CRIADA COM SUCESSO!");
					System.out.println("PARA ATIVÁ-LA, DEPOSITE UM VALOR MÍNIMO DE R$ 100,00.");
					System.out.print("DESEJA DEPOSITAR ESSE VALOR AGORA? S/N: ");
					Character escolherAtivarContaAgora = ' ';
					escolherAtivarContaAgora = Character.toUpperCase(scanner.next().charAt(0));
					scanner.nextLine();
					
					while(escolherAtivarContaAgora != 'S' && escolherAtivarContaAgora != 'N') {
						System.out.print("RESPOSTA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
						escolherAtivarContaAgora = Character.toUpperCase(scanner.next().charAt(0));
						scanner.nextLine();
						System.out.println();
					}
					System.out.println("..........................................");
					if(escolherAtivarContaAgora == 'S') {
						System.out.println("[NOME DO BANCO]");
						System.out.println("[SLOGAN]");
						System.out.println();
						
						System.out.print("DIGITE UM VALOR PARA SER DEPOSITADO: ");
						double valorTemp = Double.parseDouble(scanner.nextLine());
						
						while(valorTemp < 100.0) {
							System.out.print("VALOR ABAIXO DE R$ 100,00. POR FAVOR, INSIRA UM NOVO VALOR: ");
							valorTemp = Double.parseDouble(scanner.nextLine());
							System.out.println();
						}
						
						contaEmpresaTemp.setSaldoConta(valorTemp);
						contaEmpresaTemp.setContaAtiva(true);
						minhaContaEmpresa = contaEmpresaTemp;
						
						// Adiciona transação bancária ao extrato
						minhaContaEmpresa.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "DEPÓSITO INCIAL"));
						
						// Atualizando contagem de movimentações financeiras
						minhaContaEmpresa.registrarContagemMovimentosBancarios();
						System.out.println("..........................................");
						menuContaEmpresa();
					} else {
						minhaContaEmpresa = contaEmpresaTemp;
						menuContaEmpresa();
					}
					break;
					}
				case '5': {
					// Criar Conta Estudantil
					break;
					}
				}
			}
		}while(!escolhaMenuCriarConta.equals('6'));
	}
	
	// Daniel
	public static ArrayList<String> verificarSenha(String senha) {
		ArrayList<String> listaCaracteresEspeciais = new ArrayList<>();
		Collections.addAll(listaCaracteresEspeciais, " ", "!", "\"", "#", "$", "%", "&", "\'", "(", ")", "*", "+", ",",
			"-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "´", "`", "{", "|", "}", "~");
		
		ArrayList<String> listaCaracteresSenhaUsuario = new ArrayList<String>(Arrays.asList(senha.split("")));
		listaCaracteresSenhaUsuario.retainAll(listaCaracteresEspeciais);
		
		return listaCaracteresSenhaUsuario;
	}
	
	// Autor
	public static void menuContaPoupanca() {
		// Menu Conta Poupança
		System.out.println("Menu Conta Poupanca");
	}
	
	// Autor
	public static void menuContaCorrente() {
		// Menu Conta Corrente
		System.out.println("Menu Conta Corrente");
	}
	
	// Autor
	public static void menuContaEspecial() {
		// Menu Conta Especial
		System.out.println("Menu Conta Especial");
	}
	
	// Daniel
	public static void menuContaEmpresa() {
		// Menu Conta Empresa
		Character escolhaMenuContaEmpresa = '0';
		 do {
			ArrayList<Character> opcoesMenuContaEmpresa = new ArrayList<>();
			Collections.addAll(opcoesMenuContaEmpresa, '1','2','3','4','5','6','7','8');
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println(minhaContaEmpresa.getNomeEmpresa());
			System.out.println("CONTA PJ");
			System.out.println(minhaContaEmpresa.getNumeroConta());
			System.out.println();
			
			if(minhaContaEmpresa.isContaAtiva()) {
				System.out.println("SALDO: " + minhaContaEmpresa.getSaldoConta());
			} else {
				System.out.println("NENHUM SALDO DISPONÍVEL");
			}
			System.out.println();
			
			System.out.println("\t1. PERFIL");
			System.out.println("\t2. ÁREA PIX");
			System.out.println("\t3. PAGAR");
			System.out.println("\t4. TRANSFERIR");
			System.out.println("\t5. EXTRATO");
			System.out.println("\t6. ANTECIPAR RECEBÍVEIS");
			System.out.println("\t7. INVESTIMENTOS");
			System.out.println("\t8. SAIR");
			System.out.println();
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaMenuContaEmpresa = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!opcoesMenuContaEmpresa.contains(escolhaMenuContaEmpresa)) {
				System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaMenuContaEmpresa = scanner.next().charAt(0);
				scanner.nextLine();
				System.out.println();
			}
			System.out.println("..........................................");
			if(escolhaMenuContaEmpresa.equals('8')) {
				return;
			} else {
				switch(escolhaMenuContaEmpresa) {
				case '1':{
					// PERFIL - CONTA EMPRESA
					System.out.println("[NOME DO BANCO]");
					System.out.println("[SLOGAN]");
					System.out.println();
					
					System.out.print(minhaContaEmpresa.getNomeEmpresa() + "\t" + minhaContaEmpresa.getCnpjEmpresa() + "\n");
					System.out.println(minhaContaEmpresa.getNumeroConta());
					System.out.println(minhaContaEmpresa.getCpfConta());
					System.out.println("..........................................");
					break;
					}
				case '2':{	
					// ÁREA PIX - CONTA EMPRESA
					System.out.println("ENVIE E RECEBA PAGAMENTOS A QUALQUER MOMENTO E SEM CUSTOS ADICIONAIS.");
					System.out.println();
					Character escolhaPix = '0';
					
					do {
						System.out.println("\t1. CADASTRAR CHAVE PIX");
						System.out.println("\t2. MINHA CHAVE PIX");
						System.out.println("\t3. VOLTAR");
						System.out.println();
						
						System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
						escolhaPix = scanner.next().charAt(0);
						scanner.nextLine();
						
						while(escolhaPix != '1' && escolhaPix != '2' && escolhaPix != '3') {
							System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
							escolhaPix = scanner.next().charAt(0);
							scanner.nextLine();
							System.out.println();
						}
						System.out.println("..........................................");
						if(escolhaPix.equals('3')) {
							break;
						} else if(escolhaPix.equals('1')) {
								System.out.println("REGISTRE OU ALTERE A SUA CHAVE PIX");
								System.out.println();
								System.out.println("\t1. CELULAR");
								System.out.println("\t2. E-MAIL");
								System.out.println("\t3. CNPJ");
								System.out.println("\t4. VOLTAR");
								System.out.println();
								
								System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
								Character escolhaRegistroPix = '0';
								escolhaRegistroPix = scanner.next().charAt(0);
								scanner.nextLine();
								
								ArrayList<Character> opcoesRegistroPix = new ArrayList<>();
								Collections.addAll(opcoesRegistroPix, '1','2','3','4');
								
								while(!opcoesRegistroPix.contains(escolhaRegistroPix)) {
									System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
									escolhaRegistroPix = scanner.next().charAt(0);
									scanner.nextLine();
									System.out.println();
								}
								System.out.println("..........................................");
								if(escolhaRegistroPix.equals('4')) {
									return;
								}else {
									switch(escolhaRegistroPix) {
									case '1':{
										// Numero de telefone
										System.out.println("RECEBA PAGAMENTOS A QUALQUER MOMENTO DO DIA USANDO APENAS O NÚMERO DO CELULAR");
										System.out.println();
										
										System.out.print("NÚMERO: ");
										String numeroTemp = scanner.nextLine();
										
										minhaContaEmpresa.registrarChavePix(numeroTemp);
										System.out.println("..........................................");
										break;
										}
									case '2':{
										// E-MAIL
										System.out.println("UTILIZE O E-MAIL EMPRESARIAL PARA RECEBER PAGAMENTOS");
										System.out.println();
										
										System.out.print("E-MAIL CORPORATIVO: ");
										String emailTemp = scanner.nextLine();
										
										minhaContaEmpresa.registrarChavePix(emailTemp);
										System.out.println("..........................................");
										break;
										}
									case '3':{
										// CNPJ
										System.out.println("VINCULE O CNPJ DA SUA CONTA PJ À SUA CHAVE PIX");
										
										minhaContaEmpresa.registrarChavePix(minhaContaEmpresa.getCnpjEmpresa());
										System.out.println("..........................................");
										break;
										}
									}
								}
							} else {
								// MOSTRAR CHAVE PIX
								if(minhaContaEmpresa.getChavePix().equals("")) {
									System.out.println("NENHUMA CHAVE PIX CADASTRADA NA SUA CONTA PJ!");
									System.out.println("..........................................");
								} else {
									System.out.println("CHAVE PIX: " + minhaContaEmpresa.getChavePix());
									System.out.println("..........................................");
								}
						}
					}while(!escolhaPix.equals('3'));
					break;
					}
				case '3':{
					// PAGAR - CONTA EMPRESA
					System.out.println("SELECIONE A FORMA DE PAGAMENTO");
					System.out.println();
					
					System.out.println("\t1. DÉBITO");
					System.out.println("\t2. PIX");
					System.out.println("\t3. VOLTAR");
					
					System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
					Character escolhaPagamento = '0';
					escolhaPagamento = scanner.next().charAt(0);
					scanner.nextLine();
					
					while(escolhaPagamento != '1' && escolhaPagamento != '2' && escolhaPagamento != '3') {
						System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
						escolhaPagamento = scanner.next().charAt(0);
						scanner.nextLine();
						System.out.println();
					}
					System.out.println("..........................................");
					if(escolhaPagamento.equals('1')) {
						// DÉBITO
						System.out.println("FORMA DE PAGAMENTO: DÉBITO AUTOMÁTICO");
						System.out.println();
						System.out.print("VALOR: ");
						double valorTemp = Double.parseDouble(scanner.nextLine());
						System.out.print("SENHA: ");
						String senhaTemp = scanner.nextLine();
						
						while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
							System.out.print("SENHA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
							senhaTemp = scanner.nextLine();
							System.out.println();
						}
						
						System.out.println("PROCESSANDO O PAGAMENTO...");
						minhaContaEmpresa.pagarDebito(valorTemp);
						System.out.println("..........................................");
					} else if(escolhaPagamento.equals('2')) {
						// PIX
						System.out.println("FORMA DE PAGAMENTO: PIX");
						System.out.println();
						System.out.print("VALOR: ");
						double valorTemp = Double.parseDouble(scanner.nextLine());
						System.out.print("CHAVE PIX: ");
						String chavePixTemp = scanner.nextLine();
						System.out.print("SENHA: ");
						String senhaTemp = scanner.nextLine();
						
						while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
							System.out.print("SENHA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
							senhaTemp = scanner.nextLine();
							System.out.println();
						}
						
						System.out.println("PROCESSANDO O PAGAMENTO...");
						minhaContaEmpresa.pagarPix(valorTemp, chavePixTemp);
						System.out.println("..........................................");
					}else {
						return;
					}
					
					break;
					}
				case '4':{
					// TRANSFERIR - CONTA EMPRESA
					
					break;
					}
				case '5':{
					System.out.println("\tEXTRATO BANCÁRIO");
					System.out.println();
					for(MovimentoBancario movimento: minhaContaEmpresa.getExtratoMovimentoBancario()) {
						System.out.println(movimento.toString());
					}
					System.out.println("..........................................");
			
					break;
					}
				case '6':{
					// ANTECIPAR RECEBIVEIS
					
					break;
					}
				case '7':{
					// INVESTIMENTOS - CONTA EMPRESA
					
					break;
					}
				} // fim switch
			}
		}while(!escolhaMenuContaEmpresa.equals('8'));
	} // fim menu conta empresa
	
	// Autor
	public static void menuContaEstudantil() {
		// Menu Conta Estudantil
		System.out.println("Menu Conta Estudantil");
	}
}