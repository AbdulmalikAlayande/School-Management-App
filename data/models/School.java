package data.models;

import java.util.List;

public class School {
	private List<Student> students;
	private List<Staffs> staffs;
	private List<NonTeachingStaffs> teachers;
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public List<Staffs> getStaffs() {
		return staffs;
	}
	
	public void setStaffs(List<Staffs> staffs) {
		this.staffs = staffs;
	}
	
	public List<NonTeachingStaffs> getTeachers() {
		return teachers;
	}
	
	public void setTeachers(List<NonTeachingStaffs> teachers) {
		this.teachers = teachers;
	}
}
