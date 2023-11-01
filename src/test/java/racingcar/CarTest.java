package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("사용자의 이름이 5글자 이상이면 예외가 발생한다.")
	void test01() {
		Assertions.assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("사용자의 이름은 5글자 이하여야 합니다.");
	}

	@Test
	@DisplayName("4이하의 숫자라면 자동차는 전진하지 않는다.")
	void test02() {
		final var car = new Car("abc");
		final var number = 4;
		car.advance(number);
		final var status = car.toString();
		assertThat(status).isEqualTo("");
	}

	@Test
	@DisplayName("4이상의 숫자라면 자동차는 전진한다.")
	void test03() {
		final var car = new Car("abc");
		final var prev = car.toString();
		final int prevDistance = car.distance();

		final var number = 5;
		car.advance(number);

		final var currentStatus = car.toString();
		final int currentDistance = car.distance();
		assertThat(currentStatus).isEqualTo(prev + "-");
		assertThat(currentDistance).isEqualTo(prevDistance + 1);
	}
}
