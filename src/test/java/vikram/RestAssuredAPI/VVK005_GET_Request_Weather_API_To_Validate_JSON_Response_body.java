package vikram.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VVK005_GET_Request_Weather_API_To_Validate_JSON_Response_body
{
	@Test
	void getweatherDetails()
	{
	  //Specifying the base URI
	  RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
	  
	  //Creation of Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/Hyderabad");
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //Validate JSON Response body
	  Assert.assertEquals(responseBody.contains("Hyderabad"), true);
	  
	 }

}
