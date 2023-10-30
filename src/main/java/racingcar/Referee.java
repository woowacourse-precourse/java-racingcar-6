package racingcar;

import java.util.HashMap;
import java.util.List;

public class Referee {
	private final List<String> names;

	public Referee(List<String> names) {
		this.names = names;
	}

	public HashMap<String, Boolean> checkTryOutcome(List<Integer> randomNumbers) {
		final int MIN_MOVABLE_NUMBER = 4;
		HashMap<String, Boolean> tryResult = new HashMap<>();

		for (int i = 0; i < names.size(); i++) {
			if (randomNumbers.get(i) >= MIN_MOVABLE_NUMBER) {
				tryResult.put(names.get(i), true);
				continue;
			}
			tryResult.put(names.get(i), false);
		}

		return tryResult;
	}
}
