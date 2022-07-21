package com.ITOTracker.ITOITSupportTracker.repository;


import com.ITOTracker.ITOITSupportTracker.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
