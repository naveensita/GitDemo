package restassured.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.constants.DataConstants;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class JsonFilePayload {

	@Test
	public void endToEndGoogleMapTests() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String payloadFilePath = DataConstants.dataFilePath + "AddPlace.json";

		// Add Place
		String response = given().log().all().queryParam("key", "qaclick123").
			header("Content-Type", "application/json").body(new String(Files.readAllBytes(Paths.get(payloadFilePath)))).
		when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).body("scope", equalTo("APP")).
		    header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println("response : " + response);
		JsonPath js = ReusableMethods.rawToJson(response);
		String placeId = js.getString("place_id");
		System.out.println("placeId : " + placeId);

		// Get Place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").
			queryParam("place_id", placeId).
		when().get("maps/api/place/get/json").
		then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("getPlaceResponse : " + getPlaceResponse);
	}
}
