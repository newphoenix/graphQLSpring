package com.example.config;

import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;

import graphql.scalars.java.JavaPrimitives;
import graphql.schema.idl.RuntimeWiring.Builder;

@Component
public class RuntimeWiring implements RuntimeWiringConfigurer {

	@Override
	public void configure(Builder builder) {
		builder.scalar(JavaPrimitives.GraphQLBigDecimal);
	 }

}