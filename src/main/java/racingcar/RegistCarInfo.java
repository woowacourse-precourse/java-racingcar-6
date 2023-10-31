package racingcar;

import java.util.ArrayList;
import java.util.List;


public class RegistCarInfo {

	public List<String> registCarName(String carName) {

		List<String> racingCarNames = new ArrayList<>();
		String[] carNames = carName.split(",");
		for (int i = 0; i < carNames.length; i++) {
			racingCarNames.add(i, carNames[i]);
		}

		return racingCarNames;
	}

	public Integer registTryCount(String tryCount) {

		int racingTry = Integer.parseInt(tryCount);
		return racingTry;
	}
}

