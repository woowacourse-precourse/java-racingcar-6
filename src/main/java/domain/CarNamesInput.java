package domain;

import java.util.Arrays;
import java.util.List;

public class CarNamesInput {
	public CarNamesInput() {

	}

	public List<String> splitByCommaToList(String names) {
		return Arrays.asList(names.split(","));
	}

}
