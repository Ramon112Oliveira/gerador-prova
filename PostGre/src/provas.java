
import javax.swing.JOptionPane;
import java.util.*;

public class provas {
    private int id_prova_usuario;
    //private int id_usuario;
    private int id_prova;
    private Date data;
    private float desempenho;
    
    public ArrayList<Questao> q = new ArrayList();
    
    
    public provas(int idProva, int idProvaUsuario, Date data){
        
        this.id_prova = idProva;
        this.id_prova_usuario = idProvaUsuario;
        this.data = data;
        this.q = null;
    }
    
    public float getDesempenho(){
        return desempenho;
    }
    
    public int getIdProva(){
        return id_prova;
    }
    
    public int getIdProvaUsuario(){
        return id_prova_usuario;
    }
    
    public Date getData(){
        return data;
    }
    
    public void setQuestao(Questao quest){
        q.add(quest);
    }
}
