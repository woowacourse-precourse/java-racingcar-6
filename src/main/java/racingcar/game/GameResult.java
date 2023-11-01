package racingcar.game;

import static racingcar.msg.Sentence.FINAL_WINNER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class GameResult {

	static HashMap<String, String> gameRs = new HashMap<>();

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
		String[] array;
		for (int k = moveNumber; k > 0; k--) {
			array = carNamesArray[carNamesArray.length - k].split(":");
			String carName = array[0].trim();
			String advanceCnt = array[1].trim();

			gameRs.put(carName, advanceCnt);

		}
		finalWinner(gameRs);

	}

	private static void finalWinner(HashMap<String, String> gameRs) {
		String finalWinner = "";
		for (String value : gameRs.values()) {
			if (value.length() > finalWinner.length()) {
				finalWinner = value;
			}
		}
		String finalValue = finalWinner;
		ArrayList<String> finalKey = getKey(gameRs, finalValue);
		String result = String.join(",", finalKey);
		System.out.println(FINAL_WINNER + result);
	}

	private static ArrayList<String> getKey(HashMap<String, String> gameRs2, String finalValue) {
		ArrayList<String> finalWinner = new ArrayList<>();

		for (Map.Entry<String, String> entry : gameRs2.entrySet()) {
			if (entry.getValue().equals(finalValue)) {
				finalWinner.add(entry.getKey());
			}
		}
		return finalWinner;
	}

}
