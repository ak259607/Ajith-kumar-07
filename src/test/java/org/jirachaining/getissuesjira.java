package org.jirachaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class getissuesjira extends Basechain {

	
	@Test(dependsOnMethods="org.jirachaining.createissue.issue")
	public void getissue() {
		RestAssured.baseURI="https://api-training.atlassian.net/rest/api/2/issuetype";
		
		reqinput = RestAssured.given().log().all()
				.auth().preemptive()
				.basic("hari.radhakrishnan@testleaf.com", "2a1Jpxk7Pr7dLSkageha7DC7")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON);
		response = reqinput.get();
		valirespo = response.then();
		int statusCode = response.getStatusCode();
		System.out.println("Statuscode:"+statusCode);
		valirespo.assertThat().statusCode(200);
		//id=response.jsonPath().getList("[1]id");
		//System.out.println("id:"+id);
	}
	
	
	
}
