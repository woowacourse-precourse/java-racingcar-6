package racingcar.verfication;

import static racingcar.msg.Sentence.INPUT_NAME;

public class Validator {
	private static String[] carNamesArr;

	public static void outOfCarName(String carNameInput) {
		if (carNameInput.charAt(0) == ',' || carNameInput.charAt(carNameInput.length() - 1) == ',') {
			throw new IllegalArgumentException(INPUT_NAME);
		}
		checkSameName(carNameInput);
		checkCharNum(carNameInput);
		checkCarNameNumber(carNameInput);
	}

	private static void checkSameName(String carNameInput) {
		carNamesArr = carNameInput.split(",");
		for (int i = carNamesArr.length; i > 0; i--) {
			for (int j = carNamesArr.length; j < i; j--) {
				if (carNamesArr[i] == carNamesArr[j]) {
					throw new IllegalArgumentException(INPUT_NAME);
				}
			}
		}
	}

	private static void checkCharNum(String carNameInput) {
		carNamesArr = carNameInput.split(",");
		for (String carName : carNamesArr) {
			if (carName.length() > 5) {
				throw new IllegalArgumentException(INPUT_NAME);
			}
		}
	}

	private static void checkCarNameNumber(String carNameInput) {
		carNamesArr = carNameInput.split(",");
		if (carNamesArr.length == 1) {
			throw new IllegalArgumentException(INPUT_NAME);
		}
	}

}
