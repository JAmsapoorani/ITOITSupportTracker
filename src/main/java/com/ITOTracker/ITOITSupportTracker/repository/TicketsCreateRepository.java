package com.ITOTracker.ITOITSupportTracker.repository;

import com.ITOTracker.ITOITSupportTracker.entity.CreateTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketsCreateRepository extends JpaRepository<CreateTicket,Integer> {


}
