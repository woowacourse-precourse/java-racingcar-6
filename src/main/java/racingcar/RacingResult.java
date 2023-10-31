package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

	public List<String> racingGame(List<String> carNames, Integer tryCount) {

		int count = 0;
		List<String> gameResult = new ArrayList<>();

		while (count < tryCount) {

			for (int i = 0; i < ; i++) {
				String goOrStop = isCarGoOrStop();
				gameResult.add(i, goOrStop);
			}

			count++;
		}


		System.out.println(gameResult);
		return gameResult;
	}

	public String isCarGoOrStop() {

		int randomNum = Randoms.pickNumberInRange(0, 9);

		String result = "";
		if (randomNum >= 4) {
			result = "-";
		}
		return result;
	}

}
