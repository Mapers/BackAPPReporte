package com.cloudsrcsoft.reportes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.cloudsrcsoft.reportes.repository.mybatis.spec")
@EnableScheduling
public class CloudsrcsoftOcReportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudsrcsoftOcReportesApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	   return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/**").allowedOrigins("*");
	      }    
	   };
	}

}

