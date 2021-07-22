package com.bilqu.wage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


// For a SpringBootApplication to be discovery-aware, we've to include some Spring Discovery Client

//	1. Annotate a @Configuration with either @EnableDiscoveryClient or @EnableEurekaClient – note that this annotation is optional if we have the spring-cloud-starter-netflix-eureka-client dependency on the classpath.
//
//		<dependency>
//			<groupId>org.springframework.cloud</groupId>
//			<artifactId>spring-cloud-starter-netflix-eureka-starter</artifactId>
//		</dependency>

//		@EnableDiscoveryClient 	:	It can use any implementations like Eureka, Consul, Zookeeper, etc.
//		@EnableEurekaClient		:	It works only with Eureka Discovery Client implementation

//	2. Add your rest service @RestController

//	3. configured Spring application name to uniquely identify our client in the list of registered applications.

//			spring.application.name=wage-service
//			server.port=9000   -- You can also let Spring Boot choose a random port because later we are accessing this service with its name.
//			eureka.client.service-url.default-zone=http://localhost:8761/eureka
//
//			eureka:
//				client:
//					serviceUrl:
//						defaultZone: ${EUREKA_URI:http://localhost:8761/eureka}
//					instance:
//						preferIpAddress: true

//  4. http://localhost:8761 to view the Eureka dashboard for all the registration

@SpringBootApplication
@EnableDiscoveryClient //note that this annotation is optional if we have the spring-cloud-starter-netflix-eureka-client dependency on the classpath
public class MsWageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWageServiceApplication.class, args);
	}

}
