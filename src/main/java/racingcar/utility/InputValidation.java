package racingcar.utility;

import static racingcar.exception.ErrorMessage.*;
import static racingcar.utility.constant.InputRegex.*;

public class InputValidation {
	public static String validateName(String name) {
		if (!name.matches(LENGTH_RANGE_REGEX.getRegex())) {
			throw new IllegalArgumentException("\"" + name + "\"" + LENGTH_ERROR.getMessage());
		}
		if (!name.matches(LETTER_EXIST_REGEX.getRegex())) {
			throw new IllegalArgumentException("\"" + name + "\"" + SPACE_ERROR.getMessage());
		}
		return name;
	}

	public static Long validateNumber(String input) {
		try {
			return Long.parseLong(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("\"" + input + "\"" + NUMBER_ERROR.getMessage());
		}
	}
}
