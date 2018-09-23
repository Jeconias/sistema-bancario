public class Banco
{
  private String nome;
  private Agencia [] agencias;

  public Banco(String nome, int tAgencia)
  {
    // TOTAL DE AGENCIAS
    this.agencias = new Agencia[tAgencia];
    // NOME DO BANCO
    this.nome = nome;
    /* POR PADRAO, UMA BANCO JA COMECA COM UMA AGENCIA.
       PARAMETROS: NOME, BANCO_REFERENCIA, QUANTIDADE DE CLIENTES, CONTAS E ATENDENTES.
    */
    this.agencias[0] = new Agencia("SempreLucrando", this, 2, 2, 2);
  }

  public String getNome()
  {
    return this.nome;
  }

  public boolean setNome(String nome)
  {
    this.nome = nome;
    return true;
  }

  public Agencia acessarAgencia(int x)
  {
    return this.agencias[x];
  }

  public Agencia [] capturarAgencias()
  {
    return this.validandoAgencias();
  }

  public boolean addAgencia(String nome, int numeroAge)
  {
    // CRIANDO AGENCIAS - LEMBRAR DE VERIFICAR SE O TOTAL DE AGENCIAS ESTA NO LIMITE E DUPLICAR
    return false;
  }

  public boolean removerAgencia(int numeroAge)
  {
    /* USAMOS O NUMERO DA AGENCIA PARA REMOVER ELA, POIS O NUMERO DA AGENCIA
       EH UNICO EM TODO O BANCO */
    return false;
  }

  private Agencia [] validandoAgencias()
  {
    /*CONTANDO QUANTAS AGENCIAS ESTAO DISPONIVEIS PARA PERMITIR
      CRIAR UMA ARRAY DE AGENCIAS NAO "NULL" DO TAMANHO EXATO*/
    int agenciasLength = this.agencias.length, tAgencias = 0;
    for(int i = 0; i < agenciasLength; i++){
      if(this.agencias[i] != null){
        tAgencias++;
      }
    }

    // CRIANDO UMA ARRAY DE AGENCIAS DO TAMANHO EXATO
    Agencia [] ages = new Agencia[tAgencias];
    for(int i = 0; i < tAgencias; i++){
      if(this.agencias[i] != null){
        ages[i] = this.agencias[i];
      }
    }

    return ages;
  }
}
