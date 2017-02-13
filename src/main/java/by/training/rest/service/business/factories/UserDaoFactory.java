package by.training.rest.service.business.factories;

import by.training.rest.service.business.enums.AccessType;
import by.training.rest.service.business.implementation.UserDaoMemory;
import by.training.rest.service.business.implementation.UserDaoSql;
import by.training.rest.service.interfaces.UserDaoInterface;

public class UserDaoFactory {
	private static UserDaoInterface objUser = null;

	public static UserDaoInterface getAccessObject(AccessType type) {
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