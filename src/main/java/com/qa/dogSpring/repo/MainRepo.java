package com.qa.dogSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.dogSpring.domain.Main;

public interface MainRepo extends JpaRepository<Main, Long> {
	
	
}
