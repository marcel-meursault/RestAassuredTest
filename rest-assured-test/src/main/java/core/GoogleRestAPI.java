package core;

import enums.SearchParameters;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class GoogleRestAPI {

	private final Map<String, String> chosenOptions = new HashMap<>();

	public static GoogleOptionRestBuilder makeRequestWith() {
		GoogleRestAPI api = new GoogleRestAPI();
		return new GoogleOptionRestBuilder(api);
	}


	private RequestSpecification baseRequestSpecification() {
		return new RequestSpecBuilder()
				.setAccept(ContentType.JSON)
				.setContentType(ContentType.JSON)
				.addFilter(new RequestLoggingFilter())
				.addFilter(new ResponseLoggingFilter())
				.build();
	}

	public static class GoogleOptionRestBuilder {

		private final GoogleRestAPI api;

		public GoogleOptionRestBuilder(GoogleRestAPI api) {
			this.api = api;
		}

		public GoogleOptionRestBuilder key(String key) {
			api.chosenOptions.put(SearchParameters.KEY.getParameter(), key);
			return this;
		}

		public GoogleOptionRestBuilder query(String text) {
			api.chosenOptions.put(SearchParameters.QUERY.getParameter(), text);
			return this;
		}

		public GoogleOptionRestBuilder cx(String cx) {
			api.chosenOptions.put(SearchParameters.CX.getParameter(), cx);
			return this;
		}

		public <T> T sendRequestAndGet(Class<T> targetDto) {
			return RestAssured.given(api.baseRequestSpecification())
					.queryParams(api.chosenOptions)
					.get()
					.as(targetDto);
		}
	}

}
