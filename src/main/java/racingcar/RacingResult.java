package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingResult {

	public void racingGame(List<String> carNames, Integer tryCount) {

		int count = 0;
		String[] gameResult = new String[carNames.size()];
		for (int i = 0; i < gameResult.length; i++) {
			gameResult[i] = "";
		}
		while (count < tryCount) {
			for (int i = 0; i < carNames.size(); i++) {
				int randomNum = Randoms.pickNumberInRange(0, 9);
				String carName = carNames.get(i);
				String goOrStop = isCarGoOrStop(randomNum);
				String stepResult = gameResult[i] + goOrStop;
				printRacingStepResult(carName, stepResult);
				gameResult[i] = stepResult;
			}
			System.out.println();
			count++;
		}
		List<String> finalWinner = checkFinalWinner(carNames, gameResult);
		int i = 0;
		System.out.print("최종 우승자 : ");
		while (true) {
			System.out.print(finalWinner.get(i));
			if (i == finalWinner.size() - 1) {
				break;
			}
			System.out.print(", ");
			i++;
		}
	}


	public String isCarGoOrStop(int randomNum) {

		String result = "";
		if (randomNum >= 4) {
			result = "-";
		}

		return result;
	}

	public void printRacingStepResult(String carName, String stepResult) {
		System.out.println(carName + " : " + stepResult);
	}

	public List<String> checkFinalWinner(List<String> carNames, String[] gameResult) {
		int[] count = new int[gameResult.length];
		for (int i = 0; i < count.length; i++) {
			count[i] = gameResult[i].split("").length;
		}

		int maxCount = -1;
		int maxIndex = 0;
		int[] maxIndexes = new int[count.length];
		for (int i = 0; i < count.length; i++) {
			if (maxCount < count[i]) {
				maxCount = count[i];
				maxIndex = i;
			}
		}
		maxIndexes[maxIndex] = maxCount;

		for (int i = 0; i < count.length; i++) {
			if (maxCount == count[i]) {
				maxIndexes[i] = maxCount;
			}
		}

		List<String> finalWinner = new ArrayList<>();
		for (int i = 0; i < maxIndexes.length; i++) {
			if (maxIndexes[i] > 0) {
				finalWinner.add(carNames.get(i));
			}
		}

		return finalWinner;
	}
}
