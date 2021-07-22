package com.bilqu.naming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// Implementing a Eureka Server for service registry is as easy as:

//	1. adding spring-cloud-starter-netflix-eureka-server to the dependencies
//		<dependency>
//			<groupId>org.springframework.cloud</groupId>
//			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
//		</dependency>

//	2. enable the Eureka Server in a @SpringBootApplication by annotating it with @EnableEurekaServer

//	3. configure some properties
//		server.port=${PORT:8761}
//		eureka.client.register-with-eureka=false --telling the built-in Eureka Client
//		eureka.client.fetch-registry=false

//  4. http://localhost:8761 to view the Eureka dashboard for all the registration

@SpringBootApplication
@EnableEurekaServer
public class MsEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaNamingServerApplication.class, args);
	}

}
