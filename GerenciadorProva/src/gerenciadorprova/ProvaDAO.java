
package gerenciadorprova;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Serializable;

public class ProvaDAO extends GenericDAO<Prova, Integer> {

   public ProvaDAO() {
      sqlInsert = "INSERT INTO simuladorprova (nome) VALUES (?)";
      sqlSelect = "SELECT idprova, nome FROM simuladorprova WHERE idprova = ?";
      sqlUpdate = "UPDATE simuladorprova SET nome = ? WHERE idprova = ?";
      sqlDelete = "DELETE FROM simuladorprova WHERE idprova = ?";
      sqlSelectAll = "SELECT * FROM simuladorprova";
   }

   public ProvaDAO(Connection conn) { 
      super(conn);
   }

   protected void fillSqlInsert(PreparedStatement ps, Prova a) throws SQLException {
      ps.setString(1, a.getTitulo());
      ps.executeUpdate();
   }
   
   protected void fillSqlDelete(PreparedStatement ps, Integer id) throws SQLException {
      ps.setInt(1, id);
   }
   
   protected Prova fillFrom(ResultSet rs) throws SQLException {
      Prova a = new Prova();
      a.setId(rs.getInt("idprova"));
      a.setTitulo(rs.getString("nome"));
      return a;
   }
   
   protected void fillSqlSelect(PreparedStatement ps, Integer idprova) throws SQLException {
      ps.setInt(1, idprova);
   }
   
   protected void fillSqlUpdate(PreparedStatement ps, Prova a) throws SQLException {
      ps.setString(1, a.getTitulo());
      ps.setInt(2,a.getIdProva());
      ps.executeUpdate();
   }
}