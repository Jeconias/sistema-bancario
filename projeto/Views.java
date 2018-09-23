/*
  ### CLASSE Views ###

  VOCE DEVE CHAMAR O VALOR DESEJADO DESSA FORMA: System.out.print(Views.NOME) ou Views.NOME()
  SE FOR UM METODO.

*/

import java.util.Scanner;
public class Views
{

  public static Scanner SC = new Scanner(System.in);

  public static String CABECALHO = "------------- Banco Seu -------------\n";
  public static String BANCO_VERSAO = "v0.4";
  public static String Views_VERSAO = "v0.1";


  public static void INFO()
  {
    System.out.print(Views.CABECALHO + "Banco " + Views.BANCO_VERSAO + " | View PT-BR - " + Views.Views_VERSAO + "\n");
    System.out.print("### Codigos de erros e seus significados ###\n\n");
    System.out.print("[Tipo] [Valor] => Significado\n\n");
    System.out.print("[Type] [-1]    => Definir\n");
    System.out.print("[Type] [-2]    => Definir\n");
    System.out.print("[Type] [-3]    => Definir\n");
    System.out.print("[Type] [-4]    => Denifir\n\n");

    System.out.print("[0] - Voltar\n:");
    Views.SC.next();
  }

  public static void MENU_PRINCIPAL()
  {
    String MENU = "";
    MENU += Views.CABECALHO;
    MENU += "Bem-Vindo(a) ao SEU Banco!\n\n";
    MENU += "[1] - Acessar conta\n";
    MENU += "[2] - Atendente virtual\n";
    MENU += "[3] - Deposito\n";
    MENU += "[4] - Sobre\n\n";
    MENU += "[0] - Sair do sistema\n:";
    System.out.print(MENU);
  }

  public static int MENU_AGENCIAS_DISPONIVEIS(Agencia [] ages)
  {
    int agenciasLength = ages.length, numeroAge;
    String MENU = "";

    MENU += Views.CABECALHO;
    MENU += "Ola, O " + ages[0].getBanco().getNome() + " possui " + agenciasLength + " agencia(s).\n";
    MENU += "Por favor, confirme qual agencia deseja utilizar.\n\n";

    for(int i = 0; i < agenciasLength; i++){
      MENU += "["+ (i+1) +"] - " + ages[i].getNome() + "\n";
    }
    MENU += "\n[0] - Voltar\n";

    MENU += ":";
    while(true)
    {
      // EXIBINDO O MENU
      System.out.print(MENU);
      // PEGANDO O NUMERO DA AGENCIA E SUBTRAINDO 1
      numeroAge = (Views.SC.nextInt() - 1);

      // SE O USUARIO DIGITAR "0", VOLTAMOS PARA O MENU PRINCIPAL
      if(numeroAge == -1) return numeroAge;

      // VERIFICANDO SE A AGENCIA EXISTE
      if(numeroAge >= (agenciasLength - 1) && numeroAge <= (agenciasLength - 1)){
        return numeroAge;
      }
      System.out.print("Essa Agencia nao eh valida! Por favor, tente novamente.\n");
    }
    /*OBSERVACAO SOBRE O METODO: FOI FEITO ESSA SUBTRACAO DE 1 PARA GARANTIR QUE O
      NUMERO 0 (ZERO), SEJA UTILIZADO PARA VOLTAR AO MENU ANTERIOR EM TODOS OS
      CASOS, DESSA FORMA, MANTEMOS UM PADRAO.
    */
  }

  public static String MENU_ATENDENTE(Atendente AT)
  {
    String MENU = "";
    MENU += Views.CABECALHO;
    MENU += "Ola, eu sou o "+AT.getNome()+", atendendo do "+AT.getAgencia().getBanco().getNome()+".\n";
    MENU += "Eu estou pronto, o que vamos fazer?\n\n";
    MENU += "[1] - Criar Conta\n";
    MENU += "[2] - Solicitar emprestimo\n"; //OBS: O EMPRESTIMO EH DE APENAS 45% DO SALDO ATUAL DO CLIENTE
    MENU += "[3] - Atualizar dados pessoais\n";
    MENU += "[4] - Atualizar dados da minha conta\n";
    MENU += "[5] - Finalizar uma conta\n\n";
    MENU += "[0] - Voltar\n:";
    System.out.print(MENU);
    return Views.SC.next();
  }

  public static String [] CRIAR_CONTA()
  {

      String [] values = new String[5];
      String tmp = null;
      boolean check = true;

      System.out.print("Boa escolha! xD\n");
      System.out.print(Views.CABECALHO + "Para criarmos sua conta precisamos das seguintes informacoes;\n");
      System.out.print("Seu nome: ");
      values[0] = Views.SC.next();

      System.out.print("CPF: ");
      values[1] = Views.SC.next();

      System.out.print("Telefone: ");
      values[2] = Views.SC.next();

      System.out.print("Email: ");
      values[3] = Views.SC.next();

      /* AQUI VERIFICAMOS A CONFIRMACAO DE SENHA DO USUARIO.
        SE ESSE USUARIO ERRAR A CONFIRMACAO DE SENHA, VOLTAMOS A SOLICITAR A SENHA*/
      while(check)
      {
        System.out.print("Senha: ");
        values[4] = Views.SC.next();

        System.out.print("Por favor, confirme a senha: ");
        tmp = Views.SC.next();

        if(!values[4].equals(tmp)){
          System.out.print("As senhas nao sao iguais! Por favor, reescreva as senhas.");
        }else{
          check = false;
        }
      }
      return values;
  }

  public static String [] ACESSAR_CONTA()
  {
    String [] values = new String[4];

    System.out.print(Views.CABECALHO + "Que otimo, voce ja eh nosso cliente!\n");
    System.out.print("Informe os seguintes dados para acessar sua conta.\n\n");
    System.out.print("Agencia: ");
    values[0] = Views.SC.next();
    System.out.print("CPF: ");
    values[1] = Views.SC.next();
    System.out.print("Numero da conta: ");
    values[2] = Views.SC.next();
    System.out.print("Senha de acesso: ");
    values[3] = Views.SC.next();

    return values;
  }

  public static String [] DEPOSITAR()
  {
    System.out.print(Views.CABECALHO);
    System.out.print("Informe os seguintes dados para o deposito.\n\n");
    System.out.print("Agencia: ");
    values[0] = Views.SC.next();
    values[1] = 0;
    // VERIFICANDO SE O TIPO DE CONTA EXISTE
    while(values[1] != 1 || values[1] != 2){
      System.out.print("[1] - Corrente\n");
      System.out.print("[2] - Poupanca\n");
      System.out.print("Tipo da conta: ");
      values[1] = Views.SC.next();
      if(values[1] != 1 || values[1] != 2){
        System.out.print("Por favor, escolha um tipo de conta valida.");
      }
    }
    System.out.print("Numero da conta: ");
    values[2] = Views.SC.next();
    System.out.print("Informe o valor do deposito: ");
    values[3] = Views.SC.nextBoolean();
    return values;
  }

  public static void BYE()
  {
    System.out.print("Obrigado por usar o SEU Banco. Ate logo!\n");
  }
}
