package data.repositories;

import data.models.Staffs;

public interface IStaffRepository {
	
	void save(Staffs staff);
	int getStaffsCount();
	Staffs findByEmail(String staffEmail);
	Staffs findById(String staffId);
}
