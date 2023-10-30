package racingcar.domain;

import static racingcar.error.Error.INVALID_CARNAME_LENGTH;

import java.util.Arrays;
import java.util.List;

public class InputCarName {
	private final List<String> carNameList;

	public InputCarName(String input) {
		List<String> carNameList = toList(input);
		CarValidator.validateLength(carNameList);
		this.carNameList = toList(input);
	}

	public List<String> getCarNameList() {
		return this.carNameList;
	}

	private List<String> toList(String input) {
		return Arrays.stream(input.split(",")).toList();
	}

}
