package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private List<Car> cars = new ArrayList<>();

	public RacingGame(List<String> nameList) {
		for (String name : nameList) {
			Car car = new Car(name);
			this.cars.add(car);
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
