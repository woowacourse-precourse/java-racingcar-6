package racingcar.domain;

import static racingcar.error.Error.INVALID_CARNAME_LENGTH;

import java.util.Arrays;
import java.util.List;

public class InputCarName {
	private final List<String> carNameList;

	public InputCarName(String input) {
		List<String> carNameList = toList(input);
		validateLength(carNameList);
		this.carNameList = toList(input);
	}

	private void validateLength(List<String> carNameList) {
		for (String carName : carNameList) {
			if (isLong(carName)) {
				throw new IllegalArgumentException(INVALID_CARNAME_LENGTH.getMessage());
			}
		}
	}

	private boolean isLong(String carName) {
		return carName.length() > 5;
	}

	public List<String> getCarNameList() {
		return this.carNameList;
	}

	private List<String> toList(String input) {
		return Arrays.stream(input.split(",")).toList();
	}

}
