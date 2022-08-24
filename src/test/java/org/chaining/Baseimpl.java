package org.chaining;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Baseimpl {
	
	public static String sys_id;
	public static RequestSpecification input;
	public static Response response;
	public static ValidatableResponse valires;
	
	@BeforeSuite
	public void prereq() {
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident";
		input = RestAssured.given().log().all().auth()
		.basic("admin", "pKMMlaR-6f%4");

	}
	@AfterMethod
	public void postreq() {
		valires.log().all();

	}
	
	

}
