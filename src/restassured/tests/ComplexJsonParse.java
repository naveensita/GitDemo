package restassured.tests;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import restassured.utils.Payload;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(Payload.coursePrice());
		
		//Print no. of course return by API
		int courseCount = js.getInt("courses.size()");
		System.out.println("courseCount : "+courseCount);
		
		//Print purchase amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("purchaseAmount : "+purchaseAmount);
		
		//Title of first course
		String firstCourseTitle = js.get("courses[0].title");
		System.out.println("firstCourseTitle : "+firstCourseTitle);
		
		//Print all courses titles and respective prices
		System.out.println("*************************************");
		for (int i = 0; i < courseCount; i++) {
			String courseTitle = js.getString("courses["+i+"].title");
			System.out.println("courseTitle : "+courseTitle);
			System.out.println(js.getInt("courses["+i+"].price"));
		}
		
		//Print no. of course sold by RPA course
		System.out.println("#######################################");
		for (int i = 0; i < courseCount; i++) {
			String courseTitle = js.getString("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA")) {
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("No. of copies sold by course RPA : "+copies);
				break;
			}
		}
		
		//Verify sum of all courses price matches with purchase amount
		System.out.println("*************************************");
		//purchaseAmount = js.getInt("dashboard.purchaseAmount");
		int coursePrice = 0;
		for (int i = 0; i < courseCount; i++) {
			int price = js.getInt("courses["+i+"].price");
			int numberOfCopies = js.getInt("courses["+i+"].copies");
			coursePrice = coursePrice + (price*numberOfCopies);
		}
		System.out.println(coursePrice);
		if(coursePrice==purchaseAmount) {
			System.out.println("sum of all courses price matches with purchase amount");
		} else {
			System.out.println("sum of all courses price not matches with purchase amount");
			Assert.fail();
		}
		

	}
}
