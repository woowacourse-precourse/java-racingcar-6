package racingcar.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.message.ErrorMessage;

public class ValidatorTest {
	
	@DisplayName("숫자가 아닌 문자가 포함되어 있으면 예외처리한다.")
	@ValueSource(strings = { "#12", "0s12" })
	@ParameterizedTest
	void checkNumberFormat(String str) {
		assertThatThrownBy(() -> Validator.validateNumberFormat(str))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.INPUT_LETTER_ERROR.getMessage());
	}

	@DisplayName("숫자만을 입력했을 떄 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "123", "456" })
	@ParameterizedTest
	void checkNomalOperation1(String str) {
		Validator.validateNumberFormat(str);
	}
	
	@DisplayName("값이 비어있을 때 예외처리한다.")
	@ValueSource(strings = { "" , " "})
	@ParameterizedTest
	void checkisEmpty(String str) {
		assertThatThrownBy(() -> Validator.validateIsEmpty(str))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
	}

	@DisplayName("값이 있을 떄 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "123", "456" })
	@ParameterizedTest
	void checkNomalOperation2(String str) {
		Validator.validateIsEmpty(str);
	}
}	
