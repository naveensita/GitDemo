package restassured.specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * The Class SpecBuildersForGmap.
 * @author Naveen.Pathak
 */
public class GmapSpec {

	/**
	 * Request spec builder.
	 *
	 * @return the request specification
	 */
	public static RequestSpecification requestSpecBuilder() {

		// Request SpecBuilder for Add Place
		RequestSpecification requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		return requestSpec;
	}
	
	/**
	 * Response spec builder.
	 *
	 * @return the response specification
	 */
	public static ResponseSpecification responseSpecBuilder() {
		// Response SpecBuilder for Add Place
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
			.expectContentType(ContentType.JSON).expectHeader("server", "Apache/2.4.52 (Ubuntu)")
			.build();
		return responseSpec;
	}

}
