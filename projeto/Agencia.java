import java.util.Random;

public class Agencia {

	private String nome;
	private Banco banco;
	private Cliente [] clientes;
	private ContaBancaria [] contas;
	private Atendente [] atendentes;

	public Agencia(String ageNome, Banco bc, int tClientes, int tContas, int tAtendentes){
		this.nome = ageNome;
		this.banco = bc;

		// SETANDO A CAPACIDADE DA AGENCIA
		this.clientes = new Cliente[tClientes];
		this.contas = new ContaBancaria[tContas];
		this.atendentes = new Atendente[tAtendentes];

		// POR PADRAO, A AGENCIA COMECA COM DOIS ATENDENTES
		this.atendentes[0] = new Atendente("JavaX", this);
		this.atendentes[1] = new Atendente("JuremaX", this);
	}


	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}


	public Banco getBanco()
	{
		return this.banco;
	}


	public Atendente acessarAtendente()
	{
		//RETORNANDO UM ATENDENTE ALEATORIO
		return atendentesDisponiveis();
	}

	public boolean addAtendente()
	{
		// VERIFICAR SE EXISTE ESPACO NO ARRAY DE ATENDNETES
		return false;
	}

	private Atendente atendentesDisponiveis()
	{
		//RETORNANDO UM ATENDENTE ALEATORIO
		Random RD = new Random();
		int x = 0;
		for(int i = 0; i < 1; i++){
			x = RD.nextInt(this.atendentes.length);
		}
		return this.atendentes[x];
	}
}
