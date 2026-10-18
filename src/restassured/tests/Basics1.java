package restassured.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.utils.Payload;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics1 {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		System.out.println("ios");
		System.out.println("android");
		System.out.println("appium");
		System.out.println("ipad");
		//###########################################################################################
		
		System.out.println("chrome");
		System.out.println("firefox");
		System.out.println("edge");
		System.out.println("safari");
		
		//Add Place
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.addPlace()).
		when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println("response : " + response);
		JsonPath js = ReusableMethods.rawToJson(response);
		String placeId = js.getString("place_id");
		System.out.println("placeId : " + placeId);
		
		//Update Place
		String newAddress = "Summer Walk, Africa";
		String updatePlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.header("Content-Type","application/json")
		.body(Payload.updatePlace(placeId, newAddress)).
		when().put("maps/api/place/update/json").
		then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().response().asString();
		System.out.println("updatePlaceResponse : " + updatePlaceResponse);
		
		//Get Place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).
		when().get("maps/api/place/get/json").
		then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("getPlaceResponse : " + getPlaceResponse);
		JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
		
		//Delete Place
		String deletePlaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.deletePlace(placeId)).
		when().delete("maps/api/place/delete/json").
		then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("deletePlaceResponse : "+deletePlaceResponse);
	}
}
