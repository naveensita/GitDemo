package restassured.specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

// TODO: Auto-generated Jav-adoc
/**
 * The Class ViewOrderSpec.
 * @author Naveen.Pathak
 */
public class ViewOrderSpec {
	
	/** The base uri. */
	private static String baseUri = "https://rahulshettyacademy.com";
	
	/**
	 * View order request.
	 *
	 * @param token the token
	 * @param productOrderId the product order id
	 * @return the request specification
	 */
	public static RequestSpecification viewOrderRequest(String token, String orderId) {
		
		RequestSpecification viewOrderRequestSpec = new RequestSpecBuilder().setBaseUri(baseUri)
		    .addHeader("Authorization", token).addQueryParam("id", orderId).build();
		return viewOrderRequestSpec;
	}
	
    /**
     * View order response.
     *
     * @return the response specification
     */
    public static ResponseSpecification viewOrderResponse() {
        	// Response SpecBuilder for Add Place
    		ResponseSpecification viewOrderResponseSpec = new ResponseSpecBuilder().expectStatusCode(200)
    			.expectContentType(ContentType.JSON).expectHeader("server", "Apache/2.4.52 (Ubuntu)")
    				.build();
    			return viewOrderResponseSpec;
	}

}
