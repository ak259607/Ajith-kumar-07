package org.restassured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class createissue {

	
	@Test
	public void getissue() {
		
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\RestAssuredJuly"
				+ "\\src\\test\\resources\\issue_file.json");
		RestAssured.baseURI="https://api-training.atlassian.net/rest/api/2/issue/";
		
		
		RequestSpecification input = RestAssured.given()
		.auth().preemptive()
		.basic("hari.radhakrishnan@testleaf.com", "QwYP5qKtgEHT9kQYb6OUEB74")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(file);
		
		Response post = input.post();
		post.prettyPrint();
		int statusCode = post.getStatusCode();
		System.out.println(statusCode);
		Object object = post.jsonPath().get("id");
		System.out.println(object);
	}
	
	
	
}
