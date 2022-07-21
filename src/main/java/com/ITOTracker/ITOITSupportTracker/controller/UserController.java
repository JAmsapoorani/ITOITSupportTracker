package com.ITOTracker.ITOITSupportTracker.controller;

import com.ITOTracker.ITOITSupportTracker.entity.Admin_team;
import com.ITOTracker.ITOITSupportTracker.entity.User;
import com.ITOTracker.ITOITSupportTracker.repository.AdminRepository;
import com.ITOTracker.ITOITSupportTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/User")
    public User createuser(@RequestBody User user)
    {
        return this.userRepository.save(user);
    }
    @GetMapping("/User")
    public List<User> getAlluser()
    {
        return this.userRepository.findAll();
    }
}
