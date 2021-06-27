package com.in28minutes.rest.webservices.restfulwebservices;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.hibernate.mapping.Map;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.in28minutes.rest.webservices.restfulwebservices.helloworld.Item;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTests {
	private static final int CHECKED_ITEM_ID = 1;
	private static final Item CHECKED_ITEM = new ItemBuilder().id(CHECKED_ITEM_ID).checked().build();
	private static final Item UNCHECKED_ITEM = new ItemBuilder().id(2).checked().build();
	private static final Item NEW_ITEM = new ItemBuilder().checked().build();
	// RestAssured get All Item
	static ExtentTest test;
	static ExtentReports report;
	/*
	 * @Test public void databaseexistOrNot() { Response response = given().when()
	 * .get(
	 * "http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/h2-console/").
	 * then().extract() .response();
	 * 
	 * assertEquals(200, response.getStatusCode());
	 * 
	 * }
	 */
	@Before
	public  void startTest()
	{
	report = new ExtentReports("\\PayloadValidatorTest.html");
	test = report.startTest("Test Cases");
	}
	@Test
	public void planetsCheck() {
	    Response response = given()
	            .filter(new AllureRestAssured())
	            .when()
	            .get("http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/7").then()
	            .extract().response();
		 test.log(LogStatus.PASS, "verifyAllToDoList Test Pass");
		 test.log(LogStatus.PASS, response.asString());
	    Assert.assertEquals(response.statusCode(), 200);
	}
	 @After
	    public  void endTest()
	    {
	    	System.out.println(System.getProperty("user.dir")+"Test report data");
	    report.endTest(test);
	    report.flush();
	    }
	  
	/*
	 * @Test public void getAll() { Response response = given().when().get(
	 * "http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/")
	 * .then().extract().response(); assertEquals(200, response.getStatusCode());
	 * 
	 * } // RestAssured get By Item
	 * 
	 * @Test public void getById() { Response response = given().when().get(
	 * "http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/7")
	 * .then().extract().response(); // typecasting obj to JSONObject Item item =
	 * new Gson().fromJson(response.getBody().asString(), Item.class);
	 * 
	 * assertEquals(true, item.getStatus());
	 * 
	 * }
	 * 
	 * // Save Data to Item
	 * 
	 * @Test public void testSaveItem() { Item item = new Item(); //item.setId(1);
	 * item.setStatus(true); item.setDescription("test case save");
	 * 
	 * Response response =
	 * RestAssured.given().contentType(ContentType.JSON).header("Content-Type",
	 * ContentType.JSON) .body(new Gson().toJson(item))
	 * .post("http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items").
	 * then().extract().response();
	 * 
	 * assertEquals(200, response.getStatusCode()); }
	 * 
	 * // Update to Item
	 * 
	 * @Test public void testupdateItem() { Item item = new Item(); item.setId(8);
	 * item.setStatus(true); item.setDescription("status updated to true");
	 * 
	 * Response response = RestAssured.given() .baseUri(
	 * "http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/8")
	 * .header("Content-Type", ContentType.JSON).body(new
	 * Gson().toJson(item)).when().put().then().extract() .response();
	 * 
	 * assertEquals(200, response.getStatusCode()); }
	 */
}
