package org.runner;




import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src\\test\\java\\org\\feature\\incident.feature",
					glue="org.stepdefinition"	,monochrome=true,publish=true
					,plugin={"pretty","json:src\\test\\resources\\report\\report1.json"})
public class RunnerClass extends AbstractTestNGCucumberTests {
	@AfterSuite
	public static void report() {
		Reporting.genReport("C:\\Users\\ELCOT\\eclipse-workspace\\RestAssuredJuly\\src\\test\\resources\\report\\report1.json");
	}

}
