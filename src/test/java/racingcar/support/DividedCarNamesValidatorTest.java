package racingcar.support;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DividedCarNamesValidatorTest {

	@DisplayName("자동차 이름은 2개 이상 입력해야 한다.")
	@ParameterizedTest
	@ValueSource(strings = "12345")
	void validate_divided_count(String input) {
		// when & then
		assertThatThrownBy(() -> DividedCarNamesValidator.validate(input.split(",")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차 이름은 2개 이상 입력해야합니다");
	}

	@DisplayName("자동차 이름은 좌우 공백을 제외하고 1 ~ 5 글자로 입력해야 한다.")
	@ParameterizedTest
	@ValueSource(strings = {"     , "})
	void validate_car_empty(String input) {
		// when & then
		assertThatThrownBy(() -> DividedCarNamesValidator.validate(input.split(",")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차 이름은 1 ~ 5 글자로 입력해야합니다");
	}

	@DisplayName("자동차 이름은 1 ~ 5 글자로 입력해야합니다")
	@ParameterizedTest
	@ValueSource(strings = {"12345, 1234567"})
	void validate_car_length(String input) {
		// when & then
		assertThatThrownBy(() -> DividedCarNamesValidator.validate(input.split(",")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차 이름은 1 ~ 5 글자로 입력해야합니다");
	}
}