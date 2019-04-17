package com.bilqu.wage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilqu.wage.bo.EmpWage;

public interface EmpWageRepository extends JpaRepository<EmpWage, Integer>{
	
	EmpWage findByRoll(String roll);
	
}
