package br.com.app.aplicativo;

import br.com.app.entities.*;
import java.util.ArrayList;
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
		// Daniel	

		Character escolhaMenuInicial = new Character('0');
		ArrayList<Character> opcoesMenuInicial = new ArrayList<>();
		Collections.addAll(opcoesMenuInicial, '1', '2', '3');
		ArrayList<Character> opcoesMenuCriarConta = new ArrayList<>();
		Collections.addAll(opcoesMenuCriarConta, '1', '2', '3', '4', '5', '6');
		Character escolhaMenuCriarConta = new Character('0');
		
		// Daniel
		do {
			menuInicial();
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
				break;
			} else {
				switch(escolhaMenuInicial) {
				case '1': {
					logIn();
					break;
					}
				case '2': {
					menuCriarConta();
					break;
					}
				}
			}		
		}while(escolhaMenuInicial != '3');
		
		scanner.close();
	}
	
	// Daniel
	public static void menuInicial() {
		System.out.println("[NOME DO BANCO]");
		System.out.println("[SLOGAN]");
		
		System.out.println("1. LOGIN");
		System.out.println("2. CRIAR CONTA");
		System.out.println("3. FECHAR APLICATIVO");
		System.out.println();
	}
	
	// Daniel
	public static void logIn() {
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
			return;
		} else {
			switch(escolhaLogIn) {
			case '1': {
				System.out.println("[NOME DO BANCO]");
				System.out.println("[SLOGAN]");
				System.out.println();
				
				System.out.print("CPF: ");
				String cpfLogIn = scanner.nextLine();
				System.out.print("SENHA: ");
				String senhaLogIn = scanner.nextLine();
				System.out.println();
				
				Character retornoVerificarLogIn = new Character('0');
				retornoVerificarLogIn = verificarLogIn(cpfLogIn, senhaLogIn);
				
				if(retornoVerificarLogIn.equals('1')) {
					menuContaPoupanca();
					
				} else if(retornoVerificarLogIn.equals('2')) {
					menuContaCorrente();
					
				} else if(retornoVerificarLogIn.equals('3')) {
					menuContaEspecial();
					
				}else if(retornoVerificarLogIn.equals('4')) {
					menuContaEstudantil();
					
				} else {
					System.out.println("CPF OU SENHA INVÁLIDA.");
					System.out.println();
					return;
				}
				
				break;
				}
			case '2': {
				
				break;
				}
			}
		}
	}
	
	// Daniel
	public static Character verificarLogIn(String cpfLogIn, String senhaLogIn) {
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
	}
	
	// Daniel
	public static void menuContaPoupanca() {
		System.out.println("Menu Conta Poupanca");
	}
	
	// Daniel
	public static void menuContaCorrente() {
		System.out.println("Menu Conta Corrente");
	}
	
	// Daniel
	public static void menuContaEspecial() {
		System.out.println("Menu Conta Especial");
	}
	
	// Daniel
	public static void menuContaEmpresa() {
		System.out.println("Menu Conta Empresa");
	}
	
	// Daniel
	public static void menuContaEstudantil() {
		System.out.println("Menu Conta Estudantil");
	}
}