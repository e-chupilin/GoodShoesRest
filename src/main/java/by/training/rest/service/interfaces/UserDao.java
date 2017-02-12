package by.training.rest.service.interfaces;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.ChangeUser;
import by.training.rest.service.business.exceptions.GoodShoesUserException;

public interface UserDao {
	
	User getUser(String login, String password) throws GoodShoesUserException;
	
	ChangeUser setUser(User user) throws GoodShoesUserException;	
	
	ChangeUser deleteUser(String login, String password) throws GoodShoesUserException;	
	
	void close();
	
}
