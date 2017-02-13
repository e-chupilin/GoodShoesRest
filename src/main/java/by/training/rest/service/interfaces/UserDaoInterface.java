package by.training.rest.service.interfaces;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.ChangeUser;
import by.training.rest.service.business.exceptions.UserException;

public interface UserDaoInterface {
	
	User getUser(String login, String password) throws UserException;
	
	ChangeUser setUser(User user) throws UserException;	
	
	ChangeUser deleteUser(String login, String password) throws UserException;	
	
	void close();
	
}
