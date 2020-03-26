package com.app.lotto;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WmLottoAppMv2Application {

	private static final Logger log = LoggerFactory.getLogger(WmLottoAppMv2Application.class);
	
	public static void main(String[] args) {
		log.info("======Begin App WM-LOTTERY-APP-MV2======");
		SpringApplication.run(WmLottoAppMv2Application.class, args);
	}
	
	/*
	 * For use jwt.
	*/
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}

}
