package racingcar.utilities;

public class Parse {
	public static String[] splitString(String str, String splitter) {
		String[] splitted = str.split(splitter);	
		return splitted;
	}
	
	public static int parseStringToInt(String str) {
		return Integer.parseInt(str);
	}
}