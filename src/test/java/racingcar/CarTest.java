package racingcar;

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
}
