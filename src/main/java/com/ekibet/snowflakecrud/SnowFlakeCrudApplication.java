package com.ekibet.snowflakecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ekibet.snowflakecrud.repositories")
@EntityScan(basePackages = {"com.ekibet.snowflakecrud.entity"})
public class SnowFlakeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowFlakeCrudApplication.class, args);
	}

}
