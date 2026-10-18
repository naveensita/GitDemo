package restassured.specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EcommerceApiSpec {
	
	public static RequestSpecification requestSpecBuilder() {
		RequestSpecification request = new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com")
		    .setContentType(ContentType.JSON).build();
		return request;
	}
	
public void responseSpecBuilder() {
	
		
	}

}
