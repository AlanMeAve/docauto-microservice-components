package com.sysview.docauto.microservice.components;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EnableEurekaClient
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DocautoMicroserviceComponentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocautoMicroserviceComponentsApplication.class, args);
	}

}
