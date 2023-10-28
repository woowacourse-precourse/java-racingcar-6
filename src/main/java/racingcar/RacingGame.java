package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RacingGame {
	CarNameValidator carNameValidator = new CarNameValidator();
	Car car = new Car();
	Umpire umpire = new Umpire();
	List<StringBuilder> steps = new ArrayList<>();

	public RacingGame() {
		gameStart();
	}

	private void gameStart() {
		String[] cars = inputCarName();
		makeCarStepList(cars.length);
		int tryCount = inputTryCount();
		showTheResults(cars, tryCount);
		String winners = umpire.decideTheWinners(cars, steps);
		announceTheWinners(winners);
	}

	private String[] inputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();
		String[] carArray = carNames.split(",");

		carNameValidator.validateCarName(carArray);

		return carArray;
	}

	private void makeCarStepList(int length) {
		for (int i = 0; i < length; i++) {
			steps.add(new StringBuilder());
		}
	}

	private int inputTryCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String tryCount = Console.readLine();
		System.out.println();
		if (!Pattern.matches("^[0-9]+$", tryCount)) {
			throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
		}

		return Integer.parseInt(tryCount);
	}

	private void showTheResults(String[] cars, int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			steps = car.moveForward(steps);

			for (int j = 0; j < cars.length; j++) {
				System.out.println(cars[j] + " : " + steps.get(j));
			}
			System.out.println();
		}
	}

	private void announceTheWinners(String winners) {
		System.out.println("최종 우승자 : " + winners);
	}
}
