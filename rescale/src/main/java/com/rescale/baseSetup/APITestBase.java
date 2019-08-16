package com.rescale.baseSetup;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class APITestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static String API_KEY = "Token 39d9bbc420e3d39501f4b2ec680b0141fa6fc308";
	
	
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("RescaleRestAPI"); //added Logger
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}
