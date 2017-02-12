

import static by.training.rest.service.constants.Constants.*;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.factories.UserDaoFactory;
import by.training.rest.service.business.factories.UserDaoFactory.Type;
import by.training.rest.service.interfaces.UserDao;

@Path("/")

public class GoodShoesRs {
	
	private ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOGGER = Logger.getLogger(GoodShoesRs.class);

	@GET
	@Path("/getUser/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response getUserInJSON(@QueryParam("username") String login, @QueryParam("password") String password) {
		LOGGER.info("Rest response to get user: " + login + DASH + password);		
		UserDao userDao = UserDaoFactory.getAccessObject(Type.MEMORY);		
		User user = userDao.getUser(login, password);
		
		if ( user == null ) {
			LOGGER.info("User not found: " + login + DASH + password);
			return Response.status(Status.SERVICE_UNAVAILABLE).entity(ERROR_JSON_USER_NOT_FOUND).build();
		}
		
		try {
			String userAsJson = mapper.writeValueAsString(user);
			LOGGER.info("User found. Return : " + user);
			return Response.status(Status.OK).entity(userAsJson).build();
			
		} catch (IOException e) {
			LOGGER.error("Error get user from UserDao: " + userDao.getClass().getName());
			LOGGER.error("Error: " + e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(ERROR_JSON_IO).build();
		} 
		
	}
}