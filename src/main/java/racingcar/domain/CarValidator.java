package racingcar.domain;

import static racingcar.error.Error.INVALID_CARNAME_LENGTH;

import java.util.List;

public class CarValidator {
	private static final int CARNAME_LENGTH = 5;

	public static void validateLength(List<String> carNameList) {
		for (String carName : carNameList) {
			if (isLong(carName)) {
				throw new IllegalArgumentException(INVALID_CARNAME_LENGTH.getMessage());
			}
		}
	}
	private static boolean isLong(String carName) {
		return carName.length() > CARNAME_LENGTH;
	}
}
