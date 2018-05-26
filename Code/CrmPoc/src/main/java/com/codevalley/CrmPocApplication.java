package com.codevalley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.codevalley.crm.entity" })

public class CrmPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmPocApplication.class, args);
	}
}
