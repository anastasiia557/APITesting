import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class user {

	@BeforeTest
	public void SetUp() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	@Test
	public void getUserByUserName() {
		Response resp = RestAssured.given()
			.when()
			.get("/user/user1");
		int statusCode = resp.getStatusCode();
		System.out.println("The response status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("user1", resp.jsonPath().getString("username"));
		System.out.println(resp.prettyPrint());
	}
}
