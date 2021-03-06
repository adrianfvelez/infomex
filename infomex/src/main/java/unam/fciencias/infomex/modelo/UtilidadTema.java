/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import java.util.ArrayList;
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
    
    public void eliminaTema(Tema tema){
        String nombre = tema.getNombre_tema().toUpperCase();
       // System.out.println(nombre);
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
    
    public ArrayList<Tema> MostrarTemas(String tema){
        String hql = "from Tema t where t.nombre_tema = :nombre";
        Query query = sessionObj.createQuery(hql);
        //query.setParameter("tema", tema);
        ArrayList<Tema> temas = (ArrayList<Tema>) query.list();
        return temas;
    }
}
