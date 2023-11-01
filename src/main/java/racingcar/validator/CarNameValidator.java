package racingcar.validator;

import static racingcar.utils.GameConstants.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
	public static void checkCarNameInput(String carNameInput) {
		isEmptyInput(carNameInput);
		isDoubleDelimiter(carNameInput);
		isLastDelimiter(carNameInput);
	}


	private static void isDoubleDelimiter(String carNameInput) {
		for (int idx = 1; idx < carNameInput.length(); idx++) {
			if (carNameInput.charAt(idx) == ',' && carNameInput.charAt(idx - 1) == ',') {
				throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR);
			}
		}
	}


	public static void checkCarNames(String[] carNames) {
		isDuplicate(carNames);
		isLengthWithinRange(carNames);
	}


	private static void isLengthWithinRange(String[] carNames) {
		for (String carName : carNames) {
			if (carName.length() < 1 || carName.length() > 5) {
				throw new IllegalArgumentException(CAR_NAME_LENGTH_OUT_OF_RANGE_ERROR);
			}
		}
	}
	
	private static void isDuplicate(String[] carNames) {
		Set<String> checkedNames = new HashSet<>();
		checkedNames.addAll(Arrays.asList(carNames));
		if (checkedNames.size() != carNames.length) {
			throw new IllegalArgumentException(DUPLICATION_OF_CAR_NAME_ERROR);
		}
	}
	
	private static void isLastDelimiter(String carNameInput) {
		if (carNameInput.charAt(carNameInput.length() - 1) == ',') {
			throw new IllegalArgumentException(LAST_PART_OF_CAR_NAME_ERROR);
		}
	}
	
	private static void isEmptyInput(String carNameInput) {
		if (carNameInput.isEmpty()) {
			throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR);
		}
	}
}
