package racingcar;

import java.util.*;

public class RacingGame {
	private final List<RacingCar> cars = new ArrayList<>();

	public RacingGame(String inputNames) {

		String[] carNames = inputNames.split(",");
		for (String name : carNames) {
			if (name.length() <= 5) {
				cars.add(new RacingCar(name));
			} else {
				throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
			}
		}
	}

	public void initializeGame() {
		cars.clear();
	}

	public void runRacing(int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			for (RacingCar car : cars) {
				car.move(car.generateRandomNumber());
			}
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
