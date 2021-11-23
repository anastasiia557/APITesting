import static org.hamcrest.Matchers.equalTo;

import org.json.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
public class store {
	@BeforeTest
	public void SetUp() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
		
	@Test
	public void getOrderByID() {
		Response resp = RestAssured.given()
			.when()
			.get("/store/order/6");
		int statusCode = resp.getStatusCode();
		System.out.println("The response status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		ValidatableResponse status = resp.then().body("id", equalTo(6));
		System.out.println(resp.prettyPrint());
		}
	
	@Test
	public void postNewPet() {
		RequestSpecification request = RestAssured.given();
	
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 0);
		requestParams.put("petId", 0);
		requestParams.put("quantity", 0);
		requestParams.put("shipdate", "2021-11-22T08:23:06.229Z");
		requestParams.put("status", "placed");
		requestParams.put("complete", "true");
		request.header("Content-Type", "application/json");
		request.accept("application/json");
		request.body(requestParams.toString());
		Response response = request.post("/store/order");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("The response status code is " + statusCode);
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void getPetInvenroriesByStatus() {
		Response resp = RestAssured.given()
			.when()
			.get("/store/inventory");
		int statusCode = resp.getStatusCode();
		System.out.println("The response status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println(resp.prettyPrint());
	}
	
	@Test
	public void deleteOrderByID() {
		Response resp = RestAssured.given()
				.when()
				.delete("/store/order/2")
				.then()
				.extract().response();
	Assert.assertEquals(404, resp.statusCode());
	}
}

