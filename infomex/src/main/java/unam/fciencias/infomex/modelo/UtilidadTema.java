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
            //sessionObj.getTransaction().commit();
            
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
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"1"+"\n\n\n\n\n\n\n");
            String hql = "FROM Tema";
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"2"+"\n\n\n\n\n\n\n");
            Query query = sessionObj.createQuery(hql);
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"3"+"\n\n\n\n\n\n\n");
            obj = (List<Tema>)query.list();
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
}
