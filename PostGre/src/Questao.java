import javax.swing.JOptionPane;

public class Questao {
    private int idQuestao;
    private int idFonte;
    private boolean privada;
    private String titulo;
    private String descricao;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private int resposta;
    private int i; 
    
    public Questao(int idquestao, int idfonte, boolean privada, String titulo, String descricao, String A, String B, String C, String D, String E, int resposta){
        this.idQuestao = idquestao;
        this.idFonte = idfonte;
        this.titulo = titulo;
        this.descricao = descricao;
        this.privada = privada;
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
    
    public int getIdFonte(){
        return idFonte;
    }
    
    public boolean getPrivada(){
        return privada;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getDescricao(){
        return descricao;
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
