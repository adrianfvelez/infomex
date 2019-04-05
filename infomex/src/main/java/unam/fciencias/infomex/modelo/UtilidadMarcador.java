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
 * @author avelez
 */
public class UtilidadMarcador {
    
    static Marcador marcObj;
    static Session sessionObj;
    
        public List<Marcador> getTodosMarcadores(){
        List<Marcador> obj = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();

        try{
            sessionObj.beginTransaction();
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"1"+"\n\n\n\n\n\n\n");
            String hql = "FROM Marcador";
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"2"+"\n\n\n\n\n\n\n");
            Query query = sessionObj.createQuery(hql);
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"3"+"\n\n\n\n\n\n\n");
            obj = (List<Marcador>)query.list();
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
    
    public void save(Marcador marca) {
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(marca);
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
