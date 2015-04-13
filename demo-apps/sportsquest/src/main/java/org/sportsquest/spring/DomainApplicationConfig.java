package org.sportsquest.spring;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.IsNewAwareAuditingHandler;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.lifecycle.AuditingEventListener;
import org.springframework.data.neo4j.support.GraphDatabaseServiceFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = {"org.sportsquest.domain"})
@EnableNeo4jRepositories(basePackages = {"org.sportsquest.domain.repositories"})
public class DomainApplicationConfig extends Neo4jConfiguration {

	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService () throws Exception{
		Map<String,String> config = new HashMap<>();
		config.put("allow_store_upgrade", "true");
		GraphDatabaseServiceFactoryBean graphDbSFB = new GraphDatabaseServiceFactoryBean("/Users/johan/apps/neo4j/sportsquest-data/sportsquest.db", config);
		return graphDbSFB.getObject();
	}
	
	@Bean
    public AuditingEventListener auditingEventListener() throws Exception {
        return new AuditingEventListener(new IsNewAwareAuditingHandler(isNewStrategyFactory()));
    }
	
	@Bean
	public LocalValidatorFactoryBean validator() throws Exception{
		return new LocalValidatorFactoryBean();
	}
}
