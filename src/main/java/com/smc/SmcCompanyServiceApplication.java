package com.smc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 
    * @Description: Company service application bootstrap class
    * @author Chen Wei
    * @date May 18, 2020
    *
 */
@SpringBootApplication
@EnableJpaAuditing
public class SmcCompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmcCompanyServiceApplication.class, args);
	}

}
