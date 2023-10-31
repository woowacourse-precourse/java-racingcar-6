package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesInput {
	private final List<String> names;
	public CarNamesInput(String inputNames) {
		this.names = splitByCommaToList(inputNames);
	}

	public List<String> getNames() {
		return names;
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

	public void validateNamesDuplicate(List<String> names) {
		Set<String> nameSet = new HashSet<>();

		for (String name : names) {
			if (!nameSet.add(name)) {
				throw new IllegalArgumentException();
			}
		}
	}

	public String trimName(String name) {
		return name.trim();
	}
}
