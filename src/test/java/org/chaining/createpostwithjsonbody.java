package org.chaining;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;


public class createpostwithjsonbody extends Baseimpl{
	
	@Test
	public void sendpost() {
		
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\RestAssuredJuly\\src\\test\\resources\\body_file.json");
		input
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields","sys_id, contact_type, urgency, category, short_description" )
		.body(file);
		
		response = input.post();
		int statusCode = response.getStatusCode();
		System.out.println("Statuscode:" +statusCode);
		valires = response.then();
		valires.assertThat().statusCode(201);
		valires.assertThat().body("result.short_description", Matchers.containsString("created using xml"));
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println("SyS_Id:" +sys_id);
		
	}
	
	
	
	
	
	
	

}
