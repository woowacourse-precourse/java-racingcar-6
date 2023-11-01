package racingcar.domain;

import java.util.Arrays;

import racingcar.model.RacingcarModel;

public class CarName {
	public static void inputCarName(String carName) {
		String[] result = carName.split("[,]");
		carNameCheck(result);
		RacingcarModel.carNames = Arrays.asList(result);
	}

	public static void carNameCheck(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i].length() > 5) {
				throw new IllegalArgumentException();
			}
		}
	}
}