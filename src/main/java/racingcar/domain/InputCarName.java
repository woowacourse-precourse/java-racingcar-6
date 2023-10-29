package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class InputCarName {
	private final List<String> carNameList;

	public InputCarName(String input) {
		this.carNameList = toList(input);
	}

	public List<String> getCarNameList() {
		return this.carNameList;
	}

	private List<String> toList(String input) {
		return Arrays.stream(input.split(",")).toList();
	}

}
