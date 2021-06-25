package Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadcoverter {
	
	//convert body to string
	
	public static String generatepayloadString(String filename) throws IOException
	{
		//file name of body
		
		//String filepath = "C:\\Users\\DivyaKotteeswaran\\workspace\\Framework\\resource\\"+filename;
		
		//the below can be used if others have to understand it.
		String filepath = System.getProperty("user.dir")+"\\resource\\"+ filename;
		
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}

}
