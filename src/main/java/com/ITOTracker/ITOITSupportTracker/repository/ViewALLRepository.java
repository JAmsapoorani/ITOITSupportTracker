package com.ITOTracker.ITOITSupportTracker.repository;

import com.ITOTracker.ITOITSupportTracker.entity.ViewTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewALLRepository  extends JpaRepository<ViewTicket, Integer> {







}
