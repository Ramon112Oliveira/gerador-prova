/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public interface GenericDAOInterface<T, PK> {

   public void setConnection(Connection conn);

   public void create(T newInstance) throws SQLException;
   
   public void delete(PK id) throws SQLException;
   
   public void update(T transientObject) throws SQLException;
   
   public List<T> findAll() throws SQLException;

   public ArrayList<Vector> dumpToVector() throws SQLException;
}
