package by.training.rest.service.business.factories;

import by.training.rest.service.business.implementation.UserDaoMemory;
import by.training.rest.service.business.implementation.UserDaoSql;
import by.training.rest.service.interfaces.UserDao;

public class UserDaoFactory {

	public enum Type {
		MEMORY, SQL;
	}

	public static UserDao getAccessObject(UserDaoFactory.Type type) {
		switch (type) {
		case MEMORY:
			return new UserDaoMemory();
		case SQL:
			return new UserDaoSql();
		default:
			throw new RuntimeException("Unsupported dao type.");
		}
	}
}