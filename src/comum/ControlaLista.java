
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
    
    public int AlugarFilme(String nomeFilme, int ano, String cpf, String start, String end){
        int posicaoC = -1;
        int posicaoF = -1;

        for(int i = 0; i < filmes.size(); i++){
            if(filmes.get(i).getNome().equals(nomeFilme) && filmes.get(i).getAno() == ano){
                posicaoF=i;
                break;
            }                               
        }

        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpf)){
                posicaoC = i;
                break;
            }
        }

        if(posicaoF == -1){
            return 8;
        }else{
            if(posicaoC == -1){
            return 2;
            }else{
                Filme filme = filmes.get(posicaoF);
                Usuario cliente = usuarios.get(posicaoC);
                if(filme.isAlugado()){
                    return 10;
                }else{
                    alugados.add(new Alugado(filme.getId(), cliente.getId(), start, end));
                    filme.alugar();
                    return 9;
                }
            }
        }
    }
    
    public int devolverFilme(String nomeFilme, int ano, String cpf){
        int posicaoC = -1;
        int posicaoF = -1;
        int posicaoA = -1;
        for(int i = 0; i < filmes.size(); i++){
            if(filmes.get(i).getNome().equals(nomeFilme) && filmes.get(i).getAno() == ano){
                posicaoF=i;
                break;
            }                               
        }

        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpf)){
                posicaoC = i;
                break;
            }
        }
        if(posicaoF == -1){
            return 8;
        }
        if(posicaoC == -1){
            return 2;
        }


        Filme filme = filmes.get(posicaoF);
        Usuario cliente = usuarios.get(posicaoC);

        for(int i = 0; i < alugados.size(); i++){
            if(alugados.get(i).getIdFilme() == filme.getId() && alugados.get(i).getIdUsuario() == cliente.getId()){
                posicaoA = i;
                break;
            }
        }

        if(posicaoA == -1){
            //filme nao foi alugado
            return 11;
        }

        if(alugados.get(posicaoA).getIdUsuario() == cliente.getId()){
            alugados.remove(posicaoA);
            filme.alugar();
            return 12;
            //alugado
        }else{
            return 13;
            //não foi alugado para ele
        }
    }
    
    public String listarAlugados(){
        String compilado = "";
        for(int i = 0; i<alugados.size(); i++){

            for(int q = 0; q< filmes.size(); q++)
            {
                if(alugados.get(i).getIdFilme() == filmes.get(q).getId())
                {
                    compilado += "\nFilme " + filmes.get(q).getNome() + " de " + filmes.get(q).getAno();
                    break;
                }
            }
            for(int f = 0; f< usuarios.size(); f++){
                if(alugados.get(i).getIdUsuario() == usuarios.get(f).getId())
                {
                    compilado += "\nAlugado por: " + usuarios.get(f).getNome() + " " + usuarios.get(f).getSobrenome();
                }
            }

        }
        
        return compilado;
    }
}
