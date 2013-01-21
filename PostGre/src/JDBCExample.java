import java.sql.*;

public class JDBCExample {
    private Connection connection = null;
    
    public Connection getConnection(){
        return this.connection;
    }
    public JDBCExample() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver nÃ£o estÃ¡ bem instalado");
			e.printStackTrace();
			return;
		}
 
		System.out.println("Driver registrado");
                
                try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres","1234");
 
		} catch (SQLException e) {
			System.out.println("ConexÃ£o Falhou");
			e.printStackTrace();
			return;
		}
 
		if (connection != null) {
			System.out.println("Conectado ao banco");
		} else {
			System.out.println("Falha ao conectar com o banco!");
		}
    }
}
