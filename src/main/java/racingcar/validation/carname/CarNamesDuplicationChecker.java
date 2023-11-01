package racingcar.validation.carname;

import java.util.Collections;
import java.util.List;

public class CarNamesDuplicationChecker {

	private static final Integer maxCountOfCarName = 1;
	private static final Integer indexSteps = 1;
	private Integer index = 0;

	public void checkCarNamesDuplicationChecker(List<String> carNamesList) {
		if (index == carNamesList.size()) {
			return;
		}
		if (Collections.frequency(carNamesList, carNamesList.get(index)) != maxCountOfCarName) {
			throw new IllegalArgumentException();
		}
		index = index + indexSteps;
		checkCarNamesDuplicationChecker(carNamesList);
	}
}
