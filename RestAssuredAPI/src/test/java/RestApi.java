import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestApi
{

	@Test
	void TestApi() 
	{
		RestAssured.baseURI = "https://devpythonapi.conmove.io/chatbot";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/getquestionlist");
		
		String responsebody=response.asString();
		System.out.println(responsebody);
		
		int statusc=response.getStatusCode();
		System.out.println("status code is" + statusc );
		
		Assert.assertEquals(statusc, 200);
		
	}
}
