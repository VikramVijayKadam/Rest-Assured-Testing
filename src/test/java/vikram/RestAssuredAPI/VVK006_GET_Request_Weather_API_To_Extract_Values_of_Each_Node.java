package vikram.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VVK006_GET_Request_Weather_API_To_Extract_Values_of_Each_Node
{
	@Test
	void getweatherDetails()
	{
	  //Specifying the base URI
	  RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
	  
	  //Creation of Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/Bangalore");
	  
	  JsonPath jsonpath=response.jsonPath();
	  System.out.println(jsonpath.get("City"));
	  System.out.println(jsonpath.get("Temperature"));
	  System.out.println(jsonpath.get("Humidity"));
	  
	  //String Wd=jsonpath.get("Weather Description");
	  //System.out.println(Wd);
	  //System.out.println(jsonpath.get("WindSpeed"));
	  //System.out.println(jsonpath.get("WindDirectionDegree"));
	  //System.out.println(jsonpath.getString("Weather Description"));
	  
	  Assert.assertEquals(jsonpath.get("City"), "Bangalore");
	  //Assert.assertEquals(jsonpath.get("Temperature"), "146 Degree celsius");
	  //Assert.assertEquals(jsonpath.get("Humidity"), "195 Percent");
	  
	 }

}
