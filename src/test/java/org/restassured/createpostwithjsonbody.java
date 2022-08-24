package org.restassured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createpostwithjsonbody {
	
	@Test
	public void sendpost() {
		
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\RestAssuredJuly\\src\\test\\resources\\body_file.json");
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident";
		
		RequestSpecification inputreq = RestAssured.given().auth()
		.basic("admin", "pKMMlaR-6f%4")
		.contentType(ContentType.JSON)
		.accept(ContentType.XML)
		.queryParam("sysparm_fields","sys_id, contact_type, urgency, category, short_description" )
		.body(file);
		
		Response post = inputreq.post();
		
		post.prettyPrint();
		int statusCode = post.getStatusCode();
		System.out.println("Statuscode:" +statusCode);
		Object sys_id = post.xmlPath().get("response.result.sys_id");
		System.out.println("SyS_Id:" +sys_id);
	}
	
	
	
	
	
	
	

}
