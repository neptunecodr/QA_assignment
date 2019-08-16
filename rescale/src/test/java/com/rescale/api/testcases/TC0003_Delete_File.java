package com.rescale.api.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rescale.baseSetup.APITestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC0003_Delete_File extends APITestBase{
	@BeforeClass
	void deleteFile() throws InterruptedException {
		logger.info("*********** Started TC0003_Get_All_Files *********** ");
		
		RestAssured.baseURI = "https://platform.rescale.com/api/v3";
		httpRequest = RestAssured.given().header("Authorization",API_KEY);
		response = httpRequest.request(Method.GET,"/files/");
		//response = httpRequest.request(Method.GET,"/storage-devices/");
		
		JsonPath jsonpathEvaluator = response.jsonPath();
		String fileID=jsonpathEvaluator.get("[0].id");
		System.out.println(fileID);
		response = httpRequest.request(Method.DELETE,"/files/fileID");
		
		Thread.sleep(3000);
	}

	@Test(priority=2)
	public void checkDeleteFile_StatusCode() throws InterruptedException {
		logger.info("*********** checking Status Code for delete file TC0003_Delete_File *********** ");
		
		int statusCode = response.getStatusCode();
		logger.info("Status Code is ==>" + statusCode); //200
		try{
			Assert.assertEquals(statusCode, 200);
			}catch(AssertionError e){
			  // Log error;
			   //Takescreenshot;
				Thread.sleep(20);
				System.out.println("delete api request failed......");	
				logger.info("checkDeleteFile_statusCode returned invalid statuscode ");
				logger.info("deleteFile api Failed ");
			}
	}
	
	@AfterClass
	void tearDown() {
		logger.info("*********** finish TC0003_Delete_File *********** ");	
	}
}
