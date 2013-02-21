
package gerenciadorprova;

import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author naysinger
 */
public class Questao {
    private int idQuestao;
    private String titulo;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private int resposta;
    
    public Questao(){
        
    }
    
    public Questao(int idquestao, String titulo, String A, String B, String C, String D, String E, int resposta){
        this.idQuestao = idquestao;
        this.titulo = titulo;
        this.alternativaA = A;
        this.alternativaB = B;
        this.alternativaC = C;
        this.alternativaD = D;
        this.alternativaE = E;
        this.resposta = resposta;
    }
    
    public static Vector attribNames() {
      String[] names = {"idquestao", "titulo", "a", "b", "c", "d", "e", "resposta"};
      Vector<String> v = new Vector<String>(Arrays.asList(names));
      return v;
   }
    
    public int getIdQuestao(){
        return idQuestao;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAlternativaA(){
        return alternativaA;
    }
    
    public String getAlternativaB(){
        return alternativaB;
    }
  
    public String getAlternativaC(){
        return alternativaC;
    }
    
    public String getAlternativaD(){
        return alternativaD;
    }
    
    public String getAlternativaE(){
        return alternativaE;
    }
    public int getResposta(){
        return resposta;
    }
    
    public void setIdQuestao(int idquestao){
        this.idQuestao = idquestao;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setAlternativaA(String alternativaA){
        this.alternativaA = alternativaA;
    }
    
    public void setAlternativaB(String alternativaB){
        this.alternativaB = alternativaB;
    }
  
    public void setAlternativaC(String alternativaC){
        this.alternativaC = alternativaC;
    }
    
    public void setAlternativaD(String alternativaD){
        this.alternativaD = alternativaD;
    }
    
    public void setAlternativaE(String alternativaE){
        this.alternativaE = alternativaE;
    }
    public void setResposta(int resposta){
        this.resposta = resposta;
    }
}
