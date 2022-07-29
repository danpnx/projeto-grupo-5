package br.com.app.entities;

public class ContaEstudantil extends Conta{
    private double limiteEstudantil = 5000;
    private double saldoConta;

    public void setSaldoConta(double novoSaldo) {
        this.saldoConta = novoSaldo;
    }

    public double getSaldoConta() {
        return this.saldoConta;
    }


       public double getLimiteEstudantil() {
           return this.limiteEstudantil;
       }
    public void setLimiteEstudantil(double limiteEstudantil) {
        this.limiteEstudantil = limiteEstudantil;
    }

    public void pagarDebito(double valorDebito) {
        if(this.saldoConta >= valorDebito) {
            this.saldoConta -= valorDebito;
            System.out.println("Pagamento efetuado. ");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    public void usarEstudantil(double valorEmprestimo) {

        this.saldoConta = this.saldoConta + valorEmprestimo;
        this.limiteEstudantil = this.limiteEstudantil - valorEmprestimo;
        System.out.println("Empréstimo efetuado.");
    }

}