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
		if(this.isContaAtiva()) {
			this.saldoConta -= valorDebitado;
			this.registrarContagemMovimentosBancarios();
		}else {
			this.ativarConta();
		}
	}
	
	@Override 
	public void creditarValor(double valorCreditado) {
		this.saldoConta += valorCreditado;
		this.registrarContagemMovimentosBancarios();
	}
	
	public void cadastrarChavePix() { 
		if(this.isContaAtiva()) {
			System.out.println("Envie e receba pagamentos a qualquer momento e sem custos adicionais.");
			System.out.println();

			System.out.print("Deseja cadastrar uma chave Pix? S/N: ");
			Character escolhaFazerChavePix = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
			
			while(escolhaFazerChavePix != 'S' && escolhaFazerChavePix != 'N') {
				System.out.println("! Opção inválida. Por favor, digite novamente");
				System.out.print("→ ");
				escolhaFazerChavePix = Character.toUpperCase(scanner.next().charAt(0));
			}
			
			if(escolhaFazerChavePix.equals('S')) {
				
				System.out.println("Registre a sua chave Pix");
				System.out.println();
				System.out.println("\t1. Celular");
				System.out.println("\t2. E-mail");
				System.out.println("\t3. CNPJ");
				System.out.println("\t4. Voltar");
				System.out.println();
				
				System.out.println("Realize e receba pagamentos  qualquer momento");
				System.out.println();
				System.out.println("Digite o código da opção selecionada");
				System.out.print("→ ");
				Character escolhaPix = scanner.next().charAt(0);
				scanner.nextLine();
				
				ArrayList<Character> opcoesRegistroPix = new ArrayList<>();
				Collections.addAll(opcoesRegistroPix, '1','2','3','4');
				
				while(!opcoesRegistroPix.contains(escolhaPix)) {
					System.out.println("! Código inválido. Por favor, digite novamente");
					System.out.print("→ ");
					escolhaPix = scanner.next().charAt(0);
					scanner.nextLine();
				}
				
				switch(escolhaPix) {
				case '1':{
					// TELEFONE
					System.out.println();
					System.out.println("Receba pagamentos a qualquer momento do dia usando apenas o número do celular");
					System.out.println();
					
					System.out.println("Número");
					System.out.print("→ ");
					String numeroTemp = scanner.nextLine();
					
					this.registrarChavePix(numeroTemp);
					break;
					}
				case '2':{
					// E-MAIL
					System.out.println();
					System.out.println("Utilize o e-mail empresarial para receber pagamentos");
					System.out.println();
					
					System.out.println("E-mail empresarial");
					System.out.print("→ ");
					String emailTemp = scanner.nextLine();
					
					this.registrarChavePix(emailTemp);
					break;
					}
				case '3':{
					// CNPJ
					System.out.println();
					System.out.println("Vincule o CPNJ à chave Pix");
					System.out.println("CNPJ vinculado com sucesso!");
					this.registrarChavePix(this.getCnpjEmpresa());
					break;
					}
				case '4':{
					break;
					}
				}
			} else {
				System.out.println("Faça uma chave Pix para prosseguir com a operação");
			}
		}else {
			this.ativarConta();
		}
	}
	
	public void registrarChavePix(String chavePix) {
		System.out.println();
		if(this.chavePix.equals("")) {
			this.chavePix = chavePix;
			System.out.println("Chave Pix cadastrada com sucesso!");
		}else {
			System.out.print("Você já possui uma chave Pix. Deseja substituí-la? S/N: ");
			Character escolhaSubstituirChavePix = '0';
			escolhaSubstituirChavePix = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
			
			while(escolhaSubstituirChavePix != 'S' && escolhaSubstituirChavePix != 'N') {
				System.out.println("! Opção inválida. Por favor, digite novamente");
				System.out.print("→ ");
				escolhaSubstituirChavePix = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
			}
			if(escolhaSubstituirChavePix.equals('S')) {
				this.chavePix = chavePix;
				System.out.println("Nova chave Pix registrada!");
			} else {
				return;
			}
		}
	}
	
	public void mostrarChavePix() {
		if(this.isContaAtiva()) {
			if(this.getChavePix().equals("")) {
				System.out.println("Nenhuma chave Pix cadastrada na sua conta PJ!");
			} else {
				System.out.println("Chave Pix \t" + this.getChavePix());
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
					System.out.println("Efetuando pagamento...");
					this.debitarValor(valorPix);
					System.out.println("Pagamento Pix efetuado!");
					System.out.println();
					
					System.out.println("COMPROVANTE");
					System.out.println("VALOR: \tR$ " + valorPix);
					System.out.println("DE: CONATUS INC.");
					System.out.println("CNPJ: " + this.cnpjEmpresa);
					System.out.println("AGÊNCIA: " + this.agenciaEmpresa + "\t   CONTA: " + this.getNumeroConta());
					System.out.println("PARA: \t" + chavePix);
					this.registrarMovimentoBancario(new MovimentoBancario(valorPix, "PIX"));
				} else {
					System.out.println("Saldo insuficiente :(");
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
		System.out.println("Pagamento do boleto efetuado!");
		this.registrarMovimentoBancario(new MovimentoBancario(valorBoleto, "PAGAMENTO DE BOLETO BANCÁRIO"));
	}
	
	public void mostrarDadosContaEmpresa() {
		System.out.println("AGÊNCIA" + "\t" + this.agenciaEmpresa);
		System.out.println("CONTA" + "\t" + this.getNumeroConta());
		System.out.println("CNPJ" + "\t" + this.cnpjEmpresa);
		System.out.println("CHAVE PIX" + "\t" + this.chavePix);
		System.out.println("CONATUS INC. \tBANCO 123");
	}
	
	public void extratoContaEmpresa() {
		System.out.println(">>>>> Extrato de Movimentação Bancária <<<<<");
		for(MovimentoBancario movimento: this.getExtratoMovimentoBancario()) {
			System.out.println(movimento.toString());
		}
		System.out.println();
		System.out.println("Número de movimentações bancárias: " + this.getContagemMovimentos());
	}
	
	public void pedirEmprestimo(double valorEmprestimo) {
		if(this.isContaAtiva()) {
			if(valorEmprestimo <= this.emprestimoEmpresa) {
				this.emprestimoEmpresa -= valorEmprestimo;
				this.creditarValor(valorEmprestimo);
				System.out.println("Empréstimo realizado!");
				this.registrarMovimentoBancario(new MovimentoBancario(valorEmprestimo, "EMPRÉSTIMO"));
			} else {
				System.out.println("Valor fora do limite de empréstimo :(");
			}
		}else {
			this.ativarConta();
		}
	}
	
	public void mostrarRecebiveis() {
		if(this.getRecebiveisEmpresa().size() > 0) {
			for(double recebivel: this.getRecebiveisEmpresa()) {
				System.out.println("Conta: R$ " + recebivel);
			}
		} else {
			System.out.println("Sua conta PJ não possui nenhuma conta a receber");
		}
	}
	
	public void cadastrarRecebivel() {
		if(this.isContaAtiva()) {
			System.out.println("Digite o valor da conta");
			System.out.print("→ R$ ");
			double valorTemp = Double.parseDouble(scanner.nextLine());
			
			while(valorTemp <= 0) {
				System.out.println("! Digite um valor acima de R$ 0.0");
				System.out.print("→ R$ ");
				valorTemp = Double.parseDouble(scanner.nextLine());
			}
			
			this.recebiveisEmpresa.add(valorTemp);
			System.out.println("Valor a receber cadastrado!");
			this.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "VALOR A RECEBER"));
			this.registrarContagemMovimentosBancarios();
		}else {
			this.ativarConta();
		}
	}
	
	public void anteciparRecebivel() {
		int index = 0;
		boolean achouRecebivel = false;
		System.out.println("Digite o valor que deseja antecipar");
		System.out.print("→ R$ ");
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
				System.out.println("Recebível antecipado. VALOR: R$ " + valorTemp);
				this.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "ANTECIPAÇÃO DE RECEBÍVEL"));
			}else {
				System.out.println("! Não existe nenhum recebível com o valor R$ " + valorTemp);
			}
		} else {
			System.out.println("Sua conta PJ não possui nenhuma conta a receber");
		}
	}
	
	public void ativarConta() {
		System.out.println();
		System.out.println("Conta PJ ainda não foi ativada");
		System.out.println("Realize um depósito de no mínimo R$ 1.000,00 e continue com a operação");
		System.out.println();
		System.out.print("Deseja realizar o depósito agora? S/N: ");
		Character escolhaAtivarConta = '0';
		escolhaAtivarConta = Character.toUpperCase(scanner.next().charAt(0));
		scanner.nextLine();
		
		while(escolhaAtivarConta != 'S' && escolhaAtivarConta != 'N') {
			System.out.println();
			System.out.println("! Opção inválida. Por favor, digite novamente");
			System.out.print("→ ");
			escolhaAtivarConta = Character.toUpperCase(scanner.next().charAt(0));
			scanner.nextLine();
		}
		
		if(escolhaAtivarConta.equals('S')) {
			System.out.println();
			System.out.println("Digite um valor (Mínimo R$ 1.000,00)");
			System.out.print("→ R$ ");
			double valorTemp = Double.parseDouble(scanner.nextLine());
			
			while(valorTemp < 1000.0) {
				System.out.println();
				System.out.println("! Valor inválido. Por favor, digite novamente (Mínimo R$ 100,00)");
				System.out.print("→ R$ ");
				valorTemp = Double.parseDouble(scanner.nextLine());
			}
			
			this.creditarValor(valorTemp);
			this.setContaAtiva(true);
			System.out.println("Depósito efetuado!");
			
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
					System.out.println("ENVIANDO... \t\t RECEBIDO!");
					System.out.printf("R$ %.2f \t→\t U$D %.2f", valorCambio,valorTempCambiado);
					System.out.println();
				} else {
					System.out.println();
					double valorTempCambiado = valorCambio / 5.29;
					this.debitarValor(valorCambio);
					this.registrarMovimentoBancario(new MovimentoBancario(valorCambio, "DÉBITO INTERNACIONAL EURO"));
					System.out.println("ENVIANDO... \t\t RECEBIDO!");
					System.out.printf("R$ %.2f \t→\t € %.2f", valorCambio,valorTempCambiado);
					System.out.println();
				}
				
			}else {
				System.out.println("Saldo insuficiente :(");
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
					this.registrarMovimentoBancario(new MovimentoBancario(valorTempCambiado, "CRÉDITO INTERNACIONAL DÓLAR"));
					System.out.println("PROCESSANDO... \t\t RECEBIDO!");
					System.out.printf("R$ %.2f \t→\t U$D %.2f", valorTempCambiado,valorCambio);
					System.out.println();
				} else {
					System.out.println();
					double valorTempCambiado = valorCambio * 5.29;
					this.creditarValor(valorTempCambiado);
					this.registrarMovimentoBancario(new MovimentoBancario(valorTempCambiado, "CRÉDITO INTERNACIONAL EURO"));
					System.out.println("PROCESSANDO... \t\t RECEBIDO!");
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