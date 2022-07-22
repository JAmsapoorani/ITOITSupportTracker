package com.ITOTracker.ITOITSupportTracker.repository;

import com.ITOTracker.ITOITSupportTracker.entity.ViewTicketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewTicketListRepository extends JpaRepository<ViewTicketList,Integer> {


}
