package com.jpchef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/**
 * 
 * @author Ehtu
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class JpChefApplication {

	public static void main(String[] args) {
		System.out.println("Starting JPchef Main");
		//System.setProperty("server.servlet.context-path");
		SpringApplication.run(JpChefApplication.class, args);
		//, "/inmo"
		
	}
}
