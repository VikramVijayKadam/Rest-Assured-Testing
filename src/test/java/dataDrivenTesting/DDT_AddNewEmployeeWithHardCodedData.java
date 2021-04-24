package dataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DDT_AddNewEmployeeWithHardCodedData 
{
	@SuppressWarnings("unchecked")
	@Test
	void postNewEmployees()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Here we created data which we can send along with post request
		JSONObject requestParams= new JSONObject();
		requestParams.put("name", "VVK3");
		requestParams.put("salary", "70000");
		requestParams.put("age", "25");
		
		//Add a header stating the request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		//Add the JSON to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST Request
		Response response=httpRequest.request(Method.POST,"/create");
		
		//Capture response body to perform Validations
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		Assert.assertEquals(responseBody.contains("VVK3"), true);
		Assert.assertEquals(responseBody.contains("70000"), true);
		Assert.assertEquals(responseBody.contains("25"), true);
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

}
