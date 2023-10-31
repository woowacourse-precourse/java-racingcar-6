package domain;

import java.util.Arrays;
import java.util.List;

public class CarNamesInput {
	public CarNamesInput() {

	}

	public List<String> splitByCommaToList(String names) {
		return Arrays.asList(names.split(","));
	}

	public void validateNameLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public void validateNameBlank(String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException();
		}
	}

	public void validateNameEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
}
