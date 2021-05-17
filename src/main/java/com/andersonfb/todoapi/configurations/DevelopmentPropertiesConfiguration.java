package com.andersonfb.todoapi.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andersonfb.todoapi.service.DbInstantiationService;
import com.sun.el.parser.ParseException;

@Configuration
@Profile("dev")
public class DevelopmentPropertiesConfiguration {

	@Autowired
	DbInstantiationService dbInstantiationService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean
	public boolean databaseInstantiation() throws ParseException {
		if(!"create".equals(ddl)) {
			return false;
		}
		dbInstantiationService.databaseInstantiate();
		return true;
	}
}
