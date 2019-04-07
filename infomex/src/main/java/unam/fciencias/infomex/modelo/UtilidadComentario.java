/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author a-valderrama
 */
public class UtilidadComentario {
    
    static Comentario comObj;
    static Session sessionObj;
    
    public List<Comentario> getTodosComentarios(){
        List<Comentario> obj = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();

        try{
            sessionObj.beginTransaction();
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"1"+"\n\n\n\n\n\n\n");
            String hql = "FROM Comentario";
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"2"+"\n\n\n\n\n\n\n");
            Query query = sessionObj.createQuery(hql);
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"3"+"\n\n\n\n\n\n\n");
            obj = (List<Comentario>)query.list();
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"4"+"\n\n\n\n\n\n\n");
            sessionObj.getTransaction().commit();
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+obj+"\n\n\n\n\n\n\n");
            if(obj.isEmpty()){
                return null;
            }else{
                return obj;
            }
        }catch(Exception sqlException){
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......ERROOOOOOOOOOOR.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }finally{
            if (sessionObj != null) {
                sessionObj.close();
            }            
        } 
        return null;
    }

    public void save(Comentario comentario) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(comentario);
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    
    public void delete(Comentario comentario) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.delete(comentario);
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}
