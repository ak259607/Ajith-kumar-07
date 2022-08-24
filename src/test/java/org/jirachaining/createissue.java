package org.jirachaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class createissue extends Basechain {

	
	@Test
	public void issue() {
		
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\RestAssuredJuly\\src\\test\\resources\\issue_file.json");
		RestAssured.baseURI="https://api-training.atlassian.net/rest/api/2/issue/";
		reqinput = RestAssured.given().log().all()
		.auth().preemptive()
		.basic("hari.radhakrishnan@testleaf.com", "2a1Jpxk7Pr7dLSkageha7DC7")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(file);
		
		response = reqinput.post();
		valirespo = response.then();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		valirespo.assertThat().statusCode(201);
	}
	
	
	
}
