package data.repositories;

import data.models.IdGenerator;
import data.models.Staffs;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

import static data.models.IdGenerator.*;

public class NonTeachingStaffRepoImpl implements IStaffRepository{
	List<Staffs> listOfStaffs = new ArrayList<>();
	private int counter;
	
	@Override
	public void save(Staffs staff) {
		if (staff.getId() == null)
			saveNewStaff(staff);
		else if (!(staff.getId() == null || staff.getEmail() == null))
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
		staff.setId(generateId(0));
		listOfStaffs.add(staff);
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
			if (Objects.equals(staffEmail, eachStaff.getEmail()))
				return eachStaff;
		}
		return null;
	}
	
	@Override
	public Staffs findById(String staffId) {
		for (Staffs eachStaff : listOfStaffs)
			if (Objects.equals(staffId, eachStaff.getId()))
				return eachStaff;
		return null;
	}
	
}
