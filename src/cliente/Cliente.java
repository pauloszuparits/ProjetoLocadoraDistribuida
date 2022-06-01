package cliente;

import java.io.*;
import java.net.*;
import comum.*;
import java.util.Scanner;

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
        
        //declaração de variaveis
        String nomeCliente, sobrenome,cpf, nomeFilme, genero;
        int idade, ano;
        
        System.out.println("Bem vindo a locadora!");
        
        while(option != 1313){ //loop, quebra loop com o numero 1313 digitado
            System.out.println("Digite uma das opções abaixo");
            System.out.println("0 - Cadastrar Cliente");//
            System.out.println("1 - Cadastrar Filme");//
            System.out.println("2 - Buscar Cliente");//
            System.out.println("3 - Buscar Filme");//
            System.out.println("4 - Listar Clientes");//
            System.out.println("5 - Listar Filmes");//
            System.out.println("6 - Remover Cliente");
            System.out.println("7 - Remover Filme");
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
                case 1313:
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
                    System.out.println(resposta.getResposta());
                    break;
                case(2):
                    System.out.println("Usuário não encontrado");
                    break;
                case(3):
                    System.out.println("Usuário removido com sucesso");
                    System.out.println(resposta.getResposta());
                    break;
            }
            
            System.out.println("Deseja sair, para sair digite o código 1313");
            option = in.nextInt(); //TODO
            
    
        }
        try {
            socket.close();                               // fase de desconexao
        } catch (IOException e) {
            System.out.println("Nao encerrou a conex�o corretamente" + e.getMessage());
        }
    }
}
