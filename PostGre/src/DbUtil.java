import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

   // Constantes para conexao com HSQLSB (modo standalone)
   static final String JDBC_DRIVER = "org.postgresql.Driver";
   static final String DB_NAME = "Simulador";
   static final String DB_URL = "jdbc:postgresql://localhost:5432/Simulador";
   static final String DB_USER = "postgres";
   static final String DB_PASSWD = "1234";

   public static Connection getConnection() throws ClassNotFoundException, SQLException {
     Class.forName(JDBC_DRIVER);
     return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
   }
}