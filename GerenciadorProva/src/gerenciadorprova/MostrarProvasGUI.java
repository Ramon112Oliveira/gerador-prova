/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.Component;

public class MostrarProvasGUI {
      JFrame frame = new FrameProva();
}

class FrameProva extends JFrame {

   private JPanel jPanel = null;
   private JButton jButtonClose = null;
   private JButton jButtonSearch = null;
   private JScrollPane jScrollPane = null;
   private JTable jTable = null;

   private Connection conn = null;
   private ProvaDAO provadao = null;

   public FrameProva() {
      this.setSize(new Dimension(800, 600));
      this.setContentPane(getJPanel());
      setVisible(true);
      initDb();
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   private void initDb() {
      try {
         DbUtils db = new DbUtils();
         Connection c = db.getConnection();
         provadao = new ProvaDAO();
         provadao.setConnection(c);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private void closeDb() {
      try {
         DbUtils.shutdown(conn);
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   private void dbToJTable() {
      try {
         ArrayList<Vector> provas = provadao.dumpToVector();
         DefaultTableModel model = new DefaultTableModel(provas.get(1), Prova.attribNames());
         jTable.setModel(model);
      } catch(SQLException ex) {
         ex.printStackTrace();
      }
   }

   private JPanel getJPanel() {
      jPanel = new JPanel(); 
      jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
      jPanel.add(getJScrollPane());
      jPanel.add(getJButtonSearch());
      return jPanel;
   }

   private JScrollPane getJScrollPane() {
      jScrollPane = new JScrollPane();
      jScrollPane.setViewportView(getJTable());
      return jScrollPane;
   }

   private JTable getJTable() {
      jTable = new JTable();
      DefaultTableModel model = new DefaultTableModel(Prova.attribNames(), 0);
      jTable.setModel(model);
      return jTable;
   }

   private JButton getJButtonSearch() {
      jButtonSearch = new JButton();
      jButtonSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
      jButtonSearch.setText("Pesquisar");

      jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent e) {
            dbToJTable();
         }
      });
      return jButtonSearch;
   }
}

