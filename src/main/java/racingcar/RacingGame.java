package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class RacingGame {
	private final List<RacingCar> cars = new ArrayList<>();
	private static final int NAME_LENGTH_CHECK = 5;
	private static final int MIN_RANDOM_RANGE = 0;
	private static final int MAX_RANDOM_RANGE = 9;

	public RacingGame() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		addCar(Console.readLine());
	}

	public void addCar(String inputNames) {
		String[] carNames = inputNames.split(",");
		for (String name : carNames) {
			if (name.length() <= NAME_LENGTH_CHECK) {
				cars.add(new RacingCar(name));
			} else {
				throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
			}
		}
	}

	public void runRacing(final int tryCount, final RandomNumberGeneratorImpl randomNumberGenerator) {
		for (int i = 0; i < tryCount; i++) {
			for (RacingCar car : cars) {
				car.move(randomNumberGenerator.generate(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE));
			}
			printCarProgress();
			System.out.println("\b");
		}
	}

	public void printCarProgress() {
		for (RacingCar car : cars) {
			car.printProgress();
		}
	}

	public List<String> getWinners() {
		int maxPosition = 0;
		List<String> winners = new ArrayList<>();
		for (RacingCar car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
				winners.clear();
				winners.add(car.getName());
			} else if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}
