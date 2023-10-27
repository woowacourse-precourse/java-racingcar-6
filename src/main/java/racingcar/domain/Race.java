package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private final List<Car> cars = new ArrayList<>();

	public Race(String[] carNames) {
		for (String name : carNames) {
			cars.add(new Car(name));
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}