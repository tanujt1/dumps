package src;

public class Utils {
	static int getDBValue(int input){
		return input;
	}
	static String getDBValue(String input){
		if(input==null || input=="null")
			return null;
		else
			return "'" + input + "'";
	}

}
