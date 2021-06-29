package com.in28minutes.rest.webservices.restfulwebservices;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.mapping.Map;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.in28minutes.rest.webservices.restfulwebservices.helloworld.Item;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@ContextConfiguration(classes = ItemTests.class)
@SpringBootTest
public class ItemTests {
	private static final int CHECKED_ITEM_ID = 1;
	private static final Item CHECKED_ITEM = new ItemBuilder().id(CHECKED_ITEM_ID).checked().build();
	private static final Item UNCHECKED_ITEM = new ItemBuilder().id(2).checked().build();
	private static final Item NEW_ITEM = new ItemBuilder().checked().build();
	// RestAssured get All Item
HashMap<String, String> map=new HashMap<String, String>();
Result result=new Result();
static ArrayList<Result> arr;
static String status=""; 
@org.junit.BeforeClass
public static void startTest()
{
	arr=new ArrayList<Result>();
}

	 @Test public void databaseexistOrNot() { 
		 
	
		 
		 Response response = given().when()
	 .get(
	 "http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/h2-console/").
	 then().extract() .response();
	// result.setId(2);
	 result.setTestCaseName("databaseexistOrNot");
		 result.setStatus("Pass");
	 
	 result.setResponse("Connected");
arr.add(result);
	 assertEquals(200, response.getStatusCode());
	 
	 }
	 
	

	
	 @Test public void getAll() { Response response = given().when().get(
	 "http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/")
	 .then().extract().response(); assertEquals(200, response.getStatusCode());
	// result.setId(1);
	 result.setTestCaseName("getAll");
	 result.setStatus("Pass");
	 
	 result.setResponse(String.valueOf(response.getStatusCode()));
arr.add(result);
	 } // RestAssured get By Item
	 
	 @Test public void getById() throws Exception { Response response = given().when().get(
	"http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/7")
	  .then().extract().response(); // typecasting obj to JSONObject 
	 Item item =
	 new Gson().fromJson(response.getBody().asString(), Item.class);
	// result.setId(3);
	 
	if(item.getStatus()==false) {
		 result.setStatus("fail");

		 result.setTestCaseName("getbyId");
		 result.setResponse("java.lang.AssertionError: expected:<false> but was:<true>\n" + 
		 		"	at org.junit.Assert.fail(Assert.java:88)\n" + 
		 		"	at org.junit.Assert.failNotEquals(Assert.java:834)\n" + 
		 		"	at org.junit.Assert.assertEquals(Assert.java:118)\n" + 
		 		"	at org.junit.Assert.assertEquals(Assert.java:144)\n" + 
		 		"	at com.in28minutes.rest.webservices.restfulwebservices.ItemTests.getById(ItemTests.java:88)\n" + 
		 		"	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" + 
		 		
		 		""); 
		 arr.add(result); 
		 //new ZetaReport().createReport(arr);
		 new ZetaReport().createReportFail(arr);
		 assertEquals(true, item.getStatus());
		 
				 status="Fail";	 	 
	}else {
		 result.setStatus("Pass");
		 result.setTestCaseName("getbyId");
		 result.setResponse(response.asString());
		 arr.add(result);
		 new ZetaReport().createReport(arr);  
		 assertEquals(true, item.getStatus());
	// new ZetaReport().createReport(arr);
	 }
	 }
	 
	 // Save Data to Item
	 
	  @Test public void testSaveItem() throws Exception { Item item = new Item(); //item.setId(1);
	  item.setStatus(true); item.setDescription("test case save");
	 
	 Response response =
	 RestAssured.given().contentType(ContentType.JSON).header("Content-Type",
	 ContentType.JSON) .body(new Gson().toJson(item))
	 .post("http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items").
	 then().extract().response();
	// result.setId(4);
	 result.setTestCaseName("testSaveItem");
	 result.setStatus("Pass");
	 result.setResponse(response.asString()); 
	 arr.add(result);
	 assertEquals(200, response.getStatusCode()); 
	 
	
	  }
	 
	 // Update to Item
	 
	/*
	 * @Test public void testupdateItem() { Item item = new Item(); item.setId(8);
	 * item.setStatus(true); item.setDescription("status updated to true");
	 * 
	 * Response response = RestAssured.given() .baseUri(
	 * "http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/8")
	 * .header("Content-Type", ContentType.JSON).body(new
	 * Gson().toJson(item)).when().put().then().extract() .response();
	 * Assert.assertEquals(response.statusCode(), 200); assertEquals(200,
	 * response.getStatusCode()); }
	 */

}
