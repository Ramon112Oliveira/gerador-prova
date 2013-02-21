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

public class QuestaoDAO extends GenericDAO<Questao, Integer>{
    
    public QuestaoDAO(){
        sqlInsert = "INSERT INTO simuladorquestao (titulo, a, b, c, d, e, resposta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        sqlSelect = "SELECT idquestao, titulo, a, b, c, d, e, resposta FROM simuladorquestao WHERE idquestao = ?";
        sqlUpdate = "UPDATE simuladorquestao SET titulo = ? WHERE idquestao = ?";
        sqlDelete = "DELETE FROM simuladorquestao WHERE idquestao = ?";
        sqlSelectAll = "SELECT * FROM simuladorquestao";
    }
    
    public QuestaoDAO(Connection conn) { 
      super(conn);
    }
    
    protected void fillSqlInsert(PreparedStatement ps, Questao a) throws SQLException {
      ps.setString(1, a.getTitulo());
      ps.setString(2, a.getAlternativaA());
      ps.setString(3, a.getAlternativaB());
      ps.setString(4, a.getAlternativaC());
      ps.setString(5, a.getAlternativaD());
      ps.setString(6, a.getAlternativaE());
      ps.setInt(7, a.getResposta());
      ps.executeUpdate();
   }
    
    protected void fillSqlDelete(PreparedStatement ps, Integer id) throws SQLException {
      ps.setInt(1, id);
   }
    
    
   protected void fillSqlSelect(PreparedStatement ps, Integer id) throws SQLException {
      ps.setInt(1, id);
   }
   
   protected void fillSqlUpdate(PreparedStatement ps, Questao a) throws SQLException {
      ps.setString(1, a.getTitulo());
      ps.setInt(2, a.getIdQuestao());
   }
   
    protected Questao fillFrom(ResultSet rs) throws SQLException {
      Questao a = new Questao();
      a.setIdQuestao(rs.getInt("idquestao"));
      a.setTitulo(rs.getString("titulo"));
      a.setAlternativaA(rs.getString("a"));
      a.setAlternativaA(rs.getString("b"));
      a.setAlternativaA(rs.getString("c"));
      a.setAlternativaA(rs.getString("d"));
      a.setAlternativaA(rs.getString("e"));
      a.setResposta(rs.getInt("resposta"));
      return a;
   }
}
