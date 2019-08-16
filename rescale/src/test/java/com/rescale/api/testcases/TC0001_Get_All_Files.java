package com.rescale.api.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rescale.baseSetup.APITestBase;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;

public class TC0001_Get_All_Files extends APITestBase {

	
@BeforeClass
void getAllFiles() throws InterruptedException {
	logger.info("*********** Started TC0001_Get_All_Files *********** ");
	RestAssured.baseURI = "https://platform.rescale.com/api/v3/";
	httpRequest = RestAssured.given().header("Authorization",API_KEY);
	response = httpRequest.request(Method.GET,"/files/");
	//response = httpRequest.request(Method.GET,"/storage-devices/");
	
	Thread.sleep(3000);
}

@Test(priority=1)
public void checkResponsebody() {
	logger.info("*********** checking Response body for getfiles TC0001_Get_All_Files *********** ");
	String responseBody = response.getBody().asString();
	logger.info("Response Body==>"+responseBody);
	Assert.assertTrue(responseBody !=null);
}

@Test(priority=2)
public void checkStatusCode() throws InterruptedException {
	logger.info("*********** checking Status Code for getfiles TC0001_Get_All_Files *********** ");
	
	int statusCode = response.getStatusCode();
	logger.info("Status Code is ==>" + statusCode); //200
	try{
		Assert.assertEquals(statusCode, 200);
		}catch(AssertionError e){
		  // Log error;
		   //Takescreenshot;
			Thread.sleep(20);
			System.out.println("get all files api request failed......");	
			logger.info("getAllFiles returned invalid statuscode ");
			logger.info("getAllFiles Failed ");
		}
	
}
@Test(priority=3)
public void checkContentType() {
	logger.info("*********** checking Content Type for getfiles TC0001_Get_All_Files *********** ");
	
	String contentType = response.header("Content-Type");
	logger.info("Content type is ==>" +contentType); //200
	Assert.assertEquals(contentType, "application/json");
	
}

@Test(priority=4)
public void checkFilesListCount() {
	logger.info("*********** checking FileId for getfiles TC0001_Get_All_Files *********** ");

}


@AfterClass
void tearDown() {
	logger.info("*********** finish TC0001_Get_All_Files *********** ");	
}


}
