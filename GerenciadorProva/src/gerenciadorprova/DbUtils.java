/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DbUtils{
    
    private static Connection connection = null;
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public static void shutdown(Connection c) throws SQLException {
      Statement s = c.createStatement();
      s.execute("SHUTDOWN");
   }
    
    public DbUtils() {
	try {
	    Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
	    System.out.println("Driver no esta bem instalado");
		e.printStackTrace();
		return;
	}
 
	System.out.println("Driver registrado");
                
        try {
	     connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simulador", "postgres","1234");
 
	} catch (SQLException e) {
	      System.out.println("Conexao Falhou");
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
