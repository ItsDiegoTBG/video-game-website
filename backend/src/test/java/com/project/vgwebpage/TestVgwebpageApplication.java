package com.project.vgwebpage;

import org.springframework.boot.SpringApplication;

public class TestVgwebpageApplication {

	public static void main(String[] args) {
		SpringApplication.from(VgwebpageApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
