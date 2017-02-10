import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.Role;
import by.training.rest.service.hibernate.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {	 
	        UsersId userId = new UsersId();
	        
	        userId.setLogin("ded");
	        userId.setRole(Role.BUYER.name());
	        userId.setName("Ded name");
	        userId.setEmail("ded@email.com");
	        userId.setFoto("ded foto");
	        userId.setPassword("12345");
	        userId.setPhone("+37529111111");
	        
	        Users user = new Users();
	        user.setId(userId);
	        
	        Session session = HibernateUtil.getSessionFactory().openSession();
			  
	        try {
	        session.beginTransaction();	        
	                
//	        session.save(user);	        
	 
	      
	        session.getTransaction().commit();
	 
//	        Query q = session.createQuery("FROM Users");
	        Query q = session.createQuery("FROM Users AS E WHERE E.id.login = :ded_param");
	        q.setParameter("ded_param","dedq");
	                 
	        Collection <Users> resultList = q.list();
	        System.out.println("num of user:" + resultList.size());
	        
	        for (Users nextUser : resultList) {
	            System.out.println("next user: " + nextUser.getId().getLogin());
	        }
	        
	        } catch (Exception e) {
	        	System.out.println("MYSQL: " + e.getMessage());
	        }	
	}
}
