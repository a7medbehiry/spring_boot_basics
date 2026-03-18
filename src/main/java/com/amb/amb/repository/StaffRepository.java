package com.amb.amb.repository;

import java.util.ArrayList;
import java.util.List;
import com.amb.amb.Staff;

import org.springframework.stereotype.Repository;

@Repository
public class StaffRepository {
    private List<Staff> allStaff = new ArrayList<>();

    public void addStaff(Staff staff) {
        allStaff.add(staff);
    }

    public void updateStaff(int index, Staff staff) {
        allStaff.set(index, staff);
    }

    public void deleteStaff(int index) {
        allStaff.remove(index);
    }

    public void deleteAllStaff() {
        allStaff.clear();
    }

    public List<Staff> getAllStaff() {
        return allStaff;
    }
}
