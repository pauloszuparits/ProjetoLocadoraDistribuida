package cliente;

import java.io.*;
import java.net.*;
import comum.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Cliente {

    static Conexao conexao;
    static Socket socket;

    public Cliente() {
        try {
            socket = new Socket("localhost", 9200);
        } // fase de conexao
        catch (Exception e) {
            System.out.println("Nao consegui resolver o host...");
        }
    }

    
    public static void main(String args[]){
        int option = 0; //variavel para menu
        
        int cont = 0;
        
        MsgReq req = new MsgReq(); //ininialização da requisição
        
        MsgResp resposta = new MsgResp(); //inicialização da resposta
        
        Scanner in = new Scanner(System.in);//scanner
        
        ArrayList alugados; 
        
        //declaração de variaveis
        String nomeCliente, sobrenome,cpf, nomeFilme, genero, compilado,dMaS, dMaE;
        int idade, ano, dias;

        
        System.out.println("Bem vindo a locadora!");
        
        do{ 
            System.out.println("Digite uma das opções abaixo");
            System.out.println("0 - Cadastrar Cliente");//
            System.out.println("1 - Cadastrar Filme");//
            System.out.println("2 - Buscar Cliente");//
            System.out.println("3 - Buscar Filme");//
            System.out.println("4 - Listar Clientes");//
            System.out.println("5 - Listar Filmes");//
            System.out.println("6 - Remover Cliente");//
            System.out.println("7 - Remover Filme");//
            System.out.println("8 - Calcular taxa de aluguel");
            System.out.println("9 - Calcular Multa");
            System.out.println("10 - Alugar filme");
            System.out.println("11 - Devolver Filme");
            System.out.println("12 - Listar filmes alugados");
            System.out.println("99 - Sair");
            option = in.nextInt();
            //TODO fazer if para saida antes de começar, eviando um option para o servidor
            switch(option){
                case 0: //cadastrar usuario
                    System.out.println("Digite um nome");
                    nomeCliente = in.next();
                    System.out.println("Digite um sobrenome");
                    sobrenome = in.next();
                    System.out.println("Digite o cpf do cliente");
                    cpf = in.next();
                    System.out.println("Digite a idade do cliente");
                    idade = in.nextInt();

                    req = new MsgReq(nomeCliente, sobrenome, cpf, idade, option);

                    break;
                case 1: //cadastrar filme
                    System.out.println("Digite o nome do filme");
                    nomeFilme = in.next();
                    System.out.println("Digite o genero do filme");
                    genero = in.next();
                    System.out.println("Digite o ano do filme");
                    ano = in.nextInt();
                    
                    req = new MsgReq(nomeFilme, genero, ano, option);
                    
                    break;
                case 2: //buscar cliente
                    System.out.println("Digite o cpf do cliente:");
                    cpf = in.next();
                    req = new MsgReq(cpf, option);
                    
                    break;
                
                case 3: //buscar filme
                    System.out.println("Digite o nome do filme");
                    nomeFilme = in.next();
                    System.out.println("Digite o ano do filme");
                    ano = in.nextInt();
                    
                    req = new MsgReq(nomeFilme, ano, option);
                    break;
                case 4: //listar usuarios
                    req = new MsgReq(option);
                    break;
                case 5: //listar filmes
                    req = new MsgReq(option);
                    break;
                case 6: //remover cliente
                    System.out.println("Digite o cpf do cliente que deseja remover");
                    cpf = in.next();
                    
                    req = new MsgReq(cpf, option);
                    break;
                case 7: //remover filme
                    System.out.println("Digite o nome do filme que deseja remover");
                    nomeFilme = in.next();
                    System.out.println("Digite o ano deste filme");
                    ano = in.nextInt();
                    
                    req = new MsgReq(nomeFilme, ano, option);
                    break;
                case 8: //calcular taxa
                    System.out.println("Digite a quantidade de dias que voce deseja alugar um filme");
                    dias = in.nextInt();
                    req = new MsgReq(option, dias);
                    break;
                case 9: //calcular multa
                    System.out.println("Digite a quantidade de dias de atraso");
                    dias = in.nextInt();
                    req = new MsgReq(option, dias);
                    break;
                case 10: //alugar filme
                    System.out.println("Digite o nome do filme que você deseja alugar");
                    nomeFilme = in.next();
                    System.out.println("Digite o ano do filme");
                    ano = in.nextInt();
                    System.out.println("Digite o cpf do cliente");
                    cpf = in.next();
                    System.out.println("Digite o dia, mes e ano que o filme foi alugado (dd/MM/yyyy)");
                    dMaS = in.next();
                    System.out.println("Digite o dia, mes e ano que o filme deve ser devolvido (dd/MM/yyyy)");
                    dMaE = in.next();
                    req = new MsgReq(nomeFilme, ano, cpf ,dMaS,dMaE,option);
                    break;
                case 11: //devolver filme
                    System.out.println("Digite o nome do filme que está sendo devolvido");
                    nomeFilme = in.next();
                    System.out.println("Digite o ano do filme");
                    ano = in.nextInt();
                    System.out.println("Digite o cpf do cliente que esta devolvendo");
                    cpf = in.next();
                    req = new MsgReq(nomeFilme, ano, cpf ,option);
                    break;
                case 12: //mostrar lista de filmes alugados
                    req = new MsgReq(option);
                    break;
                case 99:
                    System.out.println("Fechando o sistema ...");
                    req = new MsgReq(option);
                    break;
            }
            
            if(cont == 0){
                new Cliente();
            }//instancia Cliente
            cont++;
            
            conexao.send(socket, req);

            resposta = (MsgResp) conexao.receive(socket);
            
            switch(resposta.getStatus()){
                case(0):
                    System.out.println("Cadastro efetuado com sucesso!");
                    break;
                case(1):                    
                    System.out.println(resposta.getUsuario().toString()); //utlizar objeto
                    break;
                case(2):
                    System.out.println("Usuário não encontrado");
                    break;
                case(3):
                    System.out.println("Usuário removido com sucesso");
                    System.out.println(resposta.getUsuario().toString());
                    break;
                case(4):
                    System.out.println("Lista de usuarios vazia!");
                    break;
                case(5):
                    System.out.println("Lista de filmes vazia");
                    break;
                case(6):
                    System.out.println("Filme removido com sucesso");
                    System.out.println(resposta.getFilme().toString());
                    break;
                case (7):
                    System.out.println("Filme alugado com sucesso");
                    break;
                case(8):
                    System.out.println("Filme não encontrado");
                    break;
                case(9):
                    System.out.println("Filme alugado com sucesso");
                    break;
                case(10):
                    System.out.println("Filme ja foi alugado");
                    break;
                case(11):
                    System.out.println("Filme nao foi alugado");
                    break;
                case(12):
                    System.out.println("Filme devolvido com sucesso");
                    break;
                case(13):
                    System.out.println("Este filme nao foi alugado para este CPF");
                    break;
                case(14):
                    System.out.println("Lista de alugados vazia");
                    break;
                case(15)://Fazer for de listas                  
                    ArrayList usuarios = resposta.getUsuarios();
                    compilado = "";
                    
                    for(int i = 0; i < usuarios.size(); i++){
                        compilado += usuarios.get(i).toString() + "\n";
                    }
                        
                    System.out.println(compilado);
                    break;
                case(16):
                    System.out.println(resposta.getFilme().toString());
                    break;
                case(17):
                    ArrayList filmes = resposta.getFilmes();
                    compilado = "";
                    
                    for(int i = 0; i < filmes.size(); i++){
                        compilado += filmes.get(i).toString() + "\n";
                    }
                        
                    System.out.println(compilado);
                    break;
                case(18):
                    System.out.println("A taxa será de: " + resposta.getTaxa());
                    break;
                case(19):
                    System.out.println("A multa será de: " + resposta.getTaxa());
                    break;
                case(20):
                    System.out.println(resposta.getStr());
                    break;
                    
                case (99):
                    System.out.println("Servidor encerrou a conexão");
                    break;
            }
                       
    
        }while(option != 99);
        try {
            socket.close();                               // fase de desconexao
        } catch (IOException e) {
            System.out.println("Nao encerrou a conexao corretamente" + e.getMessage());
        }
    }
}
