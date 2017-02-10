package by.training.rest.service.business.beans;

import by.training.rest.service.business.enums.Role;
import static by.training.rest.service.constants.Constants.*;

public class User {
	
	private String login;
	private Role role;
	private String name;
	private String email;
	private String phone;
	private String foto;
	private String password;
	
	public User() {
		super();
	}
	
	private User(Builder b) {
		this.login = b.login;
		this.role = b.role;
		this.name = b.name;
		this.email = b.email;
		this.phone = b.phone;
		this.foto = b.foto;
		this.password = b.password;
		
	}

	public User(String login, Role role, String name, String email, String phone, String foto, String password) {
		super();
		this.login = login;
		this.role = role;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.foto = foto;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", role=" + role + "]";
	}	
	
	public class Builder {
		private String login;
		private Role role;
		private String name;
		private String email;
		private String phone;
		private String foto;
		private String password;
		
		public Builder(String login, String password) {
			this.login = login;
			this.password = password;
		}
		
		public Builder role(Role role) {
			this.role = role;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public Builder foto(String foto) {
			this.foto = foto;
			return this;
		}
		
		public User buld() {
			return new User(this);
		}
		
		
	}
	
	
}
