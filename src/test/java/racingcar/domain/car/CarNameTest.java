package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
	@ParameterizedTest
	@ValueSource(strings = {"1", "12345"})
	@DisplayName("자동차 이름이 1글자 이상 5글자 이하로 구성되어 있을 시 CarName 객체를 생성할 수 있다.")
    void can_generate_car_object() {
		// given
		String name = "12345";

		// when
		CarName carName = new CarName(name);

		// then
		assertNotNull(carName);
	}

	@Test
	@DisplayName("자동차 이름이 1글자 미만으로 구성되어 있을 시 애러가 발생한다.")
	void under_1_occur_error() {
		// given
		String name = "";

		// when & then
		assertThrowsExactly(IllegalArgumentException.class, () ->  new CarName(name));
	}

	@Test
	@DisplayName("자동차 이름이 5글자 이상으로 구성되어 있을 시 애러가 발생한다.")
	void over_5_occur_error() {
		// given
		String name = "123456";

		// when & then
		assertThrowsExactly(IllegalArgumentException.class, () ->  new CarName(name));
	}
}