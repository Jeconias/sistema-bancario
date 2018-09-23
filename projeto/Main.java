/*
	# CLASSE Main #

	## ALGUNS INFORMES:
		 - NAO VAMOS UTILIZAR ACENTUACAO, GERA PROBLEMA NA COMPILACAO (PELO MENOS COMIGO);
		 - VAMOS COMENTAR COM LETRAS MAIUSCULAS, AJUDA NA HORA DE LER E ENCONTRAR OS COMENTARIOS;
     - VAMOS CONCENTRAR OS DETALHES DE FUNCIONAMENTO APENAS NESSE ARQUIVO, DESSA FORMA, EH MAIS
       FACIL DE LOCALIZAR.

  ## FUNCIONAMENTO DE TODAS AS CLASSES:
     ### CLASS Main:
         - NA CLASSE Main INSTANCIAMOS UM BANCO COM CAPACIDADE DE DUAS AGENCIAS.

         #### METODOS:
               - FUNCIONAMENTO DOS METODOS DA CLASSE Main FICAM AQUI.

     ### CLASS Banco:
         - POR PADRAO, QUANDO UM BANCO EH CRIADO ELE JA INICIA UMA AGENCIA, ESSA AGENCIA
           GANHA O NOME "SempreLucrando", UM BANCO, 2 CLIENTES (QUANTIDADE), 2 CONTAS (QTD)
           E 2 ATENDENTES (QTD).

         #### METODOS:
              - FUNCIONAMENTO DOS METODOS DA CLASSE Banco FICAM AQUI.
*/


// CARREGANDO AS BIBLIOTECAS NECESSARIAS
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class Main
{
  public static void main(String [] values)
  {
    // DECLARANDO AS VARIAVEIS NECESSARIAS
    String opt, age, cpf, senha;
    int numeroConta, numeroAgencia;
    boolean loop = true;

    // DECLARANDO ARRAYS AUXILIARES
    String [] dados;

    // INSTANCIANDO OS OBJS NECESSARIOS E INICIALIZANDO ALGUNS METODOS
    Scanner SC = new Scanner(System.in);
    Banco BS = new Banco("Banco Seu", 2); //CRIANDO UM BANCO COM CAPACIDADE PARA 2 AGENCIAS


    while(loop)
    {
      Views.MENU_PRINCIPAL();
      opt = SC.next();
      switch(opt)
      {
        case "1":
          dados = new String[4];
          //DADOS DE ACESSO
          dados = Views.ACESSAR_CONTA();
          //PASSANDO O NUMERO DA AGENCIA PARA INT
          numeroAgencia = Integer.parseInt(dados[0]);
          //EH NECESSARIO PASSAR OS DADOS PARA UM METODO DE VALIDACAO - O METODO DE VALIDACAO DEVE RETORNAR UM CODIGO ESPECIFICO PARA CADA VALOR ERRADO
          BS.acessarAgencia(numeroAgencia).acessarAtendente().verificarConta(dados[0], dados[1], dados[2], dados[3]);

        break;
        case "2":
          // PEGANDO AS AGENCIAS DISPONIVEIS NO BANCO E PASSANDO PARA A VIEW
          numeroAgencia = Views.MENU_AGENCIAS_DISPONIVEIS(BS.capturarAgencias());
          if(numeroAgencia == -1) {
            break;
          }
          // LEVANDO O USUARIO PARA UM ATENDENTE DA AGENCIA ESCOLHIDA
          opt = Views.MENU_ATENDENTE(BS.acessarAgencia(numeroAgencia).acessarAtendente());




          // QUANDO O USUARIO ESCOLHER ESSA OPCAO PRECISAMOS IR PARA A CLASSE ATENDENTE.
          // NA CLASSE ATENDENTE EH QUE DEVE TER A OPCAO PARA CRIAR A CONTA E SUAS MANIPULACOES.
          // AQUI PRECISAMOS ACESSAR O ATENDENTE E USAR A VIEW DELE
        break;
        case "3":
          dados = Views.DEPOSITAR();
          numeroAgencia = Integer.parseInt(dados[0]);
          // NO METODO DEPOSITAR EH PASSADO O TIPO DE CONTA, NUMERO DA CONTA E VALOR
          BS.acessarAgencia(numeroAgencia).acessarAtendente().depositar(dados[1], dados[2], dados[3]);
        break;
        case "4":
          Views.INFO();
        break;
        case "0":
          loop = false;
          Views.BYE();
        break;
        default:

        break;
      }
    }
  }
}
