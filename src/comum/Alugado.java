package comum;
import java.io.Serializable;
        


public class Alugado implements Serializable{
    
    private int idFilme;
    private int idUsuario;

    public Alugado(int idFilme, int idUsuario) {
        this.idFilme = idFilme;
        this.idUsuario = idUsuario;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
