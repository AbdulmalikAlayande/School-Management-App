package data.models;

import java.util.Objects;

public class Staffs {
	private String name;
	private String jobTitle;
	private String id;
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
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
		return "Staff{" + "name ==>'" + getName() + "\n" +
				       ", courses ==> " + getJobTitle() + "\n" +
				       ", id ==> " + getId() + "\n" +
				       ", email ==> '" + getEmail() + "\n" +
				       ", password==> '" + getPassword() + "\n" +
				       ", phoneNumber==> '" + getPhoneNumber() + "\n" +
				       "}";
	}
	
	@Override
	public boolean equals(Object anyObject){
		if (anyObject == null) return false;
		if (anyObject == this) return true;
		if (anyObject.getClass() != this.getClass()) return false;
		Staffs staff = (Staffs) anyObject;
		return Objects.equals(this.id, staff.id) && Objects.equals(this.name, staff.name) && Objects.equals(this.jobTitle, staff.jobTitle) && Objects.equals(this.email, staff.email)
				       && Objects.equals(this.password, staff.password) && Objects.equals(this.phoneNumber, staff.phoneNumber);
	}
}
