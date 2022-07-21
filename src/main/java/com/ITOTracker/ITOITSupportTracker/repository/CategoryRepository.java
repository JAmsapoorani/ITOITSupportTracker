package com.ITOTracker.ITOITSupportTracker.repository;


import com.ITOTracker.ITOITSupportTracker.entity.Category;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}