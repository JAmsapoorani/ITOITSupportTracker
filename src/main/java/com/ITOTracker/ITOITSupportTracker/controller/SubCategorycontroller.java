package com.ITOTracker.ITOITSupportTracker.controller;

import com.ITOTracker.ITOITSupportTracker.entity.Sub_Category;
import com.ITOTracker.ITOITSupportTracker.exception.ResourceNotFoundException;
import com.ITOTracker.ITOITSupportTracker.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubCategorycontroller {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @PostMapping("/Sub_Category")

    public Sub_Category createSubCategory(@RequestBody Sub_Category subCategory)
    {
        return this.subCategoryRepository.save(subCategory);
    }
    @GetMapping("/Sub_Category")
    @Query("select sub_Category,Category_id,sub_Category_desc from Sub_Category")
    public List<Sub_Category> getAllsubCategory()
    {
        return this.subCategoryRepository.findAll();
    }
    @GetMapping("/{sub_category_id}")
    public Sub_Category getCategoryById(@PathVariable (value = "sub_category_id") Integer sub_category_id) {
        return this.subCategoryRepository.findById(sub_category_id)
                .orElseThrow(() -> new ResourceNotFoundException("Sub Category id not found with id :" + sub_category_id, "Missing Data Exception"));
    }

}
