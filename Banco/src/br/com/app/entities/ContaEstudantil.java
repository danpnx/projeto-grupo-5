package br.com.app.entities;

public class ContaEstudantil extends Conta{

    private double limiteEstudantil = 5000;
	private String agencia;
	private String nome;
	private double emprestimoSolicitado = 0;
    
    public double getEmprestimoSolicitado() {
		return this.emprestimoSolicitado;
	}

	public void setEmprestimoSolicitado(double emprestimoSolicitado) {
		this.emprestimoSolicitado = emprestimoSolicitado;
	}

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
	
	public void pagarEmprestimo (double valorCredito) {
		
        if(this.emprestimoSolicitado == 0) {
			  System.out.println("Não existe nenhum valor de empréstimo a ser pago.");
		} else {
			if(valorCredito > emprestimoSolicitado) {
				double diferenca = valorCredito - this.emprestimoSolicitado;
				this.saldoConta += diferenca;
				valorCredito -= diferenca;
				this.limiteEstudantil += valorCredito;
		        this.emprestimoSolicitado -= valorCredito;
		        this.saldoConta -= valorCredito;
		        System.out.println("O pagamento total do empréstimo efetuado com sucesso!");
		        this.registrarContagemMovimentosBancarios();
		        this.registrarMovimentoBancario(new MovimentoBancario(valorCredito, "D"));
			} else {
				this.limiteEstudantil += valorCredito;
		        this.emprestimoSolicitado -= valorCredito;
		        this.saldoConta -= valorCredito;
		        System.out.println("O pagamento total do empréstimo efetuado com sucesso!");
		        this.registrarContagemMovimentosBancarios();
		        this.registrarMovimentoBancario(new MovimentoBancario(valorCredito, "D"));
			}
		}
    
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

    public void usarEstudantil(double valorEmprestimo) {
        if (this.limiteEstudantil >= valorEmprestimo) {
        this.saldoConta = this.saldoConta + valorEmprestimo;
        this.limiteEstudantil = this.limiteEstudantil - valorEmprestimo;
        this.emprestimoSolicitado += valorEmprestimo;
        System.out.println("Empréstimo efetuado com sucesso!");
        this.registrarMovimentoBancario(new MovimentoBancario(valorEmprestimo, "C"));
        this.registrarContagemMovimentosBancarios();
        }
        else { 
        System.out.println("Saldo insuficiente para realizar o empréstimo.");
        }
    }
    
    public void ativarSaldo () {
    	this.saldoConta = 0;
    }
}