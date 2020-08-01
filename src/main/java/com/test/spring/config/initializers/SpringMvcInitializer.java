package com.test.spring.config.initializers;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.test.security.OAuth2ServerConfiguration;
import com.test.security.WebSecurityConfig;
import com.test.spring.config.EmailConfig;


public class SpringMvcInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {com.test.spring.config.AppConfig.class, WebSecurityConfig.class, OAuth2ServerConfiguration.class, EmailConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
		
}