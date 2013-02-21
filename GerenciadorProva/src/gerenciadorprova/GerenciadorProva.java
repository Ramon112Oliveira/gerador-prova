/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;

import java.sql.SQLException;
import javax.swing.*;
import java.sql.Connection;
import java.lang.Exception;
public class GerenciadorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        JFrame janela = new TelaPrincipal();
        janela.setVisible(true);
        /*DbUtils db = new DbUtils();
        Connection c = db.getConnection();
        ProvaDAO provadao = new ProvaDAO();
        provadao.setConnection(c);
        
        Prova prova1 = new Prova();
        prova1.setTitulo("goooooo");
        prova1.setId(5);
        try{
        provadao.create(prova1);
        }catch(SQLException e) {};*/
    }
}
