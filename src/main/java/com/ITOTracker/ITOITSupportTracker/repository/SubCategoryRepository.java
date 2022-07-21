package com.ITOTracker.ITOITSupportTracker.repository;


import com.ITOTracker.ITOITSupportTracker.entity.Category;
import com.ITOTracker.ITOITSupportTracker.entity.Sub_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface SubCategoryRepository extends JpaRepository<Sub_Category, Integer> {
 public List<Category> categoryjoin=new ArrayList<>();


}
