
package comum;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ControlaLista implements Serializable{
    private int idUser = 0; //gerar id para usuario
    private int idFilme = 0; //gerar id para filme
    ArrayList<Usuario> usuarios = new ArrayList(); //instancia array list usuario
    ArrayList<Filme> filmes = new ArrayList(); //instancia array list filme
    ArrayList<Alugado> alugados = new ArrayList(); //instancioa array list alugado
    
    public void addUser(String nome, String sobrenome, String cpf, int idade){ //adicionar usuario
        usuarios.add(new Usuario(nome, sobrenome, cpf, idade, idUser));        
        idUser++;
    }
    
    public void addFilme(String nome, String genero, int ano){ //adicionar filme
        filmes.add(new Filme(nome, genero, ano, idUser));
        idUser++;
    }
    
    public Usuario buscarUser(String cpf){ //buscar usuario, retorna usuario
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
    
    public Filme buscaFilme(String nome, int ano){ //buscar filme, retorna filme
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
    
    public ArrayList listarUsuarios(){ //retorna lista de usuarios
        return usuarios;
    }
    
    public ArrayList listarFilmes(){ //retorna lista de filmes
        return filmes;
    }
    
    public Usuario removerUsuario(String cpf){ //remove um usuario, retorna usuario
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
    
    public Filme removerFilme(String nome, int ano){ //remove um filme, retorna filme
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
    
    public int AlugarFilme(String nomeFilme, int ano, String cpf, String start, String end){ //aluga um filme, retorna status (int)
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
    
    public Devolucao devolverFilme(String nomeFilme, int ano, String cpf, String dataDevolucao) throws ParseException{ //devolve filme, retorna um objeto devolução
        int posicaoC = -1;
        int posicaoF = -1;
        int posicaoA = -1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
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
            return new Devolucao(8);
        }
        if(posicaoC == -1){
            return new Devolucao(2);
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
            return new Devolucao(11);
        }

        if(alugados.get(posicaoA).getIdUsuario() == cliente.getId()){
            Date start = sdf.parse(alugados.get(posicaoA).getStartDate());
            Date end = sdf.parse(alugados.get(posicaoA).getEndDate());
            Date devolucao = sdf.parse(dataDevolucao);
            
            long diferencaMili = Math.abs(end.getTime() - start.getTime());
            long diferencaMiliDev = Math.abs(devolucao.getTime() - start.getTime());
            
            long dias = TimeUnit.DAYS.convert(diferencaMili, TimeUnit.MILLISECONDS);
            long diasDev = TimeUnit.DAYS.convert(diferencaMiliDev, TimeUnit.MILLISECONDS);
            
            double taxa = dias*1.50;
            double multa = 0;
            
            if(diasDev > dias){
                double teste  = diasDev-dias;
                multa = 10.5 * teste;
            }
            
            alugados.remove(posicaoA);
            filme.alugar();
            return new Devolucao(12, taxa, multa, filme.getNome(), cliente.getNome(), cliente.getSobrenome());
            //alugado
        }else{
            return new Devolucao(13);
            //não foi alugado para ele
        }
    }
    
    public String listarAlugados(){ //retorna uma string com a lista formatada de filmes alugados
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
                    compilado += "\nAlugado por: " + usuarios.get(f).getNome() + " " + usuarios.get(f).getSobrenome()
                                  + "\nDa data:" + alugados.get(i).getStartDate() + " até " + alugados.get(i).getEndDate();
                }
            }

        }
        
        return compilado;
    }
}
