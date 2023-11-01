package racingcar.model;

import java.util.Collections;
import java.util.List;

public class RaceStatus {
	private final List<RacingCar> cars;

	public RaceStatus(List<RacingCar> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public List<RacingCar> getCars() {
		return cars;
	}
}
