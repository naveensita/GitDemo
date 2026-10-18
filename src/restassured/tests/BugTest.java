package restassured.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.constants.DataConstants;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;

import java.io.File;

public class BugTest {
	
	@Test
	public void jiraBugTest() {
		RestAssured.baseURI = "https://naveenpathak28.atlassian.net/";
		String attachmentFilePath = DataConstants.dataFilePath + "voter id.png";
		
		//Create Bug in JIRA
		String createIssueResponse = given().log().all().header("Content-Type", "application/json")
		       .header("Authorization","Basic bmF2ZWVucGF0aGFrMjhAZ21haWwuY29tOkFUQVRUM3hGZkdGMDVPUUxpTENmOXJYOVE0bGNJWjNJZFlmWFRMcHp6d1JPbVprQmR2YWVsWFlwYVRvM0JiVkNYY19EUnIwYzBDLV96VVlFbG5nRDFPcUY4Skt0YU9wallZWTJzU0FOX3dfdFVrZkx6VUgtQ002NU1IVzJ2VC1tZ042MkVsTlFHVk1yT3NkWktURXpaaGF1ZGNxZ3NoRld2eHIzT2ZqV25MaGhsNi1sMzNxTExVcz1CNEJFRDA5NQ==")
		       .body("{\r\n"
		       		+ "    \"fields\": {\r\n"
		       		+ "       \"project\":\r\n"
		       		+ "       {\r\n"
		       		+ "          \"key\": \"SCRUM\"\r\n"
		       		+ "       },\r\n"
		       		+ "       \"summary\": \"Website items are not working-Automation\",\r\n"
		       		+ "       \"issuetype\": {\r\n"
		       		+ "          \"name\": \"Task\"\r\n"
		       		+ "       }\r\n"
		       		+ "   }\r\n"
		       		+ "}\r\n"
		       		+ "").
		when().post("rest/api/3/issue").
		then().log().all().assertThat().statusCode(201).extract().response().asString();
		System.out.println("createIssueResponse : "+createIssueResponse);
		JsonPath js = ReusableMethods.rawToJson(createIssueResponse);
		String issueId = js.getString("id");
		System.out.println("issueId : "+issueId);
		
		//Add attachment in created bug
		String addAttachmentResponse = given()
		    .header("X-Atlassian-Token", "no-check").pathParam("key", issueId)
		    .header("Authorization","Basic bmF2ZWVucGF0aGFrMjhAZ21haWwuY29tOkFUQVRUM3hGZkdGMDVPUUxpTENmOXJYOVE0bGNJWjNJZFlmWFRMcHp6d1JPbVprQmR2YWVsWFlwYVRvM0JiVkNYY19EUnIwYzBDLV96VVlFbG5nRDFPcUY4Skt0YU9wallZWTJzU0FOX3dfdFVrZkx6VUgtQ002NU1IVzJ2VC1tZ042MkVsTlFHVk1yT3NkWktURXpaaGF1ZGNxZ3NoRld2eHIzT2ZqV25MaGhsNi1sMzNxTExVcz1CNEJFRDA5NQ==")
		    .multiPart("file", new File(attachmentFilePath)).
		when().post("rest/api/3/issue/{key}/attachments").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("addAttachmentResponse : "+addAttachmentResponse);
	}
}
