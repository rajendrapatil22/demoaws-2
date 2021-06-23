package com.in28minutes.rest.webservices.restfulwebservices;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.in28minutes.rest.webservices.restfulwebservices.helloworld.Item;

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

	@Test

	public void getByIdKO() {
		Response response = given().when().get("http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items")
				.then().extract().response();
		assertEquals(200, response.getStatusCode());

	}
	// RestAssured get All Item

	@Test
	public void testItemList() {
		Response resp = (Response) RestAssured.given().when()
				.get("http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items").then().extract().response();
		assertEquals(200, resp.getStatusCode());
	}

	// Save Data to Item

	@Test
	public void testSaveItem() {
		Item item = new Item();
		item.setId(1);
		item.setStatus(true);
		item.setDescription("test case save");

		Response response = RestAssured.given().contentType(ContentType.JSON).header("Content-Type", ContentType.JSON)
				.body(new Gson().toJson(item))
				.post("http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items").then().extract().response();

		assertEquals(200, response.getStatusCode());
	}

	// Update to Item

	@Test
	public void testupdateItem() {
		Item item = new Item();
		item.setId(3);
		//item.setChecked(true);
		item.setDescription("status updated to true");

		Response response = RestAssured.given()
				.baseUri("http://demo4-env.eba-ivkwtadj.us-east-2.elasticbeanstalk.com/items/1")
				.header("Content-Type", ContentType.JSON).body(new Gson().toJson(item)).when().put().then().extract()
				.response();

		assertEquals(200, response.getStatusCode());
	}

}
