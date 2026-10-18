package restassured.tests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

// TODO: Auto-generated Java-doc
/**
 * The Class OauthAuthorizationCodeTest.
 * @author Naveen.Pathak
 */
public class OauthAuthorizationCodeTest {
	
	/**
	 * O auth authorization code test.
	 * @throws InterruptedException 
	 */
	@Test
	public void oAuthAuthorizationCodeTest() throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver.exe");
		// 1. Instantiate EdgeOptions
		EdgeOptions options = new EdgeOptions();

		// 2. Hide the "Edge is being controlled by automated test software" infobar
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		// 3. Disable Blink's automation controller flag (navigator.webdriver = false)
		options.addArguments("--disable-blink-features=AutomationControlled");

		// 4. (Optional) Start maximized
		options.addArguments("--start-maximized");
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("naveenpathaktest@gmail.com");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Sonu123@#");
		Thread.sleep(6000);
		//driver.findElement(By.cssSelector("#identifierId")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		//Thread.sleep(8000);
		//driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
		Thread.sleep(8000);
		String url = driver.getCurrentUrl();
		System.out.println("URL : "+url);
		String authorizationCode = url.split("code=")[1].split("&scope")[0];
		System.out.println("authorizationCode : "+authorizationCode);
		driver.quit();
		
		String accessTokenResponse = given().urlEncodingEnabled(false).log().all()
			.queryParam("code", authorizationCode)
			.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
			.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
			.queryParam("grant_type", "authorization_code").
			
		when().post("https://www.googleapis.com/oauth2/v4/token").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("accessTokenResponse : "+accessTokenResponse);
		
		JsonPath js = ReusableMethods.rawToJson(accessTokenResponse);
		
		String access_token = js.getString("access_token");
		System.out.println("access_token : "+access_token);
		
		String response = given().urlEncodingEnabled(false).log().all()
				.queryParam("access_token", access_token).
		when().get("https://rahulshettyacademy.com/getCourse.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("response : "+response);
		
	}

}
