
package comum;

import java.io.Serializable;
import java.util.ArrayList;

public class ControlaLista implements Serializable{
    private int idUser = 0;
    private int idFilme = 0;
    ArrayList<Usuario> usuarios = new ArrayList(); //instancia array list usuario
    ArrayList<Filme> filmes = new ArrayList(); //instancia array list filme
    ArrayList<Alugado> alugados = new ArrayList(); //instancioa array list alugado
    
    public void addUser(String nome, String sobrenome, String cpf, int idade){
        usuarios.add(new Usuario(nome, sobrenome, cpf, idade, idUser));        
        idUser++;
    }
    
    public void addFilme(String nome, String genero, int ano){
        filmes.add(new Filme(nome, genero, ano, idUser));
        idUser++;
    }
    
    public Usuario buscarUser(String cpf){
        int posicao = -1;
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpf)){
                posicao = i; 
                break;
            }
        }
        if(posicao == -1){
           return null;
        }else{
           return usuarios.get(posicao);
        }
    }
    
    public Filme buscaFilme(String nome, int ano){
        int posicao = -1;
        for(int i = 0; i < filmes.size(); i++){
            if(filmes.get(i).getNome().equals(nome) && filmes.get(i).getAno() == ano){
                posicao=i;
                break;
            }                               
        }
        
        if(posicao == -1){
            return null;
        }else{
            return filmes.get(posicao);
        }                           
    }
    
    public ArrayList listarUsuarios(){
        return usuarios;
    }
    
    public ArrayList listarFilmes(){
        return filmes;
    }
    
    public Usuario removerUsuario(String cpf){
        int posicao = -1;
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpf)){
                posicao = i; 
                break;
            }
        }
        if(posicao == -1){
           return null;
        }else{           
           return usuarios.remove(posicao);
        }
    }
    
    public Filme removerFilme(String nome, int ano){
        int posicao = -1;
        for(int i = 0; i < filmes.size(); i++){
            if(filmes.get(i).getNome().equals(nome) && filmes.get(i).getAno() == ano){
                posicao=i;
                break;
            }                               
        }
        if(posicao == -1){
           return null;
        }else{           
           return filmes.remove(posicao);
        }
    }
}
