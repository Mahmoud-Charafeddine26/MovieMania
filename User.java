package Main;

public class User {

	private String Username, Password, Admin;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAdmin() {
		return Admin;
	}

	public void setAdmin(String admin) {
		Admin = admin;
	}

	public User(String username, String password, String admin) {
		super();
		Username = username;
		Password = password;
		Admin = admin;
	}
	
	
	
}
