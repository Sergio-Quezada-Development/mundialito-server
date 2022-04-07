package mundialito.server.controller;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import mundialito.server.controller.request.LambdaRequest;

public class MundialitoController extends BasicController
		implements RequestHandler<Map<String, Object>, APIGatewayProxyResponseEvent> {

	@Override
	public APIGatewayProxyResponseEvent handleRequest(Map<String, Object> input, Context context) {
		logger = context.getLogger();

		logger.log("Mundialito...");
		
		LambdaRequest request = getRequest(input);
		
		return createLambdaResponse(200, convertAsJSON(request));

	}

}
