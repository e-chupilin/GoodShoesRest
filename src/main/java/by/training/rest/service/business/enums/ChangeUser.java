package by.training.rest.service.business.enums;

public enum ChangeUser {
	OK, LOGIN_BUSY, ERROR_SET, ERROR_DELETE;

	public String toString() {
		return this.name().toLowerCase();
	}

}
