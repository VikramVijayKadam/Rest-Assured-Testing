package dataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import UtilsPackage.*;




public class DDT_AddNewEmployeeBYReadingTheDataFromXLfile 
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
		String [][] getEmpData() throws IOException
		{
			//Read data from excel 
			String path="D:/JAVA/GENERAL/RestAssuredAPI/RestAssuredTestCase1.xlsx";
			// use directly path ="System.getProperty("user.dir")+"/RestAssuredTestCase1.xlsx";
			//use Forward-slash /
			//System.getProperty("user.dir") --> this will give current project directory
			
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
			
			String empdata [][]= new String [rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for (int j=0;j<=colcount;j++)
				{
					empdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				}
			}
			
			
			return (empdata);
		}

	

}
