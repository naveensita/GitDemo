package restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class GraphQLScript {
	
	int characterId = 6410;
	int episodeId= 5299;
	int locationId = 7349;
	String locationName ="Iran";
	String characterName = "Gola Pathak";
	String episodeName = "Terii Meharbaniyaa";
	
	
	@Test(enabled=true)
	public void graphQlQuerySciptTest() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/gq/graphql";
		String response = given().log().all().header("Content-Type", "application/json").
		   body("{\"query\":\"query($characterId:Int!, $episodeId:Int!, $locationId: Int!)\\n{\\n  character(characterId:$characterId)\\n  {\\n    name\\n    gender\\n    status\\n    id\\n    type\\n  }\\n  location(locationId:$locationId)\\n  {\\n    name\\n    dimension\\n  }\\n  episode(episodeId:$episodeId)\\n  {\\n    name\\n    air_date\\n    episode\\n  }\\n  characters(filters:{name:\\\"Praveen\\\"})\\n  {\\n    info\\n    {\\n      count\\n    }\\n    result{\\n      name\\n      type\\n    }\\n  }\\n  episodes(filters:{name:\\\"DeadPool\\\"})\\n  {\\n   result\\n    {\\n      id\\n      name\\n      air_date\\n      episode\\n    }\\n  }\\n}\",\"variables\":{\"characterId\":"+characterId+",\"episodeId\":"+episodeId+",\"locationId\":"+locationId+"}}").
		when().post().
		then().extract().response().asString();
		System.out.println("response : "+response);
		JsonPath js = new JsonPath(response);
		String characterName = js.getString("data.character.name");
		Assert.assertEquals(characterName, "Manjay");
	}
	
	@Test(enabled = true)
	public void graphQlMutationSciptTest() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/gq/graphql";
		
		String mutationResponse = given().log().all().header("Content-Type", "application/json").
		   body("{\"query\":\"mutation($locationName:String!,$characterName:String!,$episodeName:String!){\\n  \\n  createLocation(location:{name:$locationName,type:\\\"NORTH-ZONE\\\",dimension:\\\"1234\\\"})\\n  {\\n    id\\n  }\\n  \\n    createCharacter(character:{name:$characterName,type:\\\"macho\\\",status:\\\"alive\\\",species:\\\"fantasy\\\",\\n    gender:\\\"male\\\",image:\\\"png\\\",originId:7342,locationId:7342})\\n  {\\n    id\\n  }\\n  \\n  createEpisode(episode:{name:$episodeName,air_date:\\\"1990 June\\\",episode:\\\"Netflix\\\"})\\n  {\\n    id\\n  }\\n}\\n\",\"variables\":{\"locationName\":\""+locationName+"\",\"characterName\":\""+characterName+"\",\"episodeName\":\""+episodeName+"\"}}").
		when().post().
		then().extract().response().asString();
		System.out.println("mutationResponse : "+mutationResponse);
	}
}
