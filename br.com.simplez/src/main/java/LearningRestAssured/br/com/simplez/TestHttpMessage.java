package LearningRestAssured.br.com.simplez;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestHttpMessage {
	 @Test
	 public void GetWeatherDetails(){   
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/78789798798");
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
	 }
}
