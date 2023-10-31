package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.TryNumber;

public class Service {

	public void tryRace(RacingCar racingCar, TryNumber tryNumber) {
		tryEach(racingCar);
		tryNumber.decrease();
	}

	private void tryEach(RacingCar racingCar) {
		racingCar.getRacingCar().forEach(car -> car.race());
	}
}
