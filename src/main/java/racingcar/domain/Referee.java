package racingcar.domain;

import java.util.List;

public class Referee {
	private final List<Car> carList;
	private final Referee referee;

	public Referee(List<Car> carList, Referee referee) {
		this.carList = carList;
		this.referee = referee;
	}

	public List<Car> getFurthestCar() {
		return null;
	}
}
