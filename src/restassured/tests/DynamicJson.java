package restassured.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.tests.dataProvider.DataProviderForTests;
import restassured.utils.Payload;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="BooksData", dataProviderClass = DataProviderForTests.class)
	public void addBook(String isbnCode, int aisleNumber, String authorName) {
		RestAssured.baseURI = "http://216.10.245.166";
		//String authorName = "Naveen Pathak";
		
		//Add Book
		String addBookResponse = given().log().all().header("Content-Type","application/json").
		body(Payload.addBook(isbnCode, aisleNumber, authorName)).
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReusableMethods.rawToJson(addBookResponse);
		String bookId = js.get("ID");
		System.out.println("bookId : "+bookId);
		
		//Get Book by Id
		String getBookResponse = given().log().all().queryParam("ID", bookId).
		when().get("Library/GetBook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("getBookResponse : "+getBookResponse);
		
		//Get Book by author name
		String getBookResponseByName = given().log().all().queryParam("AuthorName", authorName).
		when().get("Library/GetBook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("getBookResponseByName : "+getBookResponseByName);
		
		//Delete book
		String deleteResponse = given().log().all().header("Content-Type","application/json").
		body(Payload.deleteBook(bookId)).
		when().post("Library/DeleteBook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("deleteResponse : "+deleteResponse);
		
	}

}
