package mundialito.server.controller;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mundialito.server.controller.request.LambdaRequest;
import mundialito.server.controller.request.RequestContext;

public abstract class BasicController {
	
	protected ObjectMapper mapper = new ObjectMapper();
	
	protected LambdaLogger logger;

	protected APIGatewayProxyResponseEvent createLambdaResponse(int status, String body) {
		return new APIGatewayProxyResponseEvent().withStatusCode(status).withBody(body).withIsBase64Encoded(false);
	}

	protected APIGatewayProxyResponseEvent createLambdaResponse(HttpStatus status, String body) {
		return createLambdaResponse(status.hashCode(), body);
	}
	
	protected String convertAsJSON(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}
	
	@SuppressWarnings("unchecked")
	protected LambdaRequest getRequest(Map<String, Object> input) {
		LambdaRequest lambdaRequest = new LambdaRequest();
		lambdaRequest.setResource((String) input.get("resource"));
		lambdaRequest.setPath((String) input.get("path"));
		lambdaRequest.setHttpMethod((String) input.get("httpMethod"));
		lambdaRequest.setHeaders((Map<String, String>) input.get("headers"));
		lambdaRequest.setMultiValueHeaders((Map<String, List<String>>) input.get("multiValueHeaders"));
		lambdaRequest.setQueryStringParameters((Map<String, String>) input.get("queryStringParameters"));
		lambdaRequest.setMultiValueQueryStringParameters((Map<String, List<String>>) input.get("multiValueQueryStringParameters"));
		lambdaRequest.setPathParameters((Map<String, String>) input.get("pathParameters"));
		lambdaRequest.setStageVariables((Map<String, String>) input.get("stageParameters"));
		lambdaRequest.setBody((String) input.get("body"));
		lambdaRequest.setBase64Encoded((Boolean) input.get("isBase64Encoded"));
		lambdaRequest.setRequestContext(getRequestContext((Map<String, Object>) input.get("requestContext")));
		return lambdaRequest;
	}
	
	@SuppressWarnings("unchecked")
	protected RequestContext getRequestContext(Map<String, Object> input) {
		RequestContext requestContext = new RequestContext();
		requestContext.setResourceId((String) input.get("resourceId"));
		requestContext.setResourcePath((String) input.get("resourcePath"));
		requestContext.setHttpMethod((String) input.get("httpMethod"));
		requestContext.setExtendedRequestId((String) input.get("extendedRequestId"));
		requestContext.setRequestTime((String) input.get("requestTime"));
		requestContext.setPath((String) input.get("path"));
		requestContext.setAccountId((String) input.get("accountId"));
		requestContext.setProtocol((String) input.get("protocol"));
		requestContext.setStage((String) input.get("stage"));
		requestContext.setDomainPrefix((String) input.get("domainPrefix"));
		requestContext.setRequestTimeEpoch((Long) input.get("requestTimeEpoch"));
		requestContext.setRequestId((String) input.get("requestId"));
		requestContext.setIdentity((Map<String, String>) input.get("identity"));
		requestContext.setDomainName((String) input.get("domainName"));
		requestContext.setApiId((String) input.get("apiId"));
		return requestContext;
		
	}

}
