package com.skndy.works.ticketmanager.core.service.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;

@Configuration
@SuppressWarnings("rawtypes")
public class HibernateConfig {
	
	@Bean
	org.hibernate.cfg.Configuration  conf() throws ClassNotFoundException, IOException {
		
		org.hibernate.cfg.Configuration conf = new org.hibernate.cfg.Configuration().configure();
		List<Class> list = findMyTypes("com.skndy.works.ticketmanager.core.service.model");
		for(Class c: list) {
			conf = conf.addAnnotatedClass(c);
		}
		return conf;
	}
	
	@Bean
	@Autowired
	SessionFactory sessionFactory(org.hibernate.cfg.Configuration conf) {
		return conf.buildSessionFactory();
	}
	
	@Bean
	@Autowired
	Session session(SessionFactory sf) {	
		Session s = sf.openSession();
		return s;
	}
	
	
	private List<Class> findMyTypes(String basePackage) throws IOException, ClassNotFoundException
	{
	    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	    MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);

	    List<Class> candidates = new ArrayList<Class>();
	    String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
	                               resolveBasePackage(basePackage) + "/" + "**/*.class";
	    Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
	    for (Resource resource : resources) {
	        if (resource.isReadable()) {
	            MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
	            if (isCandidate(metadataReader)) {
	                candidates.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
	            }
	        }
	    }
	    return candidates;
	}

	private String resolveBasePackage(String basePackage) {
	    return ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage));
	}
	
	private boolean isCandidate(MetadataReader metadataReader) throws ClassNotFoundException
	{
	    try {
	        Class c = Class.forName(metadataReader.getClassMetadata().getClassName());
	        if (c.getAnnotation(Entity.class) != null) {
	            return true;
	        }
	    }
	    catch(Throwable e){
	    }
	    return false;
	}

}
