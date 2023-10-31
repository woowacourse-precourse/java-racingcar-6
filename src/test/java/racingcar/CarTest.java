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
		Car car = new Car("hana");
		car.move(movable);
		assertThat(car.getStep()).isEqualTo(0);
	}

	@DisplayName("입력값의 길이가 1~5자 사이면 이름이 생성된다.")
	@Test
	void testVaLidNameLength() {
		Car car = new Car("bunny");
		assertThat(car.getName()).isEqualTo("bunny");
	}

	@DisplayName("입력값의 길이가 1~5자 사이가 아니면 예외를 발생한다.")
	@Test
	void testInvalidNameLength() {
		assertThatThrownBy(() -> new Car("baedalyee"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 자동차의 이름은 1자 이상 5자 이하로 입력해 주세요.");
	}
}