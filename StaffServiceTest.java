package tdd;

import dto.Requests.StaffRequest;
import org.junit.jupiter.api.*;
import service.*;
import static org.junit.jupiter.api.Assertions.*;

public class StaffServiceTest {
	ITeacherService teacherService;
	StaffRequest request;
	
	@BeforeEach
	public void setUp(){
		teacherService = new TeachingStaffServiceImpl();
		request = new StaffRequest();
	}
	
	@Test
	public void testThatStaffExists(){
		assertNotNull(teacherService);
		assertNotNull(request);
	}
	
	@Test
	public void testThatStaffCanRegister_CountIsIncrementedBy1(){
		request.setName("Alayande Abdulmalik");
		request.setEmail("alaabdulmalik03@gmail.com");
		request.setPassword("ayanniyi20");
		request.setPhoneNumber("07036174617");
		request.setJobTitle("H.O.D (Systems Engineering Department)");
		teacherService.RegisterNewStaff(request);
		assertEquals(1, teacherService.getStaffCount());
		
		StaffRequest request1 = new StaffRequest();
		request1.setName("Alayande Abdulmalik");
		request1.setEmail("alaabdulmalik03@gmail.com");
		request1.setPassword("ayanniyi20");
		request1.setPhoneNumber("07036174617");
		request1.setJobTitle("H.O.D (Systems Engineering Department)");
		teacherService.RegisterNewStaff(request1);
		System.out.println(request+"\n"+request1);
		assertEquals(2, teacherService.getStaffCount());
	}
	
	@Test
	@DisplayName("Update Test")
	public void testThatUserCanUpdateTheirDetails(){
		request.setName("Alayande jnr");
		request.setEmail("alaabdulmalik03@gmail.com");
		request.setPassword("ayanniyi20");
		request.setPhoneNumber("07036174617");
		request.setJobTitle("H.O.D (Systems Engineering Department)");
		teacherService.RegisterNewStaff(request);
		assertEquals(1, teacherService.getStaffCount());
		
		StaffRequest request1 = new StaffRequest();
		request1.setName("Alayande Abdulmalik");
		request1.setEmail("alaabdulmalik03@gmail.com");
		request1.setPassword("ayanniyi20");
		request1.setPhoneNumber("07036174617");
		
		request1.setJobTitle("H.O.D (Systems Engineering Department)");
		teacherService.RegisterNewStaff(request1);
		System.out.println(request+"\n"+request1);
		assertEquals(1, teacherService.getStaffCount());
		assertEquals(request1, request);
	}
}
