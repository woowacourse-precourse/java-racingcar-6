package racingcar.utilities;

import java.util.List;

public class Parse {
	public static String[] splitString(String str, String splitter) {
		String[] splitted = str.split(splitter);
		
		return splitted;
	}
}