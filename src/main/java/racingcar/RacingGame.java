package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RacingGame {
	CarNameValidator carNameValidator = new CarNameValidator();
	Car car = new Car();
	Umpire umpire = new Umpire();
	List<StringBuilder> steps = new ArrayList<>();

	public RacingGame() {
	}

	public void gameStart() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String carNames = Console.readLine();

		String[] cars = inputCarName(carNames);
		makeCarStepList(cars.length);

		System.out.println("시도할 횟수는 몇 회인가요?");

		String tryCount = Console.readLine();
		System.out.println();

		int count = inputTryCount(tryCount);

		showTheResults(cars, count);
		String winners = umpire.decideTheWinners(cars, steps);
		announceTheWinners(winners);
	}

	public String[] inputCarName(String carNames) {

		String[] carArray = carNames.split(",");

		carNameValidator.validateCarName(carArray);

		return carArray;
	}

	public void makeCarStepList(int length) {
		for (int i = 0; i < length; i++) {
			steps.add(new StringBuilder());
		}
	}

	public int inputTryCount(String tryCount) {

		if (!Pattern.matches("^[0-9]+$", tryCount)) {
			throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
		}

		return Integer.parseInt(tryCount);
	}

	public void showTheResults(String[] cars, int count) {
		for (int i = 0; i < count; i++) {
			steps = car.moveForward(steps);

			for (int j = 0; j < cars.length; j++) {
				System.out.println(cars[j] + " : " + steps.get(j));
			}
			System.out.println();
		}
	}

	public void announceTheWinners(String winners) {
		System.out.println("최종 우승자 : " + winners);
	}
}
