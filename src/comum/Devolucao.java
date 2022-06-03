
package comum;
import java.io.Serializable;

public class Devolucao implements Serializable{
    private int status;
    private double taxa;
    private double multa;
    private String nomeFilme;
    private String nomeUsuario;

    public Devolucao(int status, double taxa, double multa, String nomeFilme, String nomeUsuario) {
        this.status = status;
        this.taxa = taxa;
        this.multa = multa;
        this.nomeFilme = nomeFilme;
        this.nomeUsuario = nomeUsuario;
    }

    public int getStatus() {
        return status;
    }

    public double getTaxa() {
        return taxa;
    }

    public double getMulta() {
        return multa;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    
}
