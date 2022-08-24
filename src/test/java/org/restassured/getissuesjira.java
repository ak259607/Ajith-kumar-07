package org.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class getissuesjira {

	
	@Test
	public void getissue() {
		RestAssured.baseURI="https://api-training.atlassian.net/rest/api/2/issuetype";
		
		
		RequestSpecification input = RestAssured.given()
		.auth().preemptive()
		.basic("hari.radhakrishnan@testleaf.com", "QwYP5qKtgEHT9kQYb6OUEB74")
		.accept(ContentType.JSON);
		
		Response response = input.get();
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
	}
	
	
	
}
