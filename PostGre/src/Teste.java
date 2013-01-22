
import java.sql.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Teste {
    public static void main (String[] args){
        SQLQuery sql = new SQLQuery();
        
        
        int entrada1 = Integer.parseInt(JOptionPane.showInputDialog("idquestao"));
	int entrada2 = Integer.parseInt(JOptionPane.showInputDialog("idfonte"));
        boolean entrada3 = false;
        String entrada4 = JOptionPane.showInputDialog("titulo");
        String entrada5 = JOptionPane.showInputDialog("descricao");
        String entrada6 = JOptionPane.showInputDialog("A");
        String entrada7 = JOptionPane.showInputDialog("B");
        String entrada8 = JOptionPane.showInputDialog("C");
        String entrada9 = JOptionPane.showInputDialog("D");
        String entrada10 = JOptionPane.showInputDialog("E");
        int resposta = Integer.parseInt(JOptionPane.showInputDialog("resposta de 1 a 5"));
        sql.update(entrada1, entrada2, entrada3, entrada4,entrada5,entrada6,entrada7, entrada8,entrada9, entrada10, resposta);
        //sql.rescue();
        //provas p = new provas();
       // System.out.println(p.q.getTitulo());
        /*JFrame novo = new TesteGUI();
        novo.setVisible(true);*/
    }
}
