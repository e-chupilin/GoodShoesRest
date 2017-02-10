package by.training.rest.service.business.enums;

public enum Rating {
	ONE, TWO, THREE, FOUR, FIVE;

	public String toString() {
		return this.name().toLowerCase();
	}
}
