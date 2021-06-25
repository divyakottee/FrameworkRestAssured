package Utilities;

public class urls {
	
	public static final String URL = "https://ecommerceservice.herokuapp.com";
	
	public static String getEndpoint()
	{
		return URL;
	}
	
	public static String getEndpoint(String resource)
	{
		return URL + resource;
	}

}
