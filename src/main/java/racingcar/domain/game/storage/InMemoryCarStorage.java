package racingcar.domain.game.storage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;

public class InMemoryCarStorage implements CarStorage {

	private static final Map<CarName, Car> cars = new LinkedHashMap<>();

	private Car save(Car car) {
		cars.put(car.getCarName(), car);
		return car;
	}

	@Override
	public List<Car> saveAll(List<Car> cars) {
		return cars.stream()
				.map(this::save)
				.toList();
	}
	@Override
	public List<Car> findAll(){
		return cars.values().stream()
				.toList();
	}
}
