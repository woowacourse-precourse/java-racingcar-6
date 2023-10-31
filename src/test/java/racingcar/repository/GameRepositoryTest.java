package racingcar.repository;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class GameRepositoryTest {
	static GameRepository gameRepository = new GameRepository();

	static Car makeCar(String name, Long forwardCount) {
		Car car = new Car(name);
		while (forwardCount-- > 0) {
			car.moveForward();
		}
		return car;
	}

	@Test
	void 저장_테스트() {
		List<Car> cars = new ArrayList<>();
		cars.add(makeCar("a", 6L));
		cars.add(makeCar("b", 4L));
		cars.add(makeCar("c", 6L));
		gameRepository.saveGame(cars);
		assertThat(gameRepository.findAll()).isEqualTo(cars);
	}

	@Test
	void 전진_반영_테스트() {
		List<Car> cars = new ArrayList<>();
		cars.add(makeCar("a", 6L));
		cars.add(makeCar("b", 4L));
		cars.add(makeCar("c", 6L));
		gameRepository.saveGame(cars);

		List<Car> forwardCars = new ArrayList<>();
		forwardCars.add(makeCar("b", 4L));
		forwardCars.add(makeCar("c", 6L));
		gameRepository.moveForward(forwardCars);

		List<Car> expectList = new ArrayList<>();
		expectList.add(makeCar("a", 6L));
		expectList.add(makeCar("b", 5L));
		expectList.add(makeCar("c", 7L));

		assertThat(gameRepository.findAll()).isEqualTo(expectList);
	}

	@Test
	void 최대값_반환_테스트() {
		List<Car> cars = new ArrayList<>();
		cars.add(makeCar("a", 6L));
		cars.add(makeCar("b", 4L));
		cars.add(makeCar("c", 6L));
		gameRepository.saveGame(cars);

		List<Car> forwardCars = new ArrayList<>();
		forwardCars.add(makeCar("b", 4L));
		forwardCars.add(makeCar("c", 6L));
		gameRepository.moveForward(forwardCars);

		assertThat(gameRepository.getMaxForwardPosition()).isEqualTo(7L);
	}
}