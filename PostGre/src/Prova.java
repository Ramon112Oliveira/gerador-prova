import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

public class Prova {
    private int idprova;
    private Date data;
    private String titulo;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Date invalidDate = new Date(0);
    
    //public ArrayList<Questao> q = new ArrayList();
    
    public Prova(){
        
    }
    
    public Prova(int idProva, String titulo){
        
        this.idprova = idProva;
        this.titulo = titulo;
        this.data = null;
        //this.q = null;
    }
    
    public int getIdProva(){
        return idprova;
    }
    
    public Date getData(){
        return data;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setData( Date d){
        data = d;
    }
    
    public void setTitulo(String t){
        this.titulo = t;
    }
    
    public Date fromString( String a ) { // entra string e retorna DATA
          try {
            return dateFormat.parse( a );
          } catch( ParseException e) {
            return invalidDate;
            }
   }
}