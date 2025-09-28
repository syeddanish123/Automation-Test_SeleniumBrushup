package utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilility {

	private static RandomStringUtils utils;
	
	public static String getAlphabets(int n)
	{
		return utils.randomAlphabetic(n);
	}
	
	public static String getNumeric(int x)
	{
		return utils.randomNumeric(x);
	}
	
	public static String getAlphanumeric(int y)
	{
		return utils.randomAlphanumeric(y);
	}
}
