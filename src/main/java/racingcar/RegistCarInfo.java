package racingcar;

import java.util.ArrayList;
import java.util.List;


public class RegistCarInfo {

	public List<String> registCarName(String carName) {

		List<String> racingCarNames = new ArrayList<>();
		for (String name : carName.split(",")) {
			racingCarNames.add(name);
		}

		return racingCarNames;
	}

	public Integer registTryCount(String tryCount) {

		int racingTry = Integer.parseInt(tryCount);
		return racingTry;
	}
}

