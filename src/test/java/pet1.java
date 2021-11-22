import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class pet1 {
	private static RequestSpecification spec;
	
	
	@BeforeTest
	public void setUp() {
		spec = new RequestSpecBuilder()
				.setBaseUri("https://petstore.swagger.io/v2")
				.build();
	}
	
	@Test
	public void getPetsWithAvailableStatus() {
		List<String> status = RestAssured.given()
				.spec(spec)
				.when()
				.get("/pet/findByStatus?status=available")
				.then().assertThat().statusCode(200)
				.extract().path("status");
	for (String s : status) {
		Assert.assertEquals(s, "available");
		System.out.println("The status is " + s);
	}	
	}
	
	@Test
	public void getPetsWithPendingStatus() {
		List<String> status = RestAssured.given()
				.spec(spec)
				.when()
				.get("/pet/findByStatus?status=pending")
				.then().assertThat().statusCode(200)
				.extract().path("status");
	for (String s : status) {
		Assert.assertEquals(s, "pending");
		System.out.println("The status is " + s);
	}	
	}
	
	@Test
	public void getPetsWithSoldStatus() {
		List<String> status = RestAssured.given()
				.spec(spec)
				.when()
				.get("/pet/findByStatus?status=sold")
				.then().assertThat().statusCode(200)
				.extract().path("status");
	for (String s : status) {
		Assert.assertEquals(s, "sold");
		System.out.println("The status is " + s);
		
	}	
	}
	
	
}
		