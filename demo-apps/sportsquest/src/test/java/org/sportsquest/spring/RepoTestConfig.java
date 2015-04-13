package org.sportsquest.spring;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.support.GraphDatabaseServiceFactoryBean;

@Configuration
public class RepoTestConfig extends DomainApplicationConfig {

	@Override
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService () throws Exception{
		Map<String,String> config = new HashMap<>();
		config.put("allow_store_upgrade", "true");
		GraphDatabaseServiceFactoryBean graphDbSFB = new GraphDatabaseServiceFactoryBean("build/sportsquest-test.db", config);
		return graphDbSFB.getObject();
	}
}
