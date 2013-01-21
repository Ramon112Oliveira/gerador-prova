
import java.sql.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Teste {
    public static void main (String[] args){
        /*SQLQuery sql = new SQLQuery();
        
        
        String entrada1 = JOptionPane.showInputDialog("codigo");
	String entrada2 = JOptionPane.showInputDialog("titulo");
        sql.update(entrada1, entrada2);
        sql.rescue();
        //provas p = new provas();
       // System.out.println(p.q.getTitulo());*/
        JFrame novo = new TesteGUI();
        novo.setVisible(true);
    }
}
