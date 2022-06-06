
package comum;
import java.util.ArrayList;
import java.io.Serializable;

public class MsgResp implements Serializable{ //classe para resposta do servidor ao cliente
    
    private int status;
    
    private Usuario usuario;
    private Filme filme;
    private ArrayList usuarios;
    private ArrayList filmes;
    private ArrayList alugados;
    private String str;
    private double taxa;
    private Devolucao devolver;

    public MsgResp() {
        this.status = 0;
    }

    public MsgResp( int status) {
        this.status = status;
    }
    
    public MsgResp(int status, Usuario resposta){
        this.status = status;
        this.usuario = resposta;
    }
    
    public MsgResp(int status, Filme resposta){
        this.status = status;
        this.filme = resposta;
    }

    public MsgResp(int status, ArrayList usuarios) {
        this.status = status;
        this.usuarios = usuarios;
    }

    public MsgResp(int status, double taxa) {
        this.status = status;
        this.taxa = taxa;
    }

    public MsgResp(int status, String str) {
        this.status = status;
        this.str = str;
    }

    public Devolucao getDevolver() {
        return devolver;
    }

    public void setDevolver(Devolucao devolver) {
        this.devolver = devolver;
    }
    
               
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
      this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public ArrayList getUsuarios() {
        return usuarios;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setUsuarios(ArrayList usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList filmes) {
        this.filmes = filmes;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public ArrayList getAlugados() {
        return alugados;
    }

    public void setAlugados(ArrayList alugados) {
        this.alugados = alugados;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    
    
    
}
