package com.ITOTracker.ITOITSupportTracker.controller;

import com.ITOTracker.ITOITSupportTracker.entity.Admin_team;
import com.ITOTracker.ITOITSupportTracker.repository.AdminRepository;
import com.ITOTracker.ITOITSupportTracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @PostMapping("/Admin")
    public Admin_team createadmin(@RequestBody Admin_team admin)
    {
        return this.adminRepository.save(admin);
    }
    @GetMapping("/Admin")
    public List<Admin_team> getAlladmin()
    {
        return this.adminRepository.findAll();
    }
}
