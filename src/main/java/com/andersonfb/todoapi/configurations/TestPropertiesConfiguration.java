package com.andersonfb.todoapi.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andersonfb.todoapi.service.DbInstantiationService;

@Configuration
@Profile("test")
public class TestPropertiesConfiguration {

	@Autowired
	DbInstantiationService dbInstantiationService;

	@Bean
	public boolean databaseInstantiation() {
		dbInstantiationService.databaseInstantiate();
		return true;
	}
}
