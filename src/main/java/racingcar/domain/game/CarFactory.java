package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Position;

public class CarFactory {

	private CarFactory() {
		throw new IllegalStateException();
	}

	public static List<Car> generateCar(List<String> names) {
		return names.stream()
				.map(name -> new Car(new Position(), new CarName(name)))
				.toList();
	}

	public static Cars generateCars(List<Car> cars) {
		return new Cars(cars);
	}
}
