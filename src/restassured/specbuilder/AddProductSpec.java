package restassured.specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

// TODO: Auto-generated Java-doc
/**
 * The Class SpecBuilderForAddProduct.
 * @author Naveen.Pathak
 */
public class AddProductSpec {
	
	/** The base uri. */
	private static String baseUri = "https://rahulshettyacademy.com";
	
	/**
	 * Adds the product request.
	 *
	 * @param token the token
	 * @return the request specification
	 */
	public static RequestSpecification addProductRequest(String token) {
		RequestSpecification addProductRequest = new RequestSpecBuilder().setBaseUri(baseUri)
				.addHeader("Authorization", token).build();
		return addProductRequest;
	}
	
    /**
     * Adds the product response.
     */
    public static void addProductResponse() {
		
	}

}
