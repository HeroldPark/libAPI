package com.jungsoo.web;

import java.text.SimpleDateFormat;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.slf4j.Logger;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootWebApplication {

	static Logger logger = (Logger) LoggerFactory.getLogger(SpringBootWebApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
		// SpringApplication app = new
		// SpringApplication(SpringBootWebApplication.class);
		// app.run(args);

		run(args);
	}

	public static void run(String... args) throws Exception {
		String currentTime = new String();
		long now = System.currentTimeMillis();
		currentTime = String.format("currentTime: %s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(now));
		logger.debug(currentTime);

		logger.trace("trace -- Hello world.");
		logger.debug("debug -- Hello world.");
		logger.info("info -- 헬로우 월드.");
		logger.warn("warn -- Hello world.");
		logger.error("error -- Hello world.");
	}

}
