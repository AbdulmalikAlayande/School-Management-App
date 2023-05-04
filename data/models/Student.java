package data.models;

import java.util.List;
import static data.repositories.TeachingStaffRepoImpl.regexEmailValidator;

public class Student {
	private String name;
	private String id;
	private String email;
	private String password;
	private String phoneNumber;
	private List<Courses> courses;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		regexEmailValidator(email);
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
	
	public List<Courses> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Students{" + "name ==>'" + getName() + "\n" +
				            ", id ==> " + getId() + "\n" +
				            ", email ==> '" + getEmail() + "\n" +
				            ", password==> '" + getPassword() + "\n" +
				            ", phoneNumber==> '" + getPhoneNumber() + "\n" +
				            ", courses ==> " + getCourses() + "\n" +
							"}";
	}
}
