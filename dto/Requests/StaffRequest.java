package dto.Requests;

public class StaffRequest {
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
	
	public String toString(){
		return "Staff { "+
				       "\nName:==> " + getName() +
				       "\nJobTitle:==>"+ getJobTitle() +
					   "\nId:==> "+getId()+
				       "\nEmail:==> "+getEmail()+
					   "\nPassword:==> "+getPassword()+
				       "\nPhoneNumber:==> "+ getPhoneNumber() +
				       "\n}";
	}
}
