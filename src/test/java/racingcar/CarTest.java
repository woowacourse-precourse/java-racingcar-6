package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("심판 결과가 true면 전진한다.")
	@Test
	void testMoveForwardIfMovableIsTrue() {
		boolean movable = true;
		Car car = new Car("hana");
		car.move(movable);
		assertThat(car.getStep()).isEqualTo(1);
	}

	@DisplayName("심판 결과가 false면 전진하지 않는다.")
	@Test
	void testDoNotMoveIfMovableIsFalse() {
		boolean movable = false;
		Car car = new Car("dokkisan");
		car.move(movable);
		assertThat(car.getStep()).isEqualTo(0);
	}
}