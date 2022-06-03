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
        
        ControlaLista controlador = new ControlaLista();
        Usuario usuario;
        Filme filme;
        
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
                            controlador.addUser(req.getNomeUsuario(),
                                                req.getSobrenomeUsuario() ,
                                                req.getCpf() ,
                                                req.getIdade());
                            resposta.setStatus(0);
                            break;
                            
                        case (1): //Cadastrar filme
                            controlador.addFilme(req.getNomeFilme(), 
                                                 req.getGenero(), 
                                                 req.getAno());
                            resposta.setStatus(0);
                            break;
                            
                        case (2): //buscar usuário
                            usuario = controlador.buscarUser(req.getCpf());
                                                                                                                
                            if(usuario == null){ 
                                resposta.setStatus(2);
                                break;
                            }else{
                                resposta.setStatus(1);
                                resposta.setUsuario(usuario);
                                break;
                            }
                                                                                    
                        case (3): //buscar filme
                            filme = controlador.buscaFilme(req.getNomeFilme(), req.getAno());
                            
                            if(filme == null){ 
                                resposta.setStatus(8);
                                break;
                            }else{
                                resposta.setStatus(16);
                                resposta.setFilme(filme);
                                break;
                            }                           
                                                                                
                        case(4)://listar clientes 
                            
                            ArrayList usuarios = controlador.listarUsuarios();
                            if(usuarios.isEmpty()){
                                resposta.setStatus(4);
                                 break;
                            }else{
                                resposta.setStatus(15);
                                resposta.setUsuarios(usuarios);
                                break;
                            }
                           
                            
                        case (5): //listar filmes                           
                            ArrayList filmes = controlador.listarFilmes();
                            if(filmes.isEmpty()){
                                resposta.setStatus(5);
                                break;
                            }else{
                                resposta.setStatus(17);
                                resposta.setFilmes(filmes);
                                break;
                            }
                            
                        case (6): //remover cliente
                            usuario = controlador.removerUsuario(req.getCpf());
                            if(usuario == null){
                                resposta.setStatus(2);
                                break;
                            }else{
                                resposta.setStatus(3);
                                resposta.setUsuario(usuario);
                                break;
                            }                                                      
                                                       
                        case (7): //remover filme
                            filme = controlador.removerFilme(req.getNomeFilme(), req.getAno());
                            if(filme == null){
                                resposta.setStatus(8);
                                break;
                            }else{
                                resposta.setStatus(6);
                                resposta.setFilme(filme);
                                break;
                            }
                                                        
                        case (8): //calcular taxa
                            double taxa = req.getDias() * 1.50;
                            resposta.setStatus(18);
                            resposta.setTaxa(taxa);
                            break;
                            
                        case (9): //calcular multa
                            double multa = req.getDias() * 10.50;
                            resposta.setStatus(19);
                            resposta.setTaxa(multa);
                            break;
                            
                        case (10): //alugar filme
                            resposta.setStatus(controlador.AlugarFilme(req.getNomeFilme(), req.getAno(), req.getCpf(), req.getStartDate(), req.getEndDate()));
                            break;
                        case 11: //devolver filme
                            resposta.setStatus(controlador.devolverFilme(req.getNomeFilme(), req.getAno(), req.getCpf()));
                            break;
                        case 12: //listar alugados
                            String compilado = controlador.listarAlugados();
                            
                            if(compilado.equals("")){
                                resposta.setStatus(14);
                                break;
                            }else{
                                resposta.setStatus(20);
                                resposta.setStr(compilado);
                                break;
                            }
                        default:
                            System.out.println("Servidor encerrado a conexão...");
                            resposta.setStatus(99);
                            break;
                    }


                    conexao.send(client_socket, resposta);

                    
                
            }while(req.getOpcao() != 99);
            
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
    
    /*static Usuario buscarUser(ArrayList usuarios, String cpf){
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
        
        int posicao = -1;
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpf)){
                posicao = i;
                break;
            }
        }
        
        if(posicao == -1){
            return -1;
        }else{
            return usuarios.get(posicao);
        }
    }*/
    
}
    
    