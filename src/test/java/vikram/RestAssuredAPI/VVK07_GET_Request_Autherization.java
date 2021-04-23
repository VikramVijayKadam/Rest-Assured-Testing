package vikram.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VVK07_GET_Request_Autherization
{
	@Test
	public void AutherizationTest()
	{
	  //Specifying the base URI
	  RestAssured.baseURI="https://demoqa.com/authentication/CheckForAuthentication";
	  
	  //Basic Authentication
	  PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
	  authScheme.setUserName("ToolsQA");
	  authScheme.setPassword("TestPassword");
	  RestAssured.authentication=authScheme;
	  
	  //Creation of Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/");
	  
	  //Print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is : "+responseBody);
	  
	  //Status code Validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is : "+statusCode);
	  
	  Assert.assertEquals(statusCode, 200);
	  
	  
	  
	  
	  
	 }

}
