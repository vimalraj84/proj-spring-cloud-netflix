package com.vimal.wage.determine.service;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vimal.wage.determine.bo.EmpPayroll;
import com.vimal.wage.determine.proxy.WageServiceProxy;

@RestController
public class WageCalculator {
	
	@Autowired
	private WageServiceProxy wageServiceProxy;
	
	@GetMapping(path = "/calcWage/roll/{roll}/hours/{hours}")
	public EmpPayroll calculateWages(@PathParam(value = "roll") String roll) {
		
		EmpPayroll wageServiceResponse = wageServiceProxy.getWageByRoll(roll) ;
		System.out.format("wageServiceResponse \n %s \n" ,wageServiceResponse);
		return wageServiceResponse;
		
	}

}
