package com.bilqu.wage.determine;

import com.bilqu.wage.determine.bo.EmpPayroll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//	1. 	A discovery-aware Spring RestTemplate using interfaces to communicate with endpoints.
//		This interfaces will be automatically implemented at runtime and instead of service-urls, it is using service-names.

//	2. Without Feign
//		we would have to autowire an instance of EurekaClient into our controller with which we could receive a service-information by service-name as an Application object.
//
//		private EurekaClient eurekaClient;
//
// 		InstanceInfo service = eurekaClient
//      	.getApplication(spring-cloud-eureka-client)
//      	.getInstances()
//      	.get(0);
//
//   	String hostName = service.getHostName();
//   	int port = service.getPort();

//	3. The Feign Client is located in the spring-cloud-starter-feign package.
//
//		<dependency>
//      	<groupId>org.springframework.cloud</groupId>
//      	<artifactId>spring-cloud-starter-feign</artifactId>
//		</dependency>
//		<dependency>
//    		<groupId>org.springframework.cloud</groupId>
//    		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
//		</dependency>

//	4. To enable it annotate a @Configuration with @EnableFeignClients.

//	5. To use it, we simply annotate an interface with @FeignClient(“service-name”) and auto-wire it into a controller.

//	6. A good method to create such Feign Clients is to create interfaces with @RequestMapping annotated methods and put them into a separate module.
//		This way they can be shared between server and client.
//
//			@FeignClient(name = "wage-service")//Reference to the service name in ms-wage-service project
//			public interface WageServiceProxy {
//				@GetMapping("/getWage/roll/{roll}")
//				public EmpPayroll getWageByRoll(@PathVariable("roll") String roll);
//			}

//	7. On server-side, you can implement them as @Controller, and on client-side, they can be extended and annotated as @FeignClient

//	8. Needs to be included spring-cloud-starter-eureka package in the project and enabled by annotating the main application class with @EnableEurekaClient

//	9. configuration file is almost the same as in the previous step
//
// 		spring.application.name=wage-determine-service
//		server.port=9100
//		eureka.client.service-url.default-zone=http://localhost:8761/eureka

//  10. Launch browser to  http://localhost:9100/calcWage/roll/{roll}/hours/{hours} also launch http://localhost:8761 to view the Eureka dashboard for all the registration
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient  //note that this annotation is optional if we have the spring-cloud-starter-netflix-eureka-client dependency on the classpath
@EnableCircuitBreaker
@EnableHystrix
public class MsFeignWageDetermineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFeignWageDetermineServiceApplication.class, args);
	}

}
