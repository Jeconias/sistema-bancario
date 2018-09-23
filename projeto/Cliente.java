public class Cliente {

	private String cpf;
	private String nome;
	private String [] telefone;
	private String [] email;

	private ContaBancaria [] contas;

	public Cliente(String cpf, String nome, String telefone, String email) {
		this.contas	= new ContaBancaria[2];
		this.email = new String[2];
		this.telefone = new String[2];

		this.cpf = cpf;
		this.nome = nome;
		this.telefone[0] = telefone;
		this.email[0] = email;
	}


	public void addConta(ContaBancaria novaConta){
		int contasLength = this.contas.length;

		//VERIFICAR SE HA ESPACO VAZIO NO ARRAY CONTA
		for(int i = 0; i < contasLength; i++) {
			if(this.contas[i] == null) {
				this.contas[i] = novaConta;
				return;
			}
		}

		//AUMENTAR O TAMANHO DO ARRAY E ADICIONA O NOVO CLIENTE
		ContaBancaria [] novoArrayConta = new ContaBancaria[ contasLength * 10 ];
		for(int i = 0; i < contasLength; i++) {
			novoArrayConta[i] = this.contas[i];
		}
		novoArrayConta[ contasLength ] = novaConta;
		this.contas = novoArrayConta;
	}

	public ContaBancaria [] getContas() {
		return this.contas;
	}

	public ContaBancaria buscarConta(int numero) {
		for(int i = 0; i < this.contas.length; i++) {
			if(this.contas[i].numero() == numero) {
				return this.contas[i];
			}
		}
		return null;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCpf() {
		return cpf;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	// OS METODOS QUE ESTAO COMENTADOS AINDA NAO FORAM UTILIZADOS NESSA VERSAO

	/*public boolean setTelefone(String telefone) {
		for(int i=0; i<this.telefone.length; i++) {
			if(this.telefone[i] == null) {
				this.telefone[i] = telefone;
				return true;
			}
		}
		return false;
	}

	public boolean setTelefone(String telefone, int index) {
		if(index>=0 && index < 4) {
			this.telefone[index] = telefone;
			return true;
		}
		return false;
	}

	public String [] getTelefone() {
		return this.telefone;
	}

	public int getQuantidadeTelefones() {
		int contador = 0;
		for(int i=0; i<this.telefone.length; i++) {
			if(this.telefone[i] != null) {
				contador += 1;
			}
		}
		return contador;
	}


	public boolean setEmail(String email) {
		for(int i=0; i<this.email.length; i++) {
			if(this.email[i] == null) {
				this.email[i] = email;
				return true;
			}
		}
		return false;
	}

	public boolean setEmail(String email, int index) {
		if(index>=0 && index < 2) {
			this.email[index] = email;
			return true;
		}
		return false;
	}

	public String [] getEmail() {
		return this.email;
	}

	public int getQuantidadeEmail() {
		int contador = 0;
		for(int i=0; i<this.email.length; i++) {
			if(this.email[i] != null) {
				contador += 1;
			}
		}
		return contador;
	}*/
}
