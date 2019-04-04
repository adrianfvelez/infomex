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
    
    public int getId(){
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
                return 1;
            }else{
                return obj.get(obj.size()-1).getId_tema()+1;
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
        return 0;
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
}
