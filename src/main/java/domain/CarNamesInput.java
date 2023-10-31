package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesInput {
	private final List<String> names = new ArrayList<>();

	public CarNamesInput(String inputNames) {
		List<String> nameList = splitByCommaToList(inputNames);

		validateNamesDuplicate(nameList);
		validateAndAddNames(nameList);
	}

	private void validateAndAddNames(List<String> nameList) {
		for (String name : nameList) {
			name = trimName(name);
			validateNameEmpty(name);
			validateNameBlank(name);
			validateNameLength(name);

			this.names.add(name);
		}
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
