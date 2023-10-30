package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RandomNumberFactory;
import racingcar.domain.TryNumber;

public class Service {
	private static final int MOVE_STANDARD = 4;

	public void tryOnce(RacingCar racingCar, TryNumber tryNumber) {
		tryEach(racingCar);
		tryNumber.decrease();
	}

	private void tryEach(RacingCar racingCar) {
		racingCar.getRacingCar().forEach(car -> {
			if (isMovable(getRandomNumber())) {
				car.move();
			}
		});
	}

	private int getRandomNumber() {
		return RandomNumberFactory.createRandomNumber();
	}

	private boolean isMovable (int number) {
		return number >= MOVE_STANDARD;
	}
}
