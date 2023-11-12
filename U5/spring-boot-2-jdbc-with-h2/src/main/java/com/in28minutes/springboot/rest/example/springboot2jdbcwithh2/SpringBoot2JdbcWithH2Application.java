package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.Student.Student;
import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.Student.StudentJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		logger.info("Student id 10001 -> {}", repository.findById(10001L));
		repository.deleteById(10002L);
		logger.info("All users 2 -> {}", repository.findAll());


	}

}
