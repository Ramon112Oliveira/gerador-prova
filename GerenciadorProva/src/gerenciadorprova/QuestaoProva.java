package gerenciadorprova;

public class QuestaoProva {
    private int id;
    private int idProva;
    private int idQuestao;
    
    public QuestaoProva(){
        
    }
    
    public int getId(){
        return id;
    }
    
    public int getIdProva(){
        return idProva;
    }
    
    public int getIdQuestao(){
        return idQuestao;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setIdProva(int idP){
        this.idProva = idP;
    }
    
    public void setIdQuestao(int idQ){
        this.idQuestao = idQ;
    }
}
