package com.example.secondhandWeb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.secondhandWeb.mapper")
@ComponentScan("com.example")
public class SecondhandWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondhandWebApplication.class, args);
	}

}
