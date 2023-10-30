package racingcar.domain;

import static racingcar.error.Error.*;

import java.util.List;

public class CarValidator {
	public static void validateLength(List<String> carNameList) {
		for (String carName : carNameList) {
			if (isLong(carName)) {
				throw new IllegalArgumentException(INVALID_CARNAME_LENGTH.getMessage());
			}
		}
	}
	private static boolean isLong(String carName) {
		return carName.length() > 5;
	}
}
