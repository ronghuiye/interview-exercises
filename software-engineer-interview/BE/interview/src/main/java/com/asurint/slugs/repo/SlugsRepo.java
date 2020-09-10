package com.asurint.slugs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asurint.slugs.entity.Slugs;

@Repository
public interface SlugsRepo extends JpaRepository<Slugs, Long>{
	Slugs findOneByDescription(String description);
}
