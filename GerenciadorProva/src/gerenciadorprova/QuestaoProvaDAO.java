package gerenciadorprova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Serializable;

public class QuestaoProvaDAO extends GenericDAO<QuestaoProva, Integer> {
    
    public QuestaoProvaDAO(){
      sqlInsert = "INSERT INTO simuladorprovaquestoes (questao_idquestao, prova_idprova) VALUES (?, ?)";
      sqlSelect = "SELECT idprova, questao_idquestao, prova_idprova FROM simuladorprovaquestoes WHERE prova_idprova = ?";
      sqlUpdate = "UPDATE simuladorprovaquestoes SET nome = ? WHERE idprova = ?";
      sqlDelete = "DELETE FROM simuladorprovaquestoes WHERE idprova = ?";
      sqlSelectAll = "SELECT * FROM simuladorprovaquestoes";
    }
    
     public QuestaoProvaDAO(Connection conn) { 
      super(conn);
   }

   protected void fillSqlInsert(PreparedStatement ps, QuestaoProva a) throws SQLException {
      ps.setInt(1, a.getIdQuestao());
      ps.setInt(2, a.getIdProva());
      ps.executeUpdate();
   }
   
   protected void fillSqlDelete(PreparedStatement ps, Integer id) throws SQLException {
      ps.setInt(1, id);
   }
   
   protected QuestaoProva fillFrom(ResultSet rs) throws SQLException {
      QuestaoProva a = new QuestaoProva();
      a.setIdProva(rs.getInt("idProva"));
      a.setIdQuestao(rs.getInt("idQuestao"));
      return a;
   }
   
   protected void fillSqlSelect(PreparedStatement ps, Integer idprova) throws SQLException {
      ps.setInt(1, idprova);
   }
   
   protected void fillSqlUpdate(PreparedStatement ps, QuestaoProva a) throws SQLException {
      ps.setInt(1, a.getIdProva());
      ps.setInt(2,a.getIdProva());
   }
}
