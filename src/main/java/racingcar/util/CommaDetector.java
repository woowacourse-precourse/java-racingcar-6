package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommaDetector {

	public List<String> divideCarNames(String input) {
		return new ArrayList<>(Arrays.asList(input.split(",")));
	}

	public int divideNumberOfTrial(String input) {
		return Integer.parseInt(input);
	}
}
