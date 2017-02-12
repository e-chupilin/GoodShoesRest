package by.training.rest.service.business.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.Role;
import by.training.rest.service.business.enums.ChangeUser;
import by.training.rest.service.business.exceptions.GoodShoesUserException;
import by.training.rest.service.interfaces.UserDao;
import static by.training.rest.service.constants.Constants.*;

public class UserDaoMemory implements UserDao {
	private Collection<User> users = new ArrayList<User>();
	private static final Logger LOGGER = Logger.getLogger(UserDaoMemory.class);

	public UserDaoMemory() {
		User userOne = new User.Builder("capitan", "12345").name("Capitan America").phone("+37529111111")
				.role(Role.MANAGER).foto("URL").email("mail@mail.com").build();
		users.add(userOne);
		LOGGER.info("Create UserDaoMemory, add: " + userOne);
	}

	
	public User getUser(String login, String password) throws GoodShoesUserException {
		User searchUser = new User.Builder(login, password).build();
		for (User user : users) {
			if (user.equals(searchUser)) {
				LOGGER.info("Get User from UserDaoMemory :" + user.toString());
				return user;
			}
		}
		LOGGER.info("User not found. Return null :" + login);
		return null;
//		throw new GoodShoesUserException(ERROR_USER_NOT_FOUND);
	}

	
	public ChangeUser setUser(User user) throws GoodShoesUserException {
		if (getUser(user.getLogin(), user.getPassword()) == null) {
			users.add(user);
			LOGGER.info("Ok set user in memory :" + user.toString());
			return ChangeUser.OK;
		} else {
			LOGGER.info("Error set user in memory. Login busy :" + user.toString());
			return ChangeUser.LOGIN_BUSY;
		}
	}

	
	public ChangeUser deleteUser(String login, String password) throws GoodShoesUserException {
		User searchUser = new User.Builder(login, password).build();

		for (Iterator it = users.iterator(); it.hasNext();) {
			User user = (User) it.next();
			if (searchUser.equals(user)) {
				LOGGER.info("Ok to delete: " + login);
				it.remove();
				return ChangeUser.OK;
			}
		}
		LOGGER.info("Delete error. User not found: " + login);
		return ChangeUser.ERROR_DELETE;
	}

	
	public void close() {
		users.clear();		
	}
}