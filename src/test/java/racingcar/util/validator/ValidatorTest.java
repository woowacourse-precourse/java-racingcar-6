package racingcar.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.message.ErrorMessage;

public class ValidatorTest {
	
	@DisplayName("길이가 5초과하면 예외를 발생시킨다.")
	@ValueSource(strings = { "jajass", "nananana" })
	@ParameterizedTest
	void checkOutOfLength(String str) {
		assertThatThrownBy(() -> Validator.validateOutOfLength(str))
				.isInstanceOf(IllegalArgumentException.class)
						.hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
	}

	@DisplayName("길이가 5이하일때 정삭적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "nana", "jjaaa" })
	@ParameterizedTest
	void checkNomalOperation1(String str) {
		Validator.validateOutOfLength(str);
	}
}	
