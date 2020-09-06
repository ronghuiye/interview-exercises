package com.asurint.interview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asurint.interview.entity.Interview;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long>{
	Interview findOneByDescription(String description);
}
