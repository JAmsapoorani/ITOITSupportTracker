package com.ITOTracker.ITOITSupportTracker.repository;

import com.ITOTracker.ITOITSupportTracker.entity.Admin_team;
import com.ITOTracker.ITOITSupportTracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin_team,Long> {
}
