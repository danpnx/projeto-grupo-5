package br.com.app.entities;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

public class ContaEmpresa extends Conta{
	// AUTOR: DANIEL
	
	// ATRIBUTOS SUBCLASSE CONTA EMPRESA
	private double emprestimoEmpresa = 10_000.0; 
	private String nomeEmpresa = "";
	private String cnpjEmpresa = "";
	private final String agenciaEmpresa = "0001";
	private String chavePix = "";
	private ArrayList<Double> recebiveisEmpresa = new ArrayList<>(); 
	Scanner scanner = new Scanner(System.in);
	
	// CONSTRUTORES SUBCLASSE CONTA EMPRESA	
	public ContaEmpresa(){}
	
	public ContaEmpresa(String nomeEmpresa, String cnpjEmpresa, int numeroConta, String senhaUsuario){
		this.nomeEmpresa = nomeEmpresa;
		this.cnpjEmpresa = cnpjEmpresa;
		this.setNumeroConta(numeroConta);
		this.setSenhaUsuario(senhaUsuario);
	}
	
	// MÉTODOS SUBCLASSE CONTA EMPRESA
	@Override
	public void debitarValor(double valorDebitado) {
		// verificar se tem saldo o suficiente antes da chamada do método
		// cadastrar o movimento bancário depois da chamada do método
		if(this.isContaAtiva()) {
			this.saldoConta -= valorDebitado;
			this.registrarContagemMovimentosBancarios();
		}else {
			this.ativarConta();
		}
	}
	
	@Override 
	public void creditarValor(double valorCreditado) {
		// cadastrar o movimento bancário depois da chamada do método
		this.saldoConta += valorCreditado;
		this.registrarContagemMovimentosBancarios();
	}
	
	public void cadastrarChavePix() { 
		if(this.isContaAtiva()) {
			System.out.println("ENVIE E RECEBA PAGAMENTOS A QUALQUER MOMENTO E SEM CUSTOS ADICIONAIS.");
			System.out.println();

			System.out.print("DESEJA CADASTRAR UMA CHAVE PIX? S/N: ");
			Character escolhaFazerChavePix = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
			
			while(escolhaFazerChavePix != 'S' && escolhaFazerChavePix != 'N') {
				System.out.print("⚠ OPÇÃO INVÁLIDA. POR FAVOR DIGITE NOVAMENTE: ");
				escolhaFazerChavePix = Character.toUpperCase(scanner.next().charAt(0));
			}
			
			if(escolhaFazerChavePix.equals('S')) {
				
				System.out.println("REGISTRE A SUA CHAVE PIX");
				System.out.println();
				System.out.println("\t1. CELULAR");
				System.out.println("\t2. E-MAIL");
				System.out.println("\t3. CNPJ");
				System.out.println("\t4. VOLTAR");
				System.out.println();
				
				System.out.println("REALIZE E RECEBA PAGAMENTOS A QUALQUER MOMENTO");
				System.out.println();
				System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
				Character escolhaPix = scanner.next().charAt(0);
				scanner.nextLine();
				
				ArrayList<Character> opcoesRegistroPix = new ArrayList<>();
				Collections.addAll(opcoesRegistroPix, '1','2','3','4');
				
				while(!opcoesRegistroPix.contains(escolhaPix)) {
					System.out.print("⚠ CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
					escolhaPix = scanner.next().charAt(0);
					scanner.nextLine();
				}
				
				switch(escolhaPix) {
				case '1':{
					// TELEFONE
					System.out.println();
					System.out.println("RECEBA PAGAMENTOS A QUALQUER MOMENTO DO DIA USANDO APENAS O NÚMERO DO CELULAR");
					System.out.println();
					
					System.out.print("NÚMERO: ");
					String numeroTemp = scanner.nextLine();
					
					this.registrarChavePix(numeroTemp);
					break;
					}
				case '2':{
					// E-MAIL
					System.out.println();
					System.out.println("UTILIZE O E-MAIL EMPRESARIAL PARA RECEBER PAGAMENTOS");
					System.out.println();
					
					System.out.print("E-MAIL CORPORATIVO: ");
					String emailTemp = scanner.nextLine();
					
					this.registrarChavePix(emailTemp);
					break;
					}
				case '3':{
					// CNPJ
					System.out.println();
					System.out.println("VINCULE O CNPJ DA SUA CONTA PJ À SUA CHAVE PIX");
					this.registrarChavePix(this.getCnpjEmpresa());
					break;
					}
				case '4':{
					break;
					}
				}
			} else {
				System.out.println("FAÇA UMA CHAVE PIX PARA PROSSEGUIR COM A OPERAÇÃO.");
			}
		}else {
			this.ativarConta();
		}
	}
	
	public void registrarChavePix(String chavePix) {
		System.out.println();
		if(this.chavePix.equals("")) {
			this.chavePix = chavePix;
			System.out.println("CHAVE PIX REGISTRADA COM SUCESSO!");
		}else {
			System.out.print("VOCÊ JÁ POSSUI UMA CHAVE PIX. DESEJA SUBSTITUÍ-LA? S/N: ");
			Character escolhaSubstituirChavePix = '0';
			escolhaSubstituirChavePix = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
			
			while(escolhaSubstituirChavePix != 'S' && escolhaSubstituirChavePix != 'N') {
				System.out.print("⚠ OPÇÃO INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
				
				escolhaSubstituirChavePix = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
			}
			if(escolhaSubstituirChavePix.equals('S')) {
				this.chavePix = chavePix;
				System.out.println("NOVA CHAVE PIX REGISTRADA!");
			} else {
				return;
			}
		}
	}
	
	public void mostrarChavePix() {
		if(this.isContaAtiva()) {
			if(this.getChavePix().equals("")) {
				System.out.println("NENHUMA CHAVE PIX CADASTRADA NA SUA CONTA PJ!");
			} else {
				System.out.println("CHAVE PIX: " + this.getChavePix());
			}
		}else {
			this.ativarConta();
		}
	}
	
	public void pagarPix(double valorPix, String chavePix){
		if(this.isContaAtiva()) {
			if(this.chavePix.equals("")) {
				this.cadastrarChavePix();
			}else {				
				if(this.saldoConta >= valorPix) {
					System.out.println("EFETUANDO PAGAMENTO...");
					this.debitarValor(valorPix);
					System.out.println("PAGAMENTO PIX EFETUADO!");
					System.out.println();
					
					System.out.println("COMPROVANTE");
					System.out.println("VALOR: \t" + valorPix);
					System.out.println("DE: [NOME BANCO]\t" + "CNPJ: " + this.cnpjEmpresa);
					System.out.println("AGÊNCIA: " + this.agenciaEmpresa + "\t\tCONTA: " + this.getNumeroConta());
					System.out.println("PARA: \t" + chavePix);
					this.registrarMovimentoBancario(new MovimentoBancario(valorPix, "PIX"));
				} else {
					System.out.println("SALDO INSUFICIENTE ☹");
				}
			}
		}else {
			this.ativarConta();
		}
	}
	
	public String gerarBoleto(double valorBoleto) {
			String valorBoletoString = Double.toString(valorBoleto).replace(",", "");
			String boleto = "12390.00005 00000.000006 00000.00007 8 " + (LocalDate.now().getYear() * 365) + "00000" + valorBoletoString;
			return boleto;
	}
	
	public void pagarBoleto(double valorBoleto, String codigoBoleto) {
		this.debitarValor(valorBoleto);
		System.out.println("PAGAMENTO DO BOLETO EFETUADO!");
		this.registrarMovimentoBancario(new MovimentoBancario(valorBoleto, "PAGAMENTO DE BOLETO BANCÁRIO"));
	}
	
	public void mostrarDadosContaEmpresa() {
		System.out.println("AGÊNCIA" + "\t" + this.agenciaEmpresa);
		System.out.println("CONTA" + "\t" + this.getNumeroConta());
		System.out.println("CNPJ" + "\t" + this.cnpjEmpresa);
		System.out.println("CHAVE PIX" + "\t" + this.chavePix);
		System.out.println("[NOME DO BANCO] Inc. \tBANCO 123");
	}
	
	public void extratoContaEmpresa() {
		for(MovimentoBancario movimento: this.getExtratoMovimentoBancario()) {
			System.out.println(movimento.toString());
		}
		System.out.println();
		System.out.println("NÚMERO DE MOVIMENTAÇÕES BANCÁRIAS: " + this.getContagemMovimentos());
	}
	
	public void pedirEmprestimo(double valorEmprestimo) {
		if(this.isContaAtiva()) {
			if(valorEmprestimo <= this.emprestimoEmpresa) {
				this.emprestimoEmpresa -= valorEmprestimo;
				this.creditarValor(valorEmprestimo);
				System.out.println("EMPRÉSTIMO REALIZADO!");
				this.registrarMovimentoBancario(new MovimentoBancario(valorEmprestimo, "EMPRÉSTIMO"));
			} else {
				System.out.println("VALOR FORA DO LIMITE DE EMPRÉSTIMO ☹");
			}
		}else {
			this.ativarConta();
		}
	}
	
	public void mostrarRecebiveis() {
		if(this.getRecebiveisEmpresa().size() > 0) {
			for(double recebivel: this.getRecebiveisEmpresa()) {
				System.out.println("CONTA: R$ " + recebivel);
			}
		} else {
			System.out.println("VOCÊ NÃO POSSUI NENHUMA CONTA A RECEBER");
		}
	}
	
	public void cadastrarRecebivel() {
		if(this.isContaAtiva()) {
			System.out.print("DIGITE O VALOR DA CONTA: ");
			double valorTemp = Double.parseDouble(scanner.nextLine());
			
			while(valorTemp <= 0) {
				System.out.print("⚠ NÃO É POSSÍVEL CADASTRAR UM VALOR MENOR OU IGUAL A ZERO. DIGITE OUTRO VALOR: ");
				valorTemp = Double.parseDouble(scanner.nextLine());
			}
			
			this.recebiveisEmpresa.add(valorTemp);
			System.out.println("VALOR A RECEBER CADASTRADO!");
			this.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "VALOR A RECEBER"));
			this.registrarContagemMovimentosBancarios();
		}else {
			this.ativarConta();
		}
	}
	
	public void anteciparRecebivel() {
		int index = 0;
		boolean achouRecebivel = false;
		System.out.print("DIGITE O VALOR DO RECEBÍVEL QUE DESEJA ANTECIPAR: ");
		Double valorTemp = Double.parseDouble(scanner.nextLine());
		
		if(this.getRecebiveisEmpresa().size() > 0) {
			for(double recebivel: this.getRecebiveisEmpresa()) {
				if(valorTemp.equals(recebivel)) {
					achouRecebivel = true;
					break;
				}
			index++;
			}	
			if(achouRecebivel) {
				ArrayList<Double> recebiveisTemp = this.getRecebiveisEmpresa();
				recebiveisTemp.remove(index);
				this.setRecebiveisEmpresa(recebiveisTemp);
				this.creditarValor(valorTemp);
				System.out.println("RECEBÍVEL ANTECIPADO. VALOR: R$ " + valorTemp);
				this.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "ANTECIPAÇÃO DE RECEBÍVEL"));
			}else {
				System.out.println("⚠ NÃO EXISTE NENHUM RECEBÍVEL COM O VALOR R$ " + valorTemp);
			}
		} else {
			System.out.println("VOCÊ NÃO POSSUI NENHUMA CONTA A RECEBER");
		}
	}
	
	public void ativarConta() {
		System.out.println();
		System.out.println("A SUA CONTA AINDA NÃO FOI ATIVADA");
		System.out.println("REALIZE UM DEPÓSITO DE NO MÍNIMO R$ 100,00 E CONTINUE COM A OPERAÇÃO");
		System.out.println();
		System.out.print("DESEJA REALIZAR O DEPÓSITO AGORA? S/N: ");
		Character escolhaAtivarConta = '0';
		escolhaAtivarConta = Character.toUpperCase(scanner.next().charAt(0));
		scanner.nextLine();
		
		while(escolhaAtivarConta != 'S' && escolhaAtivarConta != 'N') {
			System.out.println();
			System.out.print("⚠ OPÇÃO INVÁLIDA. POR FAVOR, DIGITE NOVAMENTE: ");
			escolhaAtivarConta = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
		}
		
		if(escolhaAtivarConta.equals('S')) {
			System.out.println();
			System.out.print("DIGITE UM VALOR (MÍNIMO R$ 100,00): ");
			double valorTemp = Double.parseDouble(scanner.nextLine());
			
			while(valorTemp < 100.0) {
				System.out.println();
				System.out.print("⚠ VALOR INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE (MÍNIMO R$ 100,00): ");
				valorTemp = Double.parseDouble(scanner.nextLine());
			}
			
			this.creditarValor(valorTemp);
			this.setContaAtiva(true);
			System.out.println("DEPÓSITO EFETUADO!");
			
			this.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "DEPÓSITO INICIAL\t"));
		}
	}
	
	public void enviarCambio(double valorCambio, Character escolhaMoeda) {
		if(this.isContaAtiva()) {
			if(this.getSaldoConta() >= valorCambio) {
				
				if(escolhaMoeda.equals('1')) {
					System.out.println();
					double valorTempCambiado = valorCambio / 5.17;
					this.debitarValor(valorCambio);
					this.registrarMovimentoBancario(new MovimentoBancario(valorCambio, "DÉBITO INTERNACIONAL DÓLAR"));
					System.out.println("ENVIANDO... \t\t PRONTINHO!");
					System.out.printf("R$ %.2f \t→\t U$D %.2f", valorCambio,valorTempCambiado);
					System.out.println();
				} else {
					System.out.println();
					double valorTempCambiado = valorCambio / 5.29;
					this.debitarValor(valorCambio);
					this.registrarMovimentoBancario(new MovimentoBancario(valorCambio, "DÉBITO INTERNACIONAL EURO"));
					System.out.println("ENVIANDO... \t\t PRONTINHO!");
					System.out.printf("R$ %.2f \t→\t € %.2f", valorCambio,valorTempCambiado);
					System.out.println();
				}
				
			}else {
				System.out.println("SALDO INSUFICIENTE ☹");
				}
		} else {
			this.ativarConta();
		}
	}
	
	public void receberCambio(double valorCambio, Character escolhaMoeda) {
		if(this.isContaAtiva()) {		
				if(escolhaMoeda.equals('1')) {
					System.out.println();
					double valorTempCambiado = valorCambio * 5.17;
					this.creditarValor(valorTempCambiado);
					this.registrarMovimentoBancario(new MovimentoBancario(valorCambio, "CRÉDITO INTERNACIONAL DÓLAR"));
					System.out.println("PROCESSANDO... \t\t PRONTINHO!");
					System.out.printf("R$ %.2f \t→\t U$D %.2f", valorTempCambiado,valorCambio);
					System.out.println();
				} else {
					System.out.println();
					double valorTempCambiado = valorCambio * 5.29;
					this.creditarValor(valorTempCambiado);
					this.registrarMovimentoBancario(new MovimentoBancario(valorCambio, "CRÉDITO INTERNACIONAL EURO"));
					System.out.println("PROCESSANDO... \t\t PRONTINHO!");
					System.out.printf("R$ %.2f \t→\t € %.2f", valorTempCambiado,valorCambio);
					System.out.println();
				}
		} else {
			this.ativarConta();
		}
	}

	// GETTERS AND SETTERS
	public Double getEmprestimoEmpresa() {
		return this.emprestimoEmpresa;
	}
	
	public void setEmprestimoEmpresa(Double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	public String getNomeEmpresa() {
		return this.nomeEmpresa;
	}
	
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
	public String getCnpjEmpresa() {
		return this.cnpjEmpresa;
	}
	
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	
	public String getAgenciaEmpresa() {
		return this.agenciaEmpresa;
	}
	
	public String getChavePix() {
		return this.chavePix;
	}

	public ArrayList<Double> getRecebiveisEmpresa() {
		return this.recebiveisEmpresa;
	}

	public void setRecebiveisEmpresa(ArrayList<Double> recebiveis) {
		this.recebiveisEmpresa = recebiveis;
	}
}