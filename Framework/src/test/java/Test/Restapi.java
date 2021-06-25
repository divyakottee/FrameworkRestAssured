package Test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.Assertions;
import Project.BaseTest;
import Project.RestCalls;
import Utilities.TestUtil;
import Utilities.urls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Restapi {
	
	public String accessToken;
	Response response;
	public String userid;
	
	@BeforeTest
	public void setup() throws IOException
	{
		accessToken = BaseTest.login();
		System.out.println("the token is "+accessToken);
	}

	@Test(priority=0)
	public void getallusers()
	{
		String endpointurl = urls.getEndpoint("/user");
		
		System.out.println("Enpointurl is "+ endpointurl);
		
		response = RestCalls.getmethodwithheader(endpointurl,accessToken);
		
		String res = TestUtil.getresasstring(response);
		System.out.println("Response as string is "+ res);
		
		JsonPath jsonresp = TestUtil.jsonparser(res);
		
		
		userid = jsonresp.getString("users[4]._id");
		System.out.println("The user id is "+ userid);
		
		int expstatus = 200;
		
		Assertions.verifystatuscode(response, expstatus);
		
	}
	
	@Test(priority=1)
	public void deleteuser()
	{
		String endpointurl = urls.getEndpoint("/user/"+ userid);
		
		System.out.println("Enpointurl is"+ endpointurl);
		
		response = RestCalls.deletemethodwithheader(endpointurl,accessToken);
		
		String res = TestUtil.getresasstring(response);
		System.out.println("Response as string is"+ res);
		
		JsonPath jsonresp = TestUtil.jsonparser(res);
		
		String message = jsonresp.getString("message");
		System.out.println("The message is "+message);
		
		int expstatus = 200;
		Assertions.verifystatuscode(response, expstatus);
		
	}
	
	
}
