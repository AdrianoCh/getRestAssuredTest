package LearningRestAssured.br.com.simplez;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestHeader {
	@Test
	public void GetWeatherHeaders(){
	 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	 String serverType =  response.header("Server");
	 Assert.assertEquals(serverType /* actual value */, "nginx/1.12.1" /* expected value */);
	}
	
	@Test
	public void GetContentType() {
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/Hyderabad");
		 String contentType = response.header("Content-Type");
		 Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
	}
	
	@Test
	public void GetContentEncoding() {
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/Hyderabad");
		 String contentEncoding = response.header("Content-Encoding");
		 Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
	}
}
