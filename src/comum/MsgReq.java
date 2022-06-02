package comum;
import java.io.Serializable;



public class MsgReq implements Serializable{
    
    //filme
    private String nomeFilme;
    private String genero;
    private int ano;
    private boolean alugado;
    
    //usuario
    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String cpf;
    private int idade;
    
    //opção
    private int opcao;
    
    //dias
    private int dias;

    public MsgReq(String nomeFilme, String genero, int ano, int opcao) { //cadastrar cliente
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.ano = ano;
        this.opcao = opcao;
    }

    public MsgReq(String nomeUsuario, String sobrenomeUsuario, String cpf, int idade, int opcao) { //cadastrar filme
        this.nomeUsuario = nomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.cpf = cpf;
        this.idade = idade;
        
    }
    
    public MsgReq() {
    }
    
    public MsgReq(String cpf, int opcao) { //bucar user / remover
        this.cpf = cpf;
        this.opcao = opcao;
    }
    
    public MsgReq(String nomeFilme, int ano, int opcao){ //buscar filme / remover
        this.nomeFilme = nomeFilme;
        this.ano = ano;
        this.opcao = opcao;
    }
    
    public MsgReq(String nomeFilme, int ano, String cpf, int opcao){ //buscar filme / remover
        this.nomeFilme = nomeFilme;
        this.ano = ano;
        this.opcao = opcao;
        this.cpf = cpf;
    }
    
    public MsgReq(int opcao) { 
        this.opcao = opcao;
    }
    
    public MsgReq(int opcao, int dias){
        this.opcao = opcao;
        this.dias = dias;
    }
    
    //getters and setters
    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    public int getAno() {
        return ano;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    
}
