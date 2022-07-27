package br.com.app.aplicativo;

import br.com.app.entities.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
		menuInicial();

		scanner.close();
	}
	
	// Daniel
	public static void menuInicial() {
		Character escolhaMenuInicial = new Character('0');
		do {
			System.out.println("[NOME DO BANCO]");
			System.out.println("[SLOGAN]");
			System.out.println();
			
			System.out.println("1. LOGIN");
			System.out.println("2. CRIAR CONTA");
			System.out.println("3. FECHAR APLICATIVO");
			System.out.println();
			
			ArrayList<Character> opcoesMenuInicial = new ArrayList<>();
			Collections.addAll(opcoesMenuInicial, '1', '2', '3');
			
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			escolhaMenuInicial = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.println();
			
			while(!opcoesMenuInicial.contains(escolhaMenuInicial)) {
				System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaMenuInicial = scanner.next().charAt(0);
				scanner.nextLine();
				System.out.println();
			}
			
			if(escolhaMenuInicial.equals('3')) {
				// Fechar Aplicativo
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
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("[NOME DO BANCO]");
		System.out.println("[SLOGAN]");
		System.out.println();
		
		System.out.println("1. PESSOA FÍSICA");
		System.out.println("2. PESSOA JURÍDICA / EMPRESA");
		System.out.println("3. VOLTAR");
		System.out.println();
		
		System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
		Character escolhaLogIn = new Character('0');
		escolhaLogIn = scanner.next().charAt(0);
		scanner.nextLine();
		System.out.println();
		ArrayList<Character> opcoesMenuLogIn = new ArrayList<>();
		Collections.addAll(opcoesMenuLogIn, '1', '2', '3');
		
		while(!opcoesMenuLogIn.contains(escolhaLogIn)) {
			System.out.println("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
			escolhaLogIn = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.println();
		}
		
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
				
				Character retornoVerificarLogInPessoaFisica = new Character('0');
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
					System.out.println();
					return;
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
				
				Character retornoVerificarLogInPessoaJuridica = new Character('0');
				retornoVerificarLogInPessoaJuridica = verificarLogInPessoaJuridica(cnpjLogIn, senhaLogIn);
				
				if(retornoVerificarLogInPessoaJuridica.equals('1')) {
					menuContaEmpresa();
				} else {
					System.out.println("CPF OU SENHA INVÁLIDA.");
					System.out.println();
				}
				break;
				}
			}
		}
	}
	
	// Daniel
	public static Character verificarLogInPessoaFisica(String cpfLogIn, String senhaLogIn) {
		char verificaLogIn = '0';
		
		if(minhaContaPoupanca.getCpfConta().equals(cpfLogIn) && minhaContaPoupanca.getSenhaUsuario().equals(senhaLogIn)) {
			verificaLogIn = '1';
			
		} else if(minhaContaCorrente.getCpfConta().equals(cpfLogIn) && minhaContaCorrente.getSenhaUsuario().equals(senhaLogIn)) {
			verificaLogIn = '2';
			
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
		System.out.println("[NOME DO BANCO]");
		System.out.println("[SLOGAN]");
		System.out.println();
		
		System.out.println("1. CONTA POUPANÇA");
		System.out.println("2. CONTA CORRENTE");
		System.out.println("3. CONTA ESPECIAL");
		System.out.println("4. CONTA EMPRESA");
		System.out.println("5. CONTA ESTUDANTIL");
		System.out.println("6. VOLTAR");
		System.out.println();
		
		ArrayList<Character> opcoesMenuCriarConta = new ArrayList<>();
		Collections.addAll(opcoesMenuCriarConta, '1', '2', '3', '4', '5', '6');
		Character escolhaMenuCriarConta = new Character('0');
		
		System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
		escolhaMenuCriarConta = scanner.next().charAt(0);
		scanner.nextLine();
		
		while(!opcoesMenuCriarConta.contains(escolhaMenuCriarConta)) {
			System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
			escolhaMenuCriarConta = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.println();
		}
		
		if(escolhaMenuCriarConta.equals('6')) {
			return;
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
				
				System.out.println("[NOME DO BANCO]");
				System.out.println("[SLOGAN]");
				System.out.println();
				
				System.out.print("CPF: ");
				minhaContaEmpresa.setCpfConta(scanner.nextLine());
				System.out.print("CPNJ: ");
				minhaContaEmpresa.setCnpjEmpresa(scanner.nextLine());
				System.out.print("NOME DA EMPRESA: ");
				minhaContaEmpresa.setNomeEmpresa(scanner.nextLine());
				System.out.print("SENHA: ");
				minhaContaEmpresa.setSenhaUsuario(scanner.nextLine());
				System.out.println();
				
				ArrayList<String> listaCaracteresEspeciais = new ArrayList<>();
				Collections.addAll(listaCaracteresEspeciais, " ", "!", "\"", "#", "$", "%", "&", "\'", "(", ")", "*", "+", ",",
					"-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "´", "`", "{", "|", "}", "~");
				
				// cria uma lista com cada caractere digitado na senha
				ArrayList<String> listaCaracteresSenhaUsuario = new ArrayList<String>(Arrays.asList(minhaContaEmpresa.getSenhaUsuario().split("")));
				listaCaracteresSenhaUsuario.retainAll(listaCaracteresEspeciais); // mantém na lista apenas os caracteres que são comuns
				
				while(listaCaracteresSenhaUsuario.size() == 0) {
					System.out.print("A SUA SENHA DEVE CONTER PELO MENOS UM CARACTERE ESPECIAL. POR FAVOR, DIGITE NOVAMENTE: ");
					minhaContaEmpresa.setSenhaUsuario(scanner.nextLine());
					listaCaracteresSenhaUsuario = new ArrayList<String>(Arrays.asList(minhaContaEmpresa.getSenhaUsuario().split("")));
					listaCaracteresSenhaUsuario.retainAll(listaCaracteresEspeciais);
				}
				
				System.out.println("CRIANDO A CONTA...");
				System.out.println();
				
				System.out.println("A SUA CONTA EMPRESA FOI CRIADA COM SUCESSO!");
				System.out.println("PARA ATIVÁ-LA, DEPOSITE UM VALOR MÍNIMO DE R$ 100,00.");
				System.out.print("DESEJA DEPOSITAR ESSE VALOR AGORA? S/N: ");
				Character escolherAtivarContaAgora = new Character(' ');
				escolherAtivarContaAgora = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
				System.out.println();
				
				while(escolherAtivarContaAgora != 'S' && escolherAtivarContaAgora != 'N') {
					System.out.print("RESPOSTA INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
					escolherAtivarContaAgora = Character.toUpperCase(scanner.next().charAt(0));
					scanner.nextLine();
					System.out.println();
				}
				
				if(escolherAtivarContaAgora == 'S') {
					System.out.println("[NOME DO BANCO]");
					System.out.println("[SLOGAN]");
					System.out.println();
					
					System.out.print("DIGITE UM VALOR PARA SER DEPOSITADO: ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					System.out.println();
					
					minhaContaEmpresa.setSaldoConta(valorTemp);
					minhaContaEmpresa.setContaAtiva(true);
					menuContaEmpresa();
				} else {
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
	}
	
	// Daniel
	public static void menuContaPoupanca() {
		// Menu Conta Poupança
		System.out.println("Menu Conta Poupanca");
	}
	
	// Daniel
	public static void menuContaCorrente() {
		// Menu Conta Corrente
		System.out.println("Menu Conta Corrente");
	}
	
	// Daniel
	public static void menuContaEspecial() {
		// Menu Conta Especial
		System.out.println("Menu Conta Especial");
	}
	
	// Daniel
	public static void menuContaEmpresa() {
		// Menu Conta Empresa
		System.out.println("Menu Conta Empresa");
		System.out.println();
		menuInicial();
	}
	
	// Daniel
	public static void menuContaEstudantil() {
		// Menu Conta Estudantil
		System.out.println("Menu Conta Estudantil");
	}
}