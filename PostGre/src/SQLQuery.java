import java.sql.*;
import javax.swing.JOptionPane;

public class SQLQuery {
    PreparedStatement x = null;
    JDBCExample post = new JDBCExample();
    String query = null;
    
    public void updateQuestoes(int id_Questao, String Titulo, String A, String B, String C, String D, String E, int resposta){
        try{
            query = "INSERT INTO tb_questoes (Id_questao, titulo, a, b, c, d, e, resposta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            x = post.getConnection().prepareStatement(query);
            x.setInt(1,id_Questao);
            x.setString(2,Titulo);
            x.setString(3,A);
            x.setString(4,B);
            x.setString(5,C);
            x.setString(6,D);
            x.setString(7, E);
            x.setInt(8,resposta);
            x.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"erro ao inserir no banco");
        }
    }
    
    public void updateQuestoesProva(int idquestoesprova, int idquestao, int idprova){
        try{
            query = "INSERT INTO tb_questoes_provas (idquestoesprova, idquestao, idprova) VALUES(?, ?, ?)";
            x = post.getConnection().prepareStatement(query);
            x.setInt(1,idquestoesprova);
            x.setInt(2,idquestao);
            x.setInt(3,idprova);
            x.executeUpdate();
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir no banco");
        }
    }
    
    public void updateProvas(int idProva, Date dtCriacao, String titulo){
        try{
            query = "INSERT INTO tb_provas (idprova, dr_criacao, titulo) VALUES (?, ?, ?)";
            x = post.getConnection().prepareStatement(query);
            x.setInt(1, idProva);
            x.setDate(2,dtCriacao);
            x.setString(3, titulo);
            x.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir ao banco");
        }
    }
    
    public void rescue(){
        try{
            Statement stm = (Statement) post.getConnection().createStatement();
            String consulta = "SELECT titulo FROM tb_questoes";
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next()){
                String titulo = rs.getString("titulo");
                System.out.println(titulo);
            }
        }catch(SQLException e){
            System.out.println("Erro no mostrar do banco");
        }
    }
    
    public boolean verifica(int ID){
        boolean pega = false;
        try{
            Statement stm = (Statement) post.getConnection().createStatement();
            String consulta = "SELECT id_questao FROM tb_questoes";
            
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next() && pega == false){
                int id = rs.getInt("id_questao");
                if(ID == id) pega = true;
            }
        }catch(SQLException e){
            System.out.println("Erro no mostrar do banco");
        }
        return pega;
    }
}
