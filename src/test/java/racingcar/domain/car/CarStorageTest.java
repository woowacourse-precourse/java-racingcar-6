package racingcar.domain.car;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarStorageTest {

	@Test
	@DisplayName("자동차 이름은 중복될 수 있다.")
	void can_duplicated_car_name() {
		// given
		Position position = new Position();
		Car carNameA1 = new Car(position, new CarName("A"));
		Car carNameA2 = new Car(position, new CarName("A"));

		// when & then
		Assertions.assertDoesNotThrow(() -> new Cars(List.of(carNameA1, carNameA2)));
	}

	@Test
	@DisplayName("가장 많이 전진한 차들을 알아낼 수 있다.")
	void get_top_position_cars() {
		// given
		Car carNameA1 = new Car(new Position(1), new CarName("A"));
		Car carNameA2 = new Car(new Position(1), new CarName("A"));
		Car carNameA3 = new Car(new Position(0), new CarName("A"));
		Cars carStorage = new Cars(List.of(carNameA1, carNameA2, carNameA3));

		// when
		List<Car> topCars = carStorage.getTopCars();

		// then
		Assertions.assertEquals(2, topCars.size());
		Assertions.assertEquals(new CarName("A"), topCars.get(0).getCarName());
		Assertions.assertEquals(new CarName("A"), topCars.get(1).getCarName());
	}
}