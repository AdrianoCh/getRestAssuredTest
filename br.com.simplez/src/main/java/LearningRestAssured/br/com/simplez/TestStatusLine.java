package LearningRestAssured.br.com.simplez;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestStatusLine {
	@Test
	public void GetWeatherStatusLine(){
	 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	 // Get the status line from the Response and store it in a variable called statusLine
	 String statusLine = response.getStatusLine();
	 Assert.assertEquals("HTTP/1.1 200 OK" /*expected value*/, statusLine /*actual value*/);
	}
}
