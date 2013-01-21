import javax.swing.JOptionPane;

public class Questao {
    private String titulo;
    private String descricao;
    //private boolean privada;
    private String[] alternativas = new String[5];
    private int resposta;
    private String fonte;
    private int i; 
    
    public Questao(String titulo, String descricao, String[] alternativas, int resposta, String fonte){
        this.titulo = titulo;
        this.descricao = descricao;
        //this.privada = false;
        for(i = 0; i < 5; i++){
            this.alternativas[i] = alternativas[i];
        }////
        //p.add();
        //p.add();
        this.resposta = resposta;
        this.fonte = fonte;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public String[] getAlternativas(){
        return alternativas;
    }
    
    public int getResposta(){
        return resposta;
    }
    
    public String getFonte(){
        return fonte;
    }
}
