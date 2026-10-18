package restassured.specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

// TODO: Auto-generated Jav-adoc
/**
 * The Class DeleteProductSpec.
 * @author Naveen.Pathak
 */
public class DeleteProductSpec {
	
	/** The base uri. */
	private static String baseUri = "https://rahulshettyacademy.com";
	
	/**
	 * Delete product request.
	 *
	 * @param token the token
	 * @param orderId the order id
	 * @return the request specification
	 */
	public static RequestSpecification deleteProductRequest(String token) {
		
		RequestSpecification deleteProductRequestSpec = new RequestSpecBuilder().setBaseUri(baseUri)
		    .addHeader("Authorization", token).build();
		return deleteProductRequestSpec;
	}
	
    /**
     * Delete product response.
     *
     * @return the response specification
     */
    public static ResponseSpecification deleteProductResponse() {
        	// Response SpecBuilder for Add Place
    		ResponseSpecification deleteProductResponseSpec = new ResponseSpecBuilder().expectStatusCode(200)
    			.expectContentType(ContentType.JSON).expectHeader("server", "Apache/2.4.52 (Ubuntu)")
    				.build();
    			return deleteProductResponseSpec;
	}

}
