/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import org.hibernate.Query;
import org.hibernate.Session;
import static unam.fciencias.infomex.modelo.UtilidadInformador.sessionObj;
/**
 *
 * @author avelez
 */
public class UtilidadComentarista {
    
    static Comentarista userObj;
    static Session sessionObj;

    public void save(Comentarista comentarista) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(comentarista);
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
    
    public Comentarista buscaPorCorreo(String correo) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            String hql = "FROM Comentarista c WHERE c.correo_com = :correo";
            Query query = sessionObj.createQuery(hql);
            query.setString("correo",correo);
            Comentarista comen = (Comentarista)query.uniqueResult();
            sessionObj.getTransaction().commit();
            return comen;
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
        return null;
    }
}
