import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

public class Provas {
    private int id_prova;
    private Date data;
    private String titulo;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Date invalidDate = new Date(0);
    
    public ArrayList<Questao> q = new ArrayList();
    
    
    public Provas(int idProva, String titulo){
        
        this.id_prova = idProva;
        this.titulo = titulo;
        this.data = null;
        this.q = null;
    }
    
    public int getIdProva(){
        return id_prova;
    }
    
    public Date getData(){
        return data;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setQuestao(Questao quest){
        q.add(quest);
    }
    
    public void setData( Date d){
        data = d;
    }
    
    public Date fromString( String a ) { // entra string e retorna DATA
          try {
            return dateFormat.parse( a );
          } catch( ParseException e) {
            return invalidDate;
            }
   }
}