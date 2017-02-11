package by.training.rest.service.business.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.Role;
import by.training.rest.service.business.exceptions.GoodShoesUserException;
import by.training.rest.service.interfaces.UserDao;
import static by.training.rest.service.constants.Constants.*;

public class UserDaoMemory implements UserDao {
	private Collection<User> users = new ArrayList<User>();

	public UserDaoMemory() {
		User userOne = new User.Builder("capitan", "12345").name("Capitan America").phone("+37529111111")
				.role(Role.MANAGER).foto("URL").email("mail@mail.com").build();
		users.add(userOne);
	}

	@Override
	public User getUser(String login, String password) throws GoodShoesUserException {
		User searchUser = new User.Builder(login, password).build();
		for (User user : users) {
			if (user.equals(searchUser))
				return user;
		}
		throw new GoodShoesUserException(ERROR_USER_NOT_FOUND);
	}

	@Override
	public void setUser(User user) throws GoodShoesUserException {
		try {
			getUser(user.getLogin(), user.getPassword());
		} catch (GoodShoesUserException e) {
			users.add(user);
		}
	}

	@Override
	public void deleteUser(String login, String password) throws GoodShoesUserException {
		User searchUser = new User.Builder(login, password).build();

		for (Iterator it = users.iterator(); it.hasNext();) {
			User user = (User) it.next();
			if (searchUser.equals(user)) {
				it.remove();
			}
		}
		throw new GoodShoesUserException(ERROR_USER_NOT_FOUND);
	}
}