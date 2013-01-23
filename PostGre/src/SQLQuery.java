import java.sql.*;
import javax.swing.JOptionPane;

public class SQLQuery {
    PreparedStatement x = null;
    JDBCExample post = new JDBCExample();
    String query = null;
    
    public void updateQuestoes(int id_Questao, int id_fonte, boolean a, String Titulo, String Descricao, String A, String B, String C, String D, String E, int resposta){
        try{
            query = "INSERT INTO tb_questoes (Id_questao, Id_fonte, privada, titulo, descricao, a, b, c, d, e, resposta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            x = post.getConnection().prepareStatement(query);
            x.setInt(1,id_Questao);
            x.setInt(2,id_fonte);
            x.setBoolean(3,a);
            x.setString(4,Titulo);
            x.setString(5,Descricao);
            x.setString(6,A);
            x.setString(7,B);
            x.setString(8,C);
            x.setString(9,D);
            x.setString(10, E);
            x.setInt(11,resposta);
            x.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"erro ao inserir no banco");
        }
    }
    
    public void updateQuestoesProva(int idquestoesprova, int idquestao, int idprova, int sequencia){
        try{
            query = "INSERT INTO tb_questoes_provas (idquestoesprova, idquestao, idprova, sequencia) VALUES(?, ?, ?, ?)";
            x = post.getConnection().prepareStatement(query);
            x.setInt(1,idquestoesprova);
            x.setInt(2,idquestao);
            x.setInt(3,idprova);
            x.setInt(4,sequencia);
            x.executeUpdate();
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir no banco");
        }
    }
    
    
    public void rescue(){
        try{
            Statement stm = (Statement) post.getConnection().createStatement();
            String consulta = "SELECT titulo FROM filmes";
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next()){
                String titulo = rs.getString("titulo");
                System.out.println(titulo);
            }
        }catch(SQLException e){
            System.out.println("Erro no mostrar do banco");
        }
    }
}
