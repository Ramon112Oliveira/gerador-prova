/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorprova;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Controlador {
    DbUtils db = new DbUtils();
    
        
    public void insere_prova(int idp, String nome){
        ProvaDAO provadao = new ProvaDAO();
        Connection c = db.getConnection();
        provadao.setConnection(c);
        Prova prova1 = new Prova();
        prova1.setId(idp);
        prova1.setTitulo(nome);
        try{
            provadao.create(prova1);
            c.close();
        }catch(SQLException e){};

    }
    
    public void insere_questao(String titulo, String a, String b, String c, String d, String e, int resposta){
        QuestaoDAO questaodao = new QuestaoDAO();
        Connection conn = db.getConnection();
        questaodao.setConnection(conn);
        Questao questao1 = new Questao();
        questao1.setTitulo(titulo);
        questao1.setAlternativaA(a);
        questao1.setAlternativaB(b);
        questao1.setAlternativaC(c);
        questao1.setAlternativaD(d);
        questao1.setAlternativaE(e);
        questao1.setResposta(resposta);
        try{
            questaodao.create(questao1);
        }catch(SQLException f){};
    }
    
    public void insere_categoria(String nome){
        CategoriaDAO categoriadao = new CategoriaDAO();
        Connection connec = db.getConnection();
        categoriadao.setConnection(connec);
        
        Categoria categoria1 = new Categoria();
        categoria1.setNome(nome);
        try{
            categoriadao.create(categoria1);
        }catch(SQLException f){};
    } 
    
    public void insere_questoes_prova(int idProva, int idQuestao){
        QuestaoProvaDAO qprovadao = new QuestaoProvaDAO();
        Connection connec = db.getConnection();
        qprovadao.setConnection(connec);
        
        QuestaoProva qtprova = new QuestaoProva();
        qtprova.setIdProva(idProva);
        qtprova.setIdQuestao(idQuestao);
        try{
            qprovadao.create(qtprova);
        }catch(SQLException f){};
    }
    
    public void deleta_prova(int id){
        Connection c = db.getConnection();
        
        ProvaDAO provadao = new ProvaDAO();
        provadao.setConnection(c);
        try{
            provadao.delete(id);
        }catch(SQLException e){};
    }
    
    public void deleta_questao(int idq){
        Connection c = db.getConnection();
        
        QuestaoDAO questaodao = new QuestaoDAO();
        questaodao.setConnection(c);
        try{
            questaodao.delete(idq);
        }catch(SQLException e){};
    }
    
    public void deleta_categoria(int idc){
        Connection c = db.getConnection();
        
        CategoriaDAO categoriadao = new CategoriaDAO();
        categoriadao.setConnection(c);
        try{
            categoriadao.delete(idc);
        }catch(SQLException e){};
    }
    
    public void deleta_questoes_prova(int idP){
        Connection c = db.getConnection();
        
        QuestaoProvaDAO qprovadao = new QuestaoProvaDAO();
        qprovadao.setConnection(c);
        try{
            QuestaoProva qt = qprovadao.find(idP); //encontra o id da prova
            while(qt != null){
            qprovadao.delete(qt.getId());
            qt = qprovadao.find(idP);
            }
        }catch(SQLException e){};
    }
    
    public void edita_prova(int id1, String tituloDir){
        Connection c = db.getConnection();
        
        ProvaDAO provadao = new ProvaDAO();
        provadao.setConnection(c);
        try{
            Prova prova2 = provadao.find(id1); //prova2 é a prova que contem o id1
            System.out.println(prova2);
            prova2.setTitulo(tituloDir);
            provadao.update(prova2);
        }catch(SQLException e){};
        
    }
    
    public void edita_questao(int id2, String tit){
        Connection c = db.getConnection();
        
        QuestaoDAO questaodao = new QuestaoDAO();
        questaodao.setConnection(c);
        try{
            Questao q1 = questaodao.find(id2);
            System.out.println(q1);
            q1.setTitulo(tit);
            questaodao.update(q1);
        }catch(SQLException e){};
    }
    
    
}
