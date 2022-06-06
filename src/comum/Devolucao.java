
package comum;
import java.io.Serializable;

public class Devolucao implements Serializable{ //classe com dados pertinentes para devolução do filme
    private int status;
    private double taxa;
    private double multa;
    private String nomeFilme;
    private String nomeUsuario;
    private String sobrenome;

    public Devolucao(int status, double taxa, double multa, String nomeFilme, String nomeUsuario, String sobrenome) {
        this.status = status;
        this.taxa = taxa;
        this.multa = multa;
        this.nomeFilme = nomeFilme;
        this.nomeUsuario = nomeUsuario;
        this.sobrenome = sobrenome;
    }
    
    public Devolucao() {       
    }
    
    public Devolucao(int status) {
        this.status = status;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    
}
