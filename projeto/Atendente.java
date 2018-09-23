public class Atendente
{
  public String nome;
  private Agencia agencia;

  public Atendente(String nome, Agencia agencia)
  {
    this.nome = nome;
    this.agencia = agencia;
  }

  public String getNome()
  {
    return this.nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }


  public Agencia getAgencia()
  {
    return this.agencia;
  }

  public boolean setAgencia(Agencia age)
  {
    this.agencia = age;
    return true;
  }


  public boolean verificarConta(String age, String cpf, String conta, String senha)
  {
    //PASSANDO A AGENCIA E O NUMERO DA CONTA PARA INT
    int numeroAgencia = Integer.parseInt(age);
    int numeroConta = Integer.parseInt(conta);

    return this.validarAcesso(numeroAgencia, cpf, numeroConta, senha);
  }


  private boolean validarAcesso(int age, String cpf, int numeroConta, String senha)
  {
    //FAZER A VERIFICACAO DOS DADOS AQUI
    return true;
  }


  private boolean addCliente(String cpf, String nome, String telefone, String email, String senha)
  {
    // AQUI EU FACO O CADASTRO DO CLIENTE
    return false;
  }

  public boolean depositar(int tipo, int numeroConta, double valor)
  {
    return this.validarDeposito(tipo, numeroConta, valor);
  }

  private boolean validarDeposito(int tipo, int numeroConta, double valor)
  {
    
  }

  private boolean addConta(int numeroConta, Cliente cte)
  {
    //CRIAR UMA CONTA
    return false;
  }


  private boolean changeInfo(Cliente cte, String novoValor, String generic)
  {
    /* AQUI A GENTE USA PARA ALTERAR ALGUMA INFORMACAO DO USUARIO, TIPO: EMAIL, TELEFONE...
       generic CONTEM O VALOR QUE DESEJAMOS ALTERAR. EX: SE generic == "telefone" ENTAO
       O TELEFONE Q ERA ALTERADO */
      return false;
  }


  private boolean removerConta()
  {
    // O NOME JA DIZ TUDO
    return false;
  }
}
