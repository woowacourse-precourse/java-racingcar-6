package racingcar.utils;

public class StringValidator {

	public static boolean isBlank(String str) {
		return (str == null || str.trim().isEmpty());
	}

}
