
package comum;
import java.util.ArrayList;
import java.io.Serializable;

public class MsgResp implements Serializable{
    
    private int status;
    
    private Usuario usuario;
    private Filme filme;
    private ArrayList usuarios;
    private ArrayList filmes;

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

    
    
    
}
