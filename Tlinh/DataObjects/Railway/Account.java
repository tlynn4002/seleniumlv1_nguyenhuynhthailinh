package Railway;


public class Account {
	private String Email;
	private String password;
	private String pid;
	
	public Account(String email,String password, String pid)
	{
		this.Email=email;
		this.password=password;
		this.pid=pid;
	}
	
	public Account(String email,String password)
	{
		this.Email=email;
		this.password=password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	
	
}
