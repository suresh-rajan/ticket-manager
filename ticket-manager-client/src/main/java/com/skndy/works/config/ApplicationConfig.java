package com.skndy.works.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.skndy.works.ticketmager.biz.config.ServiceConfig;

@Configuration
@Import({
	//import your config here
	ServiceConfig.class
	
})
public class ApplicationConfig {

}
