package org.chaining;


import org.testng.annotations.Test;


public class delete extends Baseimpl {

	
	@Test(dependsOnMethods="org.chaining.putvalid.putid")
	public void deleteid() {
				
		response = input.when().delete(sys_id);
		valires = response.then();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		valires.assertThat().statusCode(204);
		
	}
	
	
	
}
