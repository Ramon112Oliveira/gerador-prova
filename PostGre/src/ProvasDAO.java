import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ProvasDAO implements ProvasDAOInterface {
    
       private Connection conn = null;
       
       private static final String SQL_INSERT =
      "INSERT INTO tbprovas (idprova, dt_criacao, titulo) VALUES (?, ?, ?)";
       
        public ProvasDAO() {
        }

        public ProvasDAO(Connection conn) {
            setConnection(conn);
        }

        public void setConnection(Connection conn) {
            this.conn = conn;
        }
        
        public void create(Provas a) throws SQLException {
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement(SQL_INSERT);
                ps.setInt(1, a.getIdProva());
                //ps.setDate(2,a.getData());
                ps.setString(3, a.getTitulo());
                ps.executeUpdate();
            } finally {
            close(ps);
            }
        }
}
