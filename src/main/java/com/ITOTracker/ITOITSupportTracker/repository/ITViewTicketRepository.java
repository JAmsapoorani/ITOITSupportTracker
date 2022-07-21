package com.ITOTracker.ITOITSupportTracker.repository;

import com.ITOTracker.ITOITSupportTracker.DAO.ITViewTicket;
import com.ITOTracker.ITOITSupportTracker.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITViewTicketRepository extends JpaRepository<ITViewTicket, Integer> {
}
