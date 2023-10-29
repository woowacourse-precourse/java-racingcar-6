package racingcar.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.message.ErrorMessage;

public class ValidatorTest {
	
	@DisplayName(",로 구분된 이름의 길이가 5초과하면 예외를 발생시킨다.")
	@ValueSource(strings = { "jaaa,aaaabb", "nannnnn,nanan" })
	@ParameterizedTest
	void checkOutOfLength(String str) {
		assertThatThrownBy(() -> Validator.validateOutOfLength(str))
				.isInstanceOf(IllegalArgumentException.class)
						.hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
	}
	
	@DisplayName(",로 구분된 이름의 길이가 5이하일때 정삭적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "naan,jjaa", "jjaa" })
	@ParameterizedTest
	void checkNomalOperation1(String str) {
		Validator.validateOutOfLength(str);
	}
	
	@DisplayName("숫자가 포함되어 있다면 예외를 발생시킨다.")
	@ValueSource(strings = { "jaa22", "122asa" })
	@ParameterizedTest
	void checkContainNumber(String str) {
		assertThatThrownBy(() -> Validator.validateContainNumber(str))
				.isInstanceOf(IllegalArgumentException.class)
						.hasMessageContaining(ErrorMessage.CONTAIN_NUMBER_ERROR.getMessage());
	}
	
	@DisplayName("숫자가 아닌 문자로만 구성되었을 때 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "nana", "jjaaa" })
	@ParameterizedTest
	void checkNomalOperation2(String str) {
		Validator.validateContainNumber(str);
	}
	
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
	void checkNomalOperation3(String str) {
		Validator.validateNumberFormat(str);
	}
}	
