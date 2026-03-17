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

    public void save(Staff staff) {
        int index = getStaffIndex(staff.getId());
        if (index == Constants.NO_MATCH) {
            allStaff.add(staff);
        } else {
            allStaff.set(index, staff);
        }
    }

    public Staff getStaffById(String id) {
        int index = getStaffIndex(id);
        return (index == Constants.NO_MATCH) ? null : allStaff.get(index);
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
