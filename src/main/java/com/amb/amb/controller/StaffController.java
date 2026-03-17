package com.amb.amb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.amb.amb.Staff;
import com.amb.amb.repository.StaffRepository;
import jakarta.validation.Valid;

@Controller
public class StaffController {

    StaffRepository staffRepository = new StaffRepository();

    @GetMapping("/addnewstaff")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {
        Staff staff = staffRepository.getStaffById(id);
        model.addAttribute("addnewstaff", staff == null ? new Staff() : staff);
        model.addAttribute("isUpdate", staff != null);
        return "addnewstaff";
    }

    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("addnewstaff") Staff staff, BindingResult result) {

        if (result.hasErrors()) {
            return "addnewstaff";
        }

        staffRepository.save(staff);
        return "redirect:/staffdetails";
    }

    @GetMapping("/staffdetails")
    public String getStaffDetails(Model model) {
        model.addAttribute("allStaff", staffRepository.getAllStaff());
        return "staffdetails";
    }
}
