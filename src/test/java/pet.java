import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;


public class pet {
	
	@BeforeTest
	public void SetUp() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	@Test
	public void getPetsWithAvailableStatus() {
	Response resp = RestAssured.given()
		.when()
		.get("/pet/findByStatus?status=available");
	int statusCode = resp.getStatusCode();
	System.out.println("The response status code is " + statusCode);
	Assert.assertEquals(statusCode, 200);
	String json = resp.asString();
	JsonPath jp = new JsonPath(json);
	Assert.assertEquals("available", jp.getString("status[1]"));
	System.out.println(resp.prettyPrint());
	}
	
	@Test
	public void getPetsWithPendingStatus() {
		Response resp = RestAssured.given()
			.when()
			.get("/pet/findByStatus?status=pending");
		int statusCode = resp.getStatusCode();
		System.out.println("The response status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String json = resp.asString();
		JsonPath jp = new JsonPath(json);
		Assert.assertEquals("pending", jp.getString("status[1]"));
		System.out.println(resp.prettyPrint());
		}
	
	@Test
	public void getPetsWithSoldStatus() {
		Response resp = RestAssured.given()
			.when()
			.get("/pet/findByStatus?status=sold");
		int statusCode = resp.getStatusCode();
		System.out.println("The response status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String json = resp.asString();
		JsonPath jp = new JsonPath(json);
		Assert.assertEquals("sold", jp.getString("status[1]"));
		System.out.println(resp.prettyPrint());
	}
	
	@Test
	public void getPetsByID6() {
		Response resp = RestAssured.given()
			.when()
			.get("pet/6");
		int statusCode = resp.getStatusCode();
		System.out.println("The response status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("6", resp.jsonPath().getString("id"));
		System.out.println(resp.prettyPrint());
	}
	@Test
	public void getPetsByID17() {
		Response resp = RestAssured.given()
			.when()
			.get("pet/17");
		int statusCode = resp.getStatusCode();
		System.out.println("The response status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals("17", resp.jsonPath().getString("id"));
		System.out.println(resp.prettyPrint());
	}
}
	
		
		
		
		

	
	