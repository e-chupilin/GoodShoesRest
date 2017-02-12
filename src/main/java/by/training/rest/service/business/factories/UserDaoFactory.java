package by.training.rest.service.business.factories;

import by.training.rest.service.business.implementation.UserDaoMemory;
import by.training.rest.service.business.implementation.UserDaoSql;
import by.training.rest.service.interfaces.UserDao;

public class UserDaoFactory {
	private static UserDao objUser = null;

	public enum Type {
		MEMORY, SQL;
	}

	public static UserDao getAccessObject(UserDaoFactory.Type type) {
		switch (type) {
		
		case MEMORY: {
			if (objUser == null) {
				objUser = new UserDaoMemory();
			}
			return objUser;
		}
		
		case SQL: {
			if (objUser == null) {
				objUser = new UserDaoSql();
			}
			return objUser;
		}
		default:
			throw new RuntimeException("Unsupported dao type.");
		}
	}
}