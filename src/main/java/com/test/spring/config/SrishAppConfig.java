package com.test.spring.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class SrishAppConfig {
	
	@Autowired
	private Environment environment;
	
	private static SrishAppConfig srishConfig = null;
	
	public static SrishAppConfig getInstance() {
		return srishConfig;
	}
	
	public String getConfigValue(String configKey) {
		return environment.getProperty(configKey);
	}
	
	@PostConstruct
	public void initIt() throws Exception {
		srishConfig = this;
	}

}
