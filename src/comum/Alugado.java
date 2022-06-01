package comum;
import java.io.Serializable;
        


public class Alugado implements Serializable{
    
    private int idFilme;
    private int idUsuario;

    public Alugado(int idFilme, int idUsuario) {
        this.idFilme = idFilme;
        this.idUsuario = idUsuario;
    }
    
    
    
}
