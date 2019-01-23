package LearningRestAssured.br.com.simplez;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONPostTest {
	@Test
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("FirstName", "Virender"); // Cast
	 requestParams.put("LastName", "Singh");
	 requestParams.put("UserName", "sdimpleuser2dd2011");
	 requestParams.put("Password", "password1");
	 
	 requestParams.put("Email",  "sample2ee26d9@gmail.com");
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/register");
	 
	 int statusCode = response.getStatusCode();
	 int expected = 201;
	 Assert.assertEquals(expected, statusCode);
	}
}
