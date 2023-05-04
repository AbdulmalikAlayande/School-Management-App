package data.repositories;

import data.models.IdGenerator;
import data.models.Staffs;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static data.models.IdGenerator.A;
import static data.models.IdGenerator.Z;

public class TeachingStaffRepoImpl implements IStaffRepository {
	List<Staffs> listOfStaffs = new ArrayList<>();
	private int counter;
	
	@Override
	public void save(Staffs staff) {
		if (staff.getId() == null)
			saveNewStaff(staff);
		else if (staff.getId() != null || staff.getEmail() != null)
			updateStaffDetails(staff);
	}
	
	private void updateStaffDetails(Staffs staff) {
		for (Staffs eachStaff : listOfStaffs) {
			boolean isSavedStaff = Objects.equals(staff.getId(), eachStaff.getId()) || Objects.equals(staff.getEmail(), eachStaff.getEmail());
			if (isSavedStaff){
				listOfStaffs.remove(eachStaff);
				listOfStaffs.add(staff);
				break;
			}
		}
	}
	
	private void saveNewStaff(Staffs staff) {
		validateEmailWithRegex(staff.getEmail());
		staff.setId(generateId(0));
		listOfStaffs.add(staff);
	}
	
	private String validateEmailWithRegex(String email) {
		return regexEmailValidator(email);
	}
	
	public String generateId(int idIntValue){
		String staffId = null;
		int idDifferentiator =  idIntValue+ counter;
		for (IdGenerator id : EnumSet.range(A, Z))
			staffId =  id.ordinal() + "" +counter + idDifferentiator + "" + IdGenerator.values()[idIntValue + counter];
		counter++;
		return staffId;
	}
	
	@Override
	public int getStaffsCount() {
		return listOfStaffs.size();
	}
	
	@Override
	public Staffs findByEmail(String staffEmail) {
		for (Staffs eachStaff :
				listOfStaffs) {
			if (staffEmail.equals(eachStaff.getEmail()) )
				return eachStaff;
		}
		return null;
	}
	
	@Override
	public Staffs findById(String staffId) {
		for (Staffs eachStaff : listOfStaffs)
			if (staffId == eachStaff.getId())
				return eachStaff;
		return null;
	}
	
	public static String regexEmailValidator(String email) {
		if (email != null) {
			List<String> allowedDomains = List.of("gmail.com", "yahoo.com", "outlook.com");
			boolean isValid = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$").matcher(email).matches();
			if (!isValid || !allowedDomains.contains(email.split("@")[1].toLowerCase()))
				throw new IllegalArgumentException("This is not a valid email address");
		}
		return email;
	}
	
}
