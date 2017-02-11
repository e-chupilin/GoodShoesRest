import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import by.training.rest.service.business.beans.User;

import by.training.rest.service.business.enums.Role;
import by.training.rest.service.hibernate.HibernateUtil;


public class TestHibernate {

	public static void main(String[] args) {	 
	        User user = new User.Builder("capitan Zero", "12345")
	        		.name("Capitan America 2")
	        		.email("qq@qq.com")
	        		.foto("URL")
	        		.role(Role.MANAGER)
	        		.phone("+375291305666")
	        		.build();
	        
	        UsersId userId = new UsersId(user);
	        Users users = new Users(userId);
	        
	        Session session = HibernateUtil.getSessionFactory().openSession();
			  
	        try {
	        session.beginTransaction();	        
	        
	        session.save(users);	        
	 
	      
	        session.getTransaction().commit();
	 
//	        Query q = session.createQuery("FROM Users");
	        Query q = session.createQuery("FROM Users AS E WHERE E.id.login = :ded_param");
	        q.setParameter("ded_param","capitan");
	                 
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
