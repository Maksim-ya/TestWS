
package com.mycompany.testws.dao;

import com.mycompany.testws.model.Person;
import com.mycompany.testws.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public Person getPersonById(int id){
        Person  person =null;
        Session session = null; 
        try{
         session = sessionFactory.openSession();
         session.beginTransaction();
         person= (Person) session.createQuery("from Person p where p.id = :id").setParameter("id",id).uniqueResult();
         session.getTransaction().commit();
                 }
        catch(Exception ex ){
            if (session!=null){
            session.getTransaction().rollback();
            }
        }
        finally{
        if (session!=null){
            session.close();
            }
        }
        
        
        return person ;        
    }
    
      public List<Person> getAllPersons(){
        List<Person>  persons =null;
        Session session = null; 
        try{
         session = sessionFactory.openSession();
         session.beginTransaction();
         persons =  session.createQuery("from Person p" ).list();
         session.getTransaction().commit();
                 }
        catch(Exception ex ){
            if (session!=null){
            session.getTransaction().rollback();
            }
        }
        finally{
        if (session!=null){
            session.close();
            }
        }
        
        
        return persons ;        
    }
}
