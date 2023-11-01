package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest2 {
	@Test
	void test1() {
		assertThatThrownBy(() -> new Car("a&**^"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("자동차 이름에는 영문과 숫자만 사용할 수 있습니다.");
				
	}
}
