package br.com.app.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContaEmpresa extends Conta{
	
	// Daniel
	private double saldoConta;
	private double emprestimoEmpresa = 10_000; 
	private String nomeEmpresa;
	private String cnpjEmpresa;
	private String chavePix = "";
	private double recebiveis = 0;
	Scanner scanner = new Scanner(System.in);
	
	public ContaEmpresa(){}
	
	public ContaEmpresa(String cpfConta, int numeroConta){
		this.setCpfConta(cpfConta);
		this.setNumeroConta(numeroConta);
	}
	
	// Daniel
	@Override
	public double getSaldoConta() {
		return this.saldoConta;
	}
	// Daniel
	@Override
	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}
	
	// Daniel
	public Double getEmprestimoEmpresa() {
		return this.emprestimoEmpresa;
	}
	// Daniel
	public void setEmprestimoEmpresa(Double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	// Daniel
	public String getNomeEmpresa() {
		return this.nomeEmpresa;
	}
	// Daniel
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	// Daniel
	public String getCnpjEmpresa() {
		return this.cnpjEmpresa;
	}
	// Daniel
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	
	public String getChavePix() {
		return this.chavePix;
	}

	public double getRecebiveis() {
		return recebiveis;
	}

	public void setRecebiveis(double recebiveis) {
		this.recebiveis = recebiveis;
	}

	// Daniel
	public void pedirEmprestimo(double valorEmprestimo) {
		if(valorEmprestimo <= this.emprestimoEmpresa) {
			this.emprestimoEmpresa -= valorEmprestimo;
			this.saldoConta += valorEmprestimo;
			System.out.println("EMPRÉSTIMO REALIZADO!");
			
			// Adiciona transação bancária ao extrato
			this.registrarMovimentoBancario(new MovimentoBancario(valorEmprestimo, "EMPRÉSTIMO"));
			
			// Atualizando contagem de movimentações financeiras
			this.registrarContagemMovimentosBancarios();
		} else {
			System.out.println("Impossível realizar o empréstimo. Saldo de empréstimo disponível: R$ " + this.emprestimoEmpresa);
		}
	}
	
	// Daniel
	public void pagarDebito(double valorDebito) {
		if(this.isContaAtiva()) {
			if(this.saldoConta >= valorDebito) {
				this.saldoConta -= valorDebito;
				
				System.out.println("EFETUANDO PAGAMENTO...");
				System.out.println("PAGAMENTO EFETUADO!");
				
				// Adiciona transação bancária ao extrato
				this.registrarMovimentoBancario(new MovimentoBancario(valorDebito, "PAGAMENTO DÉBITO AUTOMÁTICO"));
				
				// Atualizando contagem de movimentações financeiras
				this.registrarContagemMovimentosBancarios();
			} else {
				System.out.println("SALDO INSUFICIENTE!");
			}
		} else {
			System.out.println("A SUA CONTA AINDA NÃO FOI ATIVADA");
			System.out.println("REALIZE UM DEPÓSITO DE NO MÍNIMO R$ 100,00 E CONTINUE COM A OPERAÇÃO");
			System.out.print("DESEJA REALIZAR O DEPÓSITO AGORA? S/N: ");
			Character escolhaAtivarConta = '0';
			escolhaAtivarConta = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
			System.out.println();
			
			while(escolhaAtivarConta != 'S' && escolhaAtivarConta != 'N') {
				System.out.print("OPÇÃO INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
				escolhaAtivarConta = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
			}
			if(escolhaAtivarConta.equals('S')) {
				System.out.print("DIGITE UM VALOR (MÍNIMO R$ 100,00): ");
				double valorTemp = Double.parseDouble(scanner.nextLine());
				System.out.println();
				
				if(valorTemp >= 100.0) {
					this.setSaldoConta(valorTemp);
					this.setContaAtiva(true);
					System.out.println("DEPÓSITO EFETUADO!");
					
					// Adiciona transação bancária ao extrato
					this.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "DEPÓSITO INICIAL"));
								
					// Atualizando contagem de movimentações financeiras
					this.registrarContagemMovimentosBancarios();
				}else {
				 return;	
				}
			} else {
				return;
			}
		}
	}
	
	public void pagarPix(double valorPix, String chavePix){
		if(this.chavePix.equals("")) {
			System.out.print("VOCÊ AINDA NÃO POSSUI UMA CHAVE PIX VINCULADO A SUA CONTA PJ. DESEJA CRIAR UMA CHAVE PIX AGORA? S/N: ");
			Character escolhaFazerChavePix = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
			
			while(escolhaFazerChavePix != 'S' && escolhaFazerChavePix != 'N') {
				System.out.print("OPÇÃO INVÁLIDA. POR FAVOR DIGITE NOVAMENTE: ");
				escolhaFazerChavePix = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
			}
			
			if(escolhaFazerChavePix.equals('S')) {
				System.out.println("REALIZE E RECEBA PAGAMENTOS A QUALQUER MOMENTO");
				System.out.println();
				Character escolhaPix = '0';
				
				do {
					System.out.println("REGISTRE A SUA CHAVE PIX");
					System.out.println();
					System.out.println("\t1. CELULAR");
					System.out.println("\t2. E-MAIL");
					System.out.println("\t3. CNPJ");
					System.out.println("\t4. CANCELAR");
					System.out.println();
					
					System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
					escolhaPix = scanner.next().charAt(0);
					scanner.nextLine();
					
					ArrayList<Character> opcoesRegistroPix = new ArrayList<>();
					Collections.addAll(opcoesRegistroPix, '1','2','3','4');
					
					while(!opcoesRegistroPix.contains(escolhaPix)) {
						System.out.print("CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
						escolhaPix = scanner.next().charAt(0);
						scanner.nextLine();
						System.out.println();
					}
					if(escolhaPix.equals('4')) {
						return;
					}else {
						switch(escolhaPix) {
						case '1':{
							// Numero de telefone
							System.out.println("RECEBA PAGAMENTOS A QUALQUER MOMENTO DO DIA USANDO APENAS O NÚMERO DO CELULAR");
							System.out.println();
							
							System.out.print("NÚMERO: ");
							String numeroTemp = scanner.nextLine();
							
							this.registrarChavePix(numeroTemp);
							break;
							}
						case '2':{
							// E-MAIL
							System.out.println("UTILIZE O E-MAIL EMPRESARIAL PARA RECEBER PAGAMENTOS");
							System.out.println();
							
							System.out.print("E-MAIL CORPORATIVO: ");
							String emailTemp = scanner.nextLine();
							
							this.registrarChavePix(emailTemp);
							break;
							}
						case '3':{
							// CNPJ
							System.out.println("VINCULE O CNPJ DA SUA CONTA PJ À SUA CHAVE PIX");
							
							this.registrarChavePix(this.getCnpjEmpresa());
							break;
							}
						}
					}
				}while(escolhaPix.equals('4'));
			} else {
				System.out.println("FAÇA UMA CHAVE PIX PARA PROSSEGUIR COM A OPERAÇÃO.");
				return;
			}
		} else {
			if(this.saldoConta >= valorPix) {
				System.out.println("EFETUANDO PAGAMENTO...");
				this.saldoConta -= valorPix;
				System.out.println("PAGAMENTO PIX EFETUADO!");
				
				this.registrarMovimentoBancario(new MovimentoBancario(valorPix, "PIX"));
				this.registrarContagemMovimentosBancarios();
			} else {
				System.out.println("SALDO INSUFICIENTE!");
			}
		}
	}
	
	public void receberCredito(double valorCredito) {
		this.setRecebiveis(this.getRecebiveis() + valorCredito);
	}
	
	public void registrarChavePix(String chavePix) {
		
		if(this.chavePix.equals("")) {
			this.chavePix = chavePix;
			System.out.println("CHAVE PIX REGISTRADA COM SUCESSO!");
		}else {
			System.out.print("VOCÊ JÁ POSSUI UMA CHAVE PIX. DESEJA SUBSTITUÍ-LA? S/N: ");
			Character escolhaSubstituirChavePix = '0';
			escolhaSubstituirChavePix = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
			System.out.println();
			
			while(escolhaSubstituirChavePix != 'S' && escolhaSubstituirChavePix != 'N') {
				System.out.print("OPÇÃO INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
				
				escolhaSubstituirChavePix = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
				System.out.println();
			}
			if(escolhaSubstituirChavePix.equals('S')) {
				this.chavePix = chavePix;
				System.out.println("NOVA CHAVE PIX REGISTRADA!");
			} else {
				scanner.close();
				return;
			}
		}
	}
	
	/*
	public void debitarConta(double valorDebitado){
		
	}
	*/
}