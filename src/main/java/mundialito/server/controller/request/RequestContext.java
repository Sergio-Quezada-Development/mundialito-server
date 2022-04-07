package mundialito.server.controller.request;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestContext {
	
	@Getter
	@Setter
	private String resourceId;
	@Getter
	@Setter
	private String resourcePath;
	@Getter
	@Setter
	private String httpMethod;
	@Getter
	@Setter
	private String extendedRequestId;
	@Getter
	@Setter
	private String requestTime;
	@Getter
	@Setter
	private String path;
	@Getter
	@Setter
	private String accountId;
	@Getter
	@Setter
	private String protocol;
	@Getter
	@Setter
	private String stage;
	@Getter
	@Setter
	private String domainPrefix;
	@Getter
	@Setter
	private Long requestTimeEpoch;
	@Getter
	@Setter
	private String requestId;
	@Getter
	@Setter
	private Map<String, String> identity;
	@Getter
	@Setter
	private String domainName;
	@Getter
	@Setter
	private String apiId;

}
