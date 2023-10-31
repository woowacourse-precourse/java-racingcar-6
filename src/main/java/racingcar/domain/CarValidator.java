package racingcar.domain;

import static racingcar.error.Error.INVALID_CARNAME_LENGTH;

import java.util.List;

import racingcar.constant.Rule;

public class CarValidator {
	public static void validateLength(List<String> carNameList) {
		for (String carName : carNameList) {
			validateEachLength(carName);
		}
	}

	public static void validateEachLength(String carName) {
		if (isLong(carName)) {
			throw new IllegalArgumentException(INVALID_CARNAME_LENGTH.getMessage());
		}
	}

	private static boolean isLong(String carName) {
		return carName.length() > Rule.CARNAME_LENGTH;
	}
}
