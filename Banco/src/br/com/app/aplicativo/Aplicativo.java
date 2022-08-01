package br.com.app.aplicativo;

import br.com.app.entities.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;
import java.time.LocalDate;
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
			System.out.println("CONATUS INC.");
			System.out.println("TRANSFORMANDO O DINHEIRO EM OPORTUNIDADE");
			System.out.println();
			
			System.out.println("\t1. LOGIN");
			System.out.println("\t2. CRIAR CONTA");
			System.out.println("\t3. FECHAR APLICATIVO");
			System.out.println();
			
			System.out.println("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA");
			System.out.print("→ ");
			escolhaMenuInicial = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!escolhaMenuInicial.equals('1') && !escolhaMenuInicial.equals('2') && !escolhaMenuInicial.equals('3')) {
				System.out.println("! CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE");
				System.out.print("→ ");
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
			System.out.println("▬ ▬ LOGIN ▬ ▬");
			System.out.println();
			
			System.out.println("\t1. PESSOA FÍSICA");
			System.out.println("\t2. PESSOA JURÍDICA");
			System.out.println("\t3. VOLTAR");
			System.out.println();
			
			System.out.println("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA");
			System.out.print("→ ");
			escolhaLogin = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!escolhaLogin.equals('1') && !escolhaLogin.equals('2') && !escolhaLogin.equals('3')) {
				System.out.println("! CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE");
				System.out.print("→ ");
				escolhaLogin = scanner.next().charAt(0);
				scanner.nextLine();
			}	
			System.out.println();
			if(escolhaLogin.equals('1')) {
				// Pessoa Física
				System.out.println("\t ▬ ▬ PESSOA FÍSICA ▬ ▬");
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
					System.out.println("! CPF OU SENHA INVÁLIDA.");
				}				
			}else if(escolhaLogin.equals('2')) {
				System.out.println("\t ▬ ▬ PESSOA JURÍDICA ▬ ▬");
				System.out.println();
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
					System.out.println("! CPF OU SENHA INVÁLIDA.");
					System.out.println();
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
			System.out.println("▬ ▬ CRIAR CONTA ▬ ▬");
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
			
			System.out.println("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA");
			System.out.print("→ ");
			escolhaMenuCriarConta = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!opcoesMenuCriarConta.contains(escolhaMenuCriarConta)) {
				System.out.println("! CÓDIGO INVÁLIDO. POR FAVOR, DIGITE NOVAMENTE: ");
				System.out.print("→ ");
				escolhaMenuCriarConta = scanner.next().charAt(0);
				scanner.nextLine();
			}
			switch(escolhaMenuCriarConta) {
			case '1':{
				// CRIAR CONTA POUPANÇA
				// AUTOR: ADRIANA MONZEN
				System.out.println("> CONTA POUPANÇA");
				System.out.println();
				
				System.out.println("Seja bem-vindx à conta Poupança do [NOME BANCO]");
				System.out.println("Proteja o seu dinheiro!");
				System.out.println();
				
				System.out.println("Por favor, digite o seu nome");
				System.out.print("→ ");
				String nome = scanner.nextLine();
				
				System.out.println("Agora, diga o número da sua conta: ");
				System.out.print("→ ");
				int numero = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Digite o seu CPF: ");
				System.out.print("→ ");
				String cpf = scanner.nextLine();
				
				System.out.println("Agora digite uma senha: ");
				System.out.print("→ ");
				String senha = scanner.nextLine();
				
				boolean verifica = verificarSenha(senha);
				while(!verifica) {
					System.out.println("A sua senha deve conter pelo menos um caractere especial. Digite novamente: ");
					System.out.print("→ ");
					senha = scanner.nextLine();
				}
				
				ContaPoupanca contaPoupanca = new ContaPoupanca(nome, numero, cpf, senha, 0.0, true);
				minhaContaPoupanca = contaPoupanca;
				System.out.println("A sua conta Poupança foi criada!");
				System.out.println();
				menuContaPoupanca();
				break;
				}
			case '2':{
				// CRIAR CONTA CORRENTE
				// AUTOR: LUCAS PEREIRA
				System.out.println("> CONTA CORRENTE");
				System.out.println();
				System.out.println("Olá aguarde já iremos iniciar o seu cadastro!");
			    TimeUnit.SECONDS.sleep(2);
				System.out.println("Por favor informe seu Nome");
				System.out.print("→ ");
				String nomeClienteTemp = scanner.nextLine().toUpperCase();
				System.out.println("Por favor informe seu CPF");
				System.out.print("→ ");
				String cpfConta = scanner.nextLine();
				System.out.println("Digite a Senha");
				System.out.print("→ ");
				String senhaTemp = scanner.nextLine();
								
				boolean verificacaoSenha = verificarSenha(senhaTemp);
				while(!verificacaoSenha) {
					System.out.println();
					System.out.print("! A sua senha deve conter pelo menos um caractere especial. Por favor, digite novamente");
					System.out.print("→ ");
					senhaTemp = scanner.nextLine();
					verificacaoSenha = verificarSenha(senhaTemp);
					System.out.println();
				}
					
				System.out.println();
				ContaCorrente contaCorrenteTemp = new ContaCorrente(nomeClienteTemp, cpfConta, senhaTemp);
				minhaContaCorrente = contaCorrenteTemp;
				System.out.println("xxxxx Conta Corrente criada com Sucesso xxxxx");
				System.out.println();
				
				menuContaCorrente();
				break;
				}
			case '3':{
				// CRIAR CONTA ESPECIAL
				// AUTOR: PEDRO SILVA
				System.out.println("> CONTA ESPECIAL");
				System.out.println();
				
				System.out.println("CPF");
				System.out.print("→ ");
				String cpf = scanner.nextLine();
				
				System.out.println("Número da conta");
				System.out.print("→ ");
				int numero = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Senha");
				System.out.print("→ ");
				String senha = scanner.nextLine();
				
				boolean senhaValida = verificarSenha(senha);
				while (!senhaValida) {
					System.out.println();
					System.out.println("A sua senha deve conter pelo menos um caractere especial. Por favor, digite novamente");
					System.out.print("→ ");
					senha = scanner.nextLine();
					senhaValida = verificarSenha(senha);
				}
				
				minhaContaEspecial = new ContaEspecial(cpf, numero);
				System.out.println();
				System.out.println("Conta Especial criada com sucesso!");
				menuContaEspecial();
				
				break;
				
				}
			case '4':{
				// CRIAR CONTA ESPECIAL
				// AUTOR: DANIEL AUGUSTO
				System.out.println("> CONTA EMPRESARIAL");
				System.out.println();
				System.out.println("Nome da Empresa");
				System.out.print("→ ");
				String nomeTemp = scanner.nextLine();
				System.out.println("CNPJ");
				System.out.print("→ ");
				String cnpjTemp = scanner.nextLine();
				System.out.println("Número da conta");
				System.out.print("→ ");
				int numeroTemp = Integer.parseInt(scanner.nextLine());
				System.out.println("Senha");
				System.out.print("→ ");
				String senhaTemp = scanner.nextLine();
				
				boolean verificacaoSenha = verificarSenha(senhaTemp);
				while(!verificacaoSenha) {
					System.out.println();
					System.out.println("! A sua senha deve conter pelo menos um caractere especial. Por favor, digite novamente");
					System.out.print("→ ");
					senhaTemp = scanner.nextLine();
					verificacaoSenha = verificarSenha(senhaTemp);
				}
				
				System.out.println("A sua conta PJ está sendo criada...");
				ContaEmpresa contaEmpresaTemp = new ContaEmpresa(nomeTemp, cnpjTemp, numeroTemp, senhaTemp);
				minhaContaEmpresa = contaEmpresaTemp;
				System.out.println("Conta PJ criada com sucesso!");
				minhaContaEmpresa.ativarConta();
				System.out.println();
				menuContaEmpresa();
				break;
				}
			case '5':{
				// CRIAR CONTA ESTUDANTIL
				// AUTOR: RIZIA RAQUEL
				System.out.println("> CONTA ESTUDANTIL");
				System.out.println();
				System.out.println("Deseja cadastrar sua conta? Digite S/N");
				System.out.print("→ ");
				char escolha = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
				
				while(escolha != 'N' && escolha != 'S') {
				System.out.println("! Digite uma opção válida");
				System.out.print("→ ");
				escolha = Character.toUpperCase(scanner.next().charAt(0));
				scanner.nextLine();
				}
				
				if(escolha == 'S') {
				System.out.println();
				System.out.println("Digite o seu nome");
				System.out.print("→ ");
				String nome = scanner.nextLine();
				System.out.println("Digite o número da sua agência");
				System.out.print("→ ");
				String agencia = scanner.nextLine();
				System.out.println("Digite o número da sua Conta");
				System.out.print("→ ");
				int numero = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o número do seu CPF");
				System.out.print("→ ");
				String CPF = scanner.nextLine();
				System.out.println("Digite a sua senha");
				System.out.print("→ ");
				String senha = scanner.nextLine();
				boolean verificar = verificarSenha(senha);
				while (!verificar) {
				System.out.println("! Digite uma senha que contenha pelo menos um caractere especial");
				System.out.print("→ ");
				senha = scanner.nextLine();
				verificar = verificarSenha(senha);
				}
				ContaEstudantil ContaTemp = new ContaEstudantil(nome, agencia, numero, CPF, senha);
				minhaContaEstudantil = ContaTemp;
				minhaContaEstudantil.setContaAtiva(true);
				
				minhaContaEstudantil.ativarSaldo();
				System.out.println(" Sua conta foi cadastrada!" + " Seu saldo é: R$ " + minhaContaEstudantil.getSaldoConta());
				System.out.println();
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
	
	// MENU CONTA POUPANÇA
	// AUTOR: ADRIANA 
	public static void menuContaPoupanca() {
		char escolhaMenu = '0';
		do{
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Conatus Inc.");
			System.out.println("▬▬▬▬ Conta Poupança");
			System.out.println("▬▬▬ " + minhaContaPoupanca.getNomeConta());
			System.out.println("▬▬ " + minhaContaPoupanca.getNumeroConta());
			System.out.println("▬ R$ " + minhaContaPoupanca.getSaldoConta());
			System.out.println();
			
			System.out.println("\t1. Depósito");
			System.out.println("\t2. Saque");
			System.out.println("\t3. Extrato");
			System.out.println("\t4. Sair");
			System.out.println();
			
			System.out.println("Digite uma opção");
			System.out.print("→ ");
			escolhaMenu = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(escolhaMenu != '1' && escolhaMenu != '2' && escolhaMenu != '3'  && escolhaMenu != '4' ) {
				System.out.println("Digite uma opção válida");
				System.out.print("→ ");
				escolhaMenu = scanner.next().charAt(0);
				scanner.nextLine();
			}
			
			System.out.println();
			switch(escolhaMenu) {
			case '1':{
				System.out.println("Digite um valor de depósito");
				System.out.print("→ R$ ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				
				while(valor <= 0.0) {
					System.out.println("Digite um valor acima de R$ 0.0");
					System.out.print("→ R$ ");
					valor = scanner.nextDouble();
					scanner.nextLine();
				}
				
				System.out.println("Digite a sua senha");
				System.out.print("→ ");
				String senha = scanner.nextLine();
				
				while(!minhaContaPoupanca.getSenhaUsuario().equals(senha)) {
					System.out.println("Senha incorreta. Digite novamente");
					System.out.print("→ ");
					senha = scanner.nextLine();
				}
				System.out.println();
				boolean verificar = minhaContaPoupanca.verificarAniversario(LocalDate.now());
				if(verificar) {
					minhaContaPoupanca.corrigirSaldo(valor);
					minhaContaPoupanca.creditarValor(valor);
					System.out.println("Processando o depósito...");
					System.out.println("Depósito realizado com sucesso!");
				}else {
					minhaContaPoupanca.creditarValor(valor);
					System.out.println("Processando o depósito...");
					System.out.println("Depósito realizado com sucesso!");
				}
				System.out.println();
				break;
				}
			case '2':{
				System.out.println("Digite um valor de saque");
				System.out.print("→ R$ ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				
				while(valor <= 0.0) {
					System.out.println("Digite um valor acima de R$ 0.0");
					System.out.print("→ R$ ");
					valor = scanner.nextDouble();
					scanner.nextLine();
				}
				
				System.out.println("Digite a sua senha");
				System.out.print("→ ");
				String senha = scanner.nextLine();
				
				while(!minhaContaPoupanca.getSenhaUsuario().equals(senha)) {
					System.out.println("Senha incorreta. Digite novamente");
					System.out.print("→ ");
					senha = scanner.nextLine();
				}
				System.out.println();
				minhaContaPoupanca.debitarValor(valor);
				System.out.println();
				break;
				}
			case '3':{
				System.out.println(">>>>> Extrato de Movimentação Bancária <<<<<");
				for (MovimentoBancario transacao: minhaContaPoupanca.getExtratoMovimentoBancario()) {
					System.out.println(transacao.toString());
				}
				System.out.println();
				System.out.println("Número de movimentações bancárias: " + minhaContaPoupanca.getContagemMovimentos());
				System.out.println();
				break;
				}
			case '4':{
				break;
				}
			}
		}while(escolhaMenu != '4');	
	}
	
	// MENU CONTA CORRENTE
	// AUTOR: LUCAS
	public static void menuContaCorrente() throws InterruptedException {
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Conatus Inc.");
			System.out.println("▬▬▬▬ Conta Corrente");
			System.out.println("▬▬▬ " + minhaContaCorrente.getNomeCliente());
			System.out.println("▬▬ " + minhaContaCorrente.getNumeroConta());
			System.out.println("▬ R$ " + minhaContaCorrente.getSaldoConta());
			System.out.println();
			char opcaoMenu = '0';
			do {
			System.out.println();
			System.out.println("\t1. Depósito");
			System.out.println("\t2. Talão de Cheque");
			System.out.println("\t3. Pagamentos");
			System.out.println("\t4. Extrato da conta");
			System.out.println("\t5. Sair");	
			System.out.println();
			System.out.println("Escolha alguma das opções acima");
			System.out.print("Digite a opção desejada: ");
			opcaoMenu = scanner.next().charAt(0);
			scanner.nextLine();
			switch (opcaoMenu) {
				case '1': {
				System.out.println("Saldo: " + minhaContaCorrente.getSaldoConta());
				System.out.println("Digite o valor que deseja depositar");
				System.out.print("→ R$ ");
			    double valor = scanner.nextDouble();
			    scanner.nextLine();
			    minhaContaCorrente.creditarValor(valor);
			    System.out.println("Deposito efetuado com Sucesso!");
			break;
			}
			case '2':{
				 System.out.println("Saldo: " + minhaContaCorrente.getSaldoConta());
				 System.out.println("Quantidade de talões disponível: " + minhaContaCorrente.getContagemTalao());
			     System.out.println("Informe a quantidade de talão de cheque que irá querer");
			     System.out.print("→ ");
			     int valor = scanner.nextInt();
			     scanner.nextLine();
			     minhaContaCorrente.pediTalao(valor);
			     break;
			}
			case '3':{
				 System.out.println("Saldo: " + minhaContaCorrente.getSaldoConta());
			     System.out.println("Digite o valor que deseja efetuar o pagamento");
			     System.out.print("→ R$ ");
			     double valor = scanner.nextDouble();
			     scanner.nextLine();
			     minhaContaCorrente.debitarValor(valor);
			     break;
			}
			case '4':{
				System.out.println();
				System.out.println("Aguarde que estamos gerando seu Extrato de Movimentação");
				TimeUnit.SECONDS.sleep(2);
				System.out.println(">>>>> Extrato de Movimentação Bancária <<<<<");
				for (MovimentoBancario transacao: minhaContaCorrente.getExtratoMovimentoBancario()) {
					System.out.println(transacao.toString());
				}
				System.out.println();
				System.out.println("Número de movimentações bancárias: " + minhaContaCorrente.getContagemMovimentos());
				System.out.println();
				break;
				}
			case '5':{
				break;
			}		
			}
		}while(opcaoMenu!= '5');		
	}
	
	// MENU CONTA ESPECIAL
	// AUTOR: PEDRO
	public static void menuContaEspecial() throws InterruptedException {
		Menu menu = new Menu();
		menu.telaContaEspecial(minhaContaEspecial);
		menuInicial();
}

	// MENU CONTA EMPRESA
	// AUTOR: DANIEL
	public static void menuContaEmpresa() {
		Character escolhaMenuContaEmpresa = '0';
		 do {
			ArrayList<Character> opcoesMenuContaEmpresa = new ArrayList<>();
			Collections.addAll(opcoesMenuContaEmpresa, '1','2','3','4','5','6','7','8');
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Conatus Inc.");
			System.out.println("▬▬▬▬▬ Conta PJ");
			System.out.println("▬▬▬▬ " + minhaContaEmpresa.getNomeEmpresa());
			System.out.println("▬▬▬ " + minhaContaEmpresa.getCnpjEmpresa());
			System.out.println("▬▬ " + minhaContaEmpresa.getNumeroConta());
			if(minhaContaEmpresa.isContaAtiva()) {
				System.out.println("▬ R$ " + minhaContaEmpresa.getSaldoConta());
			} else {
				System.out.println("▬ Inativa" + minhaContaEmpresa.getSaldoConta());
			}
			System.out.println();
			
			System.out.println("\t1. Perfil");
			System.out.println("\t2. Área Pix");
			System.out.println("\t3. Pagar");
			System.out.println("\t4. Receber");
			System.out.println("\t5. Empréstimo");
			System.out.println("\t6. Câmbio");
			System.out.println("\t7. Extrato");
			System.out.println("\t8. Sair");
			System.out.println();
			
			System.out.println("Digite o código da opção selecionada");
			System.out.print("→ ");
			escolhaMenuContaEmpresa = scanner.next().charAt(0);
			scanner.nextLine();
			
			while(!opcoesMenuContaEmpresa.contains(escolhaMenuContaEmpresa)) {
				System.out.println("! Código Inválido. Por favor, digite novamente");
				System.out.print("→ ");
				escolhaMenuContaEmpresa = scanner.next().charAt(0);
				scanner.nextLine();
			}
			System.out.println();
			switch(escolhaMenuContaEmpresa) {
			case '1':{
				// PERFIL
				System.out.println("Agência " + minhaContaEmpresa.getAgenciaEmpresa() + "\t" + "Conta PJ" + minhaContaEmpresa.getNumeroConta());
				System.out.println(minhaContaEmpresa.getNomeEmpresa() + "\t" + "CNPJ " + minhaContaEmpresa.getCnpjEmpresa());
				System.out.println("Banco 123 ★ Conatus Inc.");
				break;
				}
			case '2':{
				// ÁREA PIX
				System.out.println("\t1. Cadastrar Chave Pix");
				System.out.println("\t2. Minha Chave Pix");
				System.out.println("\t3. Voltar");
				System.out.println();
				
				System.out.println("Digite o código da opção selecionada");
				System.out.print("→ ");
				Character escolhaPix = scanner.next().charAt(0);
				scanner.nextLine();
				
				while(escolhaPix != '1' && escolhaPix != '2' && escolhaPix != '3') {
					System.out.println("! Código Inválido. Por favor, digite novamente");
					System.out.print("→ ");
					escolhaPix = scanner.next().charAt(0);
					scanner.nextLine();
				}
				System.out.println();
				if(escolhaPix.equals('1')) {
					// CADASTRAR CHAVE PIX
					minhaContaEmpresa.cadastrarChavePix();
				}else if(escolhaPix.equals('2')) {
					// MINHA CHAVE PIX
					minhaContaEmpresa.mostrarChavePix();
				} else {
					break;
				}
				System.out.println();
				break;
				}
			case '3':{
				// PAGAR
				System.out.println("Selecione a forma de pagamento");
				System.out.println();
				
				System.out.println("\t1. Débito");
				System.out.println("\t2. Pix");
				System.out.println("\t3. Boleto");
				System.out.println("\t4. Voltar");
				
				System.out.println("Digite o código da opção selecionada");
				System.out.print("→ ");
				Character escolhaPagamento = scanner.next().charAt(0);
				scanner.nextLine();
				
				while(escolhaPagamento != '1' && escolhaPagamento != '2' && escolhaPagamento != '3'&& escolhaPagamento != '4') {
					System.out.println("! Código Inválido. Por favor, digite novamente");
					System.out.print("→ ");
					escolhaPagamento = scanner.next().charAt(0);
					scanner.nextLine();
				}
				System.out.println();
				if(escolhaPagamento.equals('1')) {
					// DÉBITO
					if(minhaContaEmpresa.isContaAtiva()) {
						System.out.println("Pague à vista");
						System.out.printf("Saldo Atual: %.2f\n", minhaContaEmpresa.getSaldoConta());
						System.out.println();
						System.out.println("Valor");
						System.out.print("→ R$ ");
						double valorTemp = Double.parseDouble(scanner.nextLine());
						
						while(valorTemp <= 0.0) {
							System.out.println("! Digite um valor acima de R$ 0.0");
							System.out.print("→ R$ ");
							valorTemp = Double.parseDouble(scanner.nextLine());
						}
						
						System.out.print("Senha: ");
						String senhaTemp = scanner.nextLine();
						
						while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
							System.out.println("! Senha inválida. Por favor, digite novamente");
							System.out.print("→ ");
							senhaTemp = scanner.nextLine();
						}
						
						if(minhaContaEmpresa.getSaldoConta() >= valorTemp) {
							System.out.println("Processando o pagamento...");
							minhaContaEmpresa.debitarValor(valorTemp);
							System.out.println("Pagamento efetuado!");
							minhaContaEmpresa.registrarMovimentoBancario(new MovimentoBancario(valorTemp, "DÉBITO AUTOMÁTICO"));
							System.out.println();
						}else {
							System.out.println("Saldo insuficiente :(");
							System.out.println();
						}
					}else {
						minhaContaEmpresa.ativarConta();
						System.out.println();
					}
				} else if(escolhaPagamento.equals('2')) {
					// PIX
					System.out.println("Forma de pagamento: Pix");
					System.out.printf("Saldo atual: %.2f\n", minhaContaEmpresa.getSaldoConta());
					System.out.println();
					System.out.println("Chave Pix");
					System.out.print("→ ");
					String chavePixTemp = scanner.nextLine();
					System.out.println("Valor");
					System.out.print("→ R$ ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					
					while(valorTemp <= 0.0) {
						System.out.println("! Digite um valor acima de R$ 0.0");
						System.out.print("→ R$ ");
						valorTemp = Double.parseDouble(scanner.nextLine());
					}
					System.out.println("Senha");
					System.out.print("→ ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.println("! Senha inválida. Por favor, digite novamente");
						System.out.print("→ ");
						senhaTemp = scanner.nextLine();
					}
					
					System.out.println();
					System.out.println("Processando o pagamento...");
					System.out.println();
					minhaContaEmpresa.pagarPix(valorTemp, chavePixTemp);
					System.out.println();
				} else if(escolhaPagamento.equals('3')){
					// BOLETO
					if(minhaContaEmpresa.isContaAtiva()) {
						System.out.println("Forma de pagamento: Boleto Bancário");
						System.out.printf("Saldo atual: %.2f\n", minhaContaEmpresa.getSaldoConta());
						System.out.println();
						
						System.out.println("Valor do boleto");
						System.out.print("→ R$ ");
						double valorTemp = Double.parseDouble(scanner.nextLine());
						
						while(valorTemp <= 0.0) {
							System.out.println("! Digite um valor acima de R$ 0.00");
							System.out.print("→ R$ ");
							valorTemp = Double.parseDouble(scanner.nextLine());
						}
						
						System.out.print("Senha: ");
						String senhaTemp = scanner.nextLine();
						
						while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
							System.out.println("! Senha inválida. Por favor, digite novamente");
							System.out.print("→ ");
							senhaTemp = scanner.nextLine();
						}
						
						String boletoTemp = minhaContaEmpresa.gerarBoleto(valorTemp);
						System.out.println("Código do boleto: " + boletoTemp);
						
						if(minhaContaEmpresa.getSaldoConta() >= valorTemp) {
							System.out.println("Processando pagamento...");
							minhaContaEmpresa.pagarBoleto(valorTemp, boletoTemp);
							System.out.println();
						}else {
							System.out.println("Saldo insuficiente :(");
							System.out.println();
						}
					}else {
						minhaContaEmpresa.ativarConta();
						System.out.println();
					}
				} else {
					break;
				}
				break;
				}
			case '4':{
				// RECEBER
				if(minhaContaEmpresa.isContaAtiva()) {
					double contRecebiveis = 0;
					for(double recebivel: minhaContaEmpresa.getRecebiveisEmpresa()) {
						contRecebiveis += recebivel;
					}
					
					System.out.println("Você possui um total de R$ " + contRecebiveis + " a receber!");
					System.out.println("\t1. Contas a receber");
					System.out.println("\t2. Cadastrar conta a receber");
					System.out.println("\t3. Antecipar recebível");
					System.out.println("\t4. Utilize os dados da sua conta para receber transferências usando Pix, TED e DOC");
					System.out.println("\t5. Voltar");
					System.out.println();
					ArrayList<Character> menuReceber = new ArrayList<>();
					Collections.addAll(menuReceber, '1','2','3','4','5');
					
					System.out.println("Digite o código da opção selecionada");
					System.out.print("→ ");
					Character escolhaMenuReceber = scanner.next().charAt(0);
					scanner.nextLine();
					
					while(!menuReceber.contains(escolhaMenuReceber)) {
						System.out.println("! Código inválido. Por favor, digite novamente");
						System.out.print("→ ");
						escolhaMenuReceber = scanner.next().charAt(0);
						scanner.nextLine();
					}
					System.out.println();
					if(escolhaMenuReceber.equals('1')) {
						// MOSTRAR CONTAS A RECEBER
						minhaContaEmpresa.mostrarRecebiveis();
						System.out.println();
					} else if(escolhaMenuReceber.equals('2')) {
						// CADASTRAR CONTA A RECEBER
						minhaContaEmpresa.cadastrarRecebivel();
						System.out.println();
					} else if(escolhaMenuReceber.equals('3')) {
						// ANTECIPAR RECEBÍVEL
						minhaContaEmpresa.anteciparRecebivel();
						System.out.println();
					}else if(escolhaMenuReceber.equals('4')){
						// MOSTRAR DADOS
						minhaContaEmpresa.mostrarDadosContaEmpresa();
						System.out.println();
					}else {
						break;
					}
				}else {
					minhaContaEmpresa.ativarConta();
					System.out.println();
				}
				break;
				}
			case '5':{
				// EMPRÉSTIMO
				if(minhaContaEmpresa.isContaAtiva()) {
					System.out.println("Valor disponível para empréstimo: " + minhaContaEmpresa.getEmprestimoEmpresa());
					System.out.println("Digite o valor que deseja solicitar");
					System.out.print("→ R$ ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					System.out.print("Senha: ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.println("! Senha inválida. Por favor, digite novamente");
						System.out.print("→ ");
						senhaTemp = scanner.nextLine();
					}
					System.out.println();
					System.out.println("Processando empréstimo...");
					minhaContaEmpresa.pedirEmprestimo(valorTemp);
					System.out.println();
				}else {
					minhaContaEmpresa.ativarConta();
					System.out.println();
				}
				break;
				}
			case '6':{
				// CÂMBIO
				System.out.println("Transferência Internacional");
				System.out.println("Envie e receba dinheiro do Exterior");
				System.out.printf("Saldo atual: %.2f\n", minhaContaEmpresa.getSaldoConta());
				System.out.println();
				
				System.out.println("1. Enviar");
				System.out.println("2. Receber");
				System.out.println("3. Voltar");
				System.out.println();
				
				System.out.println("Digite o código da opção selecionada");
				System.out.print("→ ");
				Character escolhaCambio = scanner.next().charAt(0);
				scanner.nextLine();
				
				while(escolhaCambio != '1' && escolhaCambio != '2' && escolhaCambio != '3') {
					System.out.println("! Código inválido. Por favor, digite novamente");
					System.out.print("→ ");
					escolhaCambio = scanner.next().charAt(0);
					scanner.nextLine();
				}
				
				System.out.println();
				
				if(escolhaCambio.equals('1')) {
					// ENVIAR
					
					System.out.println("ENVIADO \t\t RECEBIDO");
					System.out.println("R$ 500,00 \t→ \tU$D 96,66");
					System.out.println();
					
					System.out.println("1. Dólar");
					System.out.println("2. Euro");
					System.out.println("3. Voltar");
					System.out.println();
					
					System.out.println("Digite o código da opção selecionada");
					System.out.print("→ ");
					Character escolhaMoeda = scanner.next().charAt(0);
					scanner.nextLine();
					
					while(!escolhaMoeda.equals('1') && !escolhaMoeda.equals('2') && !escolhaMoeda.equals('3')) {
						System.out.println("! Opção inválida. Por favor, digite novamente");
						System.out.print("→ ");
						escolhaMoeda = scanner.next().charAt(0);
						scanner.nextLine();
					}
					
					System.out.println("Digite um valor para ser enviado");
					System.out.print("→ R$ ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					
					while(valorTemp <= 0.0) {
						System.out.println("! Digite um valor acima de R$ 0,0");
						System.out.print("→ R$ ");
						valorTemp = Double.parseDouble(scanner.nextLine());
					}
					
					System.out.println("Digite a sua senha");
					System.out.print("→ ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.println("! Senha incorreta. Por favor, digite novamente");
						System.out.print("→ ");
						senhaTemp = scanner.nextLine();
					}
					
					if(escolhaMoeda.equals('1')) {
						minhaContaEmpresa.enviarCambio(valorTemp, escolhaMoeda);
						System.out.println();
					} else if(escolhaMoeda.equals('2')) {
						minhaContaEmpresa.enviarCambio(valorTemp, escolhaMoeda);
						System.out.println();
					}else {
						break;
					}
				} else if(escolhaCambio.equals('2')) {
					// RECEBER
					System.out.println("RECEBIDO \t\t ENVIADO");
					System.out.println("R$ 2.586,40 \t→ \tU$D 500,00");
					System.out.println();
					
					System.out.println("1. Dólar");
					System.out.println("2. Euro");
					System.out.println("3. Voltar");
					System.out.println();
					
					System.out.println("Digite o código da opção selecionada");
					System.out.print("→ ");
					Character escolhaMoeda = scanner.next().charAt(0);
					scanner.nextLine();
					
					while(!escolhaMoeda.equals('1') && !escolhaMoeda.equals('2') && !escolhaMoeda.equals('3')) {
						System.out.println("! Opção inválida. Por favor, digite novamente");
						System.out.print("→ ");
						escolhaMoeda = scanner.next().charAt(0);
						scanner.nextLine();
					}
					
					System.out.println("Digite o valor que será recebido");
					System.out.print("→ U$D/€ ");
					double valorTemp = Double.parseDouble(scanner.nextLine());
					
					while(valorTemp <= 0.0) {
						System.out.println("! Digite um valor acima de R$ 0,0");
						System.out.print("→ U$D/€ ");
						valorTemp = Double.parseDouble(scanner.nextLine());
					}
					
					System.out.print("Digite a sua senha: ");
					String senhaTemp = scanner.nextLine();
					
					while(!minhaContaEmpresa.getSenhaUsuario().equals(senhaTemp)) {
						System.out.print("! Senha incorreta. Por favor, digite novamente");
						System.out.print("→ ");
						senhaTemp = scanner.nextLine();
					}
					
					if(escolhaMoeda.equals('1')) {
						minhaContaEmpresa.receberCambio(valorTemp, escolhaMoeda);
						System.out.println();
					} else if(escolhaMoeda.equals('2')) {
						minhaContaEmpresa.receberCambio(valorTemp, escolhaMoeda);
						System.out.println();
					}else {
						break;
					}
				}else {
					break;
				}
				break;
				}
			case '7':{
				// EXTRATO
				minhaContaEmpresa.extratoContaEmpresa();
				System.out.println();
				break;
			}
			case '8':{
				break;
				}
			}
		 }while(!escolhaMenuContaEmpresa.equals('8'));
	}
	
	// MENU CONTA POUPANÇA
	// AUTOR: RIZIA
		public static void menuContaEstudantil() {
		char escolha = '0';
		do {
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ Conatus Inc.");
		System.out.println("▬▬▬▬ Conta Estudante");
		System.out.println("▬▬▬ " + minhaContaEstudantil.getNome());
		System.out.println("▬▬ " + minhaContaEstudantil.getNumeroConta());
		System.out.println("▬ R$ " + minhaContaEstudantil.getSaldoConta());
		System.out.println();

		System.out.println("1. Extrato da conta");
		System.out.println("2. Depósito");
		System.out.println("3. Pagamentos");
		System.out.println("4. Transferência");
		System.out.println("5. Empréstimo");
		System.out.println("6. Pagar empréstimo");
		System.out.println("7. Investimentos");
		System.out.println("8. Sair");	
		System.out.println();
		System.out.println("Digite a opção desejada");
		System.out.print("→ ");
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
		    
		    System.out.println("Digite o valor que deseja utilizar como empréstimo");
		    System.out.print("→ R$ ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.println("Digite a sua senha");
		    System.out.print("→ ");
			String senhaTemp = scanner.nextLine();
			while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			System.out.println("! Digite a senha correta");
			System.out.print("→ ");
			senhaTemp = scanner.nextLine();}
			minhaContaEstudantil.usarEstudantil(valor);
		    }
		
		System.out.println();
		switch (escolha) {
		case '1':{
			System.out.println(">>>>> Extrato de Movimentação Bancária <<<<<");
			for (MovimentoBancario transacao: minhaContaEstudantil.getExtratoMovimentoBancario()) {
				System.out.println(transacao.toString());
			}
			System.out.println();
			System.out.println("Número de movimentações bancárias: " + minhaContaEstudantil.getContagemMovimentos());
			System.out.println(); 
		break;
		}
		case '2':{
		     System.out.println("Digite o valor que deseja depositar");
		     System.out.print("→ R$ ");
		     double valor = scanner.nextDouble();
		     scanner.nextLine();
		     System.out.println("Digite a sua senha");
		     System.out.print("→ ");
			 String senhaTemp = scanner.nextLine();
			 while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			 System.out.println("! Digite a senha correta");
			 System.out.print("→ ");
			 senhaTemp = scanner.nextLine();}
		     minhaContaEstudantil.creditarValor(valor);
		     minhaContaEstudantil.registrarMovimentoBancario(new MovimentoBancario(valor, "C"));
		     System.out.println();
		     break;
		}
		case '3':{
		     System.out.println("Digite o valor que deseja debitar");
		     System.out.print("→ R$ ");
		     double valor = scanner.nextDouble();
		     scanner.nextLine();
		     System.out.println("Digite a sua senha");
		     System.out.print("→ ");
			 String senhaTemp = scanner.nextLine();
			 while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			 System.out.println("! Digite a senha correta");
			 System.out.print("→ ");
			 senhaTemp = scanner.nextLine();}
		     minhaContaEstudantil.debitarValor(valor);
		     System.out.println();
		     break;
			 }
		case '4':{
			System.out.println("Digite o valor que deseja enviar");
			System.out.print("→ R$ ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.println("Digite o numero da conta da pessoa para o qual deseja enviar");
		    System.out.print("→ ");
		    int contaTransferencia = scanner.nextInt();
		    scanner.nextLine();
		    System.out.println("Digite a sua senha");
		    System.out.print("→ ");
		    String senhaTemp = scanner.nextLine();
		    while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
		    	System.out.println("! Digite a senha correta");
		    	System.out.print("→ ");
		    	senhaTemp = scanner.nextLine();
		    }
		    System.out.println("Processando transferência para a conta " + contaTransferencia);
		    minhaContaEstudantil.enviarValor(valor);
		    System.out.println();
			break;
		}
		case '5':{
			System.out.println("Seu limite disponível é: R$ " + minhaContaEstudantil.getLimiteEstudantil());
		    System.out.println("Digite o valor que deseja utilizar como empréstimo");
		    System.out.print("→ R$ ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.println("Digite a sua senha");
		    System.out.print("→ ");
			String senhaTemp = scanner.nextLine();
			while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			System.out.println("! Digite a senha correta");
			System.out.print("→ ");
			senhaTemp = scanner.nextLine();}
			minhaContaEstudantil.usarEstudantil(valor);
			System.out.println();
			break;
		}
		case '6':{
			System.out.println("Saldo atual: R$ " + minhaContaEstudantil.getSaldoConta());
			System.out.println("Você possui um débito de empréstimo no valor de R$ " + minhaContaEstudantil.getEmprestimoSolicitado());
			System.out.println("Quanto você deseja pagar desse débito? ");
			System.out.print("→ R$ ");
		    double valor = scanner.nextDouble();
		    scanner.nextLine();
		    System.out.println("Digite a sua senha");
		    System.out.print("→ ");
			String senhaTemp = scanner.nextLine();
			while (!minhaContaEstudantil.getSenhaUsuario().equals(senhaTemp)) {
			System.out.println("! Digite a senha correta");
			System.out.print("→ ");
			senhaTemp = scanner.nextLine();}
			if (minhaContaEstudantil.getSaldoConta() >= valor) {
			minhaContaEstudantil.pagarEmprestimo(valor);
			System.out.println();
			}
			else {
				System.out.println("Você não possui saldo para efetuar essa operação.");
				System.out.println();
			}
			break;
		}	
		case '7':{
			char opcao = '0';
			do {
			System.out.println("Seu saldo atual é: R$ " + minhaContaEstudantil.getSaldoConta());	
			System.out.println();	
			System.out.println("1. CDB");
			System.out.println("2. LCI/LCA");
			System.out.println("3. Fundo DI");
			System.out.println("4. Tesouro SELIC");
			System.out.println("5. Sair");	
			System.out.println();
			System.out.println("Digite a opção desejada");
			System.out.print("→ ");
			opcao = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.println();
			
			switch (opcao) {
			case '1':{
				System.out.println("Digite a quantidade de meses de sua aplicação");
				System.out.print("→ ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o valor inicial que deseja investir");
				System.out.print("→ R$ ");
				double valorInicial = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Digite o valor de aportes mensais que deseja investir");
				System.out.print("→ R$ ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double CDB = valorInicial * (Math.pow(1.0055, meses)) + ((valor * (Math.pow(1.0055, meses)-1)) / 0.0055);
				System.out.printf("O valor investido ao final do período será de: R$ %.2f\n" , CDB);
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
				System.out.println();
				break;
			}
			case '2':{
				System.out.println("Digite a quantidade de meses de sua aplicação");
				System.out.print("→ ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o valor inicial que deseja investir");
				System.out.print("→ R$ ");
				double valorInicial = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Digite o valor de aportes mensais que deseja investir");
				System.out.print("→ R$ ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double LCILCA = valorInicial * (Math.pow(1.0057, meses)) + ((valor * (Math.pow(1.0057, meses)-1)) / 0.0057);
				System.out.printf("O valor investido ao final do período será de: R$ %.2f\n" , LCILCA);
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
				System.out.println();
				break;
			}
			case '3':{
				System.out.println("Digite a quantidade de meses de sua aplicação");
				System.out.print("→ ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o valor inicial que deseja investir");
				System.out.print("→ R$ ");
				double valorInicial = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Digite o valor de aportes mensais que deseja investir");
				System.out.print("→ R$ ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double FundoDI = valorInicial * (Math.pow(1.0056, meses)) + ((valor * (Math.pow(1.0056, meses)-1)) / 0.0056);
				System.out.printf("O valor investido ao final do período será de: R$ %.2f\n" , FundoDI);
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
				System.out.println();
				break;
			}
			case '4':{
				System.out.println("Digite a quantidade de meses de sua aplicação");
				System.out.print("→ ");
				int meses = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o valor inicial que deseja investir");
				System.out.print("→ R$ ");
				double valorInicial = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Digite o valor de aportes mensais que deseja investir");
				System.out.print("→ R$ ");
				double valor = scanner.nextDouble();
				scanner.nextLine();
				double selic = valorInicial * (Math.pow(1.0068, meses)) + ((valor * (Math.pow(1.0068, meses)-1)) / 0.0068);
				System.out.printf("O valor investido ao final do período será de: R$ %.2f\n" , selic);
				System.out.println("Deseja investir esse valor? Baixe agora o nosso aplicativo de investimento. Disponível para Android e iOS!");
				System.out.println();
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