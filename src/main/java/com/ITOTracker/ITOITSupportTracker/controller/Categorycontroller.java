package com.ITOTracker.ITOITSupportTracker.controller;

import com.ITOTracker.ITOITSupportTracker.entity.Category;
import com.ITOTracker.ITOITSupportTracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Categorycontroller {
@Autowired
    private CategoryRepository categoryRepository;
@PostMapping("/Category")
public Category createCategory(@RequestBody Category category)
{
    return this.categoryRepository.save(category);
}
 @GetMapping("/Category")
    public List<Category> getAllCategory()
 {
     return this.categoryRepository.findAll();
 }
}
