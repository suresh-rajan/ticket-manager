package com.skndy.works.ticketmager.biz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.skndy.works.ticketmanager.core.service.config.CoreServicesConfig;

@Configuration
@ComponentScan("com.skndy.works.ticketmanager.biz.service")
@Import({
	//import core services config
	CoreServicesConfig.class
})
public class ServiceConfig {
	
	

}
