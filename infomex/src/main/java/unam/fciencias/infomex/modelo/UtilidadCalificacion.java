/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import static unam.fciencias.infomex.modelo.UtilidadComentario.sessionObj;

/**
 *
 * @author valde
 */
public class UtilidadCalificacion {
    static Comentario comObj;
    static Session sessionObj;
    
    public void save(Calificacion calificacion) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(calificacion);
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

