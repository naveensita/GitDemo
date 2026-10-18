package restassured.specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

// TODO: Auto-generated Java-doc

/**
 * The Class CreateOrderSpec.
 * @author Naveen.Pathak
 */
public class CreateOrderSpec {
	
	/** The base uri. */
	private static String baseUri = "https://rahulshettyacademy.com";
	
	/**
	 * Creates the order request.
	 *
	 * @param token the token
	 * @return the request specification
	 */
	public static RequestSpecification createOrderRequest(String token) {
		RequestSpecification createOrderRequest = new RequestSpecBuilder().setBaseUri(baseUri)
				.setContentType(ContentType.JSON).addHeader("Authorization", token).build();
		return createOrderRequest;
	}
	
    /**
     * Creates the order response.
     */
    public static void createOrderResponse() {
		
	}

}
