package com.saptco.common.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("com.saptco")
@EntityScan("com.saptco")
@ComponentScan("com.saptco")
@EnableAdminServer
@EnableSwagger2
public class MicroServiceApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}
}
