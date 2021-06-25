package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtil {
	
	public static String getresasstring(Response response)
	{
		String res = response.getBody().asString();
		return res;
	}

	
	public static JsonPath jsonparser(String response)
	{
		JsonPath jsonresponse = new JsonPath(response);
		return jsonresponse;
	}
	
	public static int getstatuscode(Response response)
	{
		int statuscode = response.getStatusCode();
		return statuscode;
	}
	
	public static String getmessage(Response response)
	{
		String message = response.getStatusLine();
		return message;
	}
	
}
