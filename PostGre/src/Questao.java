
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
    
}
