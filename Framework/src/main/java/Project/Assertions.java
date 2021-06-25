package Project;

import org.testng.Assert;

import Utilities.TestUtil;
import io.restassured.response.Response;

public class Assertions {

	public static void verifystatuscode(Response response, int statuscode)
	{
		Assert.assertEquals(TestUtil.getstatuscode(response),statuscode);
	}

}
