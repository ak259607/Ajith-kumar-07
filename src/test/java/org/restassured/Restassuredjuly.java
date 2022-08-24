package org.restassured;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Restassuredjuly {
	@Test
	public void restassured() {
		RestAssured.baseURI="https://dev123886.service-now.com/api/now/table/incident?sysparm_limit=1";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("sysparm_fields", "sys_id, contact_type, urgency, category");
		map.put("category", "hardware");
		RequestSpecification requestSpecification = RestAssured.given().auth()
		.basic("admin", "pKMMlaR-6f%4")
		.accept(ContentType.XML)
		.queryParams(map);
		
		Response response = requestSpecification.get();
		
		response.prettyPrint();
		List<Object> list = response.xmlPath().getList("response.result.sys_id");
		System.out.println("sysids:" +list);
		int statusCode = response.getStatusCode();
		System.out.println("statuscode:" +statusCode);
		
		

	}
	
	
	

}
