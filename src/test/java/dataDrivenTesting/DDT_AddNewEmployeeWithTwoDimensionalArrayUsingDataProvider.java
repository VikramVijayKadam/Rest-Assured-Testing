package dataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DDT_AddNewEmployeeWithTwoDimensionalArrayUsingDataProvider 
{
	@SuppressWarnings("unchecked")
	@Test(dataProvider="empDataProvider")
	void postNewEmployees(String ename, String esal, String eage)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Here we created data which we can send along with post request
		JSONObject requestParams= new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", esal);
		requestParams.put("age", eage);
		
		//Add a header stating the request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		//Add the JSON to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST Request
		Response response=httpRequest.request(Method.POST,"/create");
		
		//Capture response body to perform Validations
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :"+responseBody);
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
		
		@DataProvider(name="empDataProvider")
		String [][] getEmpData()
		{
			String empdata[][]={{"abcd","3000","20"},{"defg","4000","30"},{"ghik","5000","40"}};
			return (empdata);
		}

	

}
