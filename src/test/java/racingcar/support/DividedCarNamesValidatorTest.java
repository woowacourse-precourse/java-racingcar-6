package racingcar.support;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DividedCarNamesValidatorTest {

	@DisplayName("자동차 이름은 2개 이상 입력해야 한다.")
	@ParameterizedTest
	@ValueSource(strings ="12345")
	void validate_divided_count(String input) {
		// when & then
		Assertions.assertThatThrownBy(() -> DividedCarNamesValidator.validate(input.split(",")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차 이름은 2개 이상 입력해야합니다");
	}
}