package by.training.rest.service.interfaces;

import javax.ws.rs.core.Response;

public interface GoodShoesRsInterface {

	Response getUserJson(String login, String password);

	Response registerUserJson(String userRegInJson);
	
	Response getAllShoesJson();
}
