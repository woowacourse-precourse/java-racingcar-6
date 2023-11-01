package racingcar.domain.car;

import java.util.List;

public class CarFactory {

	private CarFactory() {
		throw new IllegalStateException();
	}

	public static List<Car> generateCar(List<String> names, int position) {
		return names.stream()
				.map(name -> new Car(new Position(position), new CarName(name)))
				.toList();
	}
}
