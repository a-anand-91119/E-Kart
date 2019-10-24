package com.anand.spring.onlineshopping.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

@Configuration
public class SpringWebFlowConfiguration extends AbstractFlowConfiguration {

	@Autowired
	private SpringWebConfiguration springWebConfiguration;

	@Bean
	public MvcViewFactoryCreator getMvcViewFactoryCreator() {
		MvcViewFactoryCreator mvcViewFactoryCreator = new MvcViewFactoryCreator();
		mvcViewFactoryCreator
				.setViewResolvers(Collections.singletonList(this.springWebConfiguration.getViewResolver()));
		mvcViewFactoryCreator.setUseSpringBeanBinding(true);
		return mvcViewFactoryCreator;
	}

	@Bean
	public FlowBuilderServices getFlowBuilderServices() {
		return getFlowBuilderServicesBuilder().setViewFactoryCreator(getMvcViewFactoryCreator())
				.setDevelopmentMode(true).build();
	}

	@Bean
	public FlowDefinitionRegistry getFlowDefinitionRegistry() {
		return getFlowDefinitionRegistryBuilder(getFlowBuilderServices()).setBasePath("/WEB-INF/view/flow/")
				.addFlowLocationPattern("/**/*-flow.xml").build();
	}

	@Bean
	public FlowExecutor getFlowExecutor() {
		return getFlowExecutorBuilder(getFlowDefinitionRegistry()).build();
	}
}
