/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public abstract class GenericDAO <T, PK extends Serializable> 
   implements GenericDAOInterface <T, PK> {

   protected String sqlInsert;
   protected String sqlSelect;
   protected String sqlUpdate;
   protected String sqlDelete;
   protected String sqlSelectAll;
   protected String sqlCreate;
   protected String sqlDrop;
   protected Connection conn;
   
   public GenericDAO() {
   }

   public GenericDAO(Connection conn) {
      setConnection(conn);
   }
   public void setConnection(Connection conn) {
      this.conn = conn;
   }

   //insere prova
   public void create(T t) throws SQLException {
      PreparedStatement ps = null;
      try {
         ps = conn.prepareStatement(sqlInsert);
         fillSqlInsert(ps, t);
      } catch(NullPointerException s){ 
      }finally {
         close(ps);
      }
   }

   //deleta pelo id
   public void delete(PK id) throws SQLException {
      PreparedStatement ps = null;
      try {
         ps = conn.prepareStatement(sqlDelete);
         fillSqlDelete(ps, id);
         ps.executeUpdate();
      } finally {
         close(ps);
      }
   }
   
   public void update(T t) throws SQLException {
      PreparedStatement ps = null;
      try {
         ps = conn.prepareStatement(sqlUpdate);
         fillSqlUpdate(ps, t);
         ps.executeUpdate();
      } finally {
         close(ps);
      }
   }
   
   public T find(PK id) throws SQLException {
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         ps = conn.prepareStatement(sqlSelect);
         fillSqlSelect(ps, id);
         rs = ps.executeQuery();
         List<T> results = getResults(rs);
         if (results.size() > 0)
            return results.get(0);
         else
            return null;
      } finally {
         close(rs);
         close(ps);
      }
   }
   
   public List<T> findAll() throws SQLException {
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         ps = conn.prepareStatement(sqlSelectAll);
         rs = ps.executeQuery();
         List<T> results = getResults(rs);
         return results;
      } finally {
         close(rs);
         close(ps);
      }
   }
   
   
   private List<T> getResults(ResultSet rs) throws SQLException {
      List<T> results = new ArrayList<T>();
      while (rs.next()) {
         T t = fillFrom(rs);
         results.add(t);
      }
      return results;
   }

   private void close(Statement stmt) {
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {}
      }
   }

   private void close(ResultSet rs) {
      if (rs != null) {
         try {
            rs.close();
         } catch (SQLException e) {}
      }
   }
   
   public ArrayList<Vector> dumpToVector() throws SQLException {
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         ps = conn.prepareStatement(sqlSelectAll);
         rs = ps.executeQuery();
         ArrayList<Vector> results = resultsToVector(rs);
         return results;
      } finally {
         close(rs);
         close(ps);
      }      
   }

   private ArrayList<Vector> resultsToVector(ResultSet rs) throws SQLException {
      ResultSetMetaData metaData = rs.getMetaData();
      int numberOfColumns = metaData.getColumnCount();
      Vector<String> columnNames = new Vector<String>();
      // Get the column names
      for (int column = 0; column < numberOfColumns; column++) {
         columnNames.addElement(metaData.getColumnLabel(column + 1));
      }
      // Get all rows
      Vector<Vector> rows = new Vector<Vector>();
      while (rs.next()) {
         Vector<Object> newRow = new Vector<Object>();
         for (int i = 1; i <= numberOfColumns; i++) {
            newRow.addElement(rs.getObject(i));
         }
         rows.addElement(newRow);
      }
      ArrayList<Vector> results = new ArrayList<Vector>();
      results.add(columnNames);
      results.add(rows);
      return results;
   }
   
   protected abstract void fillSqlInsert(PreparedStatement ps, T t) throws SQLException;
   
   protected abstract void fillSqlDelete(PreparedStatement ps, PK id) throws SQLException;
   
   protected abstract void fillSqlSelect(PreparedStatement ps, PK id) throws SQLException;
   
   protected abstract void fillSqlUpdate(PreparedStatement ps, T t) throws SQLException;
   
   protected abstract T fillFrom(ResultSet rs) throws SQLException;

}

