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
 * @author oscar
 */
public class UtilidadTema {
    
    static Tema userObj;
    static Session sessionObj;
    
    /**
     * Método que elimina un Tema de la base de Datos.
     * @param tema 
     */
    public void eliminaTema(Tema tema){
        String nombre = tema.getNombre_tema();
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        
        try{
            sessionObj.beginTransaction();
            String hql = "delete Tema t where t.nombre_tema = :nombre";
            Query query = sessionObj.createQuery(hql);
            query.setString("nombre", nombre);
            query.executeUpdate();
            sessionObj.getTransaction().commit();
            
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
        //return 0;
    }
    
    /**
     * Método que busca un Tema en la base de datos.
     * @param tema
     * @return Un objeto de tipo Tema
     */
    public Tema buscaTemaPorNombre(Tema tema){
        String nombre = tema.getNombre_tema();
        Tema obj = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
        
        try{
            sessionObj.beginTransaction();
            String hql = "from Tema t where t.nombre_tema = :nombre";
            Query query = sessionObj.createQuery(hql);
            query.setString("nombre", nombre);
            obj = (Tema)query.uniqueResult();
            sessionObj.getTransaction().commit();
           
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
        return obj;
    }
    
    /**
     * Método que regresa una lista llena de todos los temas en las base de datos.
     * @return Una lista de tipo Tema
     */
    public List<Tema> getTodosTemas(){
        List<Tema> obj = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();

        try{
            sessionObj.beginTransaction();
            String hql = "FROM Tema";
            Query query = sessionObj.createQuery(hql);
            obj = (List<Tema>)query.list();
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
    
    /**
     * Método que guarda un objeto Tema en la base de datos.
     * @param tema 
     */
    public void save(Tema tema) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(tema);
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
     * Método que borra un objeto de la base de datos.
     * @param tema 
     */
    public void delete(Tema tema) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.delete(tema);
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
