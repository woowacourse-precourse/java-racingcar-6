package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.message.ErrorMessage;

public class CarLocationTest {
	
	@DisplayName("0보다 작을 때 예외를 발생시킨다.")
	@ValueSource(ints = { -1, -2 })
	@ParameterizedTest
	void checkNegativeNumber(int number) {
		assertThatThrownBy(() -> new CarLocation(number))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.CAR_LOCATION_NEGATIVE_NUMBER.getMessage());
	}
	
	@DisplayName("차 이름의 길이가 5이하일때 정삭적으로 작동하는 지 확인한다.")
	@ValueSource(ints = { 0, 2 })
	@ParameterizedTest
	void checkNomalOperation1(int number) {
		new CarLocation(number);
	}
}
