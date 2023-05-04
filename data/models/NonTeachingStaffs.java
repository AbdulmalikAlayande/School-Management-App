package data.models;

public class NonTeachingStaffs {
	private String name;
	private String jobTitle;
	private int id;
	private String email;
	private String password;
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Students{" + "name ==>'" + getName() + "\n" +
				       ", courses ==> " + getJobTitle() + "\n" +
				       ", id ==> " + getId() + "\n" +
				       ", email ==> '" + getEmail() + "\n" +
				       ", password==> '" + getPassword() + "\n" +
				       ", phoneNumber==> '" + getPhoneNumber() + "\n" +
				       "}";
	}
}
