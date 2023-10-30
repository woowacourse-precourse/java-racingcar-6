package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;


public class Application {
	static final int carNamesLength = 6;

	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		List<String> carNamesList = racingCarNames();
		int tries = getNumberOfTries();
		Race race = new Race(carNamesList);
		race.run(tries);
		race.winnerPlayer();
	}


	public static List<String> racingCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		String carNamesInput = Console.readLine();
		String[] carNamesArray = carNamesInput.split(",");
		List<String> carNamesList = new ArrayList<>();
		for (int i = 0; i < carNamesArray.length; i++) {
			if (carNamesArray[i].length() < carNamesLength) {
				carNamesList.add(carNamesArray[i]);
			} else {
				throw new IllegalArgumentException();
			}
		}
		return carNamesList;
	}

	public static int getNumberOfTries() {
		System.out.println("시도할 회수는 몇회인가요?");
		String triesInput = Console.readLine();
		int tries = Integer.parseInt(triesInput);
		return tries;
	}
}
