package com.ITOTracker.ITOITSupportTracker.repository;

import com.ITOTracker.ITOITSupportTracker.DAO.CreateTicket;
import com.ITOTracker.ITOITSupportTracker.DAO.ViewTicket;
import com.ITOTracker.ITOITSupportTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ViewALLRepository  extends JpaRepository<ViewTicket, Integer> {







}
