package tdd;

import data.models.Student;
import data.repositories.IStudentRepository;
import data.repositories.StudentRepoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepoTest {
	Student student;
	IStudentRepository studentRepo;
	@BeforeEach
	public void setUp(){
		student = new Student();
		studentRepo = new StudentRepoImpl();
	}
	
	@Test
	public void assertStudentExists(){
		assertNotNull(student);
	}
	
	@Test
	public void studentCanBeSavedToListOfStudents_CountIsIncrementedTest(){
		Student student1 = new Student();
		Student student2 = new Student();
		
		studentRepo.save(student1);
		studentRepo.save(student);
		studentRepo.save(student2);
		
		assertEquals(3, studentRepo.studentsCount());
		assertNotSame(student1, student);
		assertNotSame(student1, student2);
		assertNotSame(student2, student);
	}
	
	@Test
	public void updateTest(){
		Student student1 = new Student();
		studentRepo.save(student);
		studentRepo.save(student1);
		
		Student newStudent = new Student();
		Student newStudent1 = new Student();
		
		newStudent.setEmail("alaabdulmalik03@gmail.com");
		newStudent1.setEmail("alaabdulmalik03@outlook.com");
		newStudent.setId("02500A");
		newStudent1.setId("02501B");
		
		studentRepo.save(newStudent);
		studentRepo.save(newStudent1);
		
		assertEquals(2, studentRepo.studentsCount());
	}
	
	@Test
	@DisplayName("Find BY Email test")
	public void testThatStudentCanBeFoundBeyTheirEmail(){
		Student student = new Student();
		student.setEmail("alaabdulmalik03@gmail.com");
		studentRepo.save(student);
		Student foundStudent = studentRepo.findByEmail(student.getEmail());
		assertEquals(student, foundStudent);
		
	}
	
	@Test
	public void testThatStudentCanBeFoundByTheirId(){
		Student student1 = new Student();
		Student student2 = new Student();
		
		student.setId("02500A");
		student1.setId("02501B");
		student2.setId("02502C");
		
		studentRepo.save(student);
		studentRepo.save(student1);
		studentRepo.save(student2);
		
		Student foundStudent = studentRepo.findById(student.getId());
		Student foundStudent1 = studentRepo.findById(student1.getId());
		Student foundStudent2 = studentRepo.findById(student2.getId());
		
		assertSame(foundStudent, student);
		assertSame(foundStudent1, student1);
		assertSame(foundStudent2, student2);
		assertEquals(3, studentRepo.studentsCount());
	}
}
