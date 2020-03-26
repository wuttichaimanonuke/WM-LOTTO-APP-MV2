package com.app.lotto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		log.info("======Service: /hello work!!!======");
		return "Hello World";
	}
	
	@RequestMapping({ "/notAuthPage" })
	public String notAuthPage() {
		log.info("======Service: /notAuthPage work!!!======");
		return "Hello World notAuthPage";
	}
}
