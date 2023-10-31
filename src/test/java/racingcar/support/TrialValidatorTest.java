package racingcar.support;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrialValidatorTest {

	@DisplayName("시도는 1 이상으로 입력해야 한다.")
	@ParameterizedTest
	@ValueSource(strings = "-1")
	void validate_range(String input) {
		// when & then
		assertThrows(IllegalArgumentException.class,
				() -> TrialValidator.validate(input));
	}
	@DisplayName("시도는 숫자로 1이상의 수를 입력해야 한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	void trial_input(String input) {
		// when & then
		assertDoesNotThrow(() -> TrialValidator.validate(input));
	}
}