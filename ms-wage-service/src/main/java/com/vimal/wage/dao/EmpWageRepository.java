package com.vimal.wage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vimal.wage.bo.EmpWage;

public interface EmpWageRepository extends JpaRepository<EmpWage, Integer>{
	
	EmpWage findByRoll(String roll);
	
}
