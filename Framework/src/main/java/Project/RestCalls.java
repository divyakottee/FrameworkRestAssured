package Project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jsoup.Connection.Request; 

public class RestCalls {

	public static Response getmethod(String URI)
	{
		RequestSpecification reqspec =   RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		
		Response response  = reqspec.get(URI);
		return response;
		
	}
	
	public static Response getmethodwithheader(String URI,String accessToken)
	{
		RequestSpecification reqspec =   RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.header("Authorization", "bearer "+accessToken);
		Response response  = reqspec.get(URI);
		return response;
		
	}
	
	public static Response postmethod(String URI,String strJson)
	{
		RequestSpecification reqspec =   RestAssured.given().body(strJson);
		reqspec.contentType(ContentType.JSON);
		Response response = reqspec.post(URI);
		return response;
		
	}
	
	public static Response putmethod(String URI,String strJson)
	{
		RequestSpecification reqspec =   RestAssured.given().body(strJson);
		reqspec.contentType(ContentType.JSON);
		Response response = reqspec.put(URI);
		return response;
		
	}
	
	public static Response deletemethod(String URI,String strJson)
	{
		RequestSpecification reqspec =   RestAssured.given().body(strJson);
		reqspec.contentType(ContentType.JSON);
		Response response = reqspec.delete(URI);
		return response;
		
	}
	
	public static Response deletemethodwithheader(String URI,String accessToken)
	{
		RequestSpecification reqspec =   RestAssured.given();
		//RequestSpecification reqspec =   RestAssured.given().body(strJson);
		reqspec.contentType(ContentType.JSON);
		reqspec.header("Authorization", "bearer "+accessToken);
		Response response = reqspec.delete(URI);
		return response;
		
	}
	

}
