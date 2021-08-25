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
