/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

public class Prova {
    private int idprova;
    private String titulo;
    
    public Prova(){
        
    }
    
    public Prova(int idProva, String titulo){
        this.idprova = idProva;
        this.titulo = titulo;
    }
    
    public static Vector attribNames() {
      String[] names = {"idprova", "titulo"};
      Vector<String> v = new Vector<String>(Arrays.asList(names));
      return v;
   }
    
    public int getIdProva(){
        return idprova;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String t){
        this.titulo = t;
    }
    
    public void setId(int i){
        this.idprova = i;
    }
}