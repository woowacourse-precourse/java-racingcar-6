package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.message.ErrorMessage;

public class CarNameTest {
	
	@DisplayName("자동차 이름의 길이가 5초과하면 예외를 발생시킨다.")
	@ValueSource(strings = { "jaaass", "naacsc" })
	@ParameterizedTest
	void checkOutOfLength(String str) {
		assertThatThrownBy(() -> new CarName(str))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
	}
	
	@DisplayName("자동차 이름의 길이가 5이하일 때 정삭적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "nnaa", "jjaa" })
	@ParameterizedTest
	void checkNomalOperation1(String str) {
		new CarName(str);
	}
	
	@DisplayName("자동차 이름에 숫자가 포함되어 있다면 예외를 발생시킨다.")
	@ValueSource(strings = { "jaa22", "12sa" })
	@ParameterizedTest
	void checkContainNumber(String str) {
		assertThatThrownBy(() -> new CarName(str))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.CONTAIN_NUMBER_ERROR.getMessage());
	}
	
	@DisplayName("차동차 이름이 숫자가 아닌 문자로만 구성되었을 때 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "nana", "jjaaa" })
	@ParameterizedTest
	void checkNomalOperation2(String str) {
		new CarName(str);
	}
}
