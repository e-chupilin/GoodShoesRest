package by.training.rest.service.business.enums;

public enum Category {
		ALL, BOOTS, SPORT, LOW_SHOES ;

		public String toString() {
			return this.name().toLowerCase();
		}
}
