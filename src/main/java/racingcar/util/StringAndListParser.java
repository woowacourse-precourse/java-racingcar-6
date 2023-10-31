package racingcar.util;

import java.util.List;

public class StringAndListParser {
	private String[] nameArray;
	private String winner;

	public String[] splitString(String input) {
		nameArray = input.trim().split("\\s*,\\s*");
		return nameArray;
	}

	public String parseToString(List<String> list) {
		winner = String.join(", ", list);
		return winner;
	}
}