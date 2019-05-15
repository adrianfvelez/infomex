/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author a-valderrama
 */
public class UtilidadComentario {
    
    static Comentario comObj;
    static Session sessionObj;

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
    
    public List<Comentario> getComentarios(){
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        
        List<Comentario> obj = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();

        try{
            sessionObj.beginTransaction();
            String hql = "FROM Comentario where id=:id";
            Query query = sessionObj.createQuery(hql);
            query.setString("id", i.getCorreo_com());
            obj = (List<Comentario>)query.list();
            sessionObj.getTransaction().commit();
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
}
