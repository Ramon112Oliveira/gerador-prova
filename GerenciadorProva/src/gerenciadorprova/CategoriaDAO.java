/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Serializable;

public class CategoriaDAO extends GenericDAO<Categoria, Integer>{
     public CategoriaDAO(){
        sqlInsert = "INSERT INTO simuladorcategoria (nome) VALUES (?)";
        sqlSelect = "SELECT idcategoria, nome FROM simuladorcategoria WHERE idcategoria = ?";
        sqlUpdate = "UPDATE simuladorcategoria SET nome = ? WHERE idcategoria = ?";
        sqlDelete = "DELETE FROM simuladorcategoria WHERE idcategoria = ?";
        sqlSelectAll = "SELECT * FROM simuladorcategoria";
    }
    
     public CategoriaDAO(Connection conn) { 
      super(conn);
    }
    
    protected void fillSqlInsert(PreparedStatement ps, Categoria a) throws SQLException {
      ps.setString(1, a.getNome());
      ps.executeUpdate();
   }
    
    protected void fillSqlDelete(PreparedStatement ps, Integer id) throws SQLException {
      ps.setInt(1, id);
   }
    
    protected void fillSqlSelect(PreparedStatement ps, Integer id) throws SQLException {
      ps.setInt(1, id);
   }
   
   protected void fillSqlUpdate(PreparedStatement ps, Categoria a) throws SQLException {
      ps.setString(1, a.getNome());
   }
    
    protected Categoria fillFrom(ResultSet rs) throws SQLException {
      Categoria a = new Categoria();
      a.setIdCategoria(rs.getInt("idcategoria"));
      a.setNome(rs.getString("nome"));
      return a;
   }
}
