package racingcar.utility.constant;

import static racingcar.utility.constant.NumberConstant.*;

public enum InputRegex {
	WHITE_SPACE_REGEX("\\s"),
	LETTER_EXIST_REGEX(".*\\S.*"),
	LENGTH_RANGE_REGEX(
		"^.{" + MIN_LENGTH.getValue() + "," + MAX_LENGTH.getValue() + "}$");

	private final String regex;

	InputRegex(String message) {
		this.regex = message;
	}

	public String getRegex() {
		return regex;
	}
}
