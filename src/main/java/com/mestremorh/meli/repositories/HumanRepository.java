package com.mestremorh.meli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mestremorh.meli.model.Human;

public interface HumanRepository extends JpaRepository<Human, Integer> {
	
	@Query(value = "SELECT count(1) FROM HUMAN WHERE FLAG_MUTANT = ?1", nativeQuery = true)
	  long countByMutant(long emailAddress);
}
