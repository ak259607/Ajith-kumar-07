package org.chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class putvalid extends Baseimpl {
	@Test(dependsOnMethods="org.chaining.get.getid")
	public void putid() {
		input
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "sys_id, category, short_description, priority")
		.body("{\"short_description\":\"created using put\",\"priority\":\"2\"}");
		
		response = input.when().put(sys_id);
		valires = response.then();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		valires.assertThat().statusCode(200)
		.body("result.short_description", Matchers.equalTo("created using put"));
		
	
}
}