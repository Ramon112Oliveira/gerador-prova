
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

   public void createTable() throws SQLException {
      Statement s = null;
      try {
         s = conn.createStatement();
         s.executeUpdate(sqlCreate);
      } finally {
         close(s);
      }
   }

   public void dropTable() throws SQLException {
      Statement s = null;
      try {
         s = conn.createStatement();
         s.executeUpdate(sqlDrop);
      } finally {
         close(s);
      }
   }

   public void create(T t) throws SQLException {
      PreparedStatement ps = null;
      try {
         ps = conn.prepareStatement(sqlInsert);
         fillSqlInsert(ps, t);
         //ps.setInt(1, t.getId());
         //ps.setString(1, t.getTitulo());
         //ps.setInt(3, t.getCh());
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
         //ps.setInt(1, id);
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

   public void update(T t) throws SQLException {
      PreparedStatement ps = null;
      try {
         ps = conn.prepareStatement(sqlUpdate);
         fillSqlUpdate(ps, t);
         //ps.setString(1, a.getDescr());
         //ps.setInt(2, a.getCh());
         //ps.setInt(3, a.getId());
         ps.executeUpdate();
      } finally {
         close(ps);
      }
   }

   public void delete(PK id) throws SQLException {
      PreparedStatement ps = null;
      try {
         ps = conn.prepareStatement(sqlDelete);
         fillSqlDelete(ps, id);
         //ps.setInt(1, id);
         ps.executeUpdate();
      } finally {
         close(ps);
      }
   }
    
   private List<T> getResults(ResultSet rs) throws SQLException {
      List<T> results = new ArrayList<T>();
      while (rs.next()) {
         T t = fillFrom(rs);
         //a.setId(rs.getInt("id"));
         //a.setDescr(rs.getString("descr"));
         //a.setCh(rs.getInt("ch"));
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

   protected abstract void fillSqlInsert(PreparedStatement ps, T t) throws SQLException;

   protected abstract void fillSqlSelect(PreparedStatement ps, PK id) throws SQLException;

   protected abstract void fillSqlUpdate(PreparedStatement ps, T t) throws SQLException;

   protected abstract void fillSqlDelete(PreparedStatement ps, PK id) throws SQLException;

   protected abstract T fillFrom(ResultSet rs) throws SQLException;
}
