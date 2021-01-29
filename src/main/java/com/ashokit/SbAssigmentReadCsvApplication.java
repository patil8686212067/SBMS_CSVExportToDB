package com.ashokit;

import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashokit.service.ProductServiceImpl;

@SpringBootApplication
public class SbAssigmentReadCsvApplication {


	public static void main(String[] args) throws FileNotFoundException {
		// SpringApplication.run(SbAssigmentReadCsvApplication.class, args);

		ConfigurableApplicationContext ctxt = SpringApplication.run(SbAssigmentReadCsvApplication.class, args);
		
		ProductServiceImpl productService = ctxt.getBean(ProductServiceImpl.class);
		
		String responseMessage = productService.readCsvData();
		
		System.out.println("===responseMessage===>"+responseMessage);

		

	}
	
	//HIS JIRA task Id-200
	
	public void doProess(){
		System.out.println("== single person is working on his branch and merging his code to master branch ====");
		
	}

}
