package com.skndy.works.ticketmanager.core.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.skndy.works.ticketmanager.core.service.dao.config.DaoConfig;

@Configuration
@Import({
	HibernateConfig.class,
	DaoConfig.class
})
public class CoreServicesConfig {

}
