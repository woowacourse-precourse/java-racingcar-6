package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("car 클래스 테스트")
class CarTest {
	@Test
	@DisplayName("자동차를 올바르게 생성한다.")
	void create() {
		// given
		var name = "hyedi";

		// when
		var car = Car.from(name);

		// then
		assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getDistance()).isEqualTo(Car.INIT_DISTANCE);
	}

	@Test
	@DisplayName("올바르지 않은 이름에 예외를 발생한다.")
	void createWrongName() {
		// given
		var wrongName = "sunkid";

		// when

		// then
		assertThatThrownBy(() -> Car.from(wrongName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Car.WRONG_NAME_LENGTH_EXCEPTION_MESSAGE);
	}

	@Test
	@DisplayName("자동차는 전진한다.")
	void move() {
		// given
		var name = "hyedi";
		var moveCount = 5;
		var car = Car.from(name);

		// when
		for (int i = 0; i < moveCount; i++) {
			car.move();
		}

		// then
		assertThat(car.getDistance()).isEqualTo(moveCount);
	}
}
