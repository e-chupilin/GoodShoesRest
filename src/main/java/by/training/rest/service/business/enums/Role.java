package by.training.rest.service.business.enums;

public enum Role {	
	BUYER, MANAGER;

		public String toString() {
			return this.name().toLowerCase();
		}

		public boolean equals(Role role) {
			if (role == null) {
				return false;
			}
			
			if (this == role) {
				return true;
			}
			if (this.name().equals(role.name())) {
				return true;
			}
			return false;
		}
	}
