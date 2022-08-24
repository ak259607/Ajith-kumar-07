package org.jirachaining;

import org.testng.annotations.AfterMethod;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Basechain {

	public static Object id;
	public static RequestSpecification reqinput;
	public static Response response;
	public static ValidatableResponse valirespo;

	
	
	@AfterMethod
	public void postreq() {
		valirespo.log().all();

	}
	
	
	
	
	
}
