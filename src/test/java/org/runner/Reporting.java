package org.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	
	public static void genReport(String j) {

	File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\RestAssuredJuly\\src\\test\\resources\\report");
	
	Configuration c = new Configuration(file, "login");
	
	c.addClassifications("os", "windows");
	c.addClassifications("Chrome", "99");
	c.addClassifications("sprint", "12");
	
	List<String> jsonfiles = new ArrayList<String>();
	jsonfiles.add(j);
	
	
	ReportBuilder builder = new ReportBuilder(jsonfiles, c);
	
	builder.generateReports();

	
	
	

}
}