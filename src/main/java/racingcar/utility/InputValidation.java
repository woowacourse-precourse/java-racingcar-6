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
			long roundCount = Long.parseLong(input);
			if (roundCount < 0) {
				throw new IllegalArgumentException("\"" + input + "\"" + NEGATIVE_ERROR.getMessage());
			}
			return roundCount;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("\"" + input + "\"" + NUMBER_ERROR.getMessage());
		}
	}
}
