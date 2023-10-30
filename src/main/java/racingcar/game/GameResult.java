package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class GameResult {

	public static void execution_result(String[] carNamesArray, int moveNumber) {

		for (int i = 0; i < carNamesArray.length; i++) {
			carNamesArray[i] += " : ";
		}

		for (int i = 0; i < moveNumber; i++) {

			for (int j = 0; j < carNamesArray.length; j++) {
				int randomNum = Randoms.pickNumberInRange(0, 9);
				if (randomNum >= 4) {
					carNamesArray[j] += "-";
				} else {
					carNamesArray[j] += "";
				}
				System.out.println(carNamesArray[j]);
			}
			System.out.println("");
		}

	}

}
