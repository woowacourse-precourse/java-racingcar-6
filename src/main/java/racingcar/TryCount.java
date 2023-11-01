package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryCount {

	private static final String ZERO = "0";
	private static final String ZEROS = "^0+$";
	private static final String ZERO_HOLDER = "^0+";
	Pattern pattern = Pattern.compile(ZEROS);
	private int tryCount;

	public TryCount(String input) {
		tryCount = Integer.parseInt(refine(input));
	}

	private String refine(String input) {
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return ZERO;
		}
		return input.replaceFirst(ZERO_HOLDER, "");
	}

	public int getTryCount() {
		return tryCount;
	}
}