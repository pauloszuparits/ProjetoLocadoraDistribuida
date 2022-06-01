package servidor;

import comum.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {

    static ServerSocket serversocket;
    static Socket client_socket;
    static Conexao conexao;
    static String msg;

    public Servidor() {

        try {
            serversocket = new ServerSocket(9200);
            System.out.println("Servidor locadora no ar ...");
        } catch (Exception e) {
            System.out.println("Nao criei o server socket...");
        }
    }

    public static void main(String args[]) {
        
        ArrayList<Usuario> usuarios = new ArrayList(); //instancia array list usuario
        ArrayList<Filme> filmes = new ArrayList(); //instancia array list filme
        
        //inicialização dos ID's
        int idFilme = 0;
        int idUsuario = 0;
       
        //instancias req, res
        MsgReq req = new MsgReq();
        MsgResp resposta = new MsgResp();
        
        //instancia servidor
        new Servidor();
        if (connect()) {
            do{
                
                req = (MsgReq) conexao.receive(client_socket);
                int posicao; //variavel para busca
                
                    switch(req.getOpcao()){
                        case (0): //Cadastrar usuario
                            idUsuario++;
                            usuarios.add(new Usuario(req.getNomeUsuario(), 
                                                     req.getSobrenomeUsuario(), 
                                                     req.getCpf(), 
                                                     req.getIdade(), 
                                                     idUsuario));
                            
                            resposta.setStatus(0);

                            break;
                            
                        case (1): //Cadastrar filme
                            idFilme++;
                            filmes.add(new Filme(req.getNomeFilme(), 
                                                 req.getGenero(), 
                                                 req.getAno(), 
                                                 idFilme));
                            resposta.setStatus(0);
                            break;
                            
                        case (2): //buscar usuário
                            posicao = -1;
                            for(int i = 0; i < usuarios.size(); i++){
                                if(usuarios.get(i).getCpf().equals(req.getCpf())){
                                    posicao = i;
                                    break;
                                }
                            }
                            
                            
                            
                            
                            if(posicao == -1){
                                resposta.setStatus(2);
                            }else{
                                resposta.setStatus(1);
                                resposta.setResposta(usuarios.get(posicao).toString());
                            }
                            
                            break;
                            
                        case (3): //buscar filme
                            posicao = -1;
                            for(int i = 0; i < filmes.size(); i++){
                                if(filmes.get(i).getNome().equals(req.getNomeFilme()) && filmes.get(i).getAno() == req.getAno()){
                                    posicao=i;
                                    break;
                                }                               
                            }
                            
                            if(posicao == -1){
                                resposta.setStatus(2);
                            }else{
                                resposta.setStatus(1);
                                resposta.setResposta(filmes.get(posicao).toString());
                            }
                            
                            
                            break;
                        
                        case(4)://listar clientes 
                            if(usuarios.size() == 0){
                                resposta.setStatus(4);
                                break;
                            }else{
                                String compilado = "";
                                for(int i = 0; i < usuarios.size(); i++){
                                    compilado += usuarios.get(i).toString() + "\n";
                                }

                                resposta.setResposta(compilado);
                                resposta.setStatus(1);
                            }
                            break;
                        case (5): //listar filmes
                            if(filmes.size()==0){
                                resposta.setStatus(5);
                                break;
                            }else{
                                String compilado = " ";
                                for(int i = 0; i < filmes.size(); i++){
                                    compilado += filmes.get(i).toString() + "\n";
                                }

                                resposta.setResposta(compilado);
                                resposta.setStatus(1);
                                break;
                            }
                        case (6): //remover cliente
                            posicao = -1;
                            for(int i = 0; i < usuarios.size(); i++){
                                if(usuarios.get(i).getCpf().equals(req.getCpf())){
                                    posicao = i;
                                    break;
                                }
                            }
                            
                            
                            if(posicao == -1){
                                resposta.setStatus(2);
                            }else{
                                resposta.setStatus(3);
                                Usuario removidoC = usuarios.remove(posicao);
                                resposta.setResposta(removidoC.toString());
                            }
                            
                            break;
                        case (7): //remover filme
                            posicao = -1;
                            for(int i = 0; i < filmes.size(); i++){
                                if(filmes.get(i).getNome().equals(req.getNomeFilme()) && filmes.get(i).getAno() == req.getAno()){
                                    posicao=i;
                                    break;
                                }                               
                            }
                            
                            
                            
                            if(posicao == -1){
                                resposta.setStatus(2);
                            }else{
                                resposta.setStatus(4);
                                Filme removidoF = filmes.remove(posicao);
                                resposta.setResposta(removidoF.toString());
                            }
                        default:
                            //TODO resposta para o cliente que o servidor fechou
                            break;
                    }


                    conexao.send(client_socket, resposta);

                    
                
            }while(req.getOpcao() != 1313);
            
            try {
                client_socket.close();
                serversocket.close();
            } // desconexao
            catch (Exception e) {
                System.out.println("Nao encerrou a conex�o corretamente" + e.getMessage());
            }
        }
    }
    
    static boolean connect() {
        boolean ret;
        try {
            client_socket = serversocket.accept();              // fase de conexão
            ret = true;
        } catch (Exception e) {
            System.out.println("N�o fez conex�o" + e.getMessage());
            ret = false;
        }
        return ret;
    }
    
    
}
    
    