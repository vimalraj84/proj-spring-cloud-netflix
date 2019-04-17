package com.vimal.wage.determine.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vimal.wage.determine.bo.EmpPayroll;
import com.vimal.wage.determine.proxy.WageServiceProxy;

@RestController
public class WageCalculator {
	
	@Autowired
	private WageServiceProxy wageServiceProxy;
	
	@GetMapping(path = "/calcWage/roll/{roll}/hours/{hours}")
	public EmpPayroll calculateWages(@PathVariable ("roll") String roll, @PathVariable("hours") int hours) {
		
		EmpPayroll wageServiceResponse = wageServiceProxy.getWageByRoll(roll) ;
		System.out.format("wageServiceResponse \n %s \n" ,wageServiceResponse);
		wageServiceResponse.setTotalPay(new BigDecimal(wageServiceResponse.getWage() * hours));
		return wageServiceResponse;
		
	}

}
