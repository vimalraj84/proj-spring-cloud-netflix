package com.bilqu.wage.determine.proxy;

import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bilqu.wage.determine.bo.EmpPayroll;

//This will be the Feign Proxy to call wage service  from ms-wage-service project

//A good method to create such Feign Clients is to create interfaces with @RequestMapping annotated methods and put them into a separate module.
//This way they can be shared between server and client.

@FeignClient(name = "wage-service" , fallback = WageServiceProxy.WageServiceFallback.class)//Reference to the service name in ms-wage-service project
@RibbonClient(name = "wage-service")//Enabling client side load balancing with Ribbon.
public interface WageServiceProxy {
	
	// Path of the ms-wage-service we want to consume
	@GetMapping("/getWage/roll/{roll}")
	public EmpPayroll getWageByRoll(@PathVariable("roll") String roll);

	@Component
	public class WageServiceFallback{
		@GetMapping("/getWage/roll/{roll}")
		public EmpPayroll getWageByRoll(@PathVariable("roll") String roll){
			return new EmpPayroll();
		}
	}
}
