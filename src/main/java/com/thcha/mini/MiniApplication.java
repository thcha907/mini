package com.thcha.mini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class MiniApplication {
	private static final Logger logger = LoggerFactory.getLogger(MiniApplication.class); 

	public static void main(final String[] args) {

		//System.out.printf("\n\t>>> --- MiniApplication.main Start : lang=[%s] --- <<<\n\n", System.getProperty("lang"));
		logger.error("error log");
		logger.warn("warn log");
		logger.info("info log");
		logger.debug("debug log");
		logger.trace("trace log");

		log.error("@Slf4j error log");
		log.warn("@Slf4j warn log");
		log.info("@Slf4j info log");
		log.debug("@Slf4j debug log");
		log.trace("@Slf4j trace log");

		SpringApplication.run(MiniApplication.class, args);
	}

}
