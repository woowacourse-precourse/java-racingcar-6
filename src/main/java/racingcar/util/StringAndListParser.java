package racingcar.util;

import java.util.List;

public class StringAndListParser {
	private String[] carArray;
	private String winner;

	public String[] splitString(String input) {
		carArray = input.trim().split("\\s*,\\s*");
		return carArray;
	}

	public String parseToString(List<String> list) {
		winner = String.join(", ", list);
		return winner;
	}
}