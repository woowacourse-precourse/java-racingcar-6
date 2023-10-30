package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import racingcar.constant.Rule;

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
		return Arrays.stream(input.split(Rule.SPLITOR)).toList();
	}
}
