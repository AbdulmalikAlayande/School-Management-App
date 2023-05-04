package tdd;

import data.models.Staffs;
import data.repositories.IStaffRepository;
import data.repositories.NonTeachingStaffRepoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonTeachingStaffRepoTest {
	
	Staffs staff;
	IStaffRepository staffRepo;
	
	@BeforeEach
	public void setUp(){
//		Given That I have staffs
		staff = new Staffs();
		staffRepo = new NonTeachingStaffRepoImpl();
	}
	
	@Test
	@DisplayName("Staff exists test")
	public void testThatStaffExist(){
		assertNotNull(staff);
	}
	
	@Test
	@DisplayName("Save new Staff test")
	public void testThatStaffCanBeSavedAndCountIsIncrementedByOne(){
		staffRepo.save(staff);
		System.out.println(staff);
		assertEquals(1, staffRepo.getStaffsCount());
		Staffs staff2 = new Staffs();
		staffRepo.save(staff2);
		assertEquals(2, staffRepo.getStaffsCount());
		assertNotSame(staff2, staff);
		assertNotSame(staff2.getId(), staff.getId());
	}
	
	@Test
	@DisplayName("Update test")
	public void removeStaff_SaveNewStaffTest(){
		Staffs staff2 = new Staffs();
		Staffs foundStaff = new Staffs();
		Staffs foundStaff2 = new Staffs();
		
		staffRepo.save(staff);
		staffRepo.save(staff2);
		
		foundStaff.setId("2500A");
		foundStaff2.setId("2511B");
		
		staffRepo.save(foundStaff);
		staffRepo.save(foundStaff2);
		
		assertEquals(2, staffRepo.getStaffsCount());
		assertEquals(staff2, foundStaff2);
		assertEquals(staff, foundStaff);
	}
	
	@Test
	@DisplayName("Find By email test")
	public void findByEmail_StaffIsFoundTest(){
		Staffs staff2 = new Staffs();
		
		staff.setEmail("alaabdulmalik03@gmail.com");
		staff2.setEmail("alaabdulmalik03@outlook.com");
		
		staffRepo.save(staff);
		staffRepo.save(staff2);
		
		Staffs foundStaff = staffRepo.findByEmail(staff.getEmail());
		Staffs foundStaff2 = staffRepo.findByEmail(staff2.getEmail());
		
		assertSame(staff, foundStaff);
		assertSame(staff2, foundStaff2);     
		assertEquals(2, staffRepo.getStaffsCount());
		
	}
	
	@Test
	@DisplayName("Find By id test")
	public void findById_StaffIsFoundTest(){
		Staffs staff2 = new Staffs();
		
		staffRepo.save(staff);
		staffRepo.save(staff2);
		
		Staffs foundStaff = staffRepo.findById(staff.getId());
		Staffs foundStaff2 = staffRepo.findById(staff2.getId());
		
		assertSame(staff, foundStaff);
		assertSame(staff2, foundStaff2);
		assertEquals(2, staffRepo.getStaffsCount());
		
	}
}