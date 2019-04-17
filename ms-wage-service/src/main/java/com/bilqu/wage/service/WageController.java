package com.bilqu.wage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bilqu.wage.bo.EmpWage;
import com.bilqu.wage.dao.EmpWageRepository;

@RestController
public class WageController {

	@Autowired
	private Environment environment;

	@Autowired
	private EmpWageRepository repository;

	@GetMapping("/getWage/roll/{roll}")
	public EmpWage getWageByRoll(@PathVariable("roll") String roll){
		EmpWage empWage = repository.findByRoll(roll);
		return empWage;
	}
}
