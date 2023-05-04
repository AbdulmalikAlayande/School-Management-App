package service;

import data.models.Staffs;
import data.repositories.IStaffRepository;
import data.repositories.TeachingStaffRepoImpl;
import dto.Requests.StaffRequest;

public class TeachingStaffServiceImpl implements ITeacherService{
	private IStaffRepository staffRepo = new TeachingStaffRepoImpl();
	
	@Override
	public Staffs RegisterNewStaff(StaffRequest request) {
		Staffs staffs = new Staffs();
		staffs.setName(request.getName());
		staffs.setEmail(request.getEmail());
		staffs.setPassword(request.getPassword());
		staffs.setJobTitle(request.getJobTitle());
		staffs.setPhoneNumber(request.getPhoneNumber());
		staffRepo.save(staffs);
		return staffs;
	}
	@Override
	public Staffs findStaffsById(String staffId){
		return staffRepo.findById(staffId);
	}
	
	@Override
	public Staffs findStaffByEmail(String staffEmail) {
		return staffRepo.findByEmail(staffEmail);
	}
	
	public void checkStudentResult(String teacherEmail, String teacherId, int StudentId) {
	
	}
	
	@Override
	public int getStaffCount() {
		return staffRepo.getStaffsCount();
	}
}
