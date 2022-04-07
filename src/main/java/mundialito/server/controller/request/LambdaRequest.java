package mundialito.server.controller.request;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LambdaRequest {
	
	@Getter
	@Setter
	private String resource;
	@Getter
	@Setter
	private String path;
	@Getter
	@Setter
	private String httpMethod;
	@Getter
	@Setter
	private Map<String, String> headers;
	@Getter
	@Setter
	private Map<String, List<String>> multiValueHeaders;
	@Getter
	@Setter
	private Map<String, String> queryStringParameters;
	@Getter
	@Setter
	private Map<String, List<String>> multiValueQueryStringParameters;
	@Getter
	@Setter
	private Map<String, String> pathParameters;
	@Getter
	@Setter
	private Map<String, String> stageVariables;
	@Getter
	@Setter
	private RequestContext requestContext;
	@Getter
	@Setter
	private String body;
	@Getter
	@Setter
	private boolean isBase64Encoded;

}
