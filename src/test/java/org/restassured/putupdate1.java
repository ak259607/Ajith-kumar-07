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

public class putupdate1 {

	
	@Test
	public void getissue() {
		
	
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident";
		
		
		RequestSpecification input = RestAssured.given().log().all()
		.auth()
		.basic("admin", "pKMMlaR-6f%4")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "sys_id, category, short_description, priority")
		.body("{\"short_description\":\"created using put\",\"priority\":\"2\"}");
		
		Response put = input.when().put("9eecefb247301110679fb7f3846d43b5");
		put.then().log().all();
		int statusCode = put.getStatusCode();
		System.out.println(statusCode);
		
		put.then().assertThat().statusCode(200)
		.body("result.short_description", Matchers.equalTo("created using put"));
		
	}
	
	
	
}
