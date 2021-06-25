package Project;


import java.io.IOException;
import org.testng.annotations.Test;
import Project.RestCalls;
import Utilities.payloadcoverter;
import Utilities.urls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Test
public class BaseTest {
	
	static Response response; 
	
	
	public static String login() throws IOException
	{
		
		String endpointurl = urls.getEndpoint("/user/login");
		String loginpayload = payloadcoverter.generatepayloadString("login.json");
		
		
		response = RestCalls.postmethod(endpointurl,loginpayload);
		
		String respasString = response.getBody().asString();
		
		JsonPath jsonresp = new JsonPath(respasString);
		
		String accesstoken = jsonresp.getString("accessToken");
		
		return accesstoken;
		
		
		
		
	}
	

}
