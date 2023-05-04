package service;

import data.models.Staffs;
import dto.Requests.StaffRequest;

public interface ITeacherService {
	Staffs RegisterNewStaff(StaffRequest request);
	Staffs findStaffsById(String staffId);
	
	Staffs findStaffByEmail(String staffEmail);
	void checkStudentResult(String teacherEmail, String teacherId, int StudentId);
	int getStaffCount();
	
}
