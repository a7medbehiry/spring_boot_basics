package com.amb.amb.repository;
import java.util.ArrayList;
import java.util.List;
import com.amb.amb.Constants;
import com.amb.amb.Staff;

public class StaffRepository {
    private List<Staff> allStaff = new ArrayList<>();

    public void addStaff(Staff staff) {
        allStaff.add(staff);
    }

    public void updateStaff(Staff staff, int index) {
        allStaff.set(index, staff);
    }

    public int getStaffIndex(String id) {

        for (int i = 0; i < allStaff.size(); i++) {
            if (allStaff.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NO_MATCH;
    }

    public List<Staff> getAllStaff() {
        return allStaff;
    }

}
