package com.vimal.naming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaNamingServerApplication.class, args);
	}

}
