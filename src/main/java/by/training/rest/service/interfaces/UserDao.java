package by.training.rest.service.interfaces;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.exceptions.GoodShoesUserException;

public interface UserDao {
	
	User getUser(String login, String password) throws GoodShoesUserException;
	
	void setUser(User user) throws GoodShoesUserException;	

}
