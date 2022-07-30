package br.com.app.entities;

public class ContaEstudantil extends Conta{

    private double limiteEstudantil = 5000;
	private String agencia;
	private String nome;
    
    public ContaEstudantil(){
    }
    
    public ContaEstudantil(String nome, String agencia, int numero, String CPF, String senha){
    	this.nome = nome;
    	this.agencia = agencia;
    	this.setNumeroConta(numero);
    	this.setCpfConta(CPF);
    	this.setSenhaUsuario(senha);
    }
    
    public double getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(double limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void creditarValor (double valorCredito) {
    	this.saldoConta += valorCredito;
    	System.out.println("Depósito efetuado com sucesso!");
    	this.registrarContagemMovimentosBancarios();
    }

    public void debitarValor(double valorDebito) {
        if(this.saldoConta >= valorDebito) {
            this.saldoConta -= valorDebito;
            System.out.println("Pagamento efetuado com sucesso!");
            this.registrarContagemMovimentosBancarios();
            this.registrarMovimentoBancario(new MovimentoBancario(valorDebito, "D"));
        } else {
            System.out.println("Saldo insuficiente para realizar o débito.");
        }
    }
    
    public void enviarValor(double valorDebito) {
        if(this.saldoConta >= valorDebito) {
            this.saldoConta -= valorDebito;
            System.out.println("Transferência efetuada com sucesso!");
            this.registrarContagemMovimentosBancarios();
            this.registrarMovimentoBancario(new MovimentoBancario(valorDebito, "D"));
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
    
    public void investirValor(double valorDebito) {
        if(this.saldoConta >= valorDebito) {
            this.saldoConta -= valorDebito;
            System.out.println("Investimento efetuado com sucesso!");
            this.registrarContagemMovimentosBancarios();
            this.registrarMovimentoBancario(new MovimentoBancario(valorDebito, "D"));
        } else {
            System.out.println("Saldo insuficiente para realizar o investimento.");
        }
    }

    public void usarEstudantil(double valorEmprestimo) {
        if (valorEmprestimo <= this.limiteEstudantil) {
        this.saldoConta = this.saldoConta + valorEmprestimo;
        this.limiteEstudantil = this.limiteEstudantil - valorEmprestimo;
        System.out.println("Empréstimo efetuado com sucesso!");
        this.registrarMovimentoBancario(new MovimentoBancario(valorEmprestimo, "C"));
        }
        else { 
        System.out.println("Saldo insuficiente para realizar o empréstimo, sua solicitação ultrapassa o limite de empréstimo. Seu limite atual de empréstimo é: " + this.limiteEstudantil);
        }
    }
    
    public void ativarSaldo () {
    	this.saldoConta = 0;
    }
}