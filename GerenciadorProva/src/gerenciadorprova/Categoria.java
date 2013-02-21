
package gerenciadorprova;

import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author naysinger
 */
public class Categoria {
    private int idcategoria;
    private String nome;
    
    public Categoria(){
        
    }
    
    public Categoria(int idcat, String nome){
        this.idcategoria = idcat;
        this.nome = nome;
    }
    
    public static Vector attribNames() {
      String[] names = {"idcategoria", "nome"};
      Vector<String> v = new Vector<String>(Arrays.asList(names));
      return v;
   }
    
    public int getIdCategoria(){
        return idcategoria;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setIdCategoria(int idcat){
        idcategoria = idcat;
    }
    
    public void setNome(String nomeCat){
        nome = nomeCat;
    }
}
