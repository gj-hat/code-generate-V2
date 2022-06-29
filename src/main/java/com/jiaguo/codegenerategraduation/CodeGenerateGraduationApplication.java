package com.jiaguo.codegenerategraduation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiaguo.codegenerategraduation.web.mapper")
public class CodeGenerateGraduationApplication {

	public static void main(String[] args) {
		 SpringApplication.run(CodeGenerateGraduationApplication.class, args);
	}

}
