package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	@DisplayName("자동차 이름을 2개 이상 입력하면 예외가 발생하지 않는다.")
	@Test
	void testValidCarCount() {
		assertDoesNotThrow(() -> Validator.validateCarCount("pobi,woni,jun"));
	}

	@DisplayName("자동차 이름을 1개 입력하면 예외가 발생한다.")
	@Test
	void testInvalidCarCount() {
		assertThatThrownBy(() -> Validator.validateCarCount("pobi"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 자동차의 이름을 쉼표(,)로 구분해 2개 이상 입력해 주세요. 예) pobi,woni");
	}
}