package com.example.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ExceptionResolver extends DataFetcherExceptionResolverAdapter {

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {

		if (ex instanceof UserNotFoundException) {
			return GraphqlErrorBuilder.newError()
					.errorType(ErrorType.NOT_FOUND)
					.message(ex.getMessage())
					.path(env.getExecutionStepInfo().getPath()).location(env.getField().getSourceLocation()).build();
		} else if (ex instanceof ConstraintViolationException) {
			return GraphqlErrorBuilder.newError()
					.errorType(graphql.ErrorType.ValidationError)
					.message(ex.getMessage())
					.path(env.getExecutionStepInfo().getPath())
					.location(env.getField().getSourceLocation()).build();

		} else {
			return null;
		}
	}

}
