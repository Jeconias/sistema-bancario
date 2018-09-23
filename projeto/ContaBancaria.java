public class ContaBancaria {

	private int numero;
	private String senha;
	private double saldo;
	private boolean status;
	private Cliente cliente;

	private String log = "";

	public ContaBancaria(int numero, Cliente cliente, String senha){
		this.numero = numero;
		this.cliente = cliente;
		this.senha = senha;
		this.saldo = 0;
		this.status = true;
	}

	public int numero() {
		return this.numero;
	}

	public double sacar(double valor) {
		//CONTA INATIVA
		if(!this.status) {
			this.log += " SAQUE NEGADO - CONTA DESATIVADA\n";
			return -1;
		}

		//CONTA ATIVA
		if(this.saldo >= valor) {
			this.saldo -= valor;
			this.log += " SAQUE REALIZADO - "+valor+"\n";
			return valor;
		}
		return 0;
	}

	public double depositar(double valor) {
		//CONTA INATIVA
		if(!this.status) {
			this.log += " DEPOSITO NEGADO - CONTA DESATIVADA\n";
			return -1;
		}

		//CONTA ATIVA
		this.saldo += valor;
		this.log += " DEPOSITO REALIZADO - "+valor+"\n";
		return this.saldo;
	}

	public double saldo() {
		return this.saldo;
	}

	public void changeStatus()
	{
		if(this.status == true){
			this.log += " CONTA DESATIVADA\n";
			this.status = false;
		}else{
			this.log += " CONTA ATIVADA\n";
			this.status = true;
		}
	}

	// RETORNAR UM VALOR BOOLEAN PARA VERIFICAR NO MAIN
	public String statusConta()
	{
		if(this.status == true){
			return "Desativar Conta";
		}else{
			return "Ativar Conta";
		}
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setSenha(String senha) {
		this.log += " NOVA SENHA INSERIDA\n";
		this.senha = senha;
	}

	public String getSenha() {
		return this.senha;
	}

	public String log()
	{
		return this.log;
	}
}
