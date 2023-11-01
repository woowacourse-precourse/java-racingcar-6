package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

public class CarNameTest {

	@ParameterizedTest
	@EmptySource
	public void 이름_필수_예외테스트(String carName) {
		assertThatThrownBy(() ->  new CarName(carName))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름을 입력해주세요.");
	}
}
