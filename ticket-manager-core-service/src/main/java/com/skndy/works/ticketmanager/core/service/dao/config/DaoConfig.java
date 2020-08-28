package com.skndy.works.ticketmanager.core.service.dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.skndy.works.ticketmanager.core.service.config.HibernateConfig;

@Configuration
@Import({
	HibernateConfig.class
})
@ComponentScan("com.skndy.works.ticketmanager.core.service.dao")
public class DaoConfig {

}
