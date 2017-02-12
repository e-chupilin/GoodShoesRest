import by.training.rest.service.business.beans.User;

import by.training.rest.service.business.enums.Role;
import by.training.rest.service.business.implementation.UserDaoMemory;
import by.training.rest.service.hibernate.Users;
import by.training.rest.service.hibernate.UsersId;
import by.training.rest.service.interfaces.UserDao;

public class TestHibernate {

	public static void main(String[] args) {
		
		User user = new User.Builder("ded", "1222345").name("Capitan America").email("22qq@qq.com")
				.foto("22URL").role(Role.MANAGER).phone("+375291305666").build();

		UsersId userId = new UsersId();
		Users users = new Users(userId);


		try {
			
			//session.beginTransaction();
			// session.save(users);
//			session.getTransaction().commit();

			System.out.println("Test UserDaoSql: ");
			UserDao sql = new UserDaoMemory();
			
			System.out.println(sql.getUser("daed", "12345"));			
			System.out.println(sql.setUser(user));			
			System.out.println(sql.deleteUser("capitan", "12345"));			

		} catch (Exception e) {
			System.out.println("MYSQL: " + e.getMessage());
		}
	}
}
