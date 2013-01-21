import java.sql.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class SQLQuery {
    PreparedStatement x = null;
    JDBCExample post = new JDBCExample();
    
    
    public void update(String a, String b){
        try{
            String cod = a;
            String tit = b;
            String query = "INSERT INTO filmes(codigo, titulo) VALUES (?, ?)";
            x = post.getConnection().prepareStatement(query);
            x.setString(1,cod);
            x.setString(2,tit);
            x.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"erro ao inserir no banco");
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
