# projeto-grupo-5
Projeto Integrador - Java

# DETALHES:
## SUPERCLASSE CONTA
Lembrem-se que a superclasse Conta possui apenas métodos e atributos que são comuns a TODAS as classes. Sendo assim, é essencial que você use basicamente tudo o que está ali no seu código.

1. Atributos: 
	- cpfConta (String)
	- numeroConta (int)
	- saldoConta (double)
	- contaAtiva (boolean)
	- senhaUsuario (String)
	- contadorMovimentos (int)
	- extratoMovimentoBancario (ArrayList< MovimentoBancario >)
	
	Toda vez que precisar instanciar um objeto da sua classe, lembre-se de atribuir valores a esses atributos utilizando o método set ou referenciando diretamente utilizando o 'this';
	
	Quando estiver trabalhando em sua classe, pode-se fazer referência direta ao dado usando o comando 'this';
	
Já instanciei um objeto global para cada conta, sendo eles: minhaContaCorrente, minhaContaEmpresa, minhaContaEspecial, minhaContaEstudantil e minhaContaPoupanca. Vocês podem fazer referência a esses objetos em qualquer local dentro da classe Aplicativo.

Sobre o contador de movimentos financeiros. Criei um método que pode ser usado por qualquer classe. Quando uma movimentação for realizada (lembrem-se de checar se é possível realizar essa movimentação), vocês chamam esse método. O método é o seguinte: registrarContagemMovimentosBancarios();

Sobre a lista extratoMovimentoBancario, também fiz um método que todas as contas podem chamar, bem tranquilo também. Tudo o que vocês precisam é chamado: registrarMovimentoBancario(new MovimentoBancario(Valor_Movimento, "Tipo_Movimento"));

## Classe Aplicativo
Lá na classe Aplicativo, deixei separado direitinho um local comentado para vocês inserirem o código referente tanto à criação da conta, quando do menu da conta.
Fica a liberdade de vocês como será a criação. Por exemplo, vocês podem fazer todo o processo ali mesmo já atribuindo valores ao objeto referente a sua conta que já está instanciado. Vocês também podem utilizar construtores, como um que é obrigatório o uso se não me engano.

    public NomeConta(){}
	
	public NomeConta(String cpfConta, int numeroConta){
		this.setCpfConta(cpfConta);
		this.setNumeroConta(numeroConta);
	}

Copiem o código acima e colem dentro da classe de vocês. Alterem o 'NomeConta' para o nome correto de sua conta.

O menu consiste no seguinte:
1. Login
2. Criar Conta
3. Fechar Aplicativo

Se a pessoa escolher o 1, vai fazer abrir um novo menu:
1. Pessoa Física
2. Conta PJ
3. Voltar

Se a pessoa escolher 1 novamente, abre o menu de LogIn onde pede um CPF e uma senha. Fiz o algoritmo pra realizar a busca se existe alguma conta com o cpf e a senha digitado. Se não houver, volta pra tela anterior. Se houver, abre o menu da conta específica.

Se voltar pra tela anterior e nesse momento a pessoa escolher 2, ou seja, conta PJ. Aí eu já fiz todo o algoritmo porque a unica Conta PJ possivel é a ContaEmpresa.

Se no menu inicial:
 1. Login
2. Criar Conta
3. Fechar Aplicativo

A pessoa escolher 2, então vai abrir um menu para criar conta:
1. Conta Poupança
2. Conta Corrente
3. Conta Especial
4. Conta Empresa
5. Conta Estudantil
6. Voltar 

Como eu disse, vai ter um espaço reservado lá no método menuCriarConta() para vocês desenvolverem o código relacionado a criação da conta. Lembrem-se que o objeto já foi instanciado e pode ser acessado globalmente na classe Aplicativo.
Um outro detalhe é que, ao criar a conta, chamar o método de menu referente a sua conta. Esse método já foi criado e só precisa do seu código.

Exemplo do menu da conta empresa:
1. Perfil
2. Área Pix
3. Pagar
4. Receber
5. Extrato
6. Antecipar Recebíveis
7. Investimentos [talvez]
8. Sair da conta 

Em toda a classe Aplicativo existem métodos que ajudam no código. Eu criei um método para validar que uma senha possua pelo menos um caractere especial:

    ArrayList<String> listaCaracteresSenhaUsuario = verificarSenha(OBJ_DA_CONTA.getSenhaUsuario());
					
	while(listaCaracteresSenhaUsuario.size() == 0) {
		System.out.print("A SUA SENHA DEVE CONTER PELO MENOS UM CARACTERE ESPECIAL. POR FAVOR, DIGITE NOVAMENTE: ");
		contaEmpresaTemp.setSenhaUsuario(scanner.nextLine());
		System.out.println();
		listaCaracteresSenhaUsuario = verificarSenha(OBJ_DA_CONTA.getSenhaUsuario());
	}

Qualquer dúvida, mandem mensagem, liguem ou o que for preciso ;)
