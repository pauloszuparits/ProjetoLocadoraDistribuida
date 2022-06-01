package comum;
import java.io.Serializable;
/**
package comum;

/**
 *
 * @author paulo
 */
public class Usuario implements Serializable{
        private String nome;
        private String sobrenome;
        private String cpf;
        private int idade;
        private int id;

    public Usuario(String nome, String sobrenome, String cpf, int idade, int id) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.idade = idade;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() { //TODO
        return "Usuario{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", idade=" + idade + ", id=" + id + '}';
    }
    
    
        
        
}
