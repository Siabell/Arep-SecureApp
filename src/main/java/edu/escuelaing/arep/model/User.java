package edu.escuelaing.arep.model;

public class User {

    private String name;
    private String email;
    private String userName;
    private String password;
    private String passEncrypt;
    
	public User(String password, String userName) {
		this.password = password;
		this.userName = userName;
		
	}

	public User() {}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassEncrypt() {
		return passEncrypt;
	}

	public void setPassEncrypt(String passEncrypt) {
		this.passEncrypt = passEncrypt;
	}

    
}
