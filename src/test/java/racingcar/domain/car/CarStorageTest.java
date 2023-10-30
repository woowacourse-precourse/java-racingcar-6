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
		MoveState moveState = new MoveState(()-> 4);
		Position position = new Position();
		Car carNameA1 = new Car(position, new CarName("A"), moveState);
		Car carNameA2 = new Car(position, new CarName("A"), moveState);

		// when & then
		Assertions.assertDoesNotThrow(()->new CarStorage(List.of(carNameA1, carNameA2)));
	}
}