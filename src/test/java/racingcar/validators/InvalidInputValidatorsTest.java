package racingcar.validators;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InvalidInputValidatorsTest {

	private final InvalidInputValidators invalidInputValidators = new InvalidInputValidators();

	@Test
	void validateCarName_type_blank() {
		String blank = "";

		assertThatThrownBy(() -> invalidInputValidators.validateCarName(blank))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void validateCarName_type_over_max_length() {
		String overMaxLength = "car119";

		assertThatThrownBy(() -> invalidInputValidators.validateCarName(overMaxLength))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void validateNumberOfAttempts_type_blank() {
		String blank = "";

		assertThatThrownBy(() -> invalidInputValidators.validateNumberOfAttempts(blank))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void validateNumberOfAttempts_type_String() {
		String blank = "다섯번";

		assertThatThrownBy(() -> invalidInputValidators.validateNumberOfAttempts(blank))
			.isInstanceOf(IllegalArgumentException.class);
	}
}