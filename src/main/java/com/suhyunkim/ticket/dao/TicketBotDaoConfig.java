/**
 * @(#) TicketBotConfig.class $version 2017. 03. 31
 *
 * Copyright 2017 Suhyun Kim. All rights Reserved.
 */
package com.suhyunkim.ticket.dao;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TicketBotConfig
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
@Configuration
public class TicketBotDaoConfig {
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/console/*");
		return registration;
	}
}