package racingcar.domain;

import java.util.Collections;
import java.util.List;

import racingcar.model.RacingcarModel;

public class Winner {
	public static String compareCount(List<Integer> raceResult) {
		int winnerPoint = Collections.max(raceResult);
		for (int i = 0; i < raceResult.size(); i++) {
			if (raceResult.get(i).equals(winnerPoint)) {
				RacingcarModel.winnerIndexNumber.add(i);
			}
		}
		return lastResult(RacingcarModel.winnerIndexNumber);
	}

	public static String lastResult(List<Integer> winnerIndexNumber) {
		for (int i = 0; i < winnerIndexNumber.size(); i++) {
			RacingcarModel.winnerList.add(RacingcarModel.carNames.get((winnerIndexNumber.get(i))));
		}
		String result = String.join(", ", RacingcarModel.winnerList);
		return result;
	}
}
