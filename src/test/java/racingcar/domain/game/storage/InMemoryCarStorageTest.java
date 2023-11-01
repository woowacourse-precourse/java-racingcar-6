package racingcar.domain.game.storage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;

class InMemoryCarStorageTest {

	@Test
	@DisplayName("자동차를 입력한 순서대로 저장한다.")
	void saveAll() {
		// given
		List<String> names = List.of("김수민", "안녕", "하이");
		Cars cars = new Cars(CarFactory.generateCar(names, 0));

		CarStorage carStorage = new InMemoryCarStorage();

		// when
		List<Car> savedCars = carStorage.saveAll(cars.getCars());

		//then
		assertAll(
				() -> assertEquals(names.size(), savedCars.size()),
				() -> assertEquals(cars.getCars().stream().map(Car::getCarName).toList(),
						savedCars.stream().map(Car::getCarName).toList())
		);
	}

	@Test
	@DisplayName("저장한 자동차들을 불러온다.")
	void findAll() {
		// given
		List<String> names = List.of("김수민", "안녕", "하이");
		Cars cars = new Cars(CarFactory.generateCar(names, 0));

		CarStorage carStorage = new InMemoryCarStorage();
		List<Car> savedCars = carStorage.saveAll(cars.getCars());

		// when
		List<Car> findCars = carStorage.findAll();

		// then
		assertAll(
				() -> assertEquals(savedCars.size(), findCars.size()),
				() -> assertEquals(savedCars.stream().toList(), findCars.stream().toList())
		);
	}
}