package com.ITOTracker.ITOITSupportTracker.repository;

import com.ITOTracker.ITOITSupportTracker.DAO.ViewTicket;
import com.ITOTracker.ITOITSupportTracker.DAO.ViewTicketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViewTicketListRepository extends JpaRepository<ViewTicketList,Integer> {


}
