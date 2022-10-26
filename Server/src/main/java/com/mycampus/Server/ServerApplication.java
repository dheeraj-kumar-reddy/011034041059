package com.mycampus.Server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

	private static Logger McLogger = LogManager.getLogger(ServerApplication.class);

	public static void main(String[] args) {
		String methodName = "main";
		SpringApplication.run(ServerApplication.class, args);
		McLogger.info(methodName+" My Campus Server Started");
		System.out.println("My Campus Server started");
	}

}
