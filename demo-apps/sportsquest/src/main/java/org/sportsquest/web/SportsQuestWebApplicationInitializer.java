package org.sportsquest.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.sportsquest.spring.DomainApplicationConfig;
import org.sportsquest.spring.WebApplicationConfig;

/**
 * In a Servlet 3.0+ environment, you have the option of configuring the Servlet
 * container programmatically as an alternative or in combination with a web.xml
 * file.
 * 
 */
public class SportsQuestWebApplicationInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {DomainApplicationConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebApplicationConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//return new String[] {"/"}; TODO uitzoeken hoe servlets te combineren met static files zoals index.html
		return null;
	}
}