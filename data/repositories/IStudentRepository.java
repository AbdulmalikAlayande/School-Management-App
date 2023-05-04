package data.repositories;

import data.models.Student;

public interface IStudentRepository {
	void save(Student student);
	int studentsCount();
	
	Student findByEmail(String studentEmail);
	Student findById(String studentId);
}
