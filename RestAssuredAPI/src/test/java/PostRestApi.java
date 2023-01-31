import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRestApi 

{
	@Test
	void PostApi() throws Exception
	{
		try {
		RestAssured.baseURI="https://devpythonapi.conmove.io/chatbot";
		
		RequestSpecification httprequest =RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("questionNo", "2");
		requestparams.put("containerNo", "OKOK-1234567");
		requestparams.put("latitude", "12.5643");
		requestparams.put("longitude", "11.45678");
		requestparams.put("address", "Air Force Campus, Mumbai, \r\n"
				+ "Maharashtra 411014, India");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestparams.toJSONString());
		
		Response response=httprequest.request(Method.POST,"/responsebycontainerno");
		
		String responsebody =response.getBody().asString();
		System.out.println(responsebody);
		
		int status=response.statusCode();
		System.out.println(status);
		Assert.assertEquals(status, 200);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
