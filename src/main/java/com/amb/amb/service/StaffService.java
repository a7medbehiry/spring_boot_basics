package com.amb.amb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amb.amb.Constants;
import com.amb.amb.Staff;
import com.amb.amb.repository.StaffRepository;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public void addStaff(Staff staff) {
        staffRepository.addStaff(staff);
    }

    public void submitStaff(Staff staff) {
        int index = getStaffIndex(staff.getId());
        if (index == Constants.NO_MATCH) {
            staffRepository.addStaff(staff);
        } else {
            staffRepository.updateStaff(index, staff);
        }
    }

    public Staff getStaffById(String id) {
        int index = getStaffIndex(id);
        return (index == Constants.NO_MATCH) ? null : staffRepository.getAllStaff().get(index);
    }

    public int getStaffIndex(String id) {
        List<Staff> allStaff = staffRepository.getAllStaff();
        for (int i = 0; i < allStaff.size(); i++) {
            if (allStaff.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NO_MATCH;
    }

    public void deleteStaffById(String id) {
        int index = getStaffIndex(id);
        if (index != Constants.NO_MATCH) {
            staffRepository.deleteStaff(index);
        }
    }

    public void deleteAllStaff() {
        staffRepository.deleteAllStaff();
    }

    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }
}
