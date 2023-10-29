package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차가 전진할 수 있는 조건을 만족하면 1씩 전진한다.")
	void can_move() {
		// given
		MovingStrategy movingStrategy = () -> true;
		Car car = new Car(movingStrategy);

		// when
		car.move();

        // then
        assertEquals(1, car.getPosition());
	}

	@Test
	@DisplayName("자동차가 전진할 수 있는 조건을 만족하지 않으면 움직이지 않는다.")
	void not_move() {
		// given
		MovingStrategy movingStrategy = () -> false;
		Car car = new Car(movingStrategy);

		// when
		car.move();

		// then
		assertEquals(0, car.getPosition());
	}
}