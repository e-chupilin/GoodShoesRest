
import static by.training.rest.service.constants.Constants.*;

import java.io.IOException;
import java.util.Collection;

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

import by.training.rest.service.business.beans.Shoes;
import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.AccessType;
import by.training.rest.service.business.factories.ShoesDaoFactory;
import by.training.rest.service.business.factories.UserDaoFactory;
import by.training.rest.service.interfaces.GoodShoesRsInterface;
import by.training.rest.service.interfaces.ShoesDaoInterface;
import by.training.rest.service.interfaces.UserDaoInterface;

@Path("/")

public class GoodShoesRs implements GoodShoesRsInterface {

	private ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOGGER = Logger.getLogger(GoodShoesRs.class);
	private UserDaoInterface userDao = UserDaoFactory.getAccessObject(AccessType.MEMORY);

	@GET
	@Path("/getUser/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserJson(@QueryParam("username") String login, @QueryParam("password") String password) {
		LOGGER.info("Rest request to get user: " + login + DASH + password);
		User user = userDao.getUser(login, password);

		if (user == null) {
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

	@POST
	@Path("/registerUser/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUserJson(String userRegInJson) {
		User userReg = null;
		try {
			LOGGER.info("Rest request to register user: " + userRegInJson);
			userReg = mapper.readValue(userRegInJson, User.class);

			if (!checkRegData(userReg) || userDao.getUser(userReg.getLogin(), userReg.getPassword()) != null) {
				LOGGER.info("Check error or login busy.");
				return Response.status(Status.SERVICE_UNAVAILABLE).entity(ERROR_JSON_REGISTER_LOGIN).build();
			}
			userDao.setUser(userReg);
			return Response.status(Status.OK).entity(OK_JSON_REGISTER).build();

		} catch (IOException e) {
			LOGGER.error("Invalid data: " + e.getMessage());
			return Response.status(Status.SERVICE_UNAVAILABLE).entity(ERROR_JSON_REGISTER).build();
		}
	}

	private boolean checkRegData(User userReg) {
		LOGGER.info("Check registration data.");
		if (MANAGER_LOGINS.contains(userReg.getLogin())) {
			LOGGER.info("Login busy by managers: " + userReg.getLogin());
			return false;
		}

		if (userReg.getLogin() == null || userReg.getEmail() == null || userReg.getPassword() == null) {
			LOGGER.info("Login, mail and pass can`t be empty.");
			return false;
		}
		return true;
	}

	@GET
	@Path("/getAllShoes/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllShoesJson() {
		LOGGER.info("Try to get all shoes.");
		ShoesDaoInterface dao = ShoesDaoFactory.getAccessObject(AccessType.MEMORY);
		try {
			Collection<Shoes> shoesList = dao.getAll();
			String ShoesAsJson = mapper.writeValueAsString(shoesList);
			LOGGER.info("Return shoes list. Size: " + shoesList.size());
			return Response.status(Status.OK).entity(ShoesAsJson).build();						
		} catch (IOException e) {
			LOGGER.error("Error get shoes list: " + e.getMessage());
			return Response.status(Status.SERVICE_UNAVAILABLE).entity(ERROR_JSON_GET_ALL).build();
		}
	}
}
