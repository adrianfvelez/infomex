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
 * 
 * Esta clase es la que da todas las utilidades, conexiones,
 * del nuestro sistema a la base de datos. Realiza todas las
 * transaccions de hibernate, así como los querys 
 * correspondientes para realizar acciones en la base de datos.
 * 
 * Esta clase es la utilizada por los métodos del "controlador" 
 * para realizar todas las acciones descritas en ellas.
 */
public class UtilidadComentario {
    
    static Comentario comObj;
    static Session sessionObj;

    /**
     * Método utilizado para agregar un comentario a la base 
     * de datos. El parámetro recibido ya contiene toda la 
     * inforación ingresada por el usuario,
     * @param comentario comentario a agregar por el usuario
     */
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
    
    /**
     * Método utilizado para un borrar un comentario de la base 
     * de datos, una vez que conocemos el id de dicho comentario.
     * 
     * @param comentario id del comentario a eliminar
     */
    public void deleteOnId(int comentario) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            String hql = "delete Comentario c where c.id_comentario= :comentario";
            Query query = sessionObj.createQuery(hql);
            query.setInteger("comentario", comentario);
            query.executeUpdate();
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
    
    /**
     * Método que modifica la descripción del comentario. Para esto
     * es necesario conocoer el id del comentario que se quiere 
     * modificar.
     * 
     * @param id               id del comentario
     * @param nuevaDescripcion nueva descripción
     */
    public void setDescripcion(int id, String nuevaDescripcion) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            //buscar la query adecuada
            String hql = "update Comentario c set c.descripcion= :nuevaDescripcion where c.id_comentario= :id";
            Query query = sessionObj.createQuery(hql);
            query.setParameter("nuevaDescripcion", nuevaDescripcion);
            query.setInteger("id", id);
            query.executeUpdate();
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
    
    /**
     * Método que modifica la calificación del comentario. Para 
     * esto es necesario conocoer el id del comentario que 
     * se quiere modificar.
     * 
     * @param id                id del comentario
     * @param nuevaCalificacion nueva califiación
     */
    public void setCalificacion(int id, int nuevaCalificacion) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            //buscar la query adecuada
            String hql = "update Comentario c set c.calificacion= :nuevaCalificacion where c.id_comentario= :id";
            Query query = sessionObj.createQuery(hql);
            query.setParameter("nuevaCalificacion", nuevaCalificacion);
            query.setInteger("id", id);
            query.executeUpdate();
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
    
    /*public void delete(Comentario comentario) {
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
    }*/
}
