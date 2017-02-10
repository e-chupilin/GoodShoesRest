package by.training.rest.service.business.implementation;

import java.util.ArrayList;
import java.util.Collection;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.Role;
import by.training.rest.service.business.exceptions.GoodShoesUserException;
import by.training.rest.service.interfaces.UserDao;

public class UserDaoMemory implements UserDao{
	private Collection <User> users = new ArrayList<User>();
	
	UserDaoMemory() {
		User userOne = new User.Builder("capitan", "12345")
				.name("Capitan America")
				.phone("+37529111111")
				.role(Role.MANAGER)
				.foto("URL")
				.email("mail@mail.com")
				.buld();
	}

	@Override
	public User getUser(String login, String password) throws GoodShoesUserException {
		return null;
	}

	@Override
	public void setUser(User user) throws GoodShoesUserException {
		
	}

}
