package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class RacingGame {
	private final List<RacingCar> cars = new ArrayList<>();

	public RacingGame() {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String inputNames = Console.readLine();

		String[] carNames = inputNames.split(",");
		for (String name : carNames) {
			if (name.length() <= 5) {
				cars.add(new RacingCar(name));
			} else {
				throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
			}
		}
	}

	public void runRacing(final int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			for (RacingCar car : cars) {
				car.move(car.generateRandomNumber());
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
