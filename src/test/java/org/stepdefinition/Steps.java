package org.stepdefinition;

import java.io.File;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {
	
	public static Response response;
	public static RequestSpecification request;
	
	@Given("Setup the Base URI for Incident API")
	public void setup_the_base_uri_for_incident_api() {
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident";
		    
	}
	@Given("Setup the Authentication wit valid Credentials")
	public void setup_the_authentication_wit_valid_credentials() {
	   RestAssured.authentication=RestAssured.basic("admin", "pKMMlaR-6f%4");
	}
	@When("Place the get request")
	public void place_the_get_request() {
	 response = RestAssured.given().log().all().get();  
	}

	@Then("Validate the status code as {int}")
	public void validate_the_status_code_as(Integer int1) {
	    response.then().assertThat().statusCode(int1);
	}
	
	@Given("Pass the Data to the body from {string} file")
	public void pass_the_data_to_the_body_from_json_file(String File ) {
	    File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\RestAssuredJuly\\src\\test\\resources\\"+File);
	    request = RestAssured.given().log().all().contentType(ContentType.JSON).body(file);
	}
	@When("Place the post request")
	public void place_the_post_request() {
	    response=request.post();
	}
	

	
}