package comum;
import java.io.Serializable;


/**
 *
 * @author paulo
 */
public class Filme implements Serializable{
    private String nome;
    private String genero;
    private int ano;
    private boolean alugado = false;
    private int id;

    public Filme(String nome, String genero, int ano, int id) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.id = id;
    }
    
    public void alugar(){
        this.alugado = !this.alugado;
    }

    public String getNome() {
        return nome;
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

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        
        String isAlugado = (alugado) ? "Sim" : "Não"; 
        return "Nome do Filme: " + nome + 
                "\nGenero: " + genero + 
                "\nAno: " + ano + 
                "\nEstá Alugado: " + isAlugado
                + "\nId: " + id;
    }
    
    
}
