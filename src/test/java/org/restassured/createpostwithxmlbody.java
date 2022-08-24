package org.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createpostwithxmlbody {
	
	@Test
	public void sendpost() {
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident";
		
		RequestSpecification inputreq = RestAssured.given().auth()
		.basic("admin", "pKMMlaR-6f%4")
		.contentType(ContentType.XML)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields","sys_id, contact_type, urgency, category, short_description" )
		.body("<request><entry><short_description>created using xml</short_description><category>software</category></entry></request>");
		
		Response post = inputreq.post();
		
		post.prettyPrint();
		int statusCode = post.getStatusCode();
		System.out.println("Statuscode:" +statusCode);
		Object sys_id = post.jsonPath().get("result.sys_id");
		System.out.println("SyS_Id:" +sys_id);
	}
	
	
	
	
	
	
	

}
