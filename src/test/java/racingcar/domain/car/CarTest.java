package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차가 전진할 수 있는 조건을 만족하면 1씩 전진한다.")
	void can_move() {
		// given
		Car car = new Car(new Position(), new CarName("12345"));

		// when
		car.move(new MoveStrategy(), () -> 4);

		// then
		assertEquals(new Position(1), car.getPosition());
	}

	@Test
	@DisplayName("자동차가 전진할 수 있는 조건을 만족하지 않으면 움직이지 않는다.")
	void not_move() {
		// given
		Car car = new Car(new Position(), new CarName("12345"));

		// when
		car.move(new MoveStrategy(), () -> 3);

		// then
		assertEquals(new Position(0), car.getPosition());
	}
}