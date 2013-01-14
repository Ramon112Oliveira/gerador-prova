import javax.swing.JOptionPane;

public class Questoes {
    private String titulo;
    private String descricao;
    private String[] alternativas = new String[5];
    private String fonte;
    private int resposta;
    private int i;
    
    public Questoes(){
        this.titulo = JOptionPane.showInputDialog("titulo");
        this.descricao = JOptionPane.showInputDialog("descricao");
        for(i = 0; i < 5; i++){
            this.alternativas[i] = JOptionPane.showInputDialog("Insira a alternativa " + i+1);
        }
        this.fonte = JOptionPane.showInputDialog("fonte");
        this.resposta = Integer.parseInt(JOptionPane.showInputDialog("Resposta"));
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
    
    public String getFonte(){
        return fonte;
    }
    
    public int getResposta(){
        return resposta;
    }
}
