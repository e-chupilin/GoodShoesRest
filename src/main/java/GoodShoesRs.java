import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import by.training.rest.service.business.beans.User;
import by.training.rest.service.business.enums.Role;
import by.training.rest.service.hibernate.HibernateUtil;

import static by.training.rest.service.constants.Constants.*;

@Path("/")

public class GoodShoesRs {
	
	private ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOGGER = Logger.getLogger(GoodShoesRs.class);

	@GET
	@Path("/getUser/")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getUserInJSON(@QueryParam("username") String login, @QueryParam("password") String password) {
		LOGGER.info("getUser : " + login + DASH + password);
		
		String userAsJson = "{error:error}";

		User user = new User();
		user.setLogin("kapitan");
		user.setName("America");
		user.setEmail("");
		user.setFoto("");
		user.setPassword("");
		user.setPhone("");
		user.setRole(Role.BUYER);
		
		try {
			userAsJson = mapper.writeValueAsString(user);
			LOGGER.info("Return : " + user);
			return Response.status(Status.OK).entity(userAsJson).build();
			
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(IO_ERROR_JSON).build();
		} 
		
	}
}