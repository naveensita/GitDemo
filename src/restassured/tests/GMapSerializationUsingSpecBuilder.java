package restassured.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import restassured.pojoclasses.AddPlace;
import restassured.pojoclasses.Location;
import restassured.specbuilder.GmapSpec;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;

public class GMapSerializationUsingSpecBuilder {

	@Test
	public void gmapSpecBuilderTest() {

		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setLanguage("French-IN");
		addPlace.setName("Rahul Shetty Academy");
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setWebsite("http://rahulshettyacademy.com");
		
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		addPlace.setLocation(location);
		
		List<String> typesList = new ArrayList<String>();
		typesList.add("shoe park");
		typesList.add("shoe park");
		addPlace.setTypes(typesList);
		
		// Add Place
		RequestSpecification request = given().spec(GmapSpec.requestSpecBuilder()).body(addPlace);
		
		String response = request.when().post("maps/api/place/add/json").
		then().spec(GmapSpec.responseSpecBuilder()).extract().response().asString();
		
		System.out.println("response : " + response);
		JsonPath js = ReusableMethods.rawToJson(response);
		String placeId = js.getString("place_id");
		System.out.println("placeId : " + placeId);
	}
}
