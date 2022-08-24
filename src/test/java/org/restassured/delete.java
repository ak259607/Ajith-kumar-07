package org.restassured;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class delete {

	
	@Test(priority=-1)
	public void getissue() {
		
	
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident";
		
		
		RequestSpecification input = RestAssured.given().log().all()
		.auth()
		.basic("admin", "pKMMlaR-6f%4");
		
		Response delete = input.when().delete("d733f73a47301110679fb7f3846d43d7");
		delete.then().log().all();
		int statusCode = delete.getStatusCode();
		System.out.println(statusCode);

		delete.then().assertThat().statusCode(204);
		
	}
	
	
	@Test(priority=1)
	public void getissue1() {
		
	
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident";
		
		
		RequestSpecification input = RestAssured.given().log().all()
		.auth()
		.basic("admin", "pKMMlaR-6f%4");
		
		Response delete = input.when().delete("d733f73a47301110679fb7f3846d43d7");
		delete.then().log().all();
		int statusCode = delete.getStatusCode();
		System.out.println(statusCode);

		
		delete.then().assertThat().statusCode(404);
	}
	
}
