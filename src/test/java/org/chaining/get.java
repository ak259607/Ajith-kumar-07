package org.chaining;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;


public class get extends Baseimpl {
	@Test(dependsOnMethods="org.chaining.createpostwithjsonbody.sendpost")
	public void getid() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sysparm_fields", "sys_id, contact_type, urgency, category");
		map.put("category", "hardware");
		input
		.accept(ContentType.JSON)
		.queryParams(map);
		
		response = input.get();
		valires = response.then();
		int statusCode = response.getStatusCode();
		System.out.println("statuscode:" +statusCode);
		valires.assertThat().statusCode(200);
		List<Object> list = response.jsonPath().getList("result.sys_id");
		System.out.println("sysids:" +list);
		
		

	}
	
	
	

}
