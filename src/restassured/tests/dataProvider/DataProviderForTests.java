package restassured.tests.dataProvider;
import org.testng.annotations.DataProvider;

public class DataProviderForTests {
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		
		return new Object[][] {{"sdfgh", 458970, "Naveen Pathak"},
			{"qwert", 209432, "Tanmay Pathak"},{"zxcvb", 409127, "Praveen Pathak"}};
		
	}

}
