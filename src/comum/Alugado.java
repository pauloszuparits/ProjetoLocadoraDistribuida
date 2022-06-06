package comum;
import java.io.Serializable;
        


public class Alugado implements Serializable{ //classe com id do filme alugado + is do cliente que alugou, data de entrega e devolução do filme
    
    private int idFilme;
    private int idUsuario;
    private String startDate;
    private String endDate;

    public Alugado(int idFilme, int idUsuario, String startDate, String endDate) {
        this.idFilme = idFilme;
        this.idUsuario = idUsuario;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    
    
}
