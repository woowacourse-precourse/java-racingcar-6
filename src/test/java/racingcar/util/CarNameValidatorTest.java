package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

public class CarNameValidatorTest {

	@Test
	@DisplayName("자동차 이름이 5자 이상일 경우 IllegalArgumentException 발생")
	void carNameLengthTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			InputValidator.isValidName("123456");
		});
	}

	@Test
	@DisplayName("자동차 이름에 공백이 포함될 경우 IllegalArgumentException 발생")
	void carNameSpaceTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			InputValidator.isValidName("12 3");
		});
	}

	@Test
	@DisplayName("자동차 이름이 null일 경우 IllegalArgumentException 발생")
	void carNameNullTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			InputValidator.isValidName(null);
		});
	}

	@Test
	@DisplayName("정상 입력 확인")
	void carNameValidTest() {
		assertThatCode(() -> {
			InputValidator.isValidName("abc");
		}).doesNotThrowAnyException();
	}
}
