package com.thcha.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniApplication {

	public static void main(final String[] args) {
        //System.out.printf("\n\t>>> --- MiniApplication.main Start : lang=[%s] --- <<<\n\n", System.getProperty("lang"));
		SpringApplication.run(MiniApplication.class, args);
	}

}
