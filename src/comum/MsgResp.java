
package comum;

import java.io.Serializable;

public class MsgResp implements Serializable{
    
    private int status;
    private String resposta;

    public MsgResp() {
        this.status = 0;
    }

    public MsgResp( int status) {
        this.status = status;
    }
    
    public MsgResp(int status, String resposta){
        this.status = status;
        this.resposta = resposta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
      this.status = status;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
    
}
