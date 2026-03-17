package com.amb.amb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.amb.amb.Staff;
import com.amb.amb.service.StaffService;

import jakarta.validation.Valid;

@Controller
public class StaffController {

    StaffService staffService = new StaffService();

    @GetMapping("/addnewstaff")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {
        Staff staff = staffService.getStaffById(id);
        model.addAttribute("addnewstaff", staff == null ? new Staff() : staff);
        model.addAttribute("isUpdate", staff != null);
        return "addnewstaff";
    }

    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("addnewstaff") Staff staff, BindingResult result) {

        if (result.hasErrors()) {
            return "addnewstaff";
        }

        staffService.submitStaff(staff);
        return "redirect:/staffdetails";
    }

    @GetMapping("/deleteStaff")
    public String deleteStaff(@RequestParam String id) {
        staffService.deleteStaffById(id);
        return "redirect:/staffdetails";
    }

    @GetMapping("/deleteAllStaff")
    public String deleteAllStaff() {
        staffService.deleteAllStaff();
        return "redirect:/staffdetails";
    }

    @GetMapping("/staffdetails")
    public String getStaffDetails(Model model) {
        model.addAttribute("allStaff", staffService.getAllStaff());
        return "staffdetails";
    }
}
