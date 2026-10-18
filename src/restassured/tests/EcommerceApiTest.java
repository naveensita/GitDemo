package restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import restassured.constants.DataConstants;
import restassured.pojoclasses.EcommerceAddProductResponse;
import restassured.pojoclasses.EcommerceLoginRequest;
import restassured.pojoclasses.EcommerceLoginResponse;
import restassured.pojoclasses.Order;
import restassured.pojoclasses.OrderDetails;
import restassured.specbuilder.AddProductSpec;
import restassured.specbuilder.CreateOrderSpec;
import restassured.specbuilder.DeleteProductSpec;
import restassured.specbuilder.EcommerceApiSpec;
import restassured.specbuilder.ViewOrderSpec;
import restassured.utils.ReusableMethods;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EcommerceApiTest {
	
	@Test
	public void endToEndEcommerceApiTest() {
		
		EcommerceLoginRequest loginReqPayload = new EcommerceLoginRequest();
		loginReqPayload.setUserEmail("naveenpathak715@gmail.com");
		loginReqPayload.setUserPassword("Sonu123@#");
		
		//Login to Application and get token
		RequestSpecification loginRequest = given().relaxedHTTPSValidation().spec(EcommerceApiSpec.requestSpecBuilder())
		    .body(loginReqPayload);
		
		EcommerceLoginResponse loginResponse = loginRequest.when().post("/api/ecom/auth/login").
		then().extract().response().as(EcommerceLoginResponse.class);
		
		String token = loginResponse.getToken();
		String userId = loginResponse.getUserId();
		
		System.out.println("Token : "+token);
		System.out.println("UserId : "+userId);
		
		//Add Product and get product id
		RequestSpecification addProductRequest = given().relaxedHTTPSValidation().spec(AddProductSpec.addProductRequest(token))
		    .param("productName", "Casual Shirt").param("productAddedBy", userId)
		    .param("productCategory", "Fashion").param("productSubCategory", "Shirts")
		    .param("productPrice", "1800").param("productDescription", "Blackberry")
		    .param("productFor", "Women")
		    .multiPart("productImage", new File(DataConstants.dataFilePath + "woman-8228723_640.jpg"));
		
		EcommerceAddProductResponse addProductResponse = addProductRequest.when().post("/api/ecom/product/add-product").
		then().extract().response().as(EcommerceAddProductResponse.class);
		
		String productId = addProductResponse.getProductId();
		String successMessage = addProductResponse.getMessage();
		
		System.out.println("productId : "+productId);
		System.out.println("successMessage : "+successMessage);
		
		//Create order
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setCountry("India");
		orderDetails.setProductOrderedId(productId);
		Order order = new Order();
		ArrayList<OrderDetails> orderDetailList = new ArrayList<OrderDetails>();
		orderDetailList.add(orderDetails);
		order.setOrders(orderDetailList);
		
		RequestSpecification createOrderRequest = given().relaxedHTTPSValidation().
				spec(CreateOrderSpec.createOrderRequest(token)).body(order);
		
		String createOrderResponse = createOrderRequest.when().post("/api/ecom/order/create-order").
		then().extract().response().asString();
		
		
		System.out.println("createOrderResponse : "+createOrderResponse);
		JsonPath js = ReusableMethods.rawToJson(createOrderResponse);
		
		List<String> orderIds = js.getList("orders");
		String orderId = orderIds.get(0);
		System.out.println("OrderId : "+orderId);
		
		//View Order details
		RequestSpecification viewOrderRequest = given().relaxedHTTPSValidation()
				.log().all().spec(ViewOrderSpec.viewOrderRequest(token, orderId));
		
		String viewOrderResponse = viewOrderRequest.when().get("/api/ecom/order/get-orders-details").
		then().log().all().spec(ViewOrderSpec.viewOrderResponse()).extract().response().asString();
		
		System.out.println("viewOrderResponse : "+viewOrderResponse);
		
		//Delete Product
		RequestSpecification deleteProductRequest = given().relaxedHTTPSValidation().log().all()
			.spec(DeleteProductSpec.deleteProductRequest(token)).pathParam("productId", productId);
		
		String deleteProductResponse = deleteProductRequest.when().delete("/api/ecom/product/delete-product/{productId}").
		then().log().all().spec(DeleteProductSpec.deleteProductResponse()).extract()
		    .response().asString();
		
		System.out.println("deleteProductResponse : "+deleteProductResponse);
		 JsonPath js1 = ReusableMethods.rawToJson(deleteProductResponse);
		 String actualMessage = js1.get("message");
		 Assert.assertEquals(actualMessage, "Product Deleted Successfully", "Product not deleted");
		
		
	}

}
