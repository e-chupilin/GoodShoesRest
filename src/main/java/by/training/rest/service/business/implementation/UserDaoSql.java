package by.training.rest.service.business.implementation;
import static by.training.rest.service.constants.Constants.*;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.Role;
import by.training.rest.service.business.enums.ChangeUser;
import by.training.rest.service.business.exceptions.GoodShoesUserException;
import by.training.rest.service.hibernate.HibernateUtil;
import by.training.rest.service.hibernate.Users;
import by.training.rest.service.hibernate.UsersId;
import by.training.rest.service.interfaces.UserDao;

public class UserDaoSql implements UserDao {
	private Session session = null;
	private Query query = null;
	private static final Logger LOGGER = Logger.getLogger(UserDaoSql.class);

	public UserDaoSql() {
		super();
		session = HibernateUtil.getSessionFactory().openSession();		
		LOGGER.info("Create sql session.");
	}
	
	public void close() {
		if (session != null) {
			LOGGER.info("Close sql session. ");
			session.close();
		}
	}

	public User getUser(String login, String password) throws GoodShoesUserException {
		
		try {
			session.beginTransaction();
			query = session.createQuery(SQL_GET_USER_BY_LOGIN);
			query.setParameter(SQL_LOGIN_PARAM, login);
			Collection<Users> users = query.list();

			for (Users iterUsers : users) {
				if (iterUsers.getId().getLogin().equals(login)) {
					User returnUser = usersToUser(iterUsers);
					LOGGER.info("Return from UserDaoSql: " + returnUser.toString());
					session.cancelQuery();
					return returnUser;
				}
			}
			LOGGER.info("User not found in sql");
			return null;
		} catch (RuntimeException e) {
			LOGGER.error("Error get user from sql: " + e.getMessage());
			throw new GoodShoesUserException(e.getMessage());
		} finally {				
			//	session.close();
		}
	}

	public ChangeUser setUser(User user) throws GoodShoesUserException {
		if (getUser(user.getLogin(), user.getPassword()) == null) {
			UsersId userId = new UsersId(user);
			Users users = new Users(userId);
			try {
				session.beginTransaction();
				session.save(users);
				session.getTransaction().commit();
				LOGGER.info("Ok to set user: " + user);
				return ChangeUser.OK;
			} catch (Exception e) {
				LOGGER.error("Error write user data to sql.", e);
				return ChangeUser.ERROR_SET;
			} finally {
				//	session.close();
				
			}			
		} else {
			LOGGER.info("User not set. Login is busy: " + user.getLogin());
			return ChangeUser.LOGIN_BUSY;
		}
	}

	public ChangeUser deleteUser(String login, String password) throws GoodShoesUserException {
		User userToDel = getUser(login, password);
		if (userToDel != null) {
		
			UsersId userId = new UsersId(userToDel);
			Users users = new Users(userId);
			
			LOGGER.info("Try to delete: " + login);
			try {
				session.beginTransaction();
				session.delete(users);
				session.getTransaction().commit();
				LOGGER.info("Ok to delete user: " + login);
				return ChangeUser.OK;
			} catch (Exception e) {
				LOGGER.error("Error delete user: " + e.getMessage());
				return ChangeUser.ERROR_DELETE;
			} finally {
				//	session.close();				
			}			

			
		}
		else {
			LOGGER.info("Delete error. User not found: " + login);
			return ChangeUser.ERROR_DELETE;
		}
	}

	private static User usersToUser(Users users) {
		UsersId id = users.getId();
		return new User.Builder(id.getLogin(), id.getPassword()).email(id.getEmail()).foto(id.getFoto())
				.name(id.getName()).phone(id.getPhone()).role(Role.valueOf(id.getRole())).build();
	}
}
