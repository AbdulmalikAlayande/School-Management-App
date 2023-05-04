package data.repositories;

import data.models.IdGenerator;
import data.models.Student;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

import static data.models.IdGenerator.*;

public class StudentRepoImpl implements IStudentRepository{
	List<Student> studentList = new ArrayList<>();
	private int counter;
	
	
	@Override
	public void save(Student student) {
		if (student.getEmail() != null && student.getId() != null) updateStudent(student);
		else saveNewStudent(student);
	}
	
	private void saveNewStudent(Student newStudent) {
		newStudent.setId(generateId(studentsCount()));
		studentList.add(newStudent);
	}
	
	private String generateId(int idValue) {
		String studentId = null;
		String firstIdChar = "0";
		int idDifferentiator =  idValue+ counter;
		for (IdGenerator id : EnumSet.range(A, Z))
			studentId =  firstIdChar + id.ordinal() + "" +counter + idDifferentiator + "" + IdGenerator.values()[idValue + counter];
		System.out.println(studentId);
		return studentId;
	}
	
	private void updateStudent(Student updatedStudent) {
		for (Student student : studentList) {
			if (updatedStudent.getEmail().equals(student.getEmail()) || Objects.equals(updatedStudent.getId(), student.getId())) {
				studentList.add(studentList.indexOf(student), updatedStudent);
				studentList.remove(student);
				return;
			}
		}
	}
	
	@Override
	public int studentsCount() {
		return studentList.size();
	}
	
	@Override
	public Student findByEmail(String studentEmail) {
		for (Student student: studentList)
			if (studentEmail == student.getEmail())
				return student;
		return null;
	}
	
	@Override
	public Student findById(String studentId) {
		for (Student student: studentList)
			if (studentId == student.getId())
				return student;
		return null;
	}
}
