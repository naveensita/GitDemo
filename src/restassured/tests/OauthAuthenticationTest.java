package restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import restassured.pojoclasses.Api;
import restassured.pojoclasses.GetCourse;
import restassured.pojoclasses.WebAutomation;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Class OauthAuthenticationTest.
 * @author Naveen.Pathak
 */
public class OauthAuthenticationTest {
	
	String[] courseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};
	
	@Test
	public void authorizationTest() {
		
		//RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token";
		
		//Get Authorization Token
		String getTokenResponse = given().log().all().
			formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		    formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		    formParam("grant_type", "client_credentials").formParam("scope", "trust").
		when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("getTokenResponse : "+getTokenResponse);
		JsonPath js = ReusableMethods.rawToJson(getTokenResponse);
		String token = js.getString("access_token");
		System.out.println("token : "+token);
		
		//Get Course Details with de-serialization using POJO class
		GetCourse gc = given().log().all().queryParam("access_token", token).
		when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").
		then().log().all().assertThat().statusCode(401).extract().response().as(GetCourse.class);
		System.out.println("LinkedIn : "+gc.getLinkedIn());
		System.out.println("Instructor : "+gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		List<Api> apiCourses = gc.getCourses().getApi();
		String price = "";
		for (int i = 0; i < apiCourses.size(); i++) {
			if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				price = apiCourses.get(i).getPrice();
				break;
			}
		}
		System.out.println("Price of SoapUI Webservices testing : "+price);
		
		List<WebAutomation> webAutomation = gc.getCourses().getWebAutomation();
		
		for (int i = 0; i < webAutomation.size(); i++) {
			System.out.println(webAutomation.get(i).getCourseTitle());
		}
		
		ArrayList<String> actualList = new ArrayList<String>();
		for (int i = 0; i < webAutomation.size(); i++) {
			actualList.add(webAutomation.get(i).getCourseTitle());
		}
		
		List<String> expectedList = Arrays.asList(courseTitles);
		Assert.assertTrue(actualList.equals(expectedList), "List Mismatched");
	}
}
