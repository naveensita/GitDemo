package restassured.tests;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.pojoclasses.AddPlace;
import restassured.pojoclasses.Location;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;

public class GoogleMapSerialization {

	@Test
	public void gmapSerializationTest() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
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
		String response = given().log().all().queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body(addPlace).
		when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200)
			.body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)")
			.extract().response().asString();
		System.out.println("response : " + response);
		JsonPath js = ReusableMethods.rawToJson(response);
		String placeId = js.getString("place_id");
		System.out.println("placeId : " + placeId);
	}
}
